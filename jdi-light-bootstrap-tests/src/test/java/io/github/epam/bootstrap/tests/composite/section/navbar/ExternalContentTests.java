package io.github.epam.bootstrap.tests.composite.section.navbar;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarExternalContent;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Aleksandr Khmelinin on 8.10.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class ExternalContentTests extends TestsInit {

    private String text = "COLLAPSED CONTENT";
    private String mutedText = "Toggleable via the navbar brand.";
    private static final String ariaExpanded = "aria-expanded";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void expandingTest() {
        navbarExternalContent.toggler.expander().is().core().attr(ariaExpanded, "false");
        navbarExternalContent.toggler.expand();
        navbarExternalContent.toggler.expander().is().core().attr(ariaExpanded, "true");
        navbarExternalContent.toggler.collapse();
        navbarExternalContent.toggler.expander().is().core().attr(ariaExpanded, "false");
    }

    @Test
    public void getTextTest() {
        navbarExternalContent.toggler.expand();
        navbarExternalContent.toggler.value().children().get(1).is()
                .displayed()
                .text(text);
        navbarExternalContent.toggler.value().children().get(2).is()
                .displayed()
                .text(mutedText);
        navbarExternalContent.toggler.collapse();
    }

    @Test
    public void baseValidatonTest() {
        navbarExternalContent.toggler.expand();
        baseValidation(navbarExternalContent);
        baseValidation(navbarExternalContent.collapsedText);
        baseValidation(navbarExternalContent.collapsedMutedText);
        navbarExternalContent.toggler.collapse();
    }
}
