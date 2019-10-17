package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalTooltipsAndPopovers;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class ModalTooltipsAndPopoversTests extends TestsInit {
    private static final String JS_SCROLL_TO_ELEMENT = "scrollIntoView(true);";
    private static final String THIS_LINK = "This link";
    private static final String THAT_LINK = "that link";
    private static final String TOOLTIP = "Tooltip";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        $(modalTooltipsAndPopovers.core().getLocator()).jsExecute(JS_SCROLL_TO_ELEMENT);
    }

    @Test
    public void verifyOpenModalDialogTooltips() {
        modalTooltipsAndPopovers.demoModalButton.click();
        modalTooltipsAndPopovers.modalDlg.close();
    }

    @Test
    public void verifyOpenModalDialogElements() {
        modalTooltipsAndPopovers.demoModalButton.click();
        modalTooltipsAndPopovers.modalDlg.buttonTriggers.click();
        modalTooltipsAndPopovers.modalDlg.thisLink
                .is()
                .text(is(THIS_LINK));
        modalTooltipsAndPopovers.modalDlg.thatLink
                .is()
                .text(is(THAT_LINK));
        modalTooltipsAndPopovers.modalDlg.close();
    }
}
