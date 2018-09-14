package com.practice.practiceMysql.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.practiceMysql.dao.StudentDao;
import com.practice.practiceMysql.exception.StudentServiceException;
import com.practice.practiceMysql.model.StudentObj;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<StudentObj> getAllStudent() throws StudentServiceException{
		List<StudentObj> students = null;
		try {
		Session session = this.sessionFactory.getCurrentSession();
		Query query =  session.getNamedQuery("findAllStudents");
		students = query.list();
		}catch (Exception e) {
			throw new StudentServiceException();
		}
		return students;
	}

	@Override
	public String addStudent(StudentObj studentObj) throws StudentServiceException {
		String response = "failure";
		try {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(studentObj);
		response = "success";
		}catch (Exception e) {
			throw new StudentServiceException();
		}
		return response;
	}

}
