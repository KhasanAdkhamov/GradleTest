package rest.baseRest.hw;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class restTestsForFakeApi {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }



    @Test
    void getTest() {
        Posts posts =
        given()
                .log()
                .all()
                .when()
                .get("/posts/1")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(Posts.class);
        System.out.println(posts);
        System.out.println(posts.body);
    }

    @Test
    void postTest() {
        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"jack\", \"username\":\"jackson\"}")
                .when()
                .post("/posts")
                .then()
                .log()
                .all()
                .body("name", equalTo("jack"))
                .statusCode(201);
    }



    @Test
    void putTest() {
        Post user = new Post("khas", "khas");
        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(user)
                .pathParam("id", 101)
                .when()
                .put("/posts/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(101));
    }


}
