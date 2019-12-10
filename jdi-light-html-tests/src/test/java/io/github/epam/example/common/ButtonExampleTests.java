package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.dblClickButton;
import static io.github.com.pages.HtmlElementsPage.redButton;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Test examples for Button with JDI Light asserts
 */
public class ButtonExampleTests implements TestsInit {

    String text = "Big Red Button-Input";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void buttonTest() {
        redButton.is().text(text);
        redButton.assertThat().displayed()
                .and().text(is(text))
                .core()
                .css("font-size", is("14px"))
                .cssClass("uui-button red")
                .attr("type", "button")
                .tag(is("input"));
    }

    @Test
    public void buttonIsTest() {
        redButton.is().enabled();
        redButton.is().text(equalTo(text));
    }

    @Test
    public void buttonAssertThatTest() {
        redButton.assertThat().text(is(text));
    }

    @Test
    public void buttonClickTest() {
        redButton.click();
        validateAlert(containsString("Red button"));
        dblClickButton.doubleClick();
        validateAlert(containsString("Double Click"));
    }

}
