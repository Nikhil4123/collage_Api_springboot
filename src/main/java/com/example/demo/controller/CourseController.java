package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses") // Base URL for course-related operations
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Add a new course
    @PostMapping("/add") // Endpoint for adding a course
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseRepository.save(course));
    }

    // Get all courses
    @GetMapping("/all") // Endpoint for getting all courses
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    // Get a course by ID
    @GetMapping("/{id}") // Endpoint for getting a course by ID
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a course by ID
    @DeleteMapping("/{id}") // Endpoint for deleting a course by ID
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content
        }
        return ResponseEntity.notFound().build(); // Return 404 Not Found
    }
}
