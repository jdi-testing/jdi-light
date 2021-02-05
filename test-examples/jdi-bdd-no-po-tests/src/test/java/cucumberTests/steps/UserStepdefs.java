package cucumberTests.steps;

import io.cucumber.java.en.Given;

public class UserStepdefs {
    @Given("CUSTOM {string} STEP")
    public void customStep(String name) {
    }
}