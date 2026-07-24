package com.springbootdemo.springbootdemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dto.ResponseDTO;
import model.Student;
import service.StudentService;

@RestController
@RequestMapping("/studentapi")
@CrossOrigin(origins = "*")
public class StudentController {

	public StudentController()
	{
		System.out.println("Student controller ka object bana");
	}
	
	StudentService studentService=new StudentService();
	
	@GetMapping("/wishbirthday")
	public void wishBirthDay() {
		
		studentService.wishBirthDay();
		
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "sucess";
	}

	@GetMapping("/getallstudents")
	public ResponseDTO<Student> getAllStudents() throws IOException {
		
		System.out.println("get all tak aya");
		List<Student> students = studentService.getAllStudents();
		
		ResponseDTO<Student> responseDTO=new ResponseDTO<Student>();

		if(students.isEmpty())
		{
			responseDTO.setStatus(404);
			responseDTO.setMessage("Students not found");
		}
		else
		{
			responseDTO.setStatus(200);
			responseDTO.setMessage("Students found");
			responseDTO.setData(students);
		}
		
		return responseDTO;
		
	}
	
	@GetMapping("/getstudentbyrollno/{rollno}")
	public ResponseDTO<Student> getStudentByRollNo(@PathVariable int rollno) throws IOException {
		
		Student student=studentService.getStudentByRollNo(rollno);
		
		ResponseDTO<Student> responseDTO=new ResponseDTO<Student>();

		if(student==null)
		{
			responseDTO.setStatus(404);
			responseDTO.setMessage("Student not found");
		}
		else
		{
			responseDTO.setStatus(200);
			responseDTO.setMessage("Student found");
			
			List<Student> list=new ArrayList<Student>();
			list.add(student);
			responseDTO.setData(list);
		}
		
		return responseDTO;
	}
	



	@PostMapping("/addstudent")
	public ResponseDTO<Student> addStudent(@RequestBody Student student) throws IOException {

		boolean res=studentService.addStudent(student);
		
		ResponseDTO<Student> responseDTO=new ResponseDTO<Student>();

		if(res==true)
		{
			responseDTO.setStatus(200);
			responseDTO.setMessage("Student added successfully");
		}
		else
		{
			responseDTO.setStatus(500);
			responseDTO.setMessage("Internal server error");
		}
		
		return responseDTO;

	}
	
	
}
