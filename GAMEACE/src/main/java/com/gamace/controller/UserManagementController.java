package com.gamace.controller;

import com.gamace.mapper.UserMapper;
import com.gamace.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserManagementController {
    public static final String _user = "USER";

    @Autowired
    UserMapper userMapper;

    //Sign-in
    @RequestMapping("/doLogin")
    public String doLogin() {
        return "views/doLogin";
    }

    //Sign-up
    @RequestMapping("/signup")
    public String signup() {
        return "views/signup";
    }

    @PostMapping("/PostSignUp")
    public String postSignUp(User user) {
        System.out.println(user.getRole());
        if (userMapper.judgeUsernameExist(user.getUsername()) != 0)
            return "redirect:/usernameExistError";

        userMapper.insertUser(
                user.getUsername(),
                user.getPassword(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getPhone_number(),
                user.getRole(),
                user.getGame(),
                user.getLanguage()
                );
        int id = userMapper.getIDByUsername(user.getUsername());
        return "redirect:/SignUpSuccess";
    }

    @GetMapping("/UserPage/{username}")
    @PreAuthorize("hasAnyAuthority('COACH', 'USER')")
    public String pageUsername(@PathVariable("username") String username, Model model) {
        if (username.equals("root")) username = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userMapper.getIDByUsername(username);
        User loginUser = userMapper.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        User targetUser = userMapper.getUserByID(id);
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("targetUser", targetUser);
        return "views/userPage";
    }


    @PostMapping("/PostEditUser")
    @PreAuthorize("hasAnyAuthority('COACH', 'USER')")
    public String PostEditUser(User user) {

        System.out.println(user.toString());
        User loginUser = userMapper.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        int id = userMapper.getIDByUsername(loginUser.getUsername());

        if(user.getEmail() != null && user.getEmail().length() != 0) {
            userMapper.updateUserEmailByID(id, user.getEmail());
        }
        if(user.getFirst_name() != null && user.getFirst_name().length() != 0) {
            userMapper.updateUserFirstNameByID(id, user.getFirst_name());
        }
        if(user.getLast_name() != null && user.getLast_name().length() != 0) {
            userMapper.updateUserLastNameByID(id, user.getLast_name());
        }
        if(user.getPhone_number() != null && user.getPhone_number().length() != 0) {
            userMapper.updateUserPhoneNumberByID(id, user.getPhone_number());
        }
        if(user.getPassword() != null && user.getPassword().length() != 0) {
            userMapper.updateUserPasswordByID(id, user.getPassword());
        }
        if(user.getGame() != null && user.getGame().length() != 0) {
            userMapper.updateUserGameByID(id, user.getGame());
        }
        if(user.getLanguage() != null && user.getLanguage().length() != 0) {
            userMapper.updateUserLanguageByID(id, user.getLanguage());
        }
        if(user.getBio() != null && user.getBio().length() != 0) {
            userMapper.updateUserBioByID(id, user.getBio());
        }
        if(user.getFacebook() != null && user.getFacebook().length() != 0) {
            userMapper.updateUserFacebookByID(id, user.getFacebook());
        }
        if(user.getInstagram() != null && user.getInstagram().length() != 0) {
            userMapper.updateUserInstagramByID(id, user.getInstagram());
        }
        return "redirect:/EditUserSuccess";
    }

    //manageUser
    @GetMapping("/GetManageUser")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String GetManageUser(Model model) {
        List<User> listUser = userMapper.getUserList();
        model.addAttribute("listUser", listUser);
        return "views/manageUser";
    }

    @GetMapping("/EditUser")
    @PreAuthorize("hasAnyAuthority('COACH', 'USER')")
    public String EditUser(Model model) {
        User loginUser = userMapper.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(loginUser.toString());
        model.addAttribute("loginUser", loginUser);
        return "views/EditUser";
    }

}
