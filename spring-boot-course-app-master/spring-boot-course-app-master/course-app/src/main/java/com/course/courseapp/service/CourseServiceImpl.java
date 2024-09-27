package com.course.courseapp.service;

import com.course.courseapp.jsonInfo.CourseInfo;
import com.course.courseapp.model.Course;
import com.course.courseapp.model.CourseRepository;
import com.course.courseapp.model.University;
import com.course.courseapp.model.UniversityCourse;
import com.course.courseapp.model.UniversityCourseRepository;
import com.course.courseapp.model.UniversityRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
    CourseRepository courseRepository;
	
	@Autowired
    UniversityRepository universityRepository;

	@Autowired
    UniversityCourseRepository universityCourseRepository;

	
	public long countAllCourses() {
        return courseRepository.count();
    }

	public void deleteCourse(Integer id) {
        courseRepository.delete(id);
    }

	public Course findCourse(Integer id) {
        return courseRepository.findOne(id);
    }

	public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

	public List<Course> findCourseEntries(int firstResult, int maxResults) {
        return courseRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCourse(CourseInfo courseInfo) {
		Course course = null;
		if(courseInfo.getId() == null){
			course = new Course();
			course = courseRepository.save(CourseInfo.toCourse(courseInfo));
		}else{
			course = courseRepository.findOne(courseInfo.getId());
			course.setName(courseInfo.getName());
			course = courseRepository.save(course);
		}
		
		University university = universityRepository.findOne(courseInfo.getUniversityId());
		UniversityCourse universityCourse = universityCourseRepository.findByCourseAndUniversity(course,university);
		if(universityCourse == null){
			universityCourse = new UniversityCourse();
			universityCourse.setUniversity(university);
			universityCourse.setCourse(course);
			universityCourseRepository.save(universityCourse);
		}
    }

	public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
	
	public List<String> findUniversitiesById(Integer courseId){
		List<String> universityList = new ArrayList<String>();
		Course course = courseRepository.findOne(courseId);
		Set<UniversityCourse> universityCourses = course.getUniversityCourses();
		for(UniversityCourse universityCourse : universityCourses){
			universityList.add(universityCourse.getUniversity().getName());
		}
		return universityList;
	}
}
