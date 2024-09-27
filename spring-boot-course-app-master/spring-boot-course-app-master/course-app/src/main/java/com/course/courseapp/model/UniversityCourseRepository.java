package com.course.courseapp.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityCourseRepository extends JpaRepository<UniversityCourse, Integer>, JpaSpecificationExecutor<UniversityCourse> {

	UniversityCourse findByCourseAndUniversity(Course course, University university);
}
