package crudandcascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    private final SessionFactory factory;

    public StudentDao(SessionFactory factory) {
        this.factory = factory;
    }

    public void saveStudent(Student std) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(std);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
//        try (Session session = org.example.HibernateUtils.getFactory().openSession()) {
//            return session.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.projects", Student.class).list();
//        }
        try (Session session = factory.openSession()) {
            return session.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.projects", Student.class).list();
        }

//      You can use this method also to fetch data of projects with student.
//        try (Session session = HibernateUtils.getFactory().openSession()) {
//            Student student = session.get(Student.class, studentId);
//
//            // Explicitly load projects while session is still open
//            if (student != null) {
//                Hibernate.initialize(student.getProjects());
//            }
//            return student;
//        }
    }

    public void updateStudent(Student std) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.update(std);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStudent(Long studentId) {
        Transaction tx = null;
        Session session = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);  // This will delete projects if CascadeType.ALL is set
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student with ID " + studentId + " not found.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
