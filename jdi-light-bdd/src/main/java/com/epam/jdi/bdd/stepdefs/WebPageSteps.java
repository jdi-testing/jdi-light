package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class WebPageSteps {

    private final int SCROLLY = 0;
    private final int SCROLLX = 0;

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

    @When("^(?:I |)zoom in \"(\\d+)\" times$")
    public void zoomIn(int x) {
        WebPage.zoom(x);
    }

    //    ASSERTIONS
    @Then("^the bottom of the page is reached$")
    public void bottomOfPageReached() {
        boolean execResult = jsExecute("return (" +
                "(window.innerHeight + window.scrollY) >= document.body.scrollHeight);");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the top of the page is reached$")
    public void topOfPageReached() {
        boolean execResult = jsExecute("return window.scrollX == window.scrollY;");
        Assert.assertEquals(execResult, true);
    }

    @Then("^the page is scrolled \"(\\d+)\" px down$")
    public void pageScrolledNPxDown(int x) {
        long execResult = jsExecute("return window.scrollY;");
        Assert.assertEquals(execResult, SCROLLY + x);
    }

    @Then("^the page is scrolled \"(\\d+)\" px up$")
    public void pageScrolledNPxUp(int x) {
        long execResult = jsExecute("return window.scrollY;");
        Assert.assertEquals(execResult, SCROLLY - x);
    }

    @Then("^the page is scrolled \"(\\d+)\" px right$")
    public void pageScrolledNPxRight(int x) {
        long execResult = jsExecute("return Math.ceil(window.scrollX);");
        Assert.assertEquals(execResult, SCROLLX + x);
    }

    @Then("^the page is scrolled \"(\\d+)\" px left$")
    public void pageScrolledNPxLeft(int x) {
        long execResult = jsExecute("return Math.ceil(window.scrollX);");
        Assert.assertEquals(execResult, SCROLLX - x);
    }

    @Then("^the page is zoomed \"(\\d+)\" times$")
    public void pageIsZoomed(int x) {
        long initZoom = jsExecute("return Math.round(window.devicePixelRatio * 100);");
        long finalZoom = jsExecute("return (Math.round(window.devicePixelRatio * 100) * " + x + ");");
        Assert.assertEquals((finalZoom / 2), initZoom);
    }
}
