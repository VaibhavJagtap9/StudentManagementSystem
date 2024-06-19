package com.StudentManagementSystem.service;

import java.util.List;

import com.StudentManagementSystem.entity.Student;

public interface StudentService {

    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getById(int id);

    void deleteById(int id);
    
    List<Student> searchStudents(String query);
}
