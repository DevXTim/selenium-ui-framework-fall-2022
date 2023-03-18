package APIpractice.posts;

import APIpractice.RESTBase;
import APIpractice.pojos.UserPojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class CRUDTestPosts extends RESTBase {

    @Test
    public void createPostTest() {
        // Arrangement part
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        UserPojo newUser = new UserPojo(FAKER.name().fullName(), FAKER.internet().emailAddress(),
                "female", "inactive");

        Response createUserResponse = restClientUsers.createUser(AUTH, gson.toJson(newUser));

        Assumptions.assumeTrue(201 == createUserResponse.getStatusCode());

        Response getUserById = restClientUsers.getUserById(AUTH, createUserResponse
                .jsonPath().getString("id"));

        Assumptions.assumeTrue(200 == getUserById.getStatusCode());
    }
}
