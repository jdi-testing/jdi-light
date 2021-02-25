package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.mobile.asserts.SearchViewFieldAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.ISearchViewField;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class SearchViewField extends MobileAppBaseElement<SearchViewFieldAssert>
        implements ISearchViewField, HasTouchActions, IsButton {

    @JDIAction(value = "Check that '{name}' is expanded")
    @Override
    public boolean isExpanded () {
        return core().attr("focused")
                .equalsIgnoreCase("true");
    }

    @Override
    public String getValue() {
        return text();
    }

    @Override
    public void input(String value) {
        core().input(value);
    }

    @JDIAction("Clear value from '{name}'")
    @Override
    public void clear() {
        if (!isEmpty()) {
            core().clear();
        }
    }

    @JDIAction("Select {0} in '{name}'")
    public void select(String text) {
        List<WebElement> filterList = getDriver().findElements(
                By.className("android.widget.TextView"));
        for (WebElement element : filterList) {
            if (element.getAttribute("text").equals(text)) {
                element.click();
            }
        }
    }

    @Override
    public SearchViewFieldAssert is () {
        return new SearchViewFieldAssert().set(this);
    }
}




