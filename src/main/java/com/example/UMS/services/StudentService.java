package com.example.UMS.services;

import com.example.UMS.entities.Student;
import com.example.UMS.entities.UserInfo;
import com.example.UMS.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);
    List<Student> addStudents(List<Student> students);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
    void removeStudent(int stdid);
}

@Service
 class StudentImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> addStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> newStudent=studentRepository.findById(student.getStdid());
        if(newStudent.isPresent()){
            studentRepository.save(student);
        }
        return student;
    }

    @Override
    public void removeStudent(int stdid) {
    studentRepository.deleteById(stdid);
    }
}