package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.BottomSheetAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;

public class BottomSheet extends UIBaseElement<BottomSheetAssert> {

    private static final String BOTTOM_SHEET_VALUES_CSS_SELECTOR = "#bottom-sheet .mat-list-text span:first-child";

    @Override
    public BottomSheetAssert is() {
        return new BottomSheetAssert().set(this);
    }

    public WebList values() {
        return this.finds(By.cssSelector(BOTTOM_SHEET_VALUES_CSS_SELECTOR));
    }
}
