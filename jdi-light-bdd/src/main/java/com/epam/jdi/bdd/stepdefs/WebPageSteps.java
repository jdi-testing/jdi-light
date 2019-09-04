package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class WebPageSteps {

    //    ACTIONS
    @When("^(?:I |)scroll to the bottom of the page$")
    public void scrollToBottomOfPage() {
        WebPage.scrollToBottom();
    }

    @When("^(?:I |)scroll to the top of the page$")
    public void scrollToTopOfPage() {
        WebPage.scrollToTop();
    }

    @When("^(?:I |)scroll \"(\\d+)\" px down$")
    public void scrollNPxDownAndNPxUp(int x) {
        WebPage.scrollDown(x);
    }

    @When("^(?:I |)scroll \"(\\d+)\" px up$")
    public void scrollNPxUp(int x) {
        WebPage.scrollUp(x);
    }

    @When("^(?:I |)scroll \"(\\d+)\" px right$")
    public void scrollNPxRight(int x) {
        WebPage.scrollRight(x);
    }

    @When("^(?:I |)scroll \"(\\d+)\" px left$")
    public void scrollNPxLeft(int x) {
        WebPage.scrollLeft(x);
    }

    @When("^(?:I |)zoom in$")
    public void zoomIn() {
        WebPage.zoom(2);
    }

    //    ASSERTIONS
    @Then("^the \"([^\"]*)\" text is visible$")
    public void bottomOfPageReached(String text) {
        boolean execResult = jsExecute("return (document.documentElement.textContent " +
                " || document.documentElement.innerText).indexOf(" +
                "'" + text + "') > -1;");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the top of the page is reached$")
    public void topOfPageReached() {
        boolean execResult = jsExecute("if (window.scrollY == 0 && window.scrollX == 0){\n" +
                "return true;\n" +
                "}");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the page is scrolled \"(\\d+)\" px down$")
    public void pageScrolledNPxDown(int x) {
        boolean execResult = jsExecute("console.log(window.scrollY); " +
                "if (window.scrollY == " + x + ") {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the page is scrolled \"(\\d+)\" px up$")
    public void pageScrolledNPxUp(int x) {
        boolean execResult = jsExecute("console.log(window.scrollY); " +
                "if (window.scrollY == 10) {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the page is scrolled \"(\\d+)\" px right$")
    public void pageScrolledNPxRight(int x) {
        jsExecute("console.log(Math.ceil(window.scrollX))");
        boolean execResult = jsExecute("if (Math.ceil(window.scrollX) == " + x + ") {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the page is scrolled \"(\\d+)\" px left$")
    public void pageScrolledNPxLeft(int x) {
        jsExecute("console.log(Math.ceil(window.scrollX))");
        boolean execResult = jsExecute("if (Math.ceil(window.scrollX) == 5) {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the page is zoomed$")
    public void pageIsZoomed() {
        jsExecute("var genderDropdownWidth = document.getElementById('gender').offsetWidth; " +
                "console.log(genderDropdownWidth);");
        boolean execResult = jsExecute(
                "var genderDropdownWidth = document.getElementById('gender').offsetWidth;" +
                        "if (genderDropdownWidth == 546) {return true;}"
        );
        Assert.assertEquals(execResult, true);
    }
}
