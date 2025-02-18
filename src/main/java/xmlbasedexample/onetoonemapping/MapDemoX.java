package xmlbasedexample.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemoX {

    public static void main(String[] args) throws ClassNotFoundException {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();


        QuestionX q1 = new QuestionX();
        q1.setQuestion("What is java?");


        AnswerX a1 = new AnswerX();
        a1.setAnswer("Java is a programing language");
        a1.setQuestion(q1);
        q1.setAnswer(a1);

//        Class.forName("org.postgresql.Driver");
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(q1);

        session.save(a1);

        tx.commit();

        session.close();
        factory.close();
    }

}
