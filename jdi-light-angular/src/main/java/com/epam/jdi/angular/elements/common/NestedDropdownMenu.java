package com.epam.jdi.angular.elements.common;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * Angular slide toggle documentation: https://jdi-docs.github.io/jdi-light/?java#slide-toggle
 */
public class NestedDropdownMenu extends Button {
    private String LAST_OPENED_MENU_OPTIONS_XPATH = "(.//div[contains(@class,'mat-menu-after')])[last()]//button";

    public void expandMenu() {
        if (!hasAttribute("aria-expanded"))
            click();
    }

    public void closeMenu() {
        if (hasAttribute("aria-expanded"))
            this.click(ElementArea.JS);
    }

    public WebList lastOpenedOptionsElements() {
        expandMenu();
        return $$(getDriver().findElements(By.xpath(LAST_OPENED_MENU_OPTIONS_XPATH)), getName());
    }

    public List<String> values() {
        return lastOpenedOptionsElements().values();
    }

    public void select(String value) {
        UIElement optionToClick = lastOpenedOptionsElements().get(value);
//        optionToClick.waitSec(1);
        optionToClick.click(ElementArea.JS);
//        lastOpenedOptionsElements().select(value);
        closeMenu();
    }

    public void select(int index) {
        // TODO:
        closeMenu();
    }

    public void select(String... values) {
        // TODO:
    }


}
