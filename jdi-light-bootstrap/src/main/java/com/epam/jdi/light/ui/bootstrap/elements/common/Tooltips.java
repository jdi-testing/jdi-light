package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * To see an example of Tooltip web element please visit https://getbootstrap.com/docs/4.3/components/tooltips/#examples
 */

public class Tooltips {
    public static Tooltips tooltip(String name) {
        return new Tooltips(name);
    }
    public static String getTooltipFor(ICoreElement element) {
        try {
            element.core().has().attr("aria-describedby");
            return element.core().attr("data-original-title");
        } catch (Exception ex) {
             return "";
        }
    }
    @JDIAction("Check that '{tooltipText}' tooltip is hidden for {0}")
    public static void checkTooltipIsHiddenFor(ICoreElement element) {
        element.core().waitFor().attr("aria-describedby", "");
    }
    public static boolean isHiddenFor(ICoreElement element) {
        return element.core().setup(JDIBase::noWait).attr("aria-describedby").equals("");
    }

    private String tooltipText;
    Tooltips(String text) {
        this.tooltipText = text;
    }
    @JDIAction("Check that '{tooltipText}' tooltip is displayed for {0}")
    public void checkDisplayedFor(ICoreElement element) {
        element.core().has().attr("aria-describedby")
            .and().attr("data-original-title", tooltipText);
    }
    @JDIAction("Check that '{tooltipText}' tooltip is disappear for {0}")
    public void checkDisappearFor(ICoreElement element) {
        checkDisplayedFor(element);
        checkTooltipIsHiddenFor(element);
    }
    public boolean isDisplayedFor(ICoreElement element) {
        try {
            element.core().setup(JDIBase::noWait).has().attr("aria-describedby");
            return element.core().attr("data-original-title").equals(tooltipText);
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean isDisappearFor(ICoreElement element) {
        try {
            checkDisappearFor(element);
        } catch (Exception ex) {
            return false;
        }
        return isHiddenFor(element);
    }
}
