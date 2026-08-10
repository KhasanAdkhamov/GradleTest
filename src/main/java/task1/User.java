package task1;

import lombok.Data;

@Data
public class User {
    private String name;
    private String email;
    private int age;

    public User(String alex, String s, int i) {
    }
}
