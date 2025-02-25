package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {

    public void saveUser(User user){
        Transaction tx = null;

        try(Session session = HibernateUtils.getFactory().openSession()){
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getUsers(){
        try(Session session = HibernateUtils.getFactory().openSession()){
            return session.createQuery("FROM User", User.class).list();
        }
    }

    public void updateUser(User user) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteUser(Long userId) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            tx = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }


}
