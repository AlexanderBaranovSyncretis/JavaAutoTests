package rest;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static rest.ReqSpecHelper.createSpec;

public class TestBase {

    protected static RequestSpecification managerSpec;
    protected static RequestSpecification simpleUserSpec;

    @BeforeAll
    private static void setupTests() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "http://users.bugred.ru/";
        RestAssured.basePath = "rest/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        managerSpec = createSpec(UserType.MANAGER);
        simpleUserSpec = createSpec(UserType.SIMPLE_USER);
    }

    protected static RequestSpecification chooseUser(String specName, String... params) {
        return switch (specName) {
            case "managerSpec" -> managerSpec;
            case "simpleUserSpec" -> simpleUserSpec;
            default -> null;
        };
    }

    protected static ResponseSpecification getDefaultResSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }
}