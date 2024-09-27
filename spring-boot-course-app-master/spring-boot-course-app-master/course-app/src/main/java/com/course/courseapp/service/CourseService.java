package com.course.courseapp.service;
import java.util.List;

import com.course.courseapp.jsonInfo.CourseInfo;
import com.course.courseapp.model.Course;

public interface CourseService {

	public abstract long countAllCourses();


	public abstract void deleteCourse(Integer id);


	public abstract Course findCourse(Integer id);


	public abstract List<Course> findAllCourses();


	public abstract List<Course> findCourseEntries(int firstResult, int maxResults);


	public abstract void saveCourse(CourseInfo courseInfo);


	public abstract Course updateCourse(Course course);


	public abstract List<String> findUniversitiesById(Integer courseId);

}
