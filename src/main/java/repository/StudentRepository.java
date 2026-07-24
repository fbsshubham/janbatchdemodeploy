package repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import springdemo.config.HibernateConfig;

public class StudentRepository {
	
	public boolean addStudent(Student student)
	{
		
		Session session;
		try {
			session = HibernateConfig.getSessionFactory().openSession();
		
			Transaction tx = session.beginTransaction();
			
			session.persist(student);
			
			tx.commit();
		
			return true;
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	public Student getStudentByRollNo(int rollno) {
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student student=session.get(Student.class, rollno);
		
		tx.commit();
	
		return student;
		
	}

	public List<Student> getAllStudents() {
		
		System.out.println("Repo tak aya");
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		List<Student> students=session.createQuery("from Student",Student.class).getResultList();
		
		
		tx.commit();
		
		return students;
		
	}
	
public List<Student> getStudentHavingBdayToday() {
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		String hql = "SELECT new BirthDayDTO(s.name, s.mobno) " +
	             "FROM Student s " +
	             "WHERE DAY(s.dob) = DAY(CURRENT_DATE()) " +
	             "AND MONTH(s.dob) = MONTH(CURRENT_DATE())";
		
		List<Student> students=session.createQuery(hql,Student.class).getResultList();
		
	
		tx.commit();
		
		return students;
		
	}
	


}
