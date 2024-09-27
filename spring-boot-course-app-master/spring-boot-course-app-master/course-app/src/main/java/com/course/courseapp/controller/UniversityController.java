package com.course.courseapp.controller;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapp.jsonInfo.UniversityInfo;
import com.course.courseapp.model.University;
import com.course.courseapp.service.UniversityService;
import com.course.courseapp.util.Response;

@RestController
@RequestMapping("/university")
@Api(value = "University", description = "Contains all university related rest service")
public class UniversityController {	

	@Autowired
    UniversityService universityService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get a University by id", notes = "Get a University by id")
	public ResponseEntity<Response> getAUniversity(@PathVariable("id") Integer id){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        
        University university  = universityService.findUniversity(id);
        response.setResponse(university);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get all Universities", notes = "Get all Universities")
	public ResponseEntity<Response> getAllUniversities(){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        
        List<University> universities  = universityService.findAllUniversitys();
        response.setResponse(universities);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	@ApiOperation(value = "Delete University", notes = "Delete University")
	public ResponseEntity<Response> deleteUniversity(@PathVariable("id") Integer id){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        universityService.deleteUniversity(id);
        response.setResponse("Deleted");
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	@ApiOperation(value = "Save University", notes = "Save University")
	public ResponseEntity<Response> addUniversity(@RequestBody UniversityInfo university){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        universityService.saveUniversity(university);
        response.setResponse("Successfully saved");
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get All courses for University by id", notes = "Get All courses for University by id")
	public ResponseEntity<Response> getUniversityCourses(@PathVariable("id") Integer id){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        List<String> universityCourses  = universityService.findUniversityCourses(id);
        response.setResponse(universityCourses);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}

	
}
