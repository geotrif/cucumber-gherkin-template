package org.gherkin.step_arguments;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepArgumentsSteps {
    String blogPost = "";
    String body = "";
    DataTable usersTable = DataTable.emptyDataTable();

    @Given("a blog post named {string} with Markdown body:")
    public void blogPostAndBody(String blogPost, String body) {
        // Implementation for handling blog post and body
        this.blogPost = blogPost;
        this.body = body;

        System.out.println("Blog Post: " + blogPost);
        System.out.println("Body: " + body);
    }

    @When("I visit the blog post titled {string}")
    public void visitBlogPost(String blogPost) {
        // Implementation for visiting the blog post
        System.out.println("Visiting Blog Post: " + blogPost);
    }

    @Then("I should see a heading {string}")
    public void seeHeadingName(String heading) {
        // Implementation for verifying the heading
        System.out.println("Verifying Heading: " + heading);

        Assertions.assertTrue(this.body.contains(heading));
    }

    @Given("the following users exist:")
    public void userSetup(DataTable usersTable) {
        // Implementation for setting up users from DataTable
        this.usersTable = usersTable;

        usersTable.asMaps().forEach(user -> {
            System.out.println("User: " + user.get("name") + ", Email: " + user.get("email"));
        });
    }

    @When("I visit the user list")
    public void visitUserList() {
        System.out.println("Visiting User List");
    }

    @Then("I should see the following users: {string}, {string} and {string}")
    public void seeUserInList(String user1, String user2, String user3) {
        System.out.println("Verifying Users in List: " + user1 + ", " + user2 + ", " + user3);

        Assertions.assertEquals(user1, usersTable.asMaps().get(0).get("name"));
        Assertions.assertEquals(user2, usersTable.asMaps().get(1).get("name"));
        Assertions.assertEquals(user3, usersTable.asMaps().get(2).get("name"));
    }
}
