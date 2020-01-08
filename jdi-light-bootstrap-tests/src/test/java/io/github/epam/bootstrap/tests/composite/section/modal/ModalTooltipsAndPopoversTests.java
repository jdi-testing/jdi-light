package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalTooltipsAndPopovers;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

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
        //modalTooltipsAndPopovers.modalDlg.body.thisLink.is().text(is(THIS_LINK));
        modalTooltipsAndPopovers.modalDlg.body.thatLink.is().text(is(THAT_LINK));
        modalTooltipsAndPopovers.modalDlg.saveButton.is().text(is(SAVE_BUTTON));
        modalTooltipsAndPopovers.modalDlg.closeButton.is().text(is(CLOSE_BUTTON));
        modalTooltipsAndPopovers.modalDlg.closeButton.click();
    }

    @Test
    public void verifyOpenModalDialogElements() {
        modalTooltipsAndPopovers.demoModalButton.click();
        modalTooltipsAndPopovers.modalDlg.body.popover.getPopover("p:nth-child(2) > a");
        modalTooltipsAndPopovers.modalDlg.body.popover.popoverButton.is()
                .displayed()
                .enabled()
                .core()
                .attr("data-toggle", "popover")
                .attr("data-content", POPOVER_BODY)
                .attr("data-original-title", POPOVER_TITLE)
                .text(is("button"));
        modalTooltipsAndPopovers.modalDlg.body.popover.popoverButton.click();

        //modalTooltipsAndPopovers.modalDlg.body.tooltipOnLink
        //        .core()
        //        .setLocator(modalTooltipsAndPopovers.modalDlg.body.thisLink.core().getLocator());
        modalTooltipsAndPopovers.modalDlg.body.thisLink.hover();
        //modalTooltipsAndPopovers.modalDlg.body.tooltipOnLink.assertThat().isVisible();
        //assertEquals(modalTooltipsAndPopovers.modalDlg.body.tooltipOnLink.getTooltipText(),TOOLTIP);
        modalTooltipsAndPopovers.modalDlg.body.thisLink.click();
        modalTooltipsAndPopovers.modalDlg.body.thatLink.hover();

        modalTooltipsAndPopovers.modalDlg.close();
    }
}
