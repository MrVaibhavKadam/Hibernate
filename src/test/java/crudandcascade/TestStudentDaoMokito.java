package crudandcascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)//enables Mockito annotations (@Mock, @InjectMocks, @Spy, etc.) in JUnit 5.
//It automatically initializes mock objects, eliminating the need for MockitoAnnotations.initMocks(this).
//
public class TestStudentDaoMokito {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction tx;

    @InjectMocks
    private StudentDao studentDao;

    
    @BeforeEach
    void setUp() {

//        factory = mock(SessionFactory.class);
//        session = mock(Session.class);
//        tx = mock(Transaction.class);

        lenient().when(factory.openSession()).thenReturn(session);
        lenient().when(session.beginTransaction()).thenReturn(tx);

        studentDao = new StudentDao(factory);
    }

    @Test
    @Order(1)
    void testSaveStudent() {
        Project project = new Project();
        project.setProjectName("Hotel Management");

        Project project1 = new Project();
        project1.setProjectName("Inventory Management System");

        List<Project> list = new ArrayList<>();
        list.add(project);
        list.add(project1);

        Student student = new Student();
        student.setSName("Dinesh");
        student.setProjects(list);

        studentDao.saveStudent(student);

        verify(session).save(student);//Verify if session.save(student) was called
        verify(tx).commit();//Verify if transaction.commit() was called

    }

    @Test
    @Order(2)
    void testGetStudents() {
        List<Student> studentList = new ArrayList<>();
        Student std1 = new Student();
        std1.setSName("Govind");

        Project p1 = new Project();
        p1.setProjectName("Flipkart");

        Project p2 = new Project();
        p2.setProjectName("Amazon");

        List<Project> projects = Arrays.asList(p1, p2);
        std1.setProjects(projects);

        studentList.add(std1);


        Query<Student> queryMock = mock(Query.class);

        when(session.createQuery(anyString(), eq(Student.class)))//We dont provide any query it takes it from DAO class.If query in DAO class
                .thenReturn(queryMock);// is wrong the test will still pass bcoz we are uing anyString().If you want stricter verification, replace anyString() with the actual query:
        when(queryMock.list()).thenReturn(studentList);
        List<Student> result = studentDao.getStudents();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Govind", result.get(0).getSName());

        verify(session).createQuery(anyString(), eq(Student.class));
    }

    @Test
    @Order(3)
    void testUpdateStudent() {

        Student student = new Student();
        student.setSName("Manasi");

        //lenient().when(session.get(Student.class, 1)).thenReturn(student);

        student.setSName("Rani");
        studentDao.updateStudent(student);

        verify(session).update(student);
        verify(tx).commit();

        assertEquals("Rani", student.getSName());
    }

    @Test
    @Order(4)
    void testDeletStudent() {
        Student student = new Student();
        student.setId(1L);
        student.setSName("Priyanka");

        when(session.get(Student.class, 1L)).thenReturn(student);
        when(session.isOpen()).thenReturn(true);
        studentDao.deleteStudent(1L);

        verify(session).delete(student);
        verify(tx).commit();
        verify(session).close();
    }

}
