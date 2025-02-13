package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		//get, load
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		//get data
		Student student = (Student)session.get(Student.class, 003);
		Address ad = (Address)session.load(Address.class, 1);
		
		System.out.println(ad.getStreet());
		System.out.println(student);
		
		session.close();
		factory.close();
	}

}
