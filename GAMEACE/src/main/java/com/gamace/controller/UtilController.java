package com.gamace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilController {


    @RequestMapping("/editInfoSuccess")
    public String editInfoSuccess() {
        return "../static/success/editInfoSuccess";
    }



    @RequestMapping("/updateUserSuccess")
    public String updateUserSuccess() {
        return "../static/success/updateUserSuccess";
    }

    @RequestMapping("/signUpSuccess")
    public String signUpSuccess() {
        return "SignUpSuccess";
    }


    @RequestMapping("/PostScoreSuccess")
    public String PostScoreSuccess() {
        return "../static/success/PostScoreSuccess";
    }





    @RequestMapping("/SignUpSuccess")
    public String SignUpSuccess() {
        return "../static/success/SignUpSuccess";
    }

    @RequestMapping("/EditUserSuccess")
    public String EditUserSuccess() {
        return "../static/success/EditUserSuccess";
    }


    @RequestMapping("/CreateCourseSuccess")
    public String CreateCourseSuccess() {
        return "../static/success/CreateCourseSuccess";
    }

    @RequestMapping("/DeleteCourseSuccess")
    public String DeleteUserSuccess() {
        return "../static/success/DeleteCourseSuccess";
    }

    @RequestMapping("/EditCourseSuccess")
    public String EditCourseSuccess() {
        return "../static/success/EditCourseSuccess";
    }
}
