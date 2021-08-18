package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://material-ui.com/components/breadcrumbs/
 */

public class Breadcrumbs extends UIListBase<UISelectAssert<UISelectAssert<?,?>, WebList>> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Check if '{name}' is displayed")
    @Override
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @JDIAction("Check text in '{name}'")
    public String getText() {
        return core().getText();
    }

    @JDIAction("Get breadcrumbs in '{name}'")
    @Override
    public WebList list() {
        return $$(".MuiBreadcrumbs-root .MuiBreadcrumbs-li", this).setName(getName() + " breadcrumb");
    }

    @JDIAction("Get breadcrumb icons in '{name}'")
    public WebList getIcons() {
        return $$(".MuiBreadcrumbs-li .MuiSvgIcon-root", this).setName(getName() + " breadcrumb icon");
    }

    @JDIAction("Get breadcrumb separators in '{name}'")
    public WebList getSeparators(){
        return $$(".MuiBreadcrumbs-li+.MuiBreadcrumbs-separator", this).setName(getName() + " breadcrumb separator");
    }

}
