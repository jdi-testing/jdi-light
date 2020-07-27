package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.NestedDropdownMenuAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * Angular slide toggle documentation: https://jdi-docs.github.io/jdi-light/?java#slide-toggle
 */
public class NestedDropdownMenu extends UIBaseElement<NestedDropdownMenuAssert> {
    private String LAST_OPENED_MENU_OPTIONS_XPATH = "(.//div[contains(@class,'mat-menu-after')])[last()]//button";
    private String LAST_OPENED_MENU_OPTIONS_XPATH_FOR_MENU_WITH_ICONS = "(.//div[contains(@class,'mat-menu-after')])[last()]//button//span";
    public static String[] BASIC_MENU_VALUES = {"Item 1", "Item 2"};
    public static String[] MENU_WITH_ICONS_VALUES = {"Redial", "Check voice mail", "Disable alerts"};
    public static String[] NESTED_MENU_VALUES = {"[Vertebrates, Invertebrates]",
            "[Fishes, Amphibians, Reptiles, Birds, Mammals]",
            "[Baikal oilfish, Bala shark, Ballan wrasse, Bamboo shark, Banded killifish]",
            "[Sonoran desert toad, Western toad, Arroyo toad, Yosemite toad]",
            "[Banded Day Gecko, Banded Gila Monster, Black Tree Monitor, Blue Spiny Lizard, Velociraptor]",
            "[Insects, Molluscs, Crustaceans, Corals, Arachnids, Velvet worms, Horseshoe crabs]"};

    protected Button getButton() {
        return new Button().setCore(Button.class, base());
    }

    @Override
    public NestedDropdownMenuAssert is() {
        return new NestedDropdownMenuAssert().set(this);
    }

    public void expand() {
        if (!hasAttribute("aria-expanded"))
            getButton().click();
    }

    @JDIAction("Check {name} is expanded")
    public boolean isExpanded() {
        return hasAttribute("aria-expanded");
    }

    public void close() {
        if (hasAttribute("aria-expanded"))
            this.getButton().click(ElementArea.JS);
    }

    @JDIAction("Check {name} is closed")
    public boolean isClosed() {
        return !hasAttribute("aria-expanded");
    }

    public WebList lastOpenedOptionsElements() {
        expand();
        return $$(getDriver().findElements(By.xpath(LAST_OPENED_MENU_OPTIONS_XPATH)), getName());
    }

    public WebList lastOpenedOptionsElementsForMenuWithIcons() {
        expand();
        return $$(getDriver().findElements(By.xpath(LAST_OPENED_MENU_OPTIONS_XPATH_FOR_MENU_WITH_ICONS)), getName());
    }

    @JDIAction("Check {name} is closed")
    public boolean checkValue(String expectedValue, String actualValue) {

        return actualValue.equals(expectedValue);
    }

    public List<String> valuesForNestedMenu() {
        List<String> list = new ArrayList();
        list.add(lastOpenedOptionsElements().values().toString());
        for (UIElement uiElement : lastOpenedOptionsElements()) {
            if (uiElement.hasClass("mat-menu-item-submenu-trigger")) {
                uiElement.click(ElementArea.JS);
                list.add(lastOpenedOptionsElements().values().toString());
            }
            for (UIElement uiElement1 : lastOpenedOptionsElements()) {
                if (uiElement1.hasClass("mat-menu-item-submenu-trigger")) {
                    uiElement1.click(ElementArea.JS);
                    list.add(lastOpenedOptionsElements().values().toString());
                }
            }
        }
        return list;
    }


    public List<String> values() {
        return lastOpenedOptionsElements().values();
    }

    public List<String> valuesForMenuWithIcons() {
        return lastOpenedOptionsElementsForMenuWithIcons().values();
    }

    public void selectForMenuWithIcons(String value) {
        UIElement optionToClick = lastOpenedOptionsElementsForMenuWithIcons().get(value);
        optionToClick.click(ElementArea.JS);
        close();
    }

    @JDIAction("Check {name} option is disabled")
    public boolean isDisabledMenuWithIconsOption(String value) {
        UIElement optionToClick = lastOpenedOptionsElements().get("voicemail" + value);
        return Boolean.parseBoolean(optionToClick.attr("aria-disabled"));
    }

    @JDIAction("Check {name} option is disabled")
    public boolean isDisabledNestedMenuOption(String... values) {
        return Boolean.parseBoolean(select(values).attr("aria-disabled"));


    }

    public UIElement select(String... values) {
        List<UIElement> list = new ArrayList();
        for (String value : values) {
            UIElement optionToClick = lastOpenedOptionsElements().get(value);
            list.add(optionToClick);
            if (optionToClick.isEnabled()) {
                optionToClick.click(ElementArea.JS);
            }
        }
        close();
        return list.get(list.size() - 1);
    }
}
