package com.pegination;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPegination {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Query<Student> query = session.createQuery("from Student", Student.class);

        //Implementing pegination using hibernate
        query.setFirstResult(0);
        query.setMaxResults(3);

        List<Student> list = query.list();
        for (Student st : list)
            System.out.println(st.getId() + ":" + st.getName() + ":" + st.getCity());


        factory.close();
    }

}
