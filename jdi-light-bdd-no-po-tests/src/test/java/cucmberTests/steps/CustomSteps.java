package cucmberTests.steps;

import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;

import static com.epam.jdi.light.ui.html.HtmlFactory.$;

public class CustomSteps {
    private static boolean sLoggedIn = false;
    @Given("^(?:I |)logged in with name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoggedIn(String name, String password) {
        if (!sLoggedIn) {
            WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
            $("img#user-icon").click();
            $("form #name").sendKeys(name);
            $("form #password").sendKeys(password);
            $("form [type=submit]").click();
            sLoggedIn = true;
        }
    }
}
