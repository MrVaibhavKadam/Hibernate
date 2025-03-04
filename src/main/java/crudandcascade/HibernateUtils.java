package crudandcascade;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError("SessionFactory creation failed " + e);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void shutDown() {
        if (factory != null)
            factory.close();
    }

}
