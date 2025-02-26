package xmlbasedexample.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class OneToManyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Department dept = new Department();
        dept.setName("IT");

        Employee emp1 = new Employee();
        emp1.setName("Rohit");
        emp1.setDepartment(dept);

        Employee emp2 = new Employee();
        emp2.setName("Ganesh");
        emp2.setDepartment(dept);

        Set<Employee> employees = new HashSet<>();
        employees.add(emp1);
        employees.add(emp2);

        dept.setEmployees(employees);

        session.save(dept);
        session.save(emp1);
        session.save(emp2);

        tx.commit();
        session.close();
        factory.close();
    }
}
