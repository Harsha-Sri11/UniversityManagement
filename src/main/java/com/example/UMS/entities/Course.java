package com.example.UMS.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "Course")
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;
    private String courseName;
    private int profid;

    @ManyToOne
    @JoinColumn(name = "profid", insertable = false, updatable = false)
    @JsonIgnore
    private Professor professor;
}
