package com.course.courseapp.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class Response implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String SUCCESS="success";
	public static String FAILURE="fail";
	
	HttpStatus statusCode;
	String status;
	Object response;
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus status) {
		this.statusCode = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String message) {
		this.status = message;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}

}
