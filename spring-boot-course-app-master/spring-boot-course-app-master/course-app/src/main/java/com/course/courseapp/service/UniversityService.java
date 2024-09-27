package com.course.courseapp.service;
import java.util.List;

import com.course.courseapp.jsonInfo.UniversityInfo;
import com.course.courseapp.model.University;

public interface UniversityService {

	public abstract long countAllUniversitys();


	public abstract void deleteUniversity(Integer id);


	public abstract University findUniversity(Integer id);


	public abstract List<University> findAllUniversitys();


	public abstract List<University> findUniversityEntries(int firstResult, int maxResults);


	public abstract void saveUniversity(UniversityInfo university);


	public abstract University updateUniversity(University university);


	public abstract List<String> findUniversityCourses(Integer id);

}
