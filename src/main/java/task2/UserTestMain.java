package task2;

public class UserTestMain {
    public static void main(String[] args) {
        User sdaD = new User("sdaD", "has.adx@mail.com", 25);
        UserValidator userValidator = new UserValidator();
        boolean validName = userValidator.isValidName(sdaD.getName());
        System.out.println(validName);


    }
}
