package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.DialogAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Dialog extends UIBaseElement<DialogAssert> {
    private Button dialog;
    private String answerLabel = "dialog-overview-example li.ng-star-inserted";
    private String dialogContainer = ".mat-dialog-container";
    private String greetingLabel = "mat-dialog-container dialog-overview-example-dialog h1";
    private String answerFormField = "mat-dialog-container dialog-overview-example-dialog input";
    private String nameFormField = "#mat-input-74";
    private String noThanksButton = ".mat-dialog-container .mat-dialog-actions button:first-child";
    private String okButton = ".mat-dialog-container .mat-dialog-actions button:last-child";

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
