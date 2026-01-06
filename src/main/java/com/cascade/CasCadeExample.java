package com.cascade;

import com.onetomany.AnswerOneToMany;
import com.onetomany.QuestionOneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CasCadeExample {
    public static void main(String[] args) {
	System.out.print("Session Started");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        QuestionOneToMany q1 = new QuestionOneToMany();
        q1.setQuestionId(2);
        q1.setQuestion("What is Cascading ?");

        AnswerOneToMany a1 = new AnswerOneToMany(125, "In hibernate it is IMP concept.");
        AnswerOneToMany a2 = new AnswerOneToMany(126, "Second answer.");
        AnswerOneToMany a3 = new AnswerOneToMany(127, "Third answer.");

        List<AnswerOneToMany> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswer(list);
        Transaction tx = session.beginTransaction();
        session.save(q1);//When you save the question only question is saved in database to save questions and its related entity cascade is useful.
        //to use cascade add "cascade = CascadeType.ALL" this to ur onetomany mapping or where you want to add cascade.


        tx.commit();
        session.close();
        factory.close();

    }
}
