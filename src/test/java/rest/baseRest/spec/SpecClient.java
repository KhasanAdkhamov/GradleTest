package rest.baseRest.spec;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SpecClient {

    public static RequestSpecification shouldSendBody(String json) {
        return given().contentType(ContentType.JSON).body(json);
    }

    public static ResponseSpecification shouldBeStatusCode200AndLog()  {
        return given().then().statusCode(200);
    }

    public static ResponseSpecification shouldBeStatusCode200Body(int id, int userId, String title, String body) {
        return given().then().statusCode(200).body("userId", equalTo(userId)).body("id", equalTo(id)).body("title", equalTo(title)).body("body", equalTo(body));
    }
}
