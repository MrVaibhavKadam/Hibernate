package org.example;

import org.example.UserDao;
import org.example.User;
import org.example.HibernateUtils;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

//        If you don't want to use Expression Language, you can manually set the message interpolator in your validator factory:
          ValidatorFactory vFactory = Validation.byDefaultProvider()
                  .configure()
                  .messageInterpolator(new ParameterMessageInterpolator()) // Bypass EL
                  .buildValidatorFactory();
          Validator validator = vFactory.getValidator();
//        messageInterpolator(new ParameterMessageInterpolator()) -> This helps us to read the message we provided with validations.


//        Create a validator factory and validator
//        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = vFactory.getValidator();


        User u1 = new User("Ram", "Fadatare", "");
        // **Check for invalid user data**
        Set<ConstraintViolation<User>> violations = validator.validate(u1);

        for (ConstraintViolation<User> violation : violations)
            System.out.println(violation.getPropertyPath()+ " " + violation.getMessage());

        UserDao userDao = new UserDao();

          // Create
          userDao.saveUser(u1);
          userDao.saveUser(new User("Suresh", "Kumar", "Suresh123@gmail.com"));

          // Read
          List<User> users = userDao.getUsers();
          users.forEach(System.out::println);

        // Update
        User user = users.get(4);
        System.out.println(user);
        user.setFirstName("Rameshwar");
        userDao.updateUser(user);

        // Delete
        userDao.deleteUser(8L);


        // Shutdown Hibernate
        HibernateUtils.shutdown();
    }
}