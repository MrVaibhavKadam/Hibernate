package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmbeddedDemo {
	public static void main(String [] args)
	{
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student = new Student();
		student.setId(10);
		student.setName("Rohit");
		student.setCity("Mumbai");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("DSA");
		certificate.setDuration("50 hrs");
		
		student.setCerti(certificate);
		
	
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Ram");
		student1.setCity("SambhajiNagar");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Machine Learning");
		certificate1.setDuration("150 hrs");
		
		student.setCerti(certificate);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//Save Objects
		s.save(student);
		s.save(student1); 
		
		
		tx.commit();
		s.close();
		factory.close();

	}

}
