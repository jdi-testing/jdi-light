package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.SelectAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Select extends UIBaseElement<SelectAssert> {

    public String itemLocatorByName = "li[data-value='%s']";
    public String itemsLocator = ".MuiMenuItem-root";

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Is '{name}' is expanded")
    public Boolean isExpanded() {
        return hasClass("Mui-expanded");
    }

    @JDIAction("Is '{name}' is collapsed")
    public Boolean isCollapsed() {
        return !isExpanded();
    }

    @JDIAction("Is text in '{name}' is displayed")
    public Boolean isItemDisplayed(String itemText) {
        return itemText.equals(getText());
    }
    @JDIAction("Is text in '{name}' is contained")
    public Boolean isItemContains(String itemText) {
        return getText().contains(itemText);
    }

    public void open() {
        if (isCollapsed()) {
            core().click();
        }
    }

    public void close(){
        Actions actions = new Actions(core().driver());
        actions.sendKeys(Keys.ESCAPE).perform();
        this.is().collapsed();
    }


    @JDIAction("Select item for '{name}' by text")
    public void selectItem(String item) {
        open();
        core().driver().findElement(By.cssSelector(String.format(itemLocatorByName, item))).click();
        this.is().expanded();
    }

    @JDIAction("Select item for '{name}' by index")
    public void selectItem(int index) {
        open();
        core().driver().findElements(By.cssSelector(itemsLocator)).get(index).click();
        isExpanded();
    }

    @JDIAction("Select items for '{name}'")
    public void multipleSelect(List<String> items) {
        open();
        items.forEach(item -> core().driver().findElement(By.cssSelector(String.format(itemLocatorByName, item))).click());
        this.is().expanded();
    }

    private String getText(){
        return core().getText();
    }

    @Override
    public SelectAssert is() {
        return new SelectAssert().set(this);
    }
}
