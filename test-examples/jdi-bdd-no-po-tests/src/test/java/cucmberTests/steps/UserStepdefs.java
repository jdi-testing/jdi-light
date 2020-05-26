package cucmberTests.steps;

import cucumber.api.java.en.Given;

public class UserStepdefs {
    @Given("^CUSTOM \"([^\"]*)\" STEP$")
    public void customStep(String name) {
    }
}