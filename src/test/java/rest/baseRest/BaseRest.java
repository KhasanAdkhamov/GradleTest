package rest.baseRest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rest.baseRest.spec.SpecClient;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BaseRest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGet() {
        given()//подготовка
                .log()
                .all()
                .when()//что мы делаем после подготовки данных
                .get("/posts")//отправляет запрос на сервер, posts указывает на url, добавляет на url 14ую строку
                .then()//указывает что делать с ответом от сервера
                .log()//вводим или сохраняем информацию о запросе или информации, которую мы отправляем
                .all()
                .statusCode(200);
    }

    @Test
    public void testPatch() {
//        String json = """
//                {
//                "title": "foo"
//                }
//                """;
        PostsUpdate postsUpdate = new PostsUpdate("foo");

        given().log().all().spec(SpecClient.shouldSendBody(postsUpdate)).when().patch("/posts/1").then().spec(SpecClient.shouldBeStatusCode200AndLog());
    }

    @Test
    public void testGetBody() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .log().all()
                .spec(SpecClient.shouldBeStatusCode200Body(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }

    @Test
    public void testGetBody2() {
        given()
                .when()
                .get("/posts/3")
                .then()
                .log().all()
                .spec(SpecClient.shouldBeStatusCode200Body(3, 1, "ea molestias quasi exercitationem repellat qui ipsa sit aut", "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"));
    }


}
