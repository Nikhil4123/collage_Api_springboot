package com.course.courseapp.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaSpecificationExecutor<StudentCourse>, JpaRepository<StudentCourse, Integer> {

	StudentCourse findByCourseAndStudentAndUniversity(Course course, Student student, University university);
}
