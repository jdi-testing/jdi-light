package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.FormFieldsAssert;
import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.openqa.selenium.Keys.TAB;

/**
 To see an example of FormField web element please visit https://material.angular.io/components/form-field/overview#form-field-appearance-variants
 **/

public class FormField extends UIBaseElement<FormFieldsAssert> {

    @JDIAction("Get placeholder for input in '{name}'")
    public String placeholder() {
        return getActualElement().placeholder();
    }

    @JDIAction("Get label for '{name}'")
    public String label() {
        return core().find(By.cssSelector("mat-label")).getText();
    }

    @JDIAction("Get hint for '{name}'")
    public String hint() {
        UIElement hint = core().find(By.cssSelector("mat-hint"));
        return hint.getText();
    }

    @JDIAction("Get all hints for '{name}'")
    public List<String> hints() {
        List<UIElement> hints = core().finds(By.cssSelector("mat-hint"));
        return hints.stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get error for '{name}'")
    public String error() {
        UIElement error = core().find(By.cssSelector("mat-error"));
        return error.getText();
    }

    @JDIAction("Get focus out from '{name}'")
    public void focusOut() {
        getActualElement().sendKeys(TAB);
    }

    private String getType() {
        String type = "";
        try {
            core().find(By.cssSelector("input")).get();
            type = "input";
        } catch (Exception e1) {
            try {
                core().find(By.cssSelector("mat-select")).get();
                type = "mat-select";
            } catch (Exception e2) {
                try {
                    core().find(By.cssSelector("textarea")).get();
                    type = "textarea";
                } catch (Exception e3) {
                    logger.error(e3.toString());
                }
            }
        }
        return type;
    }

    @JDIAction("Set value {0} for '{name}'")
    public void set(String value) {
        String type = getType();
        UIElement actualElement = getActualElement();
        switch (type) {
            case "input":
                actualElement.input(value);
                break;
            case "textarea":
                actualElement.input(value);
                break;
            case "mat-select":
                actualElement.click();
                MaterialSelectorContainer cdkOverlayContainer = new MaterialSelectorContainer();
                cdkOverlayContainer.select(value);
                break;
            default:
                break;
        }
    }

    @JDIAction("Get value for '{name}'")
    public String value() {
        String value = "";
        String type = getType();
        UIElement actualElement = getActualElement();
        switch (type) {
            case "input":
                value = actualElement.text(VALUE);
                break;
            case "textarea":
                value = actualElement.text(VALUE);
                break;
            case "mat-select":
                value = actualElement.getText();
                break;
            default:
                break;
        }
        return value;
    }

    @JDIAction("Clear value from '{name}'")
    public void clear() {
        UIElement actualElement = getActualElement();
        actualElement.clear();
    }

    @JDIAction("Click icon in '{name}'")
    public void clickIcon() {
        WebElement element = core().find(By.xpath("//mat-icon/ancestor::button"));
        UIElement actualElement = new UIElement(element);
        actualElement.click();
    }

    @JDIAction("Get mat-icon text in '{name}'")
    public String icon() {
        WebElement element = core().find(By.cssSelector("mat-icon"));
        UIElement actualElement = new UIElement(element);
        return actualElement.getText();
    }

    @JDIAction("Get color attribute in '{name}'")
    public String color() {
        UIElement actualElement = getActualElement();
        return actualElement.getCssValue("color");
    }

    @JDIAction("Get appearance attribute in '{name}'")
    public String appearance() {
        return core().attr("appearance");
    }

    @JDIAction("Check if '{name}' is required")
    public boolean isRequired() {
        return core().find(By.cssSelector("span")).attr("class").contains("mat-mdc-form-field-required-marker");
    }

    private UIElement getActualElement() {
        String type = getType();
        WebElement element = core().find(By.xpath("//" + type));
        return new UIElement(element);
    }

    @JDIAction("Check if '{name}' has always float label")
    public boolean hasAlwaysFloatLabel() {
        return core().attr("class").contains("mat-mdc-form-field-label-always-float");
    }

    @Override
    @JDIAction("Check if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().find(By.cssSelector("[class*='mat-form-field-disabled']")).isExist();
    }

    @JDIAction("Check if select field '{name}' is empty")
    public boolean isEmpty() {
        return getActualElement().attr("class").contains("mat-mdc-select-empty");
    }

    @JDIAction("Check if select field '{name}' has dynamic subscriptSizing")
    public boolean isDynamicSubscriptSizing() {
        return !core().finds("//div[contains(@class,'mat-mdc-form-field-subscript-dynamic-size')]").getWebElements().isEmpty();
    }

    @Override
    public FormFieldsAssert is() {
        return new FormFieldsAssert().set(this);
    }
}
