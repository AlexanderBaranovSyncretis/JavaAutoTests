package rest.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ReqSpecHelper {

    public static RequestSpecification createSpec(UserType userType) {
        Map<String, String> token = retrieveToken(PropHelper.properties, userType.toString());
//        System.out.println("token: " + token);  //for debug
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addCookies(token)
                .addHeader("X-CSRFToken", token.get("csrftoken"))
                .build();
    }

    private static Map<String, String> retrieveToken(Properties properties, String type) {
//        System.out.println("Username " + properties.get(type + ".name")); //for debug
//        System.out.println("Password " + properties.get(type + ".password")); //for debug

        return given()
                .with()
                .body(new JSONObject()
                        .put("username", properties.get(type + ".name"))
                        .put("password", properties.get(type + ".password")).toString())
                .contentType(ContentType.JSON)
                .post("http://users.bugred.ru/rest/dologin").getCookies();
    }
}
