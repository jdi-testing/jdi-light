package com.epam.jdi.bdd.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.tools.JsonUtils.getInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebPageSteps {
    private final int SCROLLY = 0;
    private final int SCROLLX = 0;

    //    ACTIONS
    @When("^(?:I |)scroll to the bottom of the page$")
    public void scrollToBottomOfPage() {
        scrollToBottom();
    }

    @When("^(?:I |)scroll to the top of the page$")
    public void scrollToTopOfPage() {
        scrollToTop();
    }

    @When("^(?:I |)scroll \"(\\d+)\" px down$")
    public void scrollNPxDownAndNPxUp(int x) {
        scrollDown(x);
    }

    @When("^(?:I |)scroll \"(\\d+)\" px up$")
    public void scrollNPxUp(int x) {
        scrollUp(x);
    }

    @When("^(?:I |)scroll \"(\\d+)\" px right$")
    public void scrollNPxRight(int x) {
        scrollRight(x);
    }

    @When("^(?:I |)scroll \"(\\d+)\" px left$")
    public void scrollNPxLeft(int x) {
        scrollLeft(x);
    }

    @When("^(?:I |)zoom in \"(\\d+)\" times$")
    public void zoomIn(int x) {
        zoom(x);
    }

    //    ASSERTIONS
    @Then("^the bottom of the page is reached$")
    public void bottomOfPageReached() {
        boolean execResult = isBottomOfThePage();
        assertThat(execResult, is(true));
    }

    @Then("^the top of the page is reached$")
    public void topOfPageReached() {
        boolean execResult = isTopOfThePage();
        assertThat(execResult, is(true));
    }

    @Then("^the page scrolled by \"(\\d+)\" px down$")
    public void pageScrolledDown(int y) {
        int execResult = getInt(jsExecute("return window.scrollY;"));
        assertThat(execResult, greaterThan(SCROLLY + y-2));
        assertThat(execResult, lessThan(SCROLLY + y+1));
    }

    @Then("^the page scrolled by \"(\\d+)\" px right$")
    public void pageScrolledRight(int x) {
        int execResult = getInt(jsExecute("return Math.ceil(window.scrollX);"));
        assertThat(execResult, greaterThan(SCROLLX + x-2));
        assertThat(execResult, lessThan(SCROLLX + x+1));
    }

    @Then("^the page is zoomed \"(\\d+)\" times$")
    public void pageIsZoomed(double x) {
        assertThat(zoomLevel(), is(x));
    }
}
