package com.course.courseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapp.jsonInfo.CourseInfo;
import com.course.courseapp.jsonInfo.UniversityInfo;
import com.course.courseapp.model.Course;
import com.course.courseapp.model.University;
import com.course.courseapp.service.CourseService;
import com.course.courseapp.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
@Api(value = "Course", description = "Contains all courses related rest service")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get a Course by id", notes = "Get a Course by id")
	public ResponseEntity<Response> getACourse(@PathVariable("id") Integer id){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        Course course  = courseService.findCourse(id);
        response.setResponse(course);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get all Courses", notes = "Get all Courses")
	public ResponseEntity<Response> getAllUniversities(){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        
        List<Course> courses  = courseService.findAllCourses();
        response.setResponse(courses);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	@ApiOperation(value = "Delete Course", notes = "Delete Course")
	public ResponseEntity<Response> deleteUniversity(@PathVariable("id") Integer id){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        courseService.deleteCourse(id);
        response.setResponse("Deleted");
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	@ApiOperation(value = "Save Course", notes = "Save Course")
	public ResponseEntity<Response> addUniversity(@RequestBody CourseInfo courseInfo){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        courseService.saveCourse(courseInfo);
        response.setResponse("Successfully saved");
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}

	@RequestMapping(value = "/university/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get univerity list for Course", notes = "Get univerity list for Course")
	public ResponseEntity<Response> getAllUniversities(@PathVariable("id") Integer courseId){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        List<String> universityNames = courseService.findUniversitiesById(courseId);
        response.setResponse(universityNames);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
}
