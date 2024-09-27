package com.course.courseapp.jsonInfo;

import com.course.courseapp.model.Student;

public class StudentInfo {

	private Integer id;
	private String name;
	private String address;
	private String city;
	private String university;
	private String course;
	private Integer universityId;
	private Integer courseId;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public static Student toStudent(StudentInfo studentInfo) {
		Student student = new Student();
		student.setAddress(studentInfo.getAddress());
		student.setCity(studentInfo.getCity());
		student.setName(studentInfo.getName());
		return student;
	}
	public static StudentInfo toStudentInfo(Student student) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setAddress(student.getAddress());
		studentInfo.setCity(student.getCity());
		studentInfo.setName(student.getName());
		studentInfo.setCourseId(student.getStudentCourse().getCourse().getId());
		studentInfo.setCourse(student.getStudentCourse().getCourse().getName());
		studentInfo.setId(student.getId());
		studentInfo.setUniversity(student.getStudentCourse().getUniversity().getName());
		studentInfo.setUniversityId(student.getStudentCourse().getUniversity().getId());
		return studentInfo;
	}
	
	
	
}
