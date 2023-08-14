package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentSubjectDao;
import com.prowings.entity.Student;
import com.prowings.entity.Subject;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {

	@Autowired
	StudentSubjectDao StudentSubjectDao;

	public boolean saveStudent(Student std) {
		return StudentSubjectDao.saveStudent(std);
	}

	@Override
	public List<Student> getStudent() {
		return StudentSubjectDao.getStudent();
	}

	@Override
	public Student getStudent(int id) {

		return StudentSubjectDao.getStudent(id);
	}

	public List<Subject> getSubject() {
		return StudentSubjectDao.getSubject();
	}

	@Override
	public Subject getSubject(int id) {
		return StudentSubjectDao.getSubject(id);
	}

	

}
