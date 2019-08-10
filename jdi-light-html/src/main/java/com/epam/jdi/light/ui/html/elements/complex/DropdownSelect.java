package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;


/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownSelect extends UIBaseElement<UISelectAssert> implements IsDropdown {
    protected Selector selector() {
        return new Selector().setCore(Selector.class, base());
    }
    public WebList list() { throw exception("not used for Selector"); }

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
    public String selected() { return selector().selected(); }
    public boolean wait(JFunc1<IsDropdown, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }
    @Override
    public boolean selected(String option) {
        return selected().equals(option);
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        return selector().values();
    }

    public String getValue() { return selected(); }
    public void setValue(String value) { select(value); }
    @JDIAction(level = DEBUG)
    public int size() { return selector().size(); }

    @Override
    public UISelectAssert is() {
        return new UISelectAssert<>().set(this);
    }
}
