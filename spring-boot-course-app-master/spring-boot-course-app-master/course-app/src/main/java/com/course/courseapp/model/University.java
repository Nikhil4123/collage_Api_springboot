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
@Table(schema = "COURSE",name = "UNIVERSITY")
public class University {

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "university")
	@JsonBackReference
    private Set<UniversityCourse> universityCourses;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true,mappedBy = "student")
	@JsonBackReference
    private StudentCourse studentCourse;

	@Column(name = "NAME", length = 200)
    @NotNull
    private String name;

	@Column(name = "ALPHA_TWO_CODE", length = 2)
    @NotNull
    private String alphaTwoCode;

	@Column(name = "COUNTRY", length = 200)
    @NotNull
    private String country;

	@Column(name = "DOMAIN", length = 200)
    @NotNull
    private String domain;

	@Column(name = "WEB_PAGE", length = 200)
    @NotNull
    private String webPage;
	
	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}
	
	public Set<UniversityCourse> getUniversityCourses() {
        return universityCourses;
    }

	public void setUniversityCourses(Set<UniversityCourse> universityCourses) {
        this.universityCourses = universityCourses;
    }

	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

	public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

	public String getCountry() {
        return country;
    }

	public void setCountry(String country) {
        this.country = country;
    }

	public String getDomain() {
        return domain;
    }

	public void setDomain(String domain) {
        this.domain = domain;
    }

	public String getWebPage() {
        return webPage;
    }

	public void setWebPage(String webPage) {
        this.webPage = webPage;
    }


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
}
