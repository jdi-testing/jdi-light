package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
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

    private String whiteColor = "rgba(255, 255, 255, 1)";
    private String grayColorBackground = "rgba(108, 117, 125, 1)";
    private String grayColorBorder = "rgb(108, 117, 125)";
    private String blueColorBackground = "rgba(0, 123, 255, 1)";
    private String blueColorBorder = "rgb(0, 123, 255)";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        bsPage.refresh();
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
        modalVaryingContentWindow.close();
    }

    @Test(dataProvider = "modalVaryingContentButtonsWithRecipients")
    public void modalButtonsTest(Button modalButton, String recipient) {
        checkButton(modalButton, String.format("Open modal for @%s", recipient), whiteColor, blueColorBackground, blueColorBorder);
    }

    @Test(dataProvider = "modalVaryingContentButtonsWithRecipients")
    public void headerValidationTest(Button modalButton, String recipient) {
        modalButton.click();
        modalVaryingContentWindow.is().displayed();
        modalVaryingContentWindow.title.core().is()
                .text(String.format("NEW MESSAGE TO @%s", recipient.toUpperCase()));
        modalVaryingContentWindow.closeX.click();
        modalVaryingContentWindow.is().hidden();
    }

    @Test(dataProvider = "modalVaryingContentButtonsWithRecipients")
    public void bodyValidationTest(Button modalButton, String recipient) {
        modalButton.click();
        modalVaryingContentWindow.recipientLabel.is().text("Recipient:");
        modalVaryingContentWindow.recipientTextField.is().text(String.format("@%s", recipient));
        modalVaryingContentWindow.messageLabel.is().text("Message:");
        modalVaryingContentWindow.messageTextArea.is().text("");
        modalVaryingContentWindow.messageTextArea.sendKeys("Hello world!");
        modalVaryingContentWindow.messageTextArea.is().text("Hello world!");
        modalVaryingContentWindow.close();
    }

    @Test(dataProvider = "modalVaryingContentButtons")
    public void footerValidationTest(Button modalButton) {
        modalButton.click();
        checkButton(modalVaryingContentWindow.sendMessageButton, "Send message", whiteColor, blueColorBackground, blueColorBorder);
        modalVaryingContentWindow.sendMessageButton.click();
        checkButton(modalVaryingContentWindow.closeButton, "Close", whiteColor, grayColorBackground, grayColorBorder);
        modalVaryingContentWindow.closeButton.click();
        modalVaryingContentWindow.is().hidden();
    }

    private void baseValidationAndUnhighlight(ICoreElement elem) {
        baseValidation(elem);
        elem.unhighlight();
    }

    private void checkButton(Button button, String text, String color, String backgroundColor, String borderColor) {
        button.is().core()
                .text(text)
                .tag("button")
                .css("color", color)
                .css("background-color", backgroundColor)
                .css("border-color", borderColor);
    }
}
