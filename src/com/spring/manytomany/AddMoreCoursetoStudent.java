package com.spring.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddMoreCoursetoStudent {

	public static void main(String[] args) {
	 
		SessionFactory sessionfactory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=sessionfactory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			int studentId=1;
			Student student=session.get(Student.class, studentId);
			Course course1=new Course("UX course1");
			Course course2=new Course(" designing1");
			student.addCourse(course1);
			student.addCourse(course2);
			session.save(course1);
			session.save(course2);			
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
			sessionfactory.close();
		}

	}

}
