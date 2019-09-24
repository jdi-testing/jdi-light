package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.elements.common.Label;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardNavigation;
import static io.github.com.pages.BootstrapPage.cardWithSubtitlesAndLinks;
import static io.github.epam.states.States.shouldBeLoggedIn;
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
        cardNavigation.menu.highlight();
        assertEquals(cardNavigation.activeLink.getText(), activeLinkText);
    }

//    @Test
//    public void getLinkValueTest() {
//        cardNavigation.menu.highlight();
//        assertEquals(cardNavigation.activeLink.getValue(), activeLinkText);
//        assertEquals(cardNavigation.jdiLink.getValue(), jdiLinkText);
//        assertEquals(cardNavigation.disabledLink.getValue(), disabledLinkText);
//    }

//    @Test
//    public void getLinkRefTest() {
//        cardNavigation.menu.highlight();
//        assertEquals(cardNavigation.activeLink.ref(), activeLinkRef);
//        assertEquals(cardNavigation.jdiLink.ref(), jdiLinkRef);
//        assertEquals(cardNavigation.disabledLink.ref(), disabledLinkRef);
//    }

//    @Test
//    public void getLinkUrlTest() {
//        cardNavigation.menu.highlight();
//        assertEquals(cardNavigation.activeLink.url().getPath(), activeLinkRef);
//        assertEquals(cardNavigation.jdiLink.ref(), jdiLinkRef);
//        assertEquals(cardNavigation.disabledLink.ref(), disabledLinkRef);
//    }

//    @Test
//    public void navLinkClickTest() {
//        cardNavigation.menu.select("Active");
//        cardNavigation.menu.select("JDI");
//    }

}
