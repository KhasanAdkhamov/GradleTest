package task2;

import java.util.regex.Pattern;

public class UserValidator {
    private String regex = "^\\w+@\\w+\\.\\w{2,3}$";

    public boolean isValid(User user) {
        if (user == null) return false;
        return isValidName(user.getName()) && isValidAge(user.getAge()) && isValidEmail(user.getEmail());
    }

    public boolean isValidName(String name) {
       return name != null && name.length() >= 3 && name.length() < 15;
    }

    public boolean isValidAge(int age) {
        return age >= 18 && age <= 100;
    }

    public boolean isValidEmail(String email) {
        return !email.isEmpty() && Pattern.matches(regex, email);
    }
}
