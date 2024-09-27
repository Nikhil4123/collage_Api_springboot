package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "accommodation_fee", nullable = false) // Ensure this is NOT NULL
    private Double accommodationFee; // Use Double type

    // Many-to-one relationship with College
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", nullable = false) // college_id cannot be null
    @JsonBackReference // Prevents infinite recursion in bidirectional relationship
    private College college;

    // Default constructor
    public Course() {
    }

    // Constructor with parameters
    public Course(String name, Double accommodationFee, College college) {
        this.name = name;
        this.accommodationFee = accommodationFee; // Set the accommodation fee
        this.college = college;
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

    public Double getAccommodationFee() {
        return accommodationFee;
    }

    public void setAccommodationFee(Double accommodationFee) {
        this.accommodationFee = accommodationFee; // Set accommodation fee
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
