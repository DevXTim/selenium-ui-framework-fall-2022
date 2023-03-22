package services;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.RegisterUser;

import java.util.Map;

public class UserServices {

    private static Gson gson = new Gson();
    private static final Faker FAKER = new Faker();
    String baseUrl = "http://18.118.14.155:8080/bank/api/v1";

    public void createNewUserViaApi(String authToken, Map<String, String> newUserMap) {
        RestAssured.baseURI = baseUrl;

        RegisterUser newUser = createUserObj(newUserMap);

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

    private RegisterUser createUserObj(Map<String, String> newUserMap) {
        RegisterUser user = new RegisterUser();
        user.setAddress(FAKER.address().fullAddress());
        user.setCountry(newUserMap.get("country"));
        user.setDob(newUserMap.get("dob"));
        user.setEmailAddress(FAKER.internet().emailAddress());
        user.setFirstName(newUserMap.get("firstName") + "_" + FAKER.code().imei());
        user.setGender(newUserMap.get("gender"));
        user.setHomePhone(FAKER.numerify("##########"));
        user.setLastName(newUserMap.get("lastName"));
        user.setLocality(newUserMap.get("locality"));
        user.setMobilePhone("");
        user.setPassword(newUserMap.get("password"));
        user.setPostalCode(newUserMap.get("postalCode"));
        user.setRegion(newUserMap.get("region"));
        user.setSsn(FAKER.idNumber().ssnValid());
        user.setTitle(newUserMap.get("title"));
        user.setWorkPhone("");
        return user;
    }
}
