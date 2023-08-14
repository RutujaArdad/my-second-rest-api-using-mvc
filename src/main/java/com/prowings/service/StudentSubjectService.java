package com.prowings.service;

import java.util.List;

import com.prowings.entity.Student;
import com.prowings.entity.Subject;

public interface StudentSubjectService {
	
	public boolean saveStudent(Student std);
	
	public List<Student>getStudent();
	
	public Student getStudent(int id);

	public List<Subject> getSubject();

	public Subject getSubject(int id);
	

}
