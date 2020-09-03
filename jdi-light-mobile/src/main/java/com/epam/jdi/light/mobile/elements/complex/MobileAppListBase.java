package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public abstract class MobileAppListBase <A extends MobileSelectAssert<?,?>> extends MobileAppBaseElement<A>
        implements IMobileSelector, SetValue {
    protected MobileList list;
    public MobileList mobileList() {
        return new MobileList(base()).setup(JDIBase::searchVisible);
    }
    protected void setList(MobileList webList) { list = webList; }
    public MobileAppUIElement first() { return mobileList().first(); }
    public MobileAppUIElement last() {
        return mobileList().last();
    }
    public MobileAppUIElement get(String value) { return mobileList().get(value); }
    public MobileAppUIElement get(int index) { return mobileList().get(index); }
    @JDIAction("Check that '{name}' is displayed") @Override
    public boolean isDisplayed() { return mobileList().isDisplayed(); }
    @JDIAction("Check that '{name}' is visible by user") @Override
    public boolean isVisible() { return isDisplayed() && mobileList().hasAny(MobileAppUIElement::isVisible); }
    @JDIAction("Check that '{name}' is not visible by user") @Override
    public boolean isNotVisible() { return isHidden() || mobileList().all(MobileAppUIElement::isNotVisible); }
    @Override
    public boolean isEnabled() { return mobileList().isEnabled(); }
    @JDIAction(level = DEBUG) @Override
    public boolean isDisabled() {
        return !isEnabled();
    }
    public String getValue() { return selected(); }
    public void setValue(String value) { select(value); }
    @Override
    public void offCache() { mobileList().offCache(); super.offCache(); }
    public boolean isEmpty() { return size() == 0; }
    public boolean isNotEmpty() { return size() > 0; }
    @Override
    public Point getLocation() {
        return mobileList().getLocation();
    }
    @Override
    public void highlight() {
        mobileList().highlight();
    }
    @Override
    public void highlight(String color) {
        mobileList().highlight(color);
    }
    @Override
    public void show() {
        mobileList().show();
    }
    @Override
    public Dimension getSize() { return mobileList().getSize(); }
    @Override
    public A is() {
        mobileList().refresh();
        return (A) new MobileSelectAssert().set(this);
    }
}
