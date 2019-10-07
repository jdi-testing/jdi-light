package com.epam.jdi.light.elements.complex.selenium;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.func.JAction1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class SeleniumWebList extends WebList {
    public SeleniumWebList() {
        super();
    }
    public SeleniumWebList(By locator) { super(); setLocator(locator);}
    public SeleniumWebList(List<WebElement> elements) {
        super(); setWebElements(elements);
    }
    public SeleniumWebList setup(JAction1<JDIBase> setup) {
        return setup(SeleniumWebList.class, setup);
    }
    /**
     * @param index
     */
    @JDIAction(level = DEBUG) @Override
    public UIElement get(int index) {
        if (index < 0)
            throw exception("Can't get element with index '%s'. Index should be 0 or more", index);
        return (locator.isTemplate()
                ? tryGetByIndex(index)
                : initElement(() -> getList(index+1).get(index)))
                .setName(nameFromIndex(index));
    }
    @Override
    public SeleniumWebList setName(String name) {
        super.setName(name);
        return this;
    }
    public SeleniumWebList noValidation() {
        super.noValidation();
        return this;
    }
}
