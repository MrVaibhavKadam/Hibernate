package deleteparentnchild;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();


        Department dept = new Department();
        dept.setDeptName("Finance");

        Employee emp1 = new Employee();
        emp1.setEmpName("Aditya");
        emp1.setDepartment(dept);


        Employee emp2 = new Employee();
        emp2.setEmpName("Angad");
        emp2.setDepartment(dept);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);

        dept.setEmployees(employeeList);
//      Code for the case one delete parent and keep child.
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//
////        session.save(dept);
////        session.save(emp1);
////        session.save(emp2);
//        session.persist(dept);//It adds all the info with employee info.
//
//        Department dept1 = session.get(Department.class, 1);
//        //session.delete(dept1);
//
//        tx.commit();
//        session.close();
        System.out.println("_________________________________________________________________________");
//        code for delete child and keep parents

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(dept);
        Department dept1 = session.get(Department.class, 1);
//        Employee emp = dept1.getEmployees().get(0);
//        dept1.getEmployees().remove(emp);
//        session.delete(emp);

        //For removing all the childs at a time
        if (dept1 != null) {
            dept1.removeAllEmployees(); // Break relationship
            Query query = session.createQuery("DELETE FROM Employee WHERE department IS NULL");
            query.executeUpdate();  // Delete all employees
        }

//        //Using native query
//        Query query = session.createNativeQuery("DELETE FROM employee WHERE dept_id = :deptId");
//        query.setParameter("deptId", 1); // Set department ID
//        query.executeUpdate(); // Execute the delete operation


        tx.commit();
        session.close();

        System.out.println("Child Deleted Successfully..!");
    }
}
