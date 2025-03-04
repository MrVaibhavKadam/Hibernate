package org.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUserDao {

    private UserDao userDao;

    @AfterAll
    static void tearDown() {
        HibernateUtils.shutdown();  // ✅ Close Hibernate after tests
    }

    @BeforeAll
    void setUp() {
        HibernateUtils.getFactory();
        userDao = new UserDao();
    }

    @Test
    @Order(1)
    @DisplayName("Test for Save User")
    void testSaveUser() {
        User user = new User("Dadu", "Patil", "dadupatil@gmail.com");
        userDao.saveUser(user);

        List<User> users = userDao.getUsers();
        assertFalse(users.isEmpty(), "User list should not be empty..!");
    }

    @Test
    @Order(2)
    @DisplayName("Test for Read Operation.")
    void testGetUser() {
        List<User> users = userDao.getUsers();
        assertNotNull(users, "Users list should not be null");
        assertTrue(users.size() > 0, "Atleast there should be one User.");
    }

    @Test
    @Order(3)
    @DisplayName("Test for Update Operation")
    void testUpdateUser() {
        List<User> users = userDao.getUsers();
        assertFalse(users.isEmpty());

        User user = users.get(0);
        String oldName = user.getFirstName();
        user.setFirstName("Deepak");
        userDao.updateUser(user);

        User updatedUser = userDao.getUsers().get(0);
        assertNotEquals(oldName, updatedUser.getFirstName());
    }

    @Test
    @Order(4)
    @DisplayName("Test for Delete Operation")
    void testDeleteUser() {
        List<User> users = userDao.getUsers();
        assertFalse(users.isEmpty());

        long userId = users.get(0).getId();
        userDao.deleteUser(userId);

        List<User> updatedUsers = userDao.getUsers();
        assertTrue(updatedUsers.stream().noneMatch(u -> u.getId() == userId), "Deleted user should not Exists.");
    }

}
