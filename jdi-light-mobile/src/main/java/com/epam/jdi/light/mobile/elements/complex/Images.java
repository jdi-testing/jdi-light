package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Images {

    @JDIAction("Select {0} item")
    public static WebElement select(Integer index) {
        return getDriver().findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiSelector().className(\"android.widget.ImageView\")"))
                .get(index);
    }

    @JDIAction("Check that element {0} is selected")
    public static void itemIsSelected(WebElement element, boolean isSelected){
        assertThat(element.isDisplayed(), equalTo(true));
        assertThat(element.isSelected(), equalTo(isSelected));
    }
}
