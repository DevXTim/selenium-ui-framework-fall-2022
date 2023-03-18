package APIpractice.posts;

import APIpractice.RESTBase;
import APIpractice.pojos.PostPojo;
import APIpractice.pojos.UserPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class CRUDTestPosts extends RESTBase {

    @Test
    public void createPostTest() throws JsonProcessingException {
        // Arrangement part
        // Prepare user to use for the creation of post
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        UserPojo newUser = new UserPojo(FAKER.name().fullName(), FAKER.internet().emailAddress(),
                "female", "inactive");
        Response createUserResponse = restClientUsers.createUser(AUTH, gson.toJson(newUser));
        Assumptions.assumeTrue(201 == createUserResponse.getStatusCode());
        System.out.println(createUserResponse.asString());
        UserPojo createResponseUser = gson.fromJson(createUserResponse.asString(), UserPojo.class);
        Response getUserById = restClientUsers.getUserById(AUTH, createResponseUser.getId() + "");
        Assumptions.assumeTrue(200 == getUserById.getStatusCode());

        // Act -> create a post for new user and use Jackson to serialize it
        // Create pojo for the posts +
        // Get dependency Jackson +
        // create a post
        PostPojo newPost = new PostPojo(FAKER.book().title(), FAKER.backToTheFuture().quote());
        System.out.println(newPost);

        // Class from Jackson that has de-serialization methods
        ObjectMapper objectMapper = new ObjectMapper();
        // Serialization of post object into json using Jackson lib
        String jsonPost = objectMapper.writeValueAsString(newPost);
        System.out.println(jsonPost);


        // Snake case user_id
        // Camel case userId -> Java it should be userId
        Response createPostResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .body(jsonPost)// serialize it
                .when()
                .pathParam("userId", createResponseUser.getId() + "")
                .post("/users/{userId}/posts");

        System.out.println(createPostResponse.asString());
        System.out.println(createPostResponse.getStatusCode());


        // Arrange pojo with annotations

    }
}
