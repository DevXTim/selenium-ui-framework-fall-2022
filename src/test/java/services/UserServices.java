package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.RegisterUser;

public class UserServices {

    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    String baseUrl = "http://18.118.14.155:8080/bank/api/v1";

    public void createNewUserViaApi(String authToken, RegisterUser newUser) {
        RestAssured.baseURI = baseUrl;
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .headers("Authorization", "Bearer " + authToken)
                .body(gson.toJson(newUser))
                .when()
                .post("/user");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
    }
}
