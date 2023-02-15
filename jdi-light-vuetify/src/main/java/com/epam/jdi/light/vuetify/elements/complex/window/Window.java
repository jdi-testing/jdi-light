package com.epam.jdi.light.vuetify.elements.complex.window;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.window.WindowAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import java.util.List;

public class Window extends UIBaseElement<WindowAssert> implements
    HasTheme {

    @UI(".v-window-item")
    public List<UIElement> items;

    @UI(".v-window__next")
    private Button next;

    @UI(".v-window__prev")
    private Button previous;

    @Override
    public WindowAssert is() {
        return new WindowAssert().set(this);
    }

    @Override
    public WindowAssert has() {return new WindowAssert().set(this);}

    protected UIElement active() {
        return core().find(".v-window-item--active");
    }

    @JDIAction("Get '{name}' previous button")
    public Button previousButton() {
        return previous;
    }

    @JDIAction("Get if '{name}' previous button exists")
    public boolean previousButtonExists() {
        return previousButton().isExist();
    }

    @JDIAction("Get '{name}' next button")
    public Button nextButton() {
        return next;
    }

    @JDIAction("Get if '{name}' next button exists")
    public boolean nextButtonExists() {
        return nextButton().isExist();
    }

    @JDIAction("Get all '{name}' window items")
    public List<UIElement> getAllItems() {
        return items;
    }

    @JDIAction("Get active item from '{name}'")
    public UIElement getActiveItem() {
        for (UIElement item : items) {
            if (item.core().attr("class").contains("active")) {
                return item;
            }
        }
        throw new UnsupportedOperationException("Can't return active window, item class not found");
    }

    @JDIAction("Get if '{name}' shows arrows on hover")
    public boolean showArrowsOnHover() {
        return hasClass("v-window--show-arrows-on-hover");
    }

}
