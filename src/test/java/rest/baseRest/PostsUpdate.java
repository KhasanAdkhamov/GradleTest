package rest.baseRest;

public class PostsUpdate {
    String title;

    public PostsUpdate() {

    }

    public PostsUpdate(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
