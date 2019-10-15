package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalFatButton;
import static io.github.com.pages.BootstrapPage.modalGetbootstrapButton;
import static io.github.com.pages.BootstrapPage.modalMdoButton;
import static io.github.com.pages.BootstrapPage.modalVaryingContentContainer;
import static io.github.com.pages.BootstrapPage.modalVaryingContentWindow;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class ModalVaryingContentTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider(name = "modalVaryingContentButtons")
    public Object[][] modalVaryingContentButtons() {
        return new Object[][]{
                {modalMdoButton},
                {modalFatButton},
                {modalGetbootstrapButton}
        };
    }

    @DataProvider(name = "modalVaryingContentButtonsWithRecipients")
    public Object[][] modalVaryingContentButtonsWithRecipients() {
        return new Object[][]{
                {modalMdoButton, "mdo"},
                {modalFatButton, "fat"},
                {modalGetbootstrapButton, "getbootstrap"}
        };
    }

    @Test(dataProvider = "modalVaryingContentButtons")
    public void baseValidationTest(Button modalButton) {
        baseValidation(modalButton);
        modalButton.click();
        baseValidationAndUnhighlight(modalVaryingContentWindow);
        baseValidationAndUnhighlight(modalVaryingContentWindow.title);
        baseValidationAndUnhighlight(modalVaryingContentWindow.closeX);
        baseValidationAndUnhighlight(modalVaryingContentWindow.recipientLabel);
        baseValidationAndUnhighlight(modalVaryingContentWindow.recipientTextField);
        baseValidationAndUnhighlight(modalVaryingContentWindow.messageLabel);
        baseValidationAndUnhighlight(modalVaryingContentWindow.messageTextArea);
        baseValidationAndUnhighlight(modalVaryingContentWindow.closeButton);
        baseValidationAndUnhighlight(modalVaryingContentWindow.sendMessageButton);
        modalVaryingContentWindow.closeButton.click();
    }

    @Test(dataProvider = "modalVaryingContentButtonsWithRecipients")
    public void headerValidationTest(Button modalButton, String recipient) {
        modalButton.click();
        modalVaryingContentWindow.title.core().is()
                .text(String.format("NEW MESSAGE TO @%s", recipient.toUpperCase()));
        modalVaryingContentWindow.closeX.click();
        //modalVaryingContentContainer.is().core()
         //       .attr("class", "modal fade");
        //assertTrue(modalVaryingContentWindow.isHidden());
        //modalVaryingContentWindow.title.is().hidden();
    }

    private void baseValidationAndUnhighlight(ICoreElement elem) {
        baseValidation(elem);
        elem.unhighlight();
    }
}
