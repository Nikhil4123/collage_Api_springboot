package com.course.courseapp.jsonInfo;

import com.course.courseapp.model.University;


public class UniversityInfo {


    private String name;

    private String alphaTwoCode;

    private String country;

    private String domain;

    private String webPage;
    
    private Integer id;

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


	public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }
	
	public static UniversityInfo toUniversityInfo(University university){
		UniversityInfo universityInfo = new UniversityInfo();
		universityInfo.setAlphaTwoCode(university.getAlphaTwoCode());
		universityInfo.setCountry(university.getCountry());
		universityInfo.setDomain(university.getDomain());
		universityInfo.setName(university.getName());
		universityInfo.setWebPage(university.getWebPage());
		universityInfo.setId(university.getId());
		return universityInfo;
	} 
	
	public static University toUniversity(UniversityInfo universityInfo){
		University university = new University();
		university.setAlphaTwoCode(universityInfo.getAlphaTwoCode());
		university.setCountry(universityInfo.getCountry());
		university.setDomain(universityInfo.getDomain());
		university.setName(universityInfo.getName());
		university.setWebPage(universityInfo.getWebPage());
		return university;
	}

	public static University toUniversity(UniversityInfo universityInfo, University university) {
		university.setAlphaTwoCode(universityInfo.getAlphaTwoCode());
		university.setCountry(universityInfo.getCountry());
		university.setDomain(universityInfo.getDomain());
		university.setName(universityInfo.getName());
		university.setWebPage(universityInfo.getWebPage());
		return university;
	} 
}
