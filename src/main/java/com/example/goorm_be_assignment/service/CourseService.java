package com.example.goorm_be_assignment.service;

import com.example.goorm_be_assignment.entity.Course;
import com.example.goorm_be_assignment.repository.CourseRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        List<Course> courses=courseRepository.findAll();
        log.info(courses.toString());
        return courses;
    }
}
