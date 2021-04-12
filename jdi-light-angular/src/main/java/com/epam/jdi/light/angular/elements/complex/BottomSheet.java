package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.BottomSheetAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * To see an example of BottomSheet web element please visit https://material.angular.io/components/bottom-sheet/overview.
 */

public class BottomSheet extends UIBaseElement<BottomSheetAssert> {
    public String bottomSheetValuesCssSelector = "#bottom-sheet-container .mat-list-text span:first-child";
    protected Button bottomSheet;
    protected com.epam.jdi.light.elements.common.uiElement bottomSheetContainer;
    
    public BottomSheet() {
        bottomSheet = new Button();
    }

    @Override
    public BottomSheetAssert is() {
        return new BottomSheetAssert().set(this);
    }

    public List<String> values() {
        return new webList(By.cssSelector(bottomSheetValuesCssSelector)).values();
    }

    public void open() {
        bottomSheet.click();
    }

    public void close() {
        if (isOpened()) {
            bottomSheetContainer.core().click();
            bottomSheetContainer.waitFor().disappear();
        }
        else {
            logger.info("BottomSheet is already closed. Do nothing");
        }
    }

    public boolean isOpened() {
        return bottomSheetContainer.isDisplayed();
    }

    public boolean isClosed() {
        return !isOpened();
    }
}
