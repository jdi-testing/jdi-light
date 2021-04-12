package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.DialogAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.uiElement;
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

    public void clickOkButton() {
        getOkButton().click();
    }

    public void clickNoThanksButton() {
        getNoThanksButton().click();
    }

    public void sendKeysToNameFormField(String name) {
        getNameFormField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        getNameFormField().sendKeys(name);
    }

    public void sendKeysToAnswerFormField(String answer) {
        getAnswerFormField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        getAnswerFormField().sendKeys(answer);
    }

    public void open() {
        dialog.click();
    }

    public void close() {
        clickNoThanksButton();
    }

    public void submitAnswer() {
        clickOkButton();
    }

    public boolean answerText(String answer) {
        return getAnswerLabel().getText().equals("You choose: " + answer);
    }

    public boolean nameText(String name) {
        return getGreetingLabel().getText().equalsIgnoreCase(("Hi " + name));
    }

    public boolean isOpened() {
        return getDialogContainer().isDisplayed();
    }

    public boolean isClosed() {
        getDialogContainer().waitFor().disappear();
        return !isOpened();
    }

    protected com.epam.jdi.light.elements.common.uiElement getOkButton() {
        return new uiElement(By.cssSelector(okButton));
    }

    protected com.epam.jdi.light.elements.common.uiElement getAnswerFormField() {
        return new uiElement(By.cssSelector(answerFormField));
    }

    protected com.epam.jdi.light.elements.common.uiElement getNoThanksButton() {
        return new uiElement(By.cssSelector(noThanksButton));
    }

    protected com.epam.jdi.light.elements.common.uiElement getNameFormField() {
        return new uiElement(By.cssSelector(nameFormField));
    }

    protected com.epam.jdi.light.elements.common.uiElement getDialogContainer() {
        return new uiElement(By.cssSelector(dialogContainer));
    }

    protected com.epam.jdi.light.elements.common.uiElement getAnswerLabel() {
        return new uiElement(By.cssSelector(answerLabel));
    }

    protected com.epam.jdi.light.elements.common.uiElement getGreetingLabel() {
        return new uiElement(By.cssSelector(greetingLabel));
    }
}
