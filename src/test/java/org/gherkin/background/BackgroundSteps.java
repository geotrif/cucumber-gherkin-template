package org.gherkin.background;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class BackgroundSteps {

    // --- Simple in-memory "world" state shared across steps ---
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Blog> blogs = new HashMap<>();
    private final BlogService blogService = new BlogService(blogs);

    private User currentUser;
    private String lastMessage;

    // ---------------- Background ----------------

    @Given("a global administrator named {word}")
    public void aGlobalAdministratorName(String name) {
        users.put(name, new User(name, Role.ADMIN));
    }

    @And("a customer named {string}")
    public void aCustomerNamed(String name) {
        // This version supports names with spaces like "Dr. Bill"
        users.put(name, new User(name, Role.CUSTOMER));
    }

    @And("a blog named {string}")
    public void aBlogNamed(String blogName) {
        // Blog without explicit owner (can be assigned later)
        blogs.put(blogName, new Blog(blogName, null));
    }

    @And("a blog named {string} owned by {string}")
    public void aBlogNamedOwnedBy(String blogName, String ownerName) {
        User owner = users.computeIfAbsent(ownerName, n -> new User(n, Role.CUSTOMER));
        blogs.put(blogName, new Blog(blogName, owner));
    }

    // ---------------- Scenarios ----------------

    @Given("I am logged in as {string}")
    public void iAmLoggedInAs(String name) {
        User user = users.get(name);
        if (user == null) {
            // If not created in Background, default to a CUSTOMER
            user = new User(name, Role.CUSTOMER);
            users.put(name, user);
        }
        currentUser = user;
    }

    @When("I try to post to {string}")
    public void iTryToPost(String blogName) {
        lastMessage = blogService.post(currentUser, blogName);
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, lastMessage, "The UI message after posting did not match.");
    }
}
