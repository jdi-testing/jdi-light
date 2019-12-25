package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.height;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class NumberSelectorExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        height.setNumber("2.1");
    }

    @Test
    public void minMaxTest() {
        height.assertThat().min(is(0.3));
        height.assertThat().max(is(2.5));
    }

    @Test
    public void stepTest() {
        height.assertThat().step(is(0.2));
    }

    @Test
    public void placeholderTest() {
        height.is().placeholder("20 cm increments. Range [0.3,2.5]");
    }

    @Test
    public void setNumberTest() {
        height.setNumber("1.4");
        height.is().number(greaterThanOrEqualTo(0.3));
        height.is().number(lessThanOrEqualTo(2.5));
        height.assertThat().number(is(1.4));
    }

    @Test
    public void labelTest() {
        height.label().is().text("Height (metres):");
        height.label().is().text(containsString("Height"));
        height.label().is().text(equalToIgnoringCase("height (metres):"));
    }

    @Test
    public void assertValidationTest() {
        height.assertThat().number(greaterThan(0.0));
        height.assertThat().number(lessThan(3.0));
        height.assertThat().number(is(2.1));
    }
}
