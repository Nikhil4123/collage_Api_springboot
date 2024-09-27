package com.course.courseapp.service;
import java.util.List;

import com.course.courseapp.model.UniversityCourse;

public interface UniversityCourseService {

	public abstract long countAllUniversityCourses();


	public abstract void deleteUniversityCourse(UniversityCourse universityCourse);


	public abstract UniversityCourse findUniversityCourse(Integer id);


	public abstract List<UniversityCourse> findAllUniversityCourses();


	public abstract List<UniversityCourse> findUniversityCourseEntries(int firstResult, int maxResults);


	public abstract void saveUniversityCourse(UniversityCourse universityCourse);


	public abstract UniversityCourse updateUniversityCourse(UniversityCourse universityCourse);

}
