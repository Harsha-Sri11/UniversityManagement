package com.example.UMS.controllers;

import com.example.UMS.entities.Course;
import com.example.UMS.entities.Professor;
import com.example.UMS.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PostMapping("/addcourses")
    public List<Course> addCourses(@RequestBody List<Course> courses){
        return courseService.addCourses(courses);
    }

    @GetMapping("/getcourses")
    @PreAuthorize("hasAuthority('ROLE_USER')")     //ROLE has to be appended to the USER ,we need to store ROLE_**** in the DB
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PutMapping("/updatecourse")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/deletecourse/{courseid}")
    String removeCourse(@PathVariable int courseid){
        courseService.removeCourse(courseid);
        return "Record removed successfully"+courseid;
    }
}
