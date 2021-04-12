package com.epam.jdi.light.mobile.elements.init;

import com.epam.jdi.light.elements.init.UIFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.base.mobileappuielement;
import com.epam.jdi.light.mobile.elements.base.mobileUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MobileAppFactory extends UIFactory {

    public static mobileappuielement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*]")
                ? new mobileappuielement().setName(locator)
                : element(defineLocator(locator));
    }

    public static mobileappuielement element(@MarkupLocator By byLocator) {
        return new mobileappuielement(byLocator);
    }

    public static mobileappuielement $(@MarkupLocator String locator) {
        return element(locator);
    }

    public static mobileappuielement $(@MarkupLocator String locator, Object parent) {
        return element(locator).setup(j -> j.setParent(parent));
    }

    public static mobileappuielement $(@MarkupLocator By locator) {
        return element(locator);
    }

    public static mobileappuielement $(WebElement webElement) {
        return new mobileappuielement(webElement);
    }

    public static mobileappuielement $(@MarkupLocator By locator, Object parent) {
        return element(locator).setup(j -> j.setParent(parent));
    }

    public static mobileappuielement $(MobileAppBaseElement appBaseElement, String valueToFilter) {
        new WebDriverWait(getDriver(), 2).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(appBaseElement.core().getLocator()));
        List<mobileappuielement> originalElementList = appBaseElement.core().getWebElements()
                .stream().map(mobileappuielement::new).collect(Collectors.toList());
        mobileappuielement element = originalElementList.stream()
                .filter(item -> item.getText().contains(valueToFilter))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Expected element with text " + valueToFilter + "' is missing in the list"));
        return element;
    }

    public static int sizeOfList(mobileUIElement appBaseElement) {
        new WebDriverWait(getDriver(), 2).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(appBaseElement.core().getLocator()));
        List<mobileappuielement> originalElementList = appBaseElement.core().getWebElements()
                .stream().map(mobileappuielement::new).collect(Collectors.toList());

        return originalElementList.size();
    }
}