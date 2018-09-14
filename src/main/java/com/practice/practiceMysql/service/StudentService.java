package com.practice.practiceMysql.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.practiceMysql.exception.StudentServiceException;
import com.practice.practiceMysql.model.StudentObj;

public interface StudentService {

	@CrossOrigin
	@RequestMapping(value="/getAllStudents",consumes = "application/json",produces = "application/json", method = {RequestMethod.GET})
	@ResponseBody
	public List<StudentObj> getAllStudents() throws StudentServiceException;
	
	@CrossOrigin
	@RequestMapping(value = "/addStudent", consumes = "application/json", produces = "text/plain", method = {RequestMethod.POST})
	@ResponseBody
	public String addStudent(@RequestBody StudentObj studentObj) throws StudentServiceException;
	
}
