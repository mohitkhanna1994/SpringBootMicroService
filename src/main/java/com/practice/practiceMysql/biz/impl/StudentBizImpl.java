package com.practice.practiceMysql.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.practiceMysql.biz.StudentBiz;
import com.practice.practiceMysql.dao.StudentDao;
import com.practice.practiceMysql.exception.StudentServiceException;
import com.practice.practiceMysql.model.StudentObj;

@Service
public class StudentBizImpl implements StudentBiz {

	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<StudentObj> getAllStuddents() throws StudentServiceException {
		return studentDao.getAllStudent();
	}

	@Override
	public String addStudent(StudentObj studentObj) throws StudentServiceException {
		return studentDao.addStudent(studentObj);
	}

}
