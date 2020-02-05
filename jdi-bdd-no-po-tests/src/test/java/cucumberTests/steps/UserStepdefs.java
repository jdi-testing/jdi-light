package cucumberTests.steps;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.settings.WebSettings;
import cucumber.api.java.en.Given;
import static com.epam.jdi.light.elements.init.UIFactory.$;

public class UserStepdefs {
    @Given("^I'm logged in as \"([^\"]*)\" with \"([^\"]*)\" password$")
    public void logIn(String name, String pass) {
        WebSettings.init();
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
        
        if ($("#user-name").isHidden()) {
            $("img#user-icon").click();
            new Form<User>().submit(new User().set(u -> {
                u.name = name;
                u.password = pass;
            }));
        }
    }
}