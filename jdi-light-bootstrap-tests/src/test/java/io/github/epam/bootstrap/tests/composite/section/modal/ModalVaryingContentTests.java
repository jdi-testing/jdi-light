package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.modal.ModalVaryingContent;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalFatButton;
import static io.github.com.pages.BootstrapPage.modalGetbootstrapButton;
import static io.github.com.pages.BootstrapPage.modalMdoButton;
import static io.github.com.pages.BootstrapPage.modalVaryingContentWindow;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

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

    @Test(dataProvider = "modalVaryingContentButtons")
    public void baseValidationTest(Button modalButton) {
        baseValidation(modalButton);
        modalButton.click();
        baseValidation(modalVaryingContentWindow);
        baseValidation(modalVaryingContentWindow.title);
        baseValidation(modalVaryingContentWindow.button);
        baseValidation(modalVaryingContentWindow.recipientLabel);
        baseValidation(modalVaryingContentWindow.recipientTextField);
        baseValidation(modalVaryingContentWindow.messageLabel);
        baseValidation(modalVaryingContentWindow.messageTextArea);
        baseValidation(modalVaryingContentWindow.closeButton);
        baseValidation(modalVaryingContentWindow.sendMessageButton);
    }
}
