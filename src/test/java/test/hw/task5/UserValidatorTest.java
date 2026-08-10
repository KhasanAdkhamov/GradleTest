package test.hw.task5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import task2.User;
import task2.UserValidator;


public class UserValidatorTest {
    UserValidator userValidator;

    @BeforeEach
    void setUser() {
        userValidator = new UserValidator();
    }

    @org.junit.jupiter.api.Nested
    class TestName {
        @Test
        @DisplayName("проверка на имя пользователя, длина должна быть не больше 15 и не меньше 3")
        void shouldReturnTrueForName() {
            User khas = new User("aleks", "jasan.as@mail.com", 25);
            boolean validName = userValidator.isValidName(khas.getName());
            Assertions.assertTrue(validName);
        }

        @ParameterizedTest
        @ValueSource(strings = {"anna", "a", "SemenovViktorAleksandrovich"})
        @DisplayName("проверка на имя пользователя из списка самого короткого и длинного")
        void listName(String name) {
            User user = new User(name, "asassa@mail.ru", 30);
            boolean validName = userValidator.isValidName(user.getName());
            Assertions.assertTrue(validName);
        }
    }

    @Nested
    class TestAge {
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 17, 18, 200})
        @DisplayName("проверить значения возраста от 18 до 100")
        void testAge(int age) {
            User aleks = new User("aleks", "jasan.as@mail.com", age);
            boolean validAge = userValidator.isValidAge(aleks.getAge());
            Assertions.assertTrue(validAge);
        }
    }

    @Nested
    class TestEmail {
        @ParameterizedTest
        @ValueSource(strings = {"hsasasa@mail.com", "assa@inbox.ru", "asad@"})
        @DisplayName("проверка на корректность имени почты")
        void emailTest(String email) {
            User aleks = new User("aleks", email, 25);
            boolean validEmail = userValidator.isValidEmail(aleks.getEmail());
            Assertions.assertTrue(validEmail);
        }
    }

    @ParameterizedTest
    @CsvSource({"aleks, hasasa@inbox.ru, 25", "a, hasan@gmail.com", "mikhail, saas@, 120"})
    @DisplayName("проверка на имя пользователя из списка самого короткого и длинного")
    void setUpUser(String name, String email, int age) {
        User user = new User(name, email, age);
        boolean valid = userValidator.isValid(user);
        Assertions.assertTrue(valid);
    }

}
