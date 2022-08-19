package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.LazyAssert;
import com.jdiai.tools.Timer;
import org.openqa.selenium.By;

import java.util.List;

/**
 * To see an example of Lazy web element please visit
 * https://vuetifyjs.com/en/components/lazy/
 */

public class Lazy extends UIBaseElement<LazyAssert> {

    @Override
    public boolean isHidden() {
        return core().isHidden();
    }

    @Override
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @JDIAction("Scroll to '{name}'")
    public void scrollIntoView() {
        Timer.waitCondition(this::isDisplayed);
        core().jsExecute("scrollIntoView()");
    }

    public LazyAssert is() {
        return new LazyAssert().set(this);
    }

    public List<UIElement> content() {
        return finds(By.xpath("./*"));
    }

    public boolean isExistContent() {
        List<UIElement> results = content();
        return results.size() != 0;
    }
}
