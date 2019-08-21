package cucmberTests.stepdefs;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import cucumber.api.java.en.Then;

import static com.epam.jdi.bdd.Utils.getBaseUIElement;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Ekaterina Vasilkova on 19.08.2019
 */

public class LinkStepdefs {

    @Then("^\"([^\"]*)\" URL path equals to \"([^\"]*)\"$")
    public void urlPathEquals(String name, String expectedText) {
        BaseUIElement el = getBaseUIElement(name);
        try {
            ((HtmlElement) el).is().urlPath(equalTo(expectedText));
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

}