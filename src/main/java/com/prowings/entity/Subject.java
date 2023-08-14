package com.prowings.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Subject {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	String subjectName;
	
	@Column
	String teacherName;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int id, String subjectName, String teacherName) {
		this.id = id;
		this.subjectName = subjectName;
		this.teacherName = teacherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", teacherName=" + teacherName + "]";
	}
	

}
