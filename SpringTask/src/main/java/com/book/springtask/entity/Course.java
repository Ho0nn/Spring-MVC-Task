package com.book.springtask.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private List<Student> students;
    private Instructor instructor;
    private List<Quiz>Quizes;
}
