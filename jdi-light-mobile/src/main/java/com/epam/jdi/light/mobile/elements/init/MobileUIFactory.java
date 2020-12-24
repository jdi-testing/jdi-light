package com.epam.jdi.light.mobile.elements.init;

import com.epam.jdi.light.elements.init.UIFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.base.MobileBaseElement;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MobileUIFactory extends UIFactory {

    public static MobileUIElement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*]")
                ? new MobileUIElement().setName(locator)
                : element(defineLocator(locator));
    }

    public static MobileUIElement element(@MarkupLocator By byLocator) {
        return new MobileUIElement(byLocator);
    }

    public static MobileUIElement $(@MarkupLocator String locator) {
        return element(locator);
    }

    public static MobileUIElement $(@MarkupLocator String locator, Object parent) {
        return element(locator).setup(j -> j.setParent(parent));
    }

    public static MobileUIElement $(@MarkupLocator By locator) {
        return element(locator);
    }

    public static MobileUIElement $(WebElement webElement) {
        return new MobileUIElement(webElement);
    }

    public static MobileUIElement $(@MarkupLocator By locator, Object parent) {
        return element(locator).setup(j -> j.setParent(parent));
    }

    public static MobileUIElement $(MobileBaseElement appBaseElement, String valueToFilter) {
        new WebDriverWait(getDriver(), 2).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(appBaseElement.core().getLocator()));
        List<MobileUIElement> originalElementList = appBaseElement.core().getWebElements()
                .stream().map(MobileUIElement::new).collect(Collectors.toList());
        MobileUIElement element = originalElementList.stream()
                .filter(item -> item.getText().contains(valueToFilter))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Expected element with text " + valueToFilter + "' is missing in the list"));
        return element;
    }
}
