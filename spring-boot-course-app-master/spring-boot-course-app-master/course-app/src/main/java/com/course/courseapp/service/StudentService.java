package com.course.courseapp.service;
import java.util.List;

import com.course.courseapp.jsonInfo.StudentInfo;
import com.course.courseapp.model.Student;

public interface StudentService {

	public abstract long countAllStudents();


	public abstract void deleteStudent(Integer id);


	public abstract Student findStudent(Integer id);


	public abstract List<Student> findAllStudents();


	public abstract List<Student> findStudentEntries(int firstResult, int maxResults);


	public abstract void saveStudent(StudentInfo studentInfo);


	public abstract Student updateStudent(Student student);

}
