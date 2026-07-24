package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import repository.StudentRepository;
import util.SMSservice;

public class StudentService {

	StudentRepository studentRepostitory=new StudentRepository();
	
	public boolean addStudent(Student student)
	{
		
		return studentRepostitory.addStudent(student);
		
		
	}

	public Student getStudentByRollNo(int rollno) {
		
		
		return studentRepostitory.getStudentByRollNo(rollno);
	}

	public List<Student> getAllStudents() {
		
		System.out.println("Service tak aya");
		return studentRepostitory.getAllStudents();
	}

	public void wishBirthDay() {
		
		List<Student> studentlist = studentRepostitory.getStudentHavingBdayToday();
		
		LocalDate todaysdate = LocalDate.now();
		for(Student s:studentlist)
		{
			if(s.getDob().getMonthValue()==todaysdate.getMonthValue() 
					&& s.getDob().getDayOfMonth()==todaysdate.getDayOfMonth())
			{
				
					String message="Happy Birthday "+s.getName();
					SMSservice.sendSMS(message, s.getMobno());
				
			}
				
		}
		
	}
}
