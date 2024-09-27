package com.course.courseapp.jsonInfo;

import java.util.List;

import com.course.courseapp.model.Course;

public class CourseInfo {
	
    private Integer id;
    private String name;
    private Integer universityId;
    private List<String> universityNames;
    
	public List<String> getUniversityNames() {
		return universityNames;
	}
	public void setUniversityNames(List<String> universityNames) {
		this.universityNames = universityNames;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public static Course toCourse(CourseInfo courseInfo) {
		Course course = new Course();
		course.setName(courseInfo.getName());
		return course;
	}
    
}
