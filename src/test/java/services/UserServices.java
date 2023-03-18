package services;

import APIpractice.RESTBase;
import APIpractice.pojos.UserPojo;
import APIpractice.users.RESTClientUsers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;

public class UserServices extends RESTBase {

    public void createUserWithName(String userName) {
        baseUrlSetup();
        UserPojo newUser = new UserPojo(userName, FAKER.internet().emailAddress(),
                "male", "active");

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Response createUser = restClientUsers.createUser(AUTH, gson.toJson(newUser));
        System.out.println(createUser.getStatusCode() + " -> " + createUser.getBody().asString());
    }
}
