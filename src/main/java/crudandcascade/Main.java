package crudandcascade;

import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        StudentDao studentDao = new StudentDao(factory);

        Student std1 = new Student();
        std1.setSName("Vaibhav");

        Project p1 = new Project();
        p1.setProjectName("Hotel Management");

        Project p2 = new Project();
        p2.setProjectName("GreenMart");

        std1.setProjects(Arrays.asList(p1, p2));

        studentDao.saveStudent(std1);

        //read

        List<Student> students = studentDao.getStudents();
        students.forEach(System.out::println);

        //Update student
        Student student = students.get(0);
        System.out.println(student);
        student.setSName("Ravi");
        studentDao.updateStudent(student);
        System.out.println(student);


    }
}
