package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * To see an example of Tooltip web element please visit https://getbootstrap.com/docs/4.3/components/tooltips/#examples
 */

public class Tooltips {
    public static Tooltips tooltip(String name) {
        return new Tooltips(name);
    }
    public static String getTooltipFor(ICoreElement element) {
        element.core().has().attr("aria-describedby");
        return element.core().attr("data-original-title");
    }
    private String tooltipText;
    Tooltips(String text) {
        this.tooltipText = text;
    }
    public void checkDisplayedFor(ICoreElement element) {
        element.core().has().attr("aria-describedby");
        element.core().has().attr("data-original-title", tooltipText);
    }
    public boolean isDisplayedFor(ICoreElement element) {
        element.core().has().attr("aria-describedby");
        return element.core().attr("data-original-title").equals(tooltipText);
    }
}
