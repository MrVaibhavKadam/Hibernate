package org.example;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//Runs tests in order
public class TestMain {

    private static Validator validator;
//    private static UserDao userDao;

    @BeforeAll
    static void setValidator() {

        ValidatorFactory vFactory = Validation.byDefaultProvider().configure().
                messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory();
        validator = vFactory.getValidator();
    }

    @Test
    @DisplayName("Test validation for User Entity")
    void testInvalidUserValidation() {
        User invalidUser = new User("Vaibhav", "Kadam", "");
        Set<ConstraintViolation<User>> violations = validator.validate(invalidUser);

        assertFalse(violations.isEmpty());
    }

    @Test
    void testValidUserValidation() {
        User validUser = new User("Vaibhav", "Kadam", "Vaibhav123@gmail.com");
        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty());
    }
}
