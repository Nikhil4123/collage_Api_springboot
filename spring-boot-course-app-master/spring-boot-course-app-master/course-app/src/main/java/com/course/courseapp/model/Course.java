package com.course.courseapp.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(schema = "COURSE",name = "COURSE")
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

	public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true, mappedBy ="course")
	@JsonBackReference
    private Set<UniversityCourse> universityCourses;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "student")
	@JsonBackReference
    private StudentCourse studentCourse;

	@Column(name = "NAME", length = 200)
    @NotNull
    private String name;

	public Set<UniversityCourse> getUniversityCourses() {
        return universityCourses;
    }

	public void setUniversityCourses(Set<UniversityCourse> universityCourses) {
        this.universityCourses = universityCourses;
    }

	public StudentCourse getStudentCourse() {
        return studentCourse;
    }

	public void setStudentCourse(StudentCourse studentCourse) {
        this.studentCourse = studentCourse;
    }

	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }
}
