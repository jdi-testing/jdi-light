package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.SetValue;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;

public abstract class UIListBase<A extends UISelectAssert> extends UIBaseElement<A>
        implements ISelector, SetValue, HasUIList {
    protected WebList list;
    public WebList list() {
        return list != null ? list : $$(base().getLocator(), getName() + " list");
    }
    protected void setList(WebList webList) { list = webList; }

    public abstract void select(String value);
    public abstract String selected();

    @JDIAction("Select '{0}' in '{name}'")
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }
    @JDIAction("Check that '{name}' is hidden")
    @Override
    public boolean isHidden() { return !isDisplayed(); }
    @JDIAction(level = DEBUG)
    @Override
    public boolean isDisabled() {
        return !isEnabled();
    }
    public String getValue() { return selected(); }
    public void setValue(String value) { select(value); }
    @JDIAction(level = DEBUG)
    public int size() { return values().size(); }
    @Override
    public void offCache() { list().offCache(); super.offCache();}

    @Override
    public A is() {
        offCache();
        return (A) new UISelectAssert().set(this);
    }
}
