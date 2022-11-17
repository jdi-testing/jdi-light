package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.LazyAssert;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.jdiai.tools.Timer;
import org.openqa.selenium.By;

import java.util.List;

/**
 * To see an example of Lazy web element please visit
 * https://vuetifyjs.com/en/components/lazy/
 */

public class Lazy extends UIBaseElement<LazyAssert> implements HasMeasurement {

    @JDIAction("Scroll to '{name}'")
    public void scrollIntoView() {
        Timer.waitCondition(this::isDisplayed);
        core().jsExecute("scrollIntoView()");
    }

    public Lazy content() {
        return new Lazy().setCore(Lazy.class, find(By.cssSelector(".v-lazy")));
    }

    @Override
    public LazyAssert is() {
        return new LazyAssert().set(this);
    }
}
