package com.example.demo.controller;

import com.example.demo.model.College;
import com.example.demo.model.Course;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CollegeController {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Add a new College
    @PostMapping("/addcollage")
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        return ResponseEntity.ok(collegeRepository.save(college));
    }

    // Delete a College by ID
    @DeleteMapping("/deletecollage/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        if (collegeRepository.existsById(id)) {
            collegeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get College by ID
    @GetMapping("/getcollagebyid/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        return collegeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get All Colleges
    @GetMapping("/getallcollage")
    public ResponseEntity<List<College>> getAllColleges() {
        return ResponseEntity.ok(collegeRepository.findAll());
    }

    // Add a Course to a specific College
    @PostMapping("/addcourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        // Ensure the college ID exists before adding the course
        if (collegeRepository.existsById(course.getCollege().getId())) {
            return ResponseEntity.ok(courseRepository.save(course));
        }
        return ResponseEntity.badRequest().body(null); // Handle the case where college does not exist
    }
}
