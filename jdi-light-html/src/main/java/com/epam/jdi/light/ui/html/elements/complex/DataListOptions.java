package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.jdiai.tools.HasStartIndex;
import com.jdiai.tools.LinqUtils;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.jdiai.tools.LinqUtils.ifSelect;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public class DataListOptions extends UIListBase<DropdownAssert>
        implements IsCombobox, HasStartIndex {
    protected int startIndex = ELEMENT.startIndex;

    @Override
    public WebList list() {
        WebList list = $$("#"+ core().attr("list")+" option")
            .setup(e -> e.noValidation().setName(getName() + "list"))
            .setUIElementName(VALUE);
        list.setStartIndex(startIndex);
        return list;
    }

    @Override
    public String getText() {
        return core().attr("value");
    }

    /**
     * Selects the value
     *
     * @param value String to select
     **/
    @JDIAction("Select '{0}' for '{name}''")
    @Override
    public void select(String value) {
        core().setText(value);
    }

    /**
     * Selects the value based on its index
     *
     * @param index int to search
     **/
    @JDIAction("Select '{0}' for '{name}'")
    @Override
    public void select(int index) {
        setText(LinqUtils.map(list().elements(index), UIElement::getTextForce).get(index - startIndex));
    }

    /**
     * Gets all options
     *
     * @return List<String>
     **/
    @JDIAction("Get all '{name}' options")
    @Override
    public List<String> values() {
        return list().values();
    }

    /**
     * Gets all enabled options
     *
     * @return List<String>
     **/
    @JDIAction("Get all '{name}' enabled options")
    @Override
    public List<String> listEnabled() {
        return ifSelect(list(), UIElement::isEnabled, UIElement::getText);
    }

    /**
     * Gets all disabled options
     *
     * @return List<String>
     **/
    @JDIAction("Get all '{name}' disabled options")
    @Override
    public List<String> listDisabled() {
        return ifSelect(list(), UIElement::isDisabled, UIElement::getText);
    }

    @JDIAction("Check that '{name}' is enabled")
    @Override
    public boolean isEnabled() {
        return !core().hasAttribute("disabled");
    }

    @JDIAction("Check that '{name}' is displayed")
    @Override
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @Override
    public boolean isExpanded() {
        throw runtimeException("function isExpanded() can not be used with this element");
    }

    @Override
    public boolean isCollapsed() {
        throw runtimeException("function isCollapsed() can not be used with this element");
    }

    @Override
    public DropdownAssert is() {
        return new DropdownAssert().set(this);
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int index) {
        startIndex = index;
    }
}
