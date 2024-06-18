package com.example.UMS.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profid;
    private String profName;
    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private List<Course> courseList = new ArrayList<>();
}
