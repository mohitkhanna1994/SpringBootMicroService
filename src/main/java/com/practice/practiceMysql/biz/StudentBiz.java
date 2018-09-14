package com.practice.practiceMysql.biz;

import java.util.List;

import com.practice.practiceMysql.exception.StudentServiceException;
import com.practice.practiceMysql.model.StudentObj;

public interface StudentBiz {

	public List<StudentObj> getAllStuddents() throws StudentServiceException;
	
	public String addStudent(StudentObj studentObj) throws StudentServiceException;
}
