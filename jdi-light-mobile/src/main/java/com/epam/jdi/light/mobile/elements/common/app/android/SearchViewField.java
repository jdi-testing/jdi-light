package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.asserts.SearchViewAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.ISearchView;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class SearchViewField extends MobileAppBaseElement<SearchViewAssert> implements ISearchView, HasTouchActions, IsButton {

    @JDIAction(value = "Check that '{name}' is iconified", level = LogLevels.DEBUG)
    @Override
    public boolean isIconified() {
        return core().isDisplayed();
    }

    @JDIAction(value = "Set '{name}' expanded", level = LogLevels.DEBUG)
    @Override
    public void setExpanded() {
        if (isIconified())
            core().tap();
    }

    @JDIAction(value = "Check that '{name}' is expanded", level = LogLevels.DEBUG)
    @Override
    public boolean isExpanded () {
        return core().attr("focused")
                .equalsIgnoreCase("true");
    }

    @Override
    public String getValue() {
        return text();
    }

    @Override
    public void input(String value) {
        core().input(value);
    }

    @JDIAction("Clear value from '{name}'")
    @Override
    public void clear() {
        if (!isEmpty()) {
            core().clear();
        }
    }

    /*@JDIAction("Get '{name}' filterElements")
    public WebList getFilterElements() {
        return this.finds("android.widget.TextView");
    }

    @JDIAction("Get '{name}' filterElement by text")
    public UIElement getFilterElementByText (String value) {
        UIElement element = null;
        for (UIElement e : getFilterElements()) {
            if (e.attr("text").equalsIgnoreCase(value)) {
                element = e;
            }
        }
        return element;
    }

    @JDIAction("Click '{name}' filterElement by text '{0}'")
    public void clickFilterElementByText(String value) {
        getFilterElementByText(value).click();
    }*/

    @Override
    public SearchViewAssert is () {
        return new SearchViewAssert().set(this);
    }
}




