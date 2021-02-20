package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.asserts.SearchViewButtonAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.ISearchViewButton;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class SearchViewButton extends MobileAppBaseElement<SearchViewButtonAssert> implements ISearchViewButton, HasTouchActions, IsButton {

    @JDIAction(value = "Set '{name}' expanded")
    public void setExpanded() {
        if (core().isDisplayed())
            core().tap();
    }

    @Override
    public SearchViewButtonAssert is() {
        return new SearchViewButtonAssert().set(this);
    }
}
