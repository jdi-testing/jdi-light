package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.asserts.TabBarAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class TabBar extends MobileAppBaseElement<TabBarAssert> implements HasTouchActions, IsButton, IsText {

    @Override
    public TabBarAssert is() {
        return new TabBarAssert().set(this);
    }

    @JDIAction(value = "Check that '{name}' is selected", level = LogLevels.DEBUG)
    public String isSelected() {
        return core().get().findElements(By.id("android:id/title"))
        .stream()
        .filter(element -> element.getAttribute("selected").equals("true"))
        .findFirst().get().getAttribute("text");
    }

    @JDIAction(value = "Check that '{name}' is selected", level = LogLevels.DEBUG)
    public void selectByText(String tabName) {
        core().get().findElements(By.id("android:id/title"))
                .stream()
                .filter(element -> element.getAttribute("text").equals(tabName))
                .findFirst().get().click();
    }

    @JDIAction(value = "Check that '{name}' is selected", level = LogLevels.DEBUG)
    public void selectByNumber(int tabNumber) {
        core().get().findElements(By.className("android.widget.LinearLayout")).get(tabNumber-1).click();
    }
}
