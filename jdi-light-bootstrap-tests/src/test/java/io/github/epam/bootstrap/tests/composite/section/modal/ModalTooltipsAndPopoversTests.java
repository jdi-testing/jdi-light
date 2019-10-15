package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalTooltipsAndPopovers;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalTooltipsAndPopoversTests extends TestsInit {
    private static final String JS_SCROLL_TO_ELEMENT = "scrollIntoView(true);";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        $(modalTooltipsAndPopovers.core().getLocator()).jsExecute(JS_SCROLL_TO_ELEMENT);
    }

    @Test
    public void verifyTooltips() {
        modalTooltipsAndPopovers.demoModalButton.click();
    }
}
