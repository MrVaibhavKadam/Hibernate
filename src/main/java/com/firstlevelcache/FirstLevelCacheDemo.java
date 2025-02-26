package com.firstlevelcache;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student st1 = session.get(Student.class, 100);
        System.out.println(st1);

        System.out.println("Woking on other things");

        //Again call same student. First level cache is available by default.
        Student st2 = session.get(Student.class, 100);
        System.out.println(st2);

        System.out.println(session.contains(st1));//Check whether the object is present in the cache or not.

        session.close();
    }

}
