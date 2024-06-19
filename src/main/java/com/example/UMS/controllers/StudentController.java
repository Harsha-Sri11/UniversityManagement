package com.example.UMS.controllers;

import com.example.UMS.entities.Student;
import com.example.UMS.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/university")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PostMapping("/addstudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return studentService.addStudents(students);
    }

    @GetMapping("/getstudents")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/updatestudent")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/deletestudent/{stdid}")
    public String removeStudent(@PathVariable int stdid){
        studentService.removeStudent(stdid);
        return "Record removes successfully"+stdid;
    }
}
