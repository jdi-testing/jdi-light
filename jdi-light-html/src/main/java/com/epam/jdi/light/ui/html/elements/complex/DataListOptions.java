package com.epam.jdi.mobile.ui.html.elements.complex;

import com.epam.jdi.mobile.asserts.generic.UISelectAssert;
import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.base.UIListBase;
import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.complex.WebList;
import com.epam.jdi.mobile.elements.interfaces.complex.IsCombobox;

import java.util.List;

import static com.epam.jdi.mobile.common.TextTypes.VALUE;
import static com.epam.jdi.mobile.elements.init.UIFactory.$$;
import static com.epam.jdi.tools.LinqUtils.ifSelect;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public class DataListOptions extends UIListBase<UISelectAssert> implements IsCombobox {
    @Override
    public WebList list() {
        return $$("#"+ uiElement.attr("list")+" option")
            .setup(e->e.noValidation().setName(getName() + "list"))
            .setUIElementName(VALUE);
    }
    /**
    *
     * Selects the value
     * @param value String to select
    **/
    @JDIAction("Select '{0}' for '{name}''") @Override
    public void select(String value) {
        core().setText(value);
    }

    /**
    *
     * Selects the value based on its index
     * @param index int to search
     **/
    @JDIAction("Select '{0}' for '{name}'") @Override
    public void select(int index) {
        setText(list().elements(index).keys().get(index-1));
    }
    /**
    *
     * Gets selected option
     * @return String
     **/
    @JDIAction("Get selected in '{name}' option") @Override
    public String selected() {
        return uiElement.attr("value");
    }
    /**
    *
     * Gets all options
     * @return List<String>
     **/
    @JDIAction("Get all '{name}' options") @Override
    public List<String> values() {
        return list().values();
    }
    /**
    *
     * Gets all enabled options
     * @return List<String>
     **/
    @JDIAction("Get all '{name}' enabled options") @Override
    public List<String> listEnabled() {
        return ifSelect(list(), UIElement::isEnabled, UIElement::getText);
    }

    /**
    *
     * Gets all disabled options
     * @return List<String>
     **/
    @JDIAction("Get all '{name}' disabled options") @Override
    public List<String> listDisabled() {
        return ifSelect(list(), UIElement::isDisabled, UIElement::getText);
    }

    @JDIAction("Check that '{name}' is enabled") @Override
    public boolean isEnabled() {
        return !core().hasAttribute("disabled");
    }
    @JDIAction("Check that '{name}' is displayed") @Override
    public boolean isDisplayed() { return core().isDisplayed(); }
}
