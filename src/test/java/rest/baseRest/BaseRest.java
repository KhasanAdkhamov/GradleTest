package rest.baseRest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        String json = """
                {
                "title": "foo"
                }
                """;
        given().contentType(ContentType.JSON).body(json).when().patch("/posts/1").then().statusCode(200);
    }

    @Test
    public void testGetBody() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(1));
    }
}
