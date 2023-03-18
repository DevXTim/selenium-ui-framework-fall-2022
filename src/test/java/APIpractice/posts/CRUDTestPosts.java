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
        // Prepare user to use for the creation of post
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        UserPojo newUser = new UserPojo(FAKER.name().fullName(), FAKER.internet().emailAddress(),
                "female", "inactive");
        Response createUserResponse = restClientUsers.createUser(AUTH, gson.toJson(newUser));
        Assumptions.assumeTrue(201 == createUserResponse.getStatusCode());
        UserPojo createResponseUser = gson.fromJson(createUserResponse.asString(), UserPojo.class);
        Response getUserById = restClientUsers.getUserById(AUTH, createResponseUser.getId() + "");
        Assumptions.assumeTrue(200 == getUserById.getStatusCode());

        // Act -> create a post for new user and use Jackson to serialize it
        // Create pojo for the posts
        // Get dependency Jackson
        // Arrange pojo with annotations
        // create a post
    }
}
