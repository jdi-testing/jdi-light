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
    private static final String TITLE = "MODAL TITLE";
    private static final String BODY_TITLE1 = "POPOVER IN A MODAL";
    private static final String BODY_TITLE2 = "TOOLTIPS IN A MODAL";
    private static final String CLOSE_BUTTON = "Close";
    private static final String SAVE_BUTTON = "Save changes";
    private static final String THIS_LINK = "This link";
    private static final String THAT_LINK = "that link";
    private static final String POPOVER_TITLE = "Popover title";
    private static final String POPOVER_BODY = "Popover body content is set in this attribute.";
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
        modalTooltipsAndPopovers.modalDlg.title.is().text(is(TITLE));
        modalTooltipsAndPopovers.modalDlg.body.title1.is().text(is(BODY_TITLE1));
        modalTooltipsAndPopovers.modalDlg.body.title2.is().text(is(BODY_TITLE2));
        modalTooltipsAndPopovers.modalDlg.body.thisLink.is().text(is(THIS_LINK));
        modalTooltipsAndPopovers.modalDlg.body.thatLink.is().text(is(THAT_LINK));
        modalTooltipsAndPopovers.modalDlg.saveButton.is().text(is(SAVE_BUTTON));
        modalTooltipsAndPopovers.modalDlg.closeButton.is().text(is(CLOSE_BUTTON));
        modalTooltipsAndPopovers.modalDlg.closeButton.click();
    }

    @Test
    public void verifyOpenModalDialogElements() {
        modalTooltipsAndPopovers.demoModalButton.click();
        modalTooltipsAndPopovers.modalDlg.body.buttonTriggers.click();
        modalTooltipsAndPopovers
                .modalDlg
                .body
                .buttonTriggers
                .is()
                .core()
                .attr("title", POPOVER_TITLE);
        modalTooltipsAndPopovers
                .modalDlg
                .body
                .buttonTriggers
                .is()
                .core()
                .attr("data-content", POPOVER_BODY);
        modalTooltipsAndPopovers
                .modalDlg
                .body
                .thisLink
                .is()
                .text(is(THIS_LINK));
        modalTooltipsAndPopovers
                .modalDlg
                .body
                .thisLink
                .is()
                .core()
                .attr("title", TOOLTIP);
        modalTooltipsAndPopovers
                .modalDlg
                .body
                .thatLink
                .is()
                .text(is(THAT_LINK));
        modalTooltipsAndPopovers
                .modalDlg
                .body
                .thatLink
                .is()
                .core()
                .attr("title", TOOLTIP);
        modalTooltipsAndPopovers.modalDlg.close();
    }
}
