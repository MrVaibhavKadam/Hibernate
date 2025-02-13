package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..!" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //Creating object of address
        Address ad = new Address();
        ad.setStreet("Hingane Home Colony");
        ad.setCity("Pune");
        ad.setOpen(true);
        ad.setAddDate(new Date());
        //ad.setX(1254.854);
        
        //Reading image
        FileInputStream fs =new FileInputStream("src/main/java/RoronoaZ.jpeg");
        byte[] data = new byte[fs.available()];
        ad.setImage(data);
        
        //creating object of student
        Student st = new Student();
        st.setId(003);
        st.setName("Vishnu");
        st.setCity("HYD");
        System.out.println(st);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done..!");
    }
}
