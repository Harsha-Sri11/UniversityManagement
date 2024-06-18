package com.example.UMS.services;

import com.example.UMS.entities.Professor;
import com.example.UMS.entities.Student;
import com.example.UMS.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
        Professor addProfessor(Professor professor);
        List<Professor> addProfessors(List<Professor> professors);
        List<Professor> getAllProfessors();
        Professor updateProfessor(Professor Professor);
        void removeProfessor(int profid);
}

@Service
class ProfessorImpl implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public Professor addProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> addProfessors(List<Professor> professors) {
        return professorRepository.saveAll(professors);
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor updateProfessor(Professor professor) {
        Optional<Professor> newProfessor = professorRepository.findById(professor.getProfid());
        if (newProfessor.isPresent()) {
            professorRepository.save(professor);
        }
        return professor;
    }

    @Override
    public void removeProfessor(int profid) {
        professorRepository.deleteById(profid);
    }
}