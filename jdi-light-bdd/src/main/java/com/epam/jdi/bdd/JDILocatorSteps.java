package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.hamcrest.Matchers.matchesPattern;

public class JDILocatorSteps {
    @When("^(?:I |)Click on \"([^\"]*)\" element$")
    public void click(String locator) {
        WebElement el = getDriver().findElement(By.cssSelector(locator));
        el.click();
    }

    @When("^(?:I |)Click with JS on \"([^\"]*)\" element$")
    public void jsClick(String locator) {
        BaseUIElement el = new UIElement(getDriver().findElement(By.cssSelector(locator)));
        el.jsClick();
    }

    @Then("^the \"([^\"]*)\" element text equals to \"([^\"]*)\"$")
    public void textEquals(String locator, String value) {
        JDIBase el = new UIElement(getDriver().findElement(By.cssSelector(locator)));
        el.is().text(value);
    }

    @When("^(?:I |)send keys \"([^\"]*)\" to \"([^\"]*)\" element$")
    public void sendKeys(String value, String locator) {
        BaseUIElement el = new UIElement(getDriver().findElement(By.cssSelector(locator)));
        el.sendKeys(value);
    }

    @Then("^the \"([^\"]*)\" element text matches to \"([^\"]*)\"$")
    public void textMatchRegex(String locator, String regex) {
        JDIBase el = new UIElement(getDriver().findElement(By.cssSelector(locator)));
        el.is().text(matchesPattern(regex));
    }

    @When("^(?:I |)check \"([^\"]*)\" element$")
    public void check(String locator) {
        BaseUIElement el = new UIElement(getDriver().findElement(By.cssSelector(locator)));
        el.check();
    }

    @Then("^the \"([^\"]*)\" element is selected$")
    public void isSelected(String locator) {
        JDIBase el = new UIElement(getDriver().findElement(By.cssSelector(locator)));
        el.is().selected();
    }
}
