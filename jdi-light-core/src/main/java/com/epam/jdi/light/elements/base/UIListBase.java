package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class UIListBase<A extends UISelectAssert<?,?>> extends UIBaseElement<A>
        implements ISelector, SetValue {
    protected int startIndex = ELEMENT.startIndex;

    public WebList list() {
        WebList webList = new WebList(base()).setup(JDIBase::searchVisible);
        webList.setStartIndex(getStartIndex());
        return webList;
    }
    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int index) {
        startIndex = index;
    }
    public UIElement first() { return list().first(); }
    public UIElement last() {
        return list().last();
    }
    public UIElement get(String value) { return list().get(value); }
    public UIElement get(int index) { return list().get(index); }
    @JDIAction("Check that '{name}' is displayed") @Override
    public boolean isDisplayed() { return list().isDisplayed(); }
    @JDIAction("Check that '{name}' is visible by user") @Override
    public boolean isVisible() { return isDisplayed() && list().hasAny(UIElement::isVisible); }
    @JDIAction("Check that '{name}' is not visible by user") @Override
    public boolean isNotVisible() { return isHidden() || list().all(UIElement::isNotVisible); }
    @Override
    public boolean isEnabled() { return list().isEnabled(); }
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
    public Point getLocation() {
        return list().getLocation();
    }
    @Override
    public void highlight() {
        list().highlight();
    }
    @Override
    public void highlight(String color) {
        list().highlight(color);
    }
    @Override
    public void show() {
        list().show();
    }
    @Override
    public Dimension getSize() { return list().getSize(); }
    @Override
    public A is() {
        list().refresh();
        return (A) new UISelectAssert().set(this);
    }
}
