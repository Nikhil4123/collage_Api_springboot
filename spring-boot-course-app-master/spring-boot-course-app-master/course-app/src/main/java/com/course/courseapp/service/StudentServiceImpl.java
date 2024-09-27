package com.course.courseapp.service;

import com.course.courseapp.jsonInfo.StudentInfo;
import com.course.courseapp.model.Course;
import com.course.courseapp.model.CourseRepository;
import com.course.courseapp.model.Student;
import com.course.courseapp.model.StudentCourse;
import com.course.courseapp.model.StudentCourseRepository;
import com.course.courseapp.model.StudentRepository;
import com.course.courseapp.model.University;
import com.course.courseapp.model.UniversityRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
    StudentRepository studentRepository;
	
	@Autowired
	UniversityRepository universityRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentCourseRepository studentCourseRepository;

	public long countAllStudents() {
        return studentRepository.count();
    }

	public void deleteStudent(Integer id) {
        studentRepository.delete(id);
    }

	public Student findStudent(Integer id) {
        return studentRepository.findOne(id);
    }

	public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

	public List<Student> findStudentEntries(int firstResult, int maxResults) {
        return studentRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveStudent(StudentInfo studentInfo) {
		Student student = null;
		if(studentInfo.getId() == null){
			student = StudentInfo.toStudent(studentInfo);
			student = studentRepository.save(student);
		}else{
			student  = studentRepository.findOne(studentInfo.getId());
			student.setAddress(studentInfo.getAddress());
			student.setCity(studentInfo.getCity());
			student.setName(studentInfo.getName());
		}
		
		University university = universityRepository.findOne(studentInfo.getUniversityId());
		Course course = courseRepository.findOne(studentInfo.getCourseId());
		StudentCourse studentCourse = null;
		studentCourse = studentCourseRepository.findByCourseAndStudentAndUniversity(course,student,university);
		if(studentCourse == null){
			studentCourse = new StudentCourse();
		}
		studentCourse.setCourse(course);
		studentCourse.setStudent(student);
		studentCourse.setUniversity(university);
		studentCourseRepository.save(studentCourse);
    }
	
	
	public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}
