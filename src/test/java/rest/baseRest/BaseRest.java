package rest.baseRest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BaseRest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGet() {
        given().log().all().when().get("/posts").then().log().all().statusCode(200);
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
}
