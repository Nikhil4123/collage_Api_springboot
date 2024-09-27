package com.course.courseapp.service;
import java.util.List;

import com.course.courseapp.model.StudentCourse;


public interface StudentCourseService {

	public abstract long countAllStudentCourses();


	public abstract void deleteStudentCourse(StudentCourse studentCourse);


	public abstract StudentCourse findStudentCourse(Integer id);


	public abstract List<StudentCourse> findAllStudentCourses();


	public abstract List<StudentCourse> findStudentCourseEntries(int firstResult, int maxResults);


	public abstract void saveStudentCourse(StudentCourse studentCourse);


	public abstract StudentCourse updateStudentCourse(StudentCourse studentCourse);

}
