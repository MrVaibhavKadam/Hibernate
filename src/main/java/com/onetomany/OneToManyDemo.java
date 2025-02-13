package com.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

//        //Creating object of Question
//        QuestionOneToMany q1 = new QuestionOneToMany();
//        q1.setQuestionId(1212);
//        q1.setQuestion("What is Java?");
//
//        //creating object of answer
//        AnswerOneToMany a1 = new AnswerOneToMany();
//        a1.setAnswerId(343);
//        a1.setAnswer("Java is programing language");
//        a1.setQuestion(q1);
//
//
//        AnswerOneToMany a2 = new AnswerOneToMany();
//        a2.setAnswerId(344);
//        a2.setAnswer("Java is Simple and Robust Language.");
//        a2.setQuestion(q1);
//
//        AnswerOneToMany a3 = new AnswerOneToMany();
//        a3.setAnswerId(345);
//        a3.setAnswer("By using java we can develope software.");
//        a3.setQuestion(q1);
//
//        List<AnswerOneToMany> list = new ArrayList<>();
//        list.add(a1);
//        list.add(a2);
//        list.add(a3);
//
//        q1.setAnswer(list);

        //session
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
//        session.save(q1);
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);

        QuestionOneToMany q = (QuestionOneToMany)session.get(QuestionOneToMany.class, 1212);
        System.out.println(q.getQuestion());

        for (AnswerOneToMany ans:q.getAnswer())
            System.out.println(ans.getAnswer());

        tx.commit();

        //Fetching
//        Question newQ =  session.get(Question.class, 1212);
//        System.out.println(newQ.getQuestion());
//        System.out.println(newQ.getAnswer().getAnswer());//first .getAnswer() - gives answer object(i.e a1) and second gives actual answer.

        session.close();
        factory.close();
    }

}
