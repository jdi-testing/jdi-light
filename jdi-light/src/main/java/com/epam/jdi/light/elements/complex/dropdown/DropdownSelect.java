package com.epam.jdi.light.elements.complex.dropdown;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.tools.func.JFunc1;

import java.util.List;


/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DropdownSelect extends UIBaseElement<UISelectAssert> implements IsDropdown {
    protected Selector selector() {
        return new Selector().setCore(Selector.class, base());
    }
    public WebList list() { return selector().list(); }

    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(String value) {
        selector().select(value);
    }

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(int index) {
        selector().select(index);
    }

    @JDIAction("Check that '{name}' is displayed") @Override
    public String selected() {
        return selector().selected();
    }
    public boolean wait(JFunc1<IsDropdown, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }
    @Override
    public boolean selected(String option) {
        return selector().selected(option);
    }
    @Override
    public List<String> values() { return selector().values(); }
    @Override
    public List<String> values(TextTypes type) { return selector().values(); }

    @Override
    public UISelectAssert is() {
        return new UISelectAssert<>().set(this);
    }
    @Override
    public boolean isEnabled() { return list().isEnabled(); }
    @Override
    public boolean isDisabled() { return !isEnabled(); }
    @Override
    public boolean isDisplayed() { return list().isDisplayed(); }
    @Override
    public boolean isHidden() { return list().isHidden(); }
}
