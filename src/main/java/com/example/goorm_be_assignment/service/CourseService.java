package com.example.goorm_be_assignment.service;

import com.example.goorm_be_assignment.entity.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}
