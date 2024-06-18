package com.example.UMS.controllers;

import com.example.UMS.entities.Professor;
import com.example.UMS.entities.Student;
import com.example.UMS.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping("/addprofessor")
    public Professor addProfessor(@RequestBody Professor professor){
        return professorService.addProfessor(professor);
    }

    @PostMapping("/addprofessors")
    public List<Professor> addProfessors(@RequestBody List<Professor> professors){
        return professorService.addProfessors(professors);
    }

    @GetMapping("/getprofessors")
    public List<Professor> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @PutMapping("/updateprofessor")
    public Professor updateStudent(@RequestBody Professor professor){
        return professorService.updateProfessor(professor);
    }

    @DeleteMapping("/deleteprofessor/{profid}")
    public String removeProfessor(@PathVariable int profid){
        professorService.removeProfessor(profid);
        return "Record removed successfully"+profid;
    }
}
