package com.practice.practiceMysql.dao;

import java.util.List;

import com.practice.practiceMysql.exception.StudentServiceException;
import com.practice.practiceMysql.model.StudentObj;

public interface StudentDao {

	public List<StudentObj> getAllStudent() throws StudentServiceException;
	
	public String addStudent(StudentObj studentObj) throws StudentServiceException;
}
