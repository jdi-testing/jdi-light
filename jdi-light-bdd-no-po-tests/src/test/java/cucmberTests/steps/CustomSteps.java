package cucmberTests.steps;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.map.MapArray;
import cucumber.api.java.en.Given;

import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.tools.map.MapArray.map;

public class CustomSteps {
    private static boolean sLoggedIn = false;

    @Given("^(?:I |)logged in with name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoggedIn(String name, String password) {
        if (!sLoggedIn) {
            WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
            $("img#user-icon").click();
            new Form().submit(new MapArray<>(new Object[][] {{"name", name}, {"password", password}}));
/*        $("form #name").sendKeys(name);
        $("form #password").sendKeys(password);
        $("form [type=submit]").click();*/
            sLoggedIn = true;
        }
    }
}
