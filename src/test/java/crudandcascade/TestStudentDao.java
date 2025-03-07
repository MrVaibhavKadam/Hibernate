//package crudandcascade;
//
//import org.junit.jupiter.api.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class TestStudentDao {
//
//    private StudentDao studentDao;
//
//    @AfterAll
//    static void tearDown() {
//        HibernateUtils.shutDown();
//    }
//
//    @BeforeAll
//    void setUp() {
//        HibernateUtils.getFactory();
//        studentDao = new StudentDao();
//    }
//
//    @Test
//    @Order(1)
//    @DisplayName("Test for saveUser.")
//    void testSaveStudent() {
//
//        Project project = new Project();
//        project.setProjectName("Hotel Management");
//
//        Project project1 = new Project();
//        project1.setProjectName("Inventory Management System");
//
//        List<Project> list = new ArrayList<>();
//        list.add(project);
//        list.add(project1);
//
//        Student student = new Student();
//        student.setProjects(list);
//
//        StudentDao.saveStudent(student);
//
//        List<Student> students = studentDao.getStudents();
//        assertFalse(students.isEmpty());
//    }
//
//    @Test
//    @Order(2)
//    void testGetStudent() {
//        List<Student> students = studentDao.getStudents();
//        assertNotNull(students);
//        assertTrue(students.size() > 0);
//    }
//
//    @Test
//    @Order(3)
//    void testUpdateStudent() {
//        List<Student> students = studentDao.getStudents();
//        assertFalse(students.isEmpty());
//
//        Student student = students.get(0);
//        String oldName = student.getSName();
//        student.setSName("Krushna");
//        studentDao.updateStudent(student);
//
//        Student updatedStudent = studentDao.getStudents().get(0);
//        assertNotEquals(oldName, updatedStudent.getSName());
//    }
//
//    @Test
//    @Order(4)
//    void testDeleteStudent() {
//        List<Student> students = studentDao.getStudents();
//        assertFalse(students.isEmpty());
//
//        long studentId = students.get(0).getId();
//        studentDao.deleteStudent(studentId);
//
//        List<Student> updatedStudents = studentDao.getStudents();
//        assertTrue(updatedStudents.stream().noneMatch(s -> s.getId() == studentId));
//    }
//}
