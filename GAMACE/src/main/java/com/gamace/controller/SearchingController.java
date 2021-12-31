package com.gamace.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchingController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SearchingService searchingService;

    @RequestMapping("/SearchCourse")
    @PreAuthorize("hasAnyAuthority('COACH', 'USER')")
    public String SearchCOurse() {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        return "EditUser";
    }


    @GetMapping("/GetSearchingResult")
    @PreAuthorize("hasAnyAuthority('COACH', 'USER')")
    public String GetSearchingResult(Filter filter, Model model) {
        List<Course> listCourse = searchingService.getListCourse(filter);

        List<CourseAndCoach> listCourseAndCoach = new ArrayList<>();
        for(Course i: listCourse) {
            User a = userMapper.getUserByUsername(i.getUsername());
            listCourseAndCoach.add(new CourseAndCoach(a, i));
        }

        model.addAttribute("listCourseAndCoach", listCourseAndCoach);
        return "views/SearchingResultPage";
    }
}
