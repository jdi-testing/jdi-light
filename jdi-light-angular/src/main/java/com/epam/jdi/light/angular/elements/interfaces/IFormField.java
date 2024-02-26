package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public interface IFormField<T extends UIBaseElement> extends ICoreElement {

    String placeholder();
    Label label();
    String value();
    String color();
    boolean isEmpty();

    @JDIAction("Get hint for '{name}'")
    default String hint() {
        return core().find(By.cssSelector("mat-hint")).getValue();
    }

    @JDIAction("Get all hints for '{name}'")
    default List<String> hints() {
        List<UIElement> hints = core().finds(By.cssSelector("mat-hint"));
        return hints.stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get error for '{name}'")
    default String error() {
        return core().find(By.cssSelector("mat-error")).getText();
    }

    @JDIAction("Click icon in '{name}'")
    default void clickIcon() {
        WebElement element = core().find(By.xpath("//mat-icon/ancestor::button"));
        UIElement actualElement = new UIElement(element);
        actualElement.click();
    }

    @JDIAction("Get mat-icon text in '{name}'")
    default String icon() {
        WebElement element = core().find(By.cssSelector("mat-icon"));
        UIElement actualElement = new UIElement(element);
        return actualElement.getText();
    }

    @JDIAction("Get appearance attribute in '{name}'")
    default String appearance() {
        return core().attr("appearance");
    }

    @JDIAction("Check if '{name}' is required")
    default boolean isRequired() {
        return core().find(By.cssSelector("span")).attr("class").contains("mat-mdc-form-field-required-marker");
    }

    @JDIAction("Check if '{name}' has always float label")
    default boolean hasAlwaysFloatLabel() {
        return core().attr("class").contains("mat-mdc-form-field-label-always-float");
    }

    @Override
    @JDIAction("Check if '{name}' is disabled")
    default boolean isDisabled() {
        return core().attr("class").contains("mat-form-field-disabled");
    }

    @JDIAction("Check if select field '{name}' has dynamic subscriptSizing")
    default boolean isDynamicSubscriptSizing() {
        return !core().finds("//div[contains(@class,'mat-mdc-form-field-subscript-dynamic-size')]").getWebElements().isEmpty();
    }
}
