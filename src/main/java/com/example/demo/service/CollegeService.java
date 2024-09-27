package com.example.demo.service;

import com.example.demo.model.College;
import com.example.demo.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("College not found"));
    }

    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
