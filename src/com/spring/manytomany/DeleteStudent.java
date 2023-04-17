package com.spring.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

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
			
			Student student=session.get(Student.class,1);
			session.delete(student);
		
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
			sessionfactory.close();
		}

	}

}
