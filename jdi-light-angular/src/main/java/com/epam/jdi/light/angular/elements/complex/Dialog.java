package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.DialogAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * To see an example of Dialog web element please visit https://material.angular.io/components/dialog/overview.
 */

public class Dialog extends UIBaseElement<DialogAssert> {
    protected Button dialog;
    public String answerLabel = "dialog-overview-example li.ng-star-inserted";
    public String dialogContainer = ".mat-dialog-container";
    public String greetingLabel = "mat-dialog-container dialog-overview-example-dialog h1";
    public String answerFormField = "mat-dialog-container dialog-overview-example-dialog input";
    public String nameFormField = "#mat-input-74";
    public String noThanksButton = ".mat-dialog-container .mat-dialog-actions button:first-child";
    public String okButton = ".mat-dialog-container .mat-dialog-actions button:last-child";

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }

    @JDIAction("Click on button")
    public void clickOkButton() {
        getOkButton().click();
    }

    @JDIAction("Click on noThanks button")
    public void clickNoThanksButton() {
        getNoThanksButton().click();
    }

    @JDIAction("Send '{name}' to name form field")
    public void sendKeysToNameFormField(String name) {
        getNameFormField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        getNameFormField().sendKeys(name);
    }

    @JDIAction("Send '{name}' to answer form field")
    public void sendKeysToAnswerFormField(String answer) {
        getAnswerFormField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        getAnswerFormField().sendKeys(answer);
    }

    @JDIAction("Open dialog")
    public void open() {
        dialog.click();
    }

    @JDIAction("Close dialog")
    public void close() {
        clickNoThanksButton();
    }

    @JDIAction("Submit answer")
    public void submitAnswer() {
        clickOkButton();
    }

    @JDIAction("Get '{name}' answer value")
    public boolean answerText(String answer) {
        return getAnswerLabel().getText().equals("You choose: " + answer);
    }

    @JDIAction("Get '{name}' text value")
    public boolean nameText(String name) {
        return getGreetingLabel().getText().equalsIgnoreCase(("Hi " + name));
    }

    @JDIAction("Is dialog container opened")
    public boolean isOpened() {
        return getDialogContainer().isDisplayed();
    }

    @JDIAction("Is dialog container closed")
    public boolean isClosed() {
        getDialogContainer().waitFor().disappear();
        return !isOpened();
    }

    protected UIElement getOkButton() {
        return new UIElement(By.cssSelector(okButton));
    }

    protected UIElement getAnswerFormField() {
        return new UIElement(By.cssSelector(answerFormField));
    }

    protected UIElement getNoThanksButton() {
        return new UIElement(By.cssSelector(noThanksButton));
    }

    protected UIElement getNameFormField() {
        return new UIElement(By.cssSelector(nameFormField));
    }

    protected UIElement getDialogContainer() {
        return new UIElement(By.cssSelector(dialogContainer));
    }

    protected UIElement getAnswerLabel() {
        return new UIElement(By.cssSelector(answerLabel));
    }

    protected UIElement getGreetingLabel() {
        return new UIElement(By.cssSelector(greetingLabel));
    }
}
