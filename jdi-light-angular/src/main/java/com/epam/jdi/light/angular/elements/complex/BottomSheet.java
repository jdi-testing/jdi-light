package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.BottomSheetAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

public class BottomSheet extends UIBaseElement<BottomSheetAssert> {
    private String BOTTOM_SHEET_VALUES_XPATH = "//mat-nav-list[@id]/a/div/div/span[1]";
    public static String[] BOTTOM_SHEET_VALUES = {"Google Keep", "Google Docs", "Google Plus", "Google Hangouts"};

    @Override
    public BottomSheetAssert is() {
        return new BottomSheetAssert().set(this);
    }

    public List<String> values() {
        return $$(getDriver().findElements(By.xpath(BOTTOM_SHEET_VALUES_XPATH)), getName()).values();
    }

    @JDIAction("Check {name} option values are correct")
    public boolean checkValue(String expectedValue, String actualValue) {
        return actualValue.equals(expectedValue);
    }
}
