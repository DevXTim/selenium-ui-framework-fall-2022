package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.UserServices;

public class PostsSteps {
    private UserServices userServices = new UserServices();

    @Given("creates a new user with name {string}")
    public void creates_a_new_user_with_name(String userName) {
        userServices.createUserWithName(userName);
    }

    @When("user creates a post with title {string} and body {string} for user {string}")
    public void user_creates_a_post_with_title_and_body_for_user(String postTitle, String bodyTitle, String userName) {
//        postServices.createPostForUserByName(postTitle, bodyTitle, userName);
    }

    @Then("check if new post is created with title {string} and body {string} for user {string}")
    public void check_if_new_post_is_created_with_title_and_body_for_user(String postTitle, String bodyTitle, String userName) {
//        postService.assertPostExistsForUser(postTitle, bodyTitle, userName);
    }
}
