package com.epam.jdi.light.mobile.elements.complex;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MobileUIElementList {
    public static WebElement $(By locator, String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        List<WebElement> elements = getDriver().findElements(locator);
        WebElement element = elements.stream().filter(item -> item.getText().contains(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Expected WebElement with text" + name + "is missing in the list"));
        return element;
    }
}
