package com.course.courseapp.service;

import com.course.courseapp.jsonInfo.UniversityInfo;
import com.course.courseapp.model.Course;
import com.course.courseapp.model.University;
import com.course.courseapp.model.UniversityCourse;
import com.course.courseapp.model.UniversityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UniversityServiceImpl implements UniversityService {

	@Autowired
    UniversityRepository universityRepository;

	public long countAllUniversitys() {
        return universityRepository.count();
    }

	public void deleteUniversity(Integer id) {
		University university = universityRepository.findOne(id);
        universityRepository.delete(university);
    }

	public University findUniversity(Integer id) {
        return universityRepository.findOne(id);
    }

	public List<University> findAllUniversitys() {
        return universityRepository.findAll();
    }

	public List<University> findUniversityEntries(int firstResult, int maxResults) {
        return universityRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveUniversity(UniversityInfo universityInfo) {
		if(universityInfo.getId() == null){
			universityRepository.save(UniversityInfo.toUniversity(universityInfo));
		}else{
			University university = universityRepository.findOne(universityInfo.getId());
			universityRepository.save(UniversityInfo.toUniversity(universityInfo, university));
		}
		
    }

	public University updateUniversity(University university) {
        return universityRepository.save(university);
    }
	
	public List<String> findUniversityCourses(Integer id){
		List<String> universityCourses = new ArrayList<String>();
		University university = universityRepository.findOne(id);
		Set<UniversityCourse> courses = university.getUniversityCourses();
		for(UniversityCourse course : courses){
			universityCourses.add(course.getId() + "- "+ course.getCourse().getName());
		}
		return universityCourses;
	}
}
