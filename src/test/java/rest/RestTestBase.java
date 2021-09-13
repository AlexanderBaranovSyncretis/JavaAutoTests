package rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class RestTestBase {

    @BeforeAll
    private static void setupTests() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "http://users.bugred.ru/";
        RestAssured.basePath = "tasks/rest/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    protected static RequestSpecification getResSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://users.bugred.ru/")
                .setBasePath("tasks/rest/")
                .setContentType(ContentType.JSON)
                .build();
    }

    protected static ResponseSpecification getDefaultResSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static void deleteUserByAPI(String email) {
        String body = String.format("{\"email\": \"%s\"}", email);
        given().spec(getResSpec()).when().body(body).delete("deleteuser");
    }
}
