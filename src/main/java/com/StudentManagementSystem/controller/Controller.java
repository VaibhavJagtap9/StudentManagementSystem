package com.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private StudentService service;
	
    @GetMapping("/main")
    public String mainPage() {
        return "main";  // This will map to src/main/resources/templates/main.html (if using Thymeleaf)
    }

	@GetMapping("/home")
	public String home() {
		return "home"; //view page html file ==> home.html
	}
	
	//get student details
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		
		model.addAttribute("students", service.getAllStudents());
		
		return "students";
	}
	
	//registration form 
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		
		Student student = new Student(); //to hold student object
		model.addAttribute("student", student);
		return "create-student";
	}
	
	//add student button 
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		service.saveStudent(student);
		return "redirect:/students";
		
	}
	
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "edit_student";
    }
    
    
    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
    	
    	Student existingStudent = service.getById(id);
		
    	existingStudent.setFirstName(student.getFirstName());
    	existingStudent.setLastName(student.getLastName());
    	existingStudent.setEmail(student.getEmail());
    	
		service.saveStudent(existingStudent);
		
		return "redirect:/students";
    }
    
    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/students";
    }
	
    // View student details
    @GetMapping("/students/view/{id}")
    public String viewStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "view_student";
    }

    @GetMapping("/students/search")
    public String searchStudents(@RequestParam("query") String query, Model model) {
        List<Student> students = service.searchStudents(query);
        model.addAttribute("students", students);
        return "students";
    }

}
