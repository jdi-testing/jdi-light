package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardNavigation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Zaur Bibilov on 24.09.2019
 * Email: zaur_bibilov@epam.com;
 * Skype: dasilveria
 */

public class CardNavigationTests extends TestsInit {

    // Texts to check
    String titleText = "SPECIAL TITLE TREATMENT";
    String subtitleText = "With supporting text below as a natural lead-in to additional content.";
    String buttonText = "Click Me!";
    String activeLinkText = "Active";
    String jdiLinkText = "JDI";
    String disabledLinkText = "Disabled";
    String activeLinkRef = "javascript: void()";
    String jdiLinkRef = "https://github.com/jdi-testing/jdi-light";
    String disabledLinkRef = "javascript: void()";
    String jdiLinkPath = "/jdi-testing/jdi-light";
    String activeLinkAlert = "Active Tab Clicked!";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTitleTextTest() {
        assertEquals(cardNavigation.title.getText(), titleText);
    }

    @Test
    public void getDescriptionTextTest() {
        assertEquals(cardNavigation.subtitle.getText(), subtitleText);
    }

    @Test
    public void getButtonTextTest() {
        assertEquals(cardNavigation.button.getText(), buttonText);
    }

    @Test
    public void getLinkTextTest() {
        cardNavigation.nav.highlight();
        assertEquals(cardNavigation.activeLink.getText(), activeLinkText);
        assertEquals(cardNavigation.jdiLink.getText(), jdiLinkText);
        assertEquals(cardNavigation.disabledLink.getText(), disabledLinkText);
    }

    @Test
    public void getLinkValueTest() {
        cardNavigation.nav.highlight();
        assertEquals(cardNavigation.activeLink.getValue(), activeLinkText);
        assertEquals(cardNavigation.jdiLink.getValue(), jdiLinkText);
        assertEquals(cardNavigation.disabledLink.getValue(), disabledLinkText);
    }

    @Test
    public void getLinkRefTest() {
        cardNavigation.nav.highlight();
        assertEquals(cardNavigation.activeLink.ref(), activeLinkRef);
        assertEquals(cardNavigation.jdiLink.ref(), jdiLinkRef);
        assertEquals(cardNavigation.disabledLink.ref(), disabledLinkRef);
    }

    @Test
    public void getLinkUrlTest() {
        cardNavigation.nav.highlight();
        assertEquals(cardNavigation.jdiLink.url().getPath(), jdiLinkPath);
    }

    @Test
    public void linkClickTest() {
        cardNavigation.nav.highlight();

        cardNavigation.activeLink.click();
        validateAlert(is(activeLinkAlert));

        cardNavigation.jdiLink.click();
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));
        assertEquals(getUrl() , jdiLinkRef);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValidationTest() {
        cardNavigation.highlight();

        cardNavigation.title.is().text(titleText);
        cardNavigation.title.is().displayed();

        cardNavigation.subtitle.is().text(subtitleText);
        cardNavigation.subtitle.is().displayed();

        cardNavigation.activeLink.is().displayed();
        cardNavigation.activeLink.is().enabled();

        cardNavigation.jdiLink.is().displayed();
        cardNavigation.jdiLink.is().enabled();

        cardNavigation.disabledLink.is().displayed();
        cardNavigation.disabledLink.is().disabled();

        cardNavigation.activeLink.assertThat().text(is(activeLinkText));
        cardNavigation.jdiLink.assertThat().text(is(jdiLinkText));
        cardNavigation.disabledLink.assertThat().text(is(disabledLinkText));

        cardNavigation.activeLink.is().ref(activeLinkRef);
        cardNavigation.jdiLink.is().ref(jdiLinkRef);
        cardNavigation.disabledLink.is().ref(disabledLinkRef);

        cardNavigation.button.is().text(is(buttonText));
        cardNavigation.button.is().text(containsString("Click"));
        assertThat(cardNavigation.button.core().css("font-size"), is("16px"));
        cardNavigation.button.assertThat().displayed()
                .and()
                .core()
                .cssClass("btn btn-primary")
                .attr("onclick", "alert('Button Clicked!');")
                .tag(is("button"));
    }

}
