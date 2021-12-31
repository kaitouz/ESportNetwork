package com.gamace.service;

import com.gamace.mapper.CourseMapper;
import com.gamace.pojo.Course;
import com.gamace.pojo.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchingService {

    @Autowired
    CourseMapper courseMapper;

    public List<Course> getListCourse() {
        List<Course> result;
        result = courseMapper.getCourseList();
        return result;
    }

    public List<Course> getListCourse(Filter filter) {
        List<Course> tmp = courseMapper.getCourseList();

        List<Course> result = new ArrayList<>();
        for(Course i: tmp) {
            int k = filter.check(i);
            if(k == 1) result.add(i);
        }
        return result;
    }


}
