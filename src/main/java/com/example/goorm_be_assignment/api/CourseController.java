package com.example.goorm_be_assignment.api;

import com.example.goorm_be_assignment.entity.Course;
import com.example.goorm_be_assignment.service.CourseService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/course")
    public ResponseEntity<List<Course>>show(){
        List<Course> createdList=courseService.getCourses();
        log.info(createdList.toString());
        return (createdList!=null)?
                ResponseEntity.status(HttpStatus.OK).body(createdList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
