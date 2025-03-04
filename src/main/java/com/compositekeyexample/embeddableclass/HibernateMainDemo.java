package com.compositekeyexample.embeddableclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMainDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        //Create Composite Key
        OrderPK orderPK = new OrderPK(1, 101);
        //Create Order Object
        Order order = new Order(orderPK, "Angad Raut");

        Transaction tx = session.beginTransaction();
        session.save(order);


        tx.commit();
        session.close();
        factory.close();
        System.out.println("Order saved Successfully");
    }
}
