package com.example.demo.repository;

import com.example.demo.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}
