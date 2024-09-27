package com.course.courseapp.service;

import com.course.courseapp.model.StudentCourse;
import com.course.courseapp.model.StudentCourseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
    StudentCourseRepository studentCourseRepository;

	public long countAllStudentCourses() {
        return studentCourseRepository.count();
    }

	public void deleteStudentCourse(StudentCourse studentCourse) {
        studentCourseRepository.delete(studentCourse);
    }

	public StudentCourse findStudentCourse(Integer id) {
        return studentCourseRepository.findOne(id);
    }

	public List<StudentCourse> findAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

	public List<StudentCourse> findStudentCourseEntries(int firstResult, int maxResults) {
        return studentCourseRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveStudentCourse(StudentCourse studentCourse) {
        studentCourseRepository.save(studentCourse);
    }

	public StudentCourse updateStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }
}
