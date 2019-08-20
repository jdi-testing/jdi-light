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
    @Then("^image \"([^\"]*)\" src is equals to \"([^\"]*)\"$")
    public void imageSrcIsEqualsTo(String imageName, String source) {
        Image image = getImage(imageName);
        assertEquals(image.src(), source);
    }

    @Then("^image \"([^\"]*)\" alt attribute is equal to \"([^\"]*)\"$")
    public void imageAltAttributeIs(String imageName, String altAttributeText){
        Image image = getImage(imageName);
        image.is().alt(Matchers.is(altAttributeText));
    }

    @When("^click at image \"([^\"]*)\"$")
    public void clickAtImage(String imageName){
        getImage(imageName).click();
    }

    @Then("^image \"([^\"]*)\" scr contains \"([^\"]*)\"$")
    public void assertThatImageScrContains(String imageName, String text) {
        getImage(imageName).is().src(containsString(text));
    }

    @When("^I click on image \"([^\"]*)\"$")
    public void iClickOnImage(String imageName) {
        getImage(imageName).click();
        assertEquals(getAlertText(), "JDI Logo");
    }

    @And("^image \"([^\"]*)\" height is equal to (\\d+)$")
    public void assertThatImageHeightIs(String imageName, int height) {
        Image image = getImage(imageName);
        assertEquals(image.height(), Integer.toString(height));
    }

    @And("^image \"([^\"]*)\" width is equal to (\\d+)$")
    public void assertThatImageWidthIs(String imageName, int width) {
        Image image = getImage(imageName);
        assertEquals(image.width(), Integer.toString(width));
    }

}
