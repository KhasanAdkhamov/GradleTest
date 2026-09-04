package gson;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class GsonMapper {
    @Test
    void toJson() {
        Gson gson = new Gson();
        Post post = new Post("jack", "jackson");
        String json = gson.toJson(post);
        System.out.println(json);
        Post post1 = gson.fromJson(json, Post.class);
        System.out.println(post1);
    }
}
