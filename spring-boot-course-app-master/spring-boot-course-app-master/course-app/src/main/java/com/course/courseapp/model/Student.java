package com.course.courseapp.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(schema = "COURSE",name = "STUDENT")
public class Student {

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

	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true,mappedBy = "student")
	@JsonBackReference
    private StudentCourse studentCourse;
			
	@Column(name = "NAME", length = 200)
    @NotNull
    private String name;

	@Column(name = "ADDRESS", length = 200)
    @NotNull
    private String address;

	@Column(name = "CITY", length = 200)
    @NotNull
    private String city;

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

	public String getAddress() {
        return address;
    }

	public void setAddress(String address) {
        this.address = address;
    }

	public String getCity() {
        return city;
    }

	public void setCity(String city) {
        this.city = city;
    }
}
