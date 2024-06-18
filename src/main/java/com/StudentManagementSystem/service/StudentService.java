package com.StudentManagementSystem.service;

import java.util.List;

import com.StudentManagementSystem.entity.Student;

public interface StudentService {
	
	//Get Student Data
	public Object getAllStudents();

	//Add student - post mapping
	public Student saveStudent(Student student);

	public Student getById(int id);
	
	//delete student 
	public void deleteById(int id);
	

}
