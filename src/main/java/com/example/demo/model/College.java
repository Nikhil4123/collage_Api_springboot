package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "colleges") // Explicit table name
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Ensures name is not null in DB
    private String name;

    // One-to-many relationship with Course
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Handles JSON serialization of bidirectional relationships
    private List<Course> courses;

    // Default constructor
    public College() {
    }

    // Constructor
    public College(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
