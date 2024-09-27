package com.course.courseapp.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "COURSE",name = "UNIVERSITY_COURSE")
public class UniversityCourse {

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

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSE", referencedColumnName = "ID", nullable = false)
    private Course course;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UNIVERSITY", referencedColumnName = "ID", nullable = false)
    private University university;

	public Course getCourse() {
        return course;
    }

	public void setCourse(Course course) {
        this.course = course;
    }

	public University getUniversity() {
        return university;
    }

	public void setUniversity(University university) {
        this.university = university;
    }

}
