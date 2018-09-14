package com.practice.practiceMysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.practiceMysql.biz.StudentBiz;
import com.practice.practiceMysql.exception.StudentServiceException;
import com.practice.practiceMysql.model.StudentObj;
import com.practice.practiceMysql.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController implements StudentService {

	@Autowired
	StudentBiz studentBiz;
	
	@Override
	public List<StudentObj> getAllStudents() throws StudentServiceException {
		System.out.println("get all students called");
		return studentBiz.getAllStuddents();
	}

	@Override
	public String addStudent(@RequestBody StudentObj studentObj) throws StudentServiceException {
		System.out.println("add new student called::" +studentObj);
		return studentBiz.addStudent(studentObj);
	}	
}
