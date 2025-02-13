package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Creating objject of Quesion
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is Java?");

        //creating object of answer
        Answer a1 = new Answer();
        a1.setAnswerId(343);
        a1.setAnswer("Java is programing language");
        a1.setQuestion(q1);
        q1.setAnswer(a1);

        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is Collection API?");

        Answer a2 = new Answer();
        a2.setAnswerId(344);
        a2.setAnswer("API to work with objects in java.");
        a2.setQuestion(q2);

        q2.setAnswer(a2);


        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(q1);
        session.save(q2);
        session.save(a1);
        session.save(a2);
        tx.commit();

        //Fetching
        Question newQ =  session.get(Question.class, 1212);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());//first .getAnswer() - gives answer object(i.e a1) and second gives actual answer.

        session.close();
        factory.close();
    }

}
