package com.spring.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

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
			
			Course course=new Course("Digital marketing");
			
			Student s1=new Student("John","l","john.l@gmail.com");
			Student s2=new Student("John","l","john.l@gmail.com");
            
			course.addStudent(s1);
			course.addStudent(s2);
			
			session.save(s1);
			session.save(s2);
			session.save(course);
			
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
			sessionfactory.close();
		}

	}

}
