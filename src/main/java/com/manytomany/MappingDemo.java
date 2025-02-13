package com.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Employee e1 = new Employee();
        e1.setEid(1);
        e1.setName("Ram");

        Employee e2 = new Employee();
        e2.setEid(2);
        e2.setName("Shyam");

        //Creating Object of project and setting values
        Project p1 = new Project();
        p1.setPid(5);
        p1.setpName("Library Management");

        Project p2 = new Project();
        p2.setPid(6);
        p2.setpName("ChatBot");

        List<Employee> listEmp = new ArrayList<>();
        listEmp.add(e1);
        listEmp.add(e2);

        List<Project> listP = new ArrayList<>();
        listP.add(p1);
        listP.add(p2);

        e1.setProjects(listP);

        p2.setEmps(listEmp);

        Session s = factory.openSession();

        Transaction tx = s.beginTransaction();

        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);
        
        tx.commit();
        factory.close();
    }

}
