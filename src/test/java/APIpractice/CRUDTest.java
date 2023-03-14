package APIpractice;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.Test;

public class CRUDTest {

    private static final Faker FAKER = new Faker();
    private static final String APIHOST = "https://gorest.co.in/public";
    private static final String APIV = "/v2";
    private static final String AUTH = "4a5df07f01f92a0b18a513fe4176f2e030c9bc4a6e4a18e43daea56172202843";


    @Test
    public void getUsersTest() {
        RestAssured.baseURI = APIHOST + APIV;

        Response responseListUsers = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .when()
                .get("/users");

        assertAll(
                () -> assertEquals(200, responseListUsers.getStatusCode(), "Status codes are not the same"),
                () -> assertTrue(responseListUsers.getBody().asString().contains("id"), "id key is not present in the response body"),
                () -> assertTrue(responseListUsers.getBody().asString().contains("name"), "name key is not present in the response body"),
                () -> assertTrue(responseListUsers.getBody().asString().contains("email"), "email key is not present in the response body"),
                () -> assertTrue(responseListUsers.getBody().asString().contains("status"), "status key is not present in the response body"),
                () -> assertTrue(responseListUsers.getBody().asString().contains("gender"), "gender key is not present in the response body")
        );
    }

    @Test
    public void createUserTest() {
        RestAssured.baseURI = APIHOST + APIV;

        String name = FAKER.name().fullName();
        String email = FAKER.internet().emailAddress();
        String body = "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        Response responseCreateUser = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post("/users");

        Response responseGetUserById = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .when()
                .pathParam("userId", responseCreateUser.jsonPath().getString("id"))
                .get("/users/{userId}");

        assertAll(
                () -> assertEquals(201, responseCreateUser.getStatusCode(), "Status codes are not the same"),
                //jsonPath.getString() -> gets value using a key from the json response
                () -> assertEquals(name, responseCreateUser.jsonPath().getString("name"), "Names are not the same"),
                () -> assertEquals(email, responseCreateUser.jsonPath().getString("email"), "Emails are not the same"),
                () -> assertEquals(200, responseGetUserById.getStatusCode(), "Status codes are not the same"),
                () -> assertEquals(name, responseGetUserById.jsonPath().getString("name"), "Names are not the same"),
                () -> assertEquals(email, responseGetUserById.jsonPath().getString("email"), "Emails are not the same"),
                () -> assertTrue(responseGetUserById.getBody().asString().contains("id"), "id key is not present in the response body"),
                () -> assertTrue(responseGetUserById.getBody().asString().contains("name"), "name key is not present in the response body"),
                () -> assertTrue(responseGetUserById.getBody().asString().contains("email"), "email key is not present in the response body"),
                () -> assertTrue(responseGetUserById.getBody().asString().contains("status"), "status key is not present in the response body"),
                () -> assertTrue(responseGetUserById.getBody().asString().contains("gender"), "gender key is not present in the response body")
        );
    }
}
