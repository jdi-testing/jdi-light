package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Image;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.bdd.Utils.getImage;
import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.elements.base.Alerts.getAlertText;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class ImageSteps {
    @Then("^source of image \"([^\"]*)\" is \"([^\"]*)\"$")
    public void sourceOfImageIs(String imageName, String source) {
        Image image = getImage(imageName);
        assertEquals(image.src(), source);
    }

    @Then("^image \"([^\"]*)\" alt attribute is \"([^\"]*)\"$")
    public void imageAltAttributeIs(String imageName, String altAttributeText){
        Image image = getImage(imageName);
        image.is().alt(Matchers.is(altAttributeText));
    }

    @When("^click at image \"([^\"]*)\"$")
    public void clickAtImage(String imageName){
        getImage(imageName).click();
    }

    @Then("^image source of \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void imageSourceOfContains(String imageName, String text) {
        getImage(imageName).is().src(containsString(text));
    }

    @When("^I click on image \"([^\"]*)\"$")
    public void iClickOnImage(String imageName) {
        getImage(imageName).click();
        assertEquals(getAlertText(), "JDI Logo");
    }


    @And("^image \"([^\"]*)\" height is (\\d+)$")
    public void imageHeightIs(String imageName, int height) {
        Image image = getImage(imageName);
        assertEquals(image.height(), Integer.toString(height));
    }

    @And("^image \"([^\"]*)\" width is (\\d+)$")
    public void imageWidthIs(String imageName, int width) {
        Image image = getImage(imageName);
        assertEquals(image.width(), Integer.toString(width));
    }

    @Then("^\"([^\"]*)\" alt is \"([^\"]*)\"$")
    public void altIs(String imageName, String altAttributeText) {
        Image image = getImage(imageName);
        image.assertThat().alt(Matchers.is(altAttributeText));
    }
}
