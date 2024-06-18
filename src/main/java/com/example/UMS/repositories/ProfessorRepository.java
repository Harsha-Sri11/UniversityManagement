package com.example.UMS.repositories;

import com.example.UMS.entities.Professor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springdoc.core.providers.JavadocProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
