package xmlbasedexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student std = new Student();
        std.setName("Vaibhav");
        std.setAddress("Karve Nagar, Pune");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(std);

        tx.commit();
        session.close();

    }
}
