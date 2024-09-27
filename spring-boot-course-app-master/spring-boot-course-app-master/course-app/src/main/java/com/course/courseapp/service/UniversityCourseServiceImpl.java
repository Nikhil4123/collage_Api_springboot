package com.course.courseapp.service;

import com.course.courseapp.model.UniversityCourse;
import com.course.courseapp.model.UniversityCourseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UniversityCourseServiceImpl implements UniversityCourseService {

	@Autowired
    UniversityCourseRepository universityCourseRepository;

	public long countAllUniversityCourses() {
        return universityCourseRepository.count();
    }

	public void deleteUniversityCourse(UniversityCourse universityCourse) {
        universityCourseRepository.delete(universityCourse);
    }

	public UniversityCourse findUniversityCourse(Integer id) {
        return universityCourseRepository.findOne(id);
    }

	public List<UniversityCourse> findAllUniversityCourses() {
        return universityCourseRepository.findAll();
    }

	public List<UniversityCourse> findUniversityCourseEntries(int firstResult, int maxResults) {
        return universityCourseRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveUniversityCourse(UniversityCourse universityCourse) {
        universityCourseRepository.save(universityCourse);
    }

	public UniversityCourse updateUniversityCourse(UniversityCourse universityCourse) {
        return universityCourseRepository.save(universityCourse);
    }
}
