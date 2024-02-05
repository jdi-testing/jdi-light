package com.epam.jdi.light.mobile.elements.init;

import com.epam.jdi.light.elements.init.UIFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MobileAppFactory extends UIFactory {

    public static MobileAppUIElement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*]")
                ? new MobileAppUIElement().setName(locator)
                : element(defineLocator(locator));
    }

    public static MobileAppUIElement element(@MarkupLocator By byLocator) {
        return new MobileAppUIElement(byLocator);
    }

    //CHECKSTYLE:OFF
    public static MobileAppUIElement $(@MarkupLocator String locator) {
        //CHECKSTYLE:ON
        return element(locator);
    }

    //CHECKSTYLE:OFF
    public static MobileAppUIElement $(@MarkupLocator String locator, Object parent) {
        //CHECKSTYLE:ON
        return element(locator).setup(j -> j.setParent(parent));
    }

    //CHECKSTYLE:OFF
    public static MobileAppUIElement $(@MarkupLocator By locator) {
        //CHECKSTYLE:ON
        return element(locator);
    }

    //CHECKSTYLE:OFF
    public static MobileAppUIElement $(WebElement webElement) {
        //CHECKSTYLE:ON
        return new MobileAppUIElement(webElement);
    }

    //CHECKSTYLE:OFF
    public static MobileAppUIElement $(@MarkupLocator By locator, Object parent) {
        //CHECKSTYLE:ON
        return element(locator).setup(j -> j.setParent(parent));
    }

    //CHECKSTYLE:OFF
    public static MobileAppUIElement $(MobileAppBaseElement appBaseElement, String valueToFilter) {
        //CHECKSTYLE:ON
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(appBaseElement.core().getLocator()));
        List<MobileAppUIElement> originalElementList = appBaseElement.core().getWebElements()
                .stream().map(MobileAppUIElement::new).collect(Collectors.toList());
        MobileAppUIElement element = originalElementList.stream()
                .filter(item -> item.getText().contains(valueToFilter))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Expected element with text " + valueToFilter + "' is missing in the list"));
        return element;
    }

    public static int sizeOfList(MobileUIElement appBaseElement) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(appBaseElement.core().getLocator()));
        List<MobileAppUIElement> originalElementList = appBaseElement.core().getWebElements()
                .stream().map(MobileAppUIElement::new).collect(Collectors.toList());

        return originalElementList.size();
    }
}
