package com.prowings.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Student;
import com.prowings.entity.Subject;
import com.prowings.service.StudentSubjectService;

@Repository
public class StudentSubjectDaoimpl implements StudentSubjectDao {
	@Autowired
	SessionFactory sessionfactory;

	public boolean saveStudent(Student std) {

		boolean result = false;
		try {

			Session session = sessionfactory.openSession();
			Transaction trx = session.beginTransaction();

			session.save(std);
			trx.commit();

			session.close();

			result = true;
		}

		catch (Exception e) {
			System.out.println("Error occured while storing the student :" + e.getMessage());
		}

		return result;
	}

	public List<Student> getStudent() {
		List<Student> listStd = null;

		try {

			Session Session = sessionfactory.openSession();
			Transaction trx = Session.beginTransaction();

			Query<Student> query = Session.createQuery("from Student");

			listStd = query.getResultList();

			trx.commit();
			Session.close();
		} catch (HibernateException e) {

			System.out.println("Exception:" + e.getMessage());

		}
		return listStd;

	}

	@Override
	public Student getStudent(int id) {

		Student std = null;

		Session Session = sessionfactory.openSession();

		Transaction trx = Session.beginTransaction();

		std = Session.get(Student.class, id);

		trx.commit();
		Session.close();

		return std;
	}

	@Override
	public List<Subject> getSubject() {

		List<Subject> listSub = null;

		try {

			Session Session = sessionfactory.openSession();
			Transaction trx = Session.beginTransaction();

			Query<Subject> query = Session.createQuery("from Subject");

			listSub = query.getResultList();

			trx.commit();
			Session.close();
		} catch (HibernateException e) {

			System.out.println("Exception:" + e.getMessage());

		}
		return listSub;

	}

	@Override
	public Subject getSubject(int id) {
		Subject sub = null;

		Session Session = sessionfactory.openSession();

		Transaction trx = Session.beginTransaction();

		sub = Session.get(Subject.class, id);

		trx.commit();
		Session.close();

		return sub;
	}

}
