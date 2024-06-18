package com.example.UMS.services;

import com.example.UMS.entities.Course;
import com.example.UMS.entities.Professor;
import com.example.UMS.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course addCourse(Course course);
    List<Course> addCourses(List<Course> courses);
    List<Course> getAllCourses();
    Course updateCourse(Course course);
    String removeCourse(int courseid);
}

@Service
class CourseImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> addCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Course course) {
        Optional<Course> newCourse = courseRepository.findById(course.getCourseid());
        if(newCourse.isPresent()){
            courseRepository.save(course);
        }
        return course;
    }

    @Override
    public String removeCourse(@PathVariable int courseid) {
        courseRepository.deleteById(courseid);
        return "Course record removed successfully";
    }
}