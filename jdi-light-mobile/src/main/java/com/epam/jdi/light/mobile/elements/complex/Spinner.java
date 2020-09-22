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

import java.util.List;

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

    @JDIAction("Select {0} in '{name}'")
    public void select(String text) {
        List<WebElement> spinnerList = getDriver().findElements(
                new MobileBy.ByAndroidUIAutomator(
                        "new UiSelector().className(\"android.widget.CheckedTextView\")"));
        for (WebElement element : spinnerList) {
            if (text.equals(element.getText())) {
                element.click();
                break;
            }
        }
        getDriver().getPageSource();
    }

}
