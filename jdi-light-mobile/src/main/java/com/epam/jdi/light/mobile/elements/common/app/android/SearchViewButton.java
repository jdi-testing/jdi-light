package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.asserts.SearchViewAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.ISearchView;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class SearchViewButton extends MobileAppBaseElement<SearchViewAssert> implements ISearchView, HasTouchActions, IsButton {

    @JDIAction(value = "Check that '{name}' is iconified", level = LogLevels.DEBUG)
    public boolean isIconified () {
        return core().isDisplayed();
    }

    @JDIAction(value = "Set '{name}' expanded", level = LogLevels.DEBUG)
    public void setExpanded() {
        if (isIconified())
            core().tap();
    }

    @JDIAction(value = "Check that '{name}' is expanded", level = LogLevels.DEBUG)
    public boolean isExpanded () {
        return core().attr("focused").
                equalsIgnoreCase("true");
    }

    @Override
    public String getValue() {
        return text();
    }

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

    @Override
    public SearchViewAssert is() {
        return new SearchViewAssert().set(this);
    }
}
