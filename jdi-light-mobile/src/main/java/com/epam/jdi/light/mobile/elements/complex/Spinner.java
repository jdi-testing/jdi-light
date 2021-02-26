package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class Spinner extends MobileAppBaseElement<TextAssert>
        implements HasTouchActions, IsText {

    @MobileFindBy(xpath = "*/android.widget.TextView")
    public Text spinnerValue;

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }

    @Override
    public TextAssert has() {
        return new TextAssert().set(this.spinnerValue);
    }

    public void hasItems(String[] items) {
        List<WebElement> elements = getDriver().findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiSelector().className(\"android.widget.CheckedTextView\")"));
        try {
            Arrays.asList(items).forEach(
                    item -> item.equalsIgnoreCase(
                            elements.stream().filter(
                                    element -> element.getText().equalsIgnoreCase(item)
                            ).findFirst().get().getText()));
        } catch (NoSuchElementException e){
            StringBuilder builder = new StringBuilder();
            elements.forEach(el -> builder.append(el.getText()).append(", "));
            throw new NoSuchElementException("One of the expected items is missing in the spinner list. \nExpected:\n" +
                    Arrays.asList(items) + "\nActual:\n" + builder);
        }
    }

    @JDIAction("Select {0} in '{name}'")
    public void select(String text) {
        getDriver().findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiSelector().className(\"android.widget.CheckedTextView\")"))
                .stream()
                .filter(element -> element.getText().equals(text))
                .findFirst().get().click();
    }
}