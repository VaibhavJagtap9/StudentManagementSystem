package com.StudentManagementSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;

@Service
public class Serviceimpl implements StudentService {

	//object of StudentRepository class
	@Autowired
	com.StudentManagementSystem.repository.StudentRepository StudentRepository;
	
	//Get student data method - @GetMapping
	@Override
	public List<Student> getAllStudents(){ 
		
		List<Student> list =  StudentRepository.findAll();
		return list;
	} 
	
	//Post Student Data - @PostMapping
	@Override
	public Student saveStudent(Student student) {
		
		return StudentRepository.save(student);
		
	}

	@Override
	public Student getById(int id) {
		
		return StudentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {

		StudentRepository.deleteById(id);

	}



	
	
	 
}
