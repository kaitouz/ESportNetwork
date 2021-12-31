package com.gamace.controller;

import com.gamace.mapper.CourseMapper;
import com.gamace.mapper.UserMapper;
import com.gamace.pojo.Course;
import com.gamace.pojo.CourseAndCoach;
import com.gamace.pojo.Filter;
import com.gamace.pojo.User;
import com.gamace.service.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseManagementController {

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    SearchingService searchingService;

    @RequestMapping("/CreateCourse")
    @PreAuthorize("hasAnyAuthority('COACH')")
    public String CreateCourse() {
        return "views/CreateCourse";
    }

    @PostMapping("/PostCreateCourse")
    @PreAuthorize("hasAnyAuthority('COACH')")
    public String PostCreateCourse(Course course) {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(course.toString());
        courseMapper.insertCourse(
                loginName,
                course.getGame(),
                course.getLanguage(),
                course.getLevel(),
                course.getPrice(),
                course.getDescription()
        );
        return "redirect:/CreateCourseSuccess";
    }

    @RequestMapping("/CourseManagement")
    @PreAuthorize("hasAnyAuthority('COACH')")
    public String CourseManagement(Model model) {

        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        Filter filter = new Filter(loginName, null, null, null, null, null);
        List<Course> listCourse = searchingService.getListCourse(filter);

        List<CourseAndCoach> listCourseOfCoach = new ArrayList<>();
        for(Course i: listCourse) {
            User a = userMapper.getUserByUsername(i.getUsername());
            listCourseOfCoach.add(new CourseAndCoach(a, i));
        }
        model.addAttribute("listCourseOfCoach", listCourseOfCoach);
        return "views/CourseManagement";
    }

    @GetMapping("/EditCourse/{id}")
    @PreAuthorize("hasAnyAuthority('COACH')")
    public String EditCourse(@PathVariable("id") int id, Model model) {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        String courseCoach = courseMapper.getCourseById(id).getUsername();
        if(!courseCoach.equals(loginName)) return "redirect:/deleteUserNotExistError";

        Course thisCourse = courseMapper.getCourseById(id);
        model.addAttribute("thisCourse", thisCourse);
        return "views/EditCourse";
    }

    @PostMapping("/PostEditCourse{tempId}")
    @PreAuthorize("hasAnyAuthority('COACH')")
    public String PostEditCourse(@PathVariable("tempId") int Id, Course course) {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        String courseCoach = courseMapper.getCourseById(Id).getUsername();
        if(!courseCoach.equals(loginName)) return "redirect:/deleteUserNotExistError";

        System.out.println(course.toString());

        if(course.getLanguage() != null && course.getLanguage().length() != 0) {
            courseMapper.updateLanguageCourse(Id, course.getLanguage());
        }
        if(course.getGame() != null && course.getGame().length() != 0) {
            courseMapper.updateGameCourse(Id, course.getGame());
        }
        if(course.getLevel() != null && course.getLevel().length() != 0) {
            courseMapper.updateLevelCourse(Id, course.getLevel());
        }
        if(course.getPrice() != null && course.getPrice().length() != 0) {
            courseMapper.updatePriceCourse(Id, course.getPrice());
        }
        if(course.getDescription() != null && course.getDescription().length() != 0) {
            courseMapper.updateDescriptionCourse(Id, course.getDescription());
        }
        return "redirect:/EditCourseSuccess";
    }

    @GetMapping("/PostManagementDeleteCourse/{id}")
    @PreAuthorize("hasAnyAuthority('COACH')")
    public String managementDeleteCourse(@PathVariable("id") int id) {
        courseMapper.deleteCourse(id);
        return "redirect:/DeleteCourseSuccess";
    }
}
