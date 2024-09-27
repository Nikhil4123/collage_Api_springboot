package com.course.courseapp.controller;

import java.util.ArrayList;
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
import com.course.courseapp.jsonInfo.StudentInfo;
import com.course.courseapp.model.Course;
import com.course.courseapp.model.Student;
import com.course.courseapp.service.CourseService;
import com.course.courseapp.service.StudentService;
import com.course.courseapp.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
@Api(value = "Student", description = "Contains all student related rest service")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get a Student by id", notes = "Get a Student by id")
	public ResponseEntity<Response> getAStudent(@PathVariable("id") Integer id){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        Student student  = studentService.findStudent(id);
        StudentInfo studentInfo = StudentInfo.toStudentInfo(student);
        response.setResponse(studentInfo);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get all Courses", notes = "Get all Courses")
	public ResponseEntity<Response> getAllStudents(){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        
        List<Student> students  = studentService.findAllStudents();
        List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
        for(Student student : students){
        	studentInfos.add(StudentInfo.toStudentInfo(student));
        }
        response.setResponse(studentInfos);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	@ApiOperation(value = "Delete Student", notes = "Delete Student")
	public ResponseEntity<Response> deleteStudent(@PathVariable("id") Integer id){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        studentService.deleteStudent(id);
        response.setResponse("Deleted");
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	@ApiOperation(value = "Save Student", notes = "Save Student")
	public ResponseEntity<Response> addStudent(@RequestBody StudentInfo studentInfo){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        studentService.saveStudent(studentInfo);
        response.setResponse("Successfully saved");
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}

/*	@RequestMapping(value = "/university/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Get univerity list for Course", notes = "Get univerity list for Course")
	public ResponseEntity<Response> getAllUniversities(@PathVariable("id") Integer courseId){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Response response = new Response();
        List<String> universityNames = studentService.findUniversitiesById(courseId);
        response.setResponse(universityNames);
        response.setStatus(Response.SUCCESS);
        response.setStatusCode(HttpStatus.OK); 
		return new ResponseEntity<Response>(response,response.getStatusCode());
	}
*/
	
}
