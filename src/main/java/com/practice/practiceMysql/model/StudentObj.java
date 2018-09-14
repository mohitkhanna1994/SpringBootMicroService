package com.practice.practiceMysql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "findAllStudents",query = "select s from StudentObj s")
@Entity
@Table(name = "student")
public class StudentObj implements Serializable{

	@Column
	@Id
	private int rollNo;
	
	@Column
	private String name;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentObj [rollNo=" + rollNo + ", name=" + name + "]";
	}
	
}
