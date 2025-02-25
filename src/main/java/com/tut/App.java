package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project Started..!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

//        //Creating object of address
//        Address ad = new Address();
//        ad.setStreet("Hingane Home Colony");
//        ad.setCity("Pune");
//        ad.setOpen(true);
//        ad.setAddDate(new Date());
//        //ad.setX(1254.854);

        //Reading image
//        FileInputStream fs = new FileInputStream("src/main/java/RoronoaZ.jpeg");
//        byte[] data = new byte[fs.available()];
//        ad.setImage(data);

        //creating object of student
        Student st = new Student();
        st.setId(100);
        st.setName("Vishnu");
        st.setCity("HYD");

        Student st1 = new Student();
        st1.setId(101);
        st1.setName("Krushna");
        st1.setCity("HYD");

        Student st2 = new Student();
        st2.setId(103);
        st2.setName("Angad");
        st2.setCity("Pune");

        Student st3 = new Student();
        st3.setId(104);
        st3.setName("Digvijay");
        st3.setCity("Solapur");

        System.out.println(st);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(st1);
        session.save(st2);
        session.save(st3);
        tx.commit();
        session.close();
        System.out.println("Done..!");
    }
}
