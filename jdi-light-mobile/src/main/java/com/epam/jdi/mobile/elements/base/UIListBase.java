package com.epam.jdi.mobile.elements.base;

import com.epam.jdi.mobile.asserts.generic.UISelectAssert;
import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.complex.ISelector;
import com.epam.jdi.mobile.elements.complex.WebList;
import com.epam.jdi.mobile.elements.interfaces.base.SetValue;

import static com.epam.jdi.mobile.logger.LogLevels.DEBUG;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class UIListBase<A extends UISelectAssert> extends UIBaseElement<A>
        implements ISelector, SetValue {
    protected WebList list;
    public WebList list() {
        return new WebList(base()).setup(JDIBase::searchVisible);
    }
    protected void setList(WebList webList) { list = webList; }
    @JDIAction("Check that '{name}' is displayed") @Override
    public boolean isDisplayed() { return list().isDisplayed(); }
    @Override
    public boolean isHidden() { return !isDisplayed(); }
    @JDIAction(level = DEBUG) @Override
    public boolean isDisabled() {
        return !isEnabled();
    }
    public String getValue() { return selected(); }
    public void setValue(String value) { select(value); }
    @Override
    public void offCache() { list().offCache(); super.offCache(); }
    public boolean isEmpty() { return size() == 0; }
    public boolean isNotEmpty() { return size() > 0; }

    @Override
    public A is() {
        list().refresh();
        return (A) new UISelectAssert().set(this);
    }
}
