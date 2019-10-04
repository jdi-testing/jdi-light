package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardNavigation;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Zaur Bibilov on 24.09.2019
 * Email: zaur_bibilov@epam.com;
 * Skype: dasilveria
 */

public class CardNavigationTests extends TestsInit {

    private final String titleText = "SPECIAL TITLE TREATMENT";
    private final String subtitleText = "With supporting text below as a natural lead-in to additional content.";
    private final String buttonText = "Click Me!";
    private final String activeLinkText = "Active";
    private final String jdiLinkText = "JDI";
    private final String disabledLinkText = "Disabled";
    private final String activeLinkRef = "javascript: void()";
    private final String jdiLinkRef = "https://github.com/jdi-testing/jdi-light";
    private final String disabledLinkRef = "javascript: void()";
    private final String jdiLinkPath = "/jdi-testing/jdi-light";
    private final String activeLinkAlert = "Active Tab Clicked!";

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
        WindowsManager windowsManager = new WindowsManager();
        windowsManager.switchToWindow(2);
        assertEquals(getUrl() , jdiLinkRef);
        windowsManager.closeWindow();
        windowsManager.switchToWindow(1);
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
