package gson;

public class Post {
    private String name;
    private String username;
    private int id;

    public Post(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                '}';
    }
}
