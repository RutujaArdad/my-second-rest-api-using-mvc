package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.entity.Subject;
import com.prowings.service.StudentSubjectService;
@RestController
public class StudentSubjectController {
	@Autowired
	StudentSubjectService studentSubjectService;
	
	@PostMapping("/students")
	public String saveStudent(@RequestBody Student std) {
		
		if(studentSubjectService.saveStudent(std))
			
			return"Student save succefully";
		
		else
			return"student not save";
		
		
	}

	@GetMapping("/students")
	public List<Student> getStudent(){
		
		System.out.println("request recived to get all students");
		
		return studentSubjectService.getStudent();
		
		
		
	}
	@GetMapping("/students/{id}")
	public Student getStudent (@PathVariable int id) {
		
		System.out.println("request recived tp get student of id:"+id);
		
		Student retriveStudent=studentSubjectService.getStudent(id);
		
		return  retriveStudent;
	}
	@GetMapping("/subjects")
	public List<Subject> getSubject(){
		
		System.out.println("request recived to get all subject");
		
		return studentSubjectService.getSubject();
		
	}	
	@GetMapping("/students/{id}/subjects/{id}")
	public Subject getSubject(@PathVariable int id) {
		
		System.out.println("request recived to get subject of id:"+id);
		
		Subject retriveSubject=studentSubjectService.getSubject(id);
		
		return  retriveSubject;
	}
}
