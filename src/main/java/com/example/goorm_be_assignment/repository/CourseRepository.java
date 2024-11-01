package com.example.goorm_be_assignment.repository;

import com.example.goorm_be_assignment.entity.Course;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

    @Override
    List<Course> findAll();
}
