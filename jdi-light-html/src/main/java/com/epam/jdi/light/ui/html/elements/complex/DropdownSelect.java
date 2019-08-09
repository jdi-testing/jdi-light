package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.Selector;
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

public class DropdownSelect extends UIBaseElement<UISelectAssert>
        implements ISelector, SetValue, HasLabel {
    protected Selector selector;
    protected Selector selector() {
        if (selector == null) {
            selector = new Selector();
            selector.base().setCore(base());
        }
        return selector;
    }
    protected Select getSelect(String action) {
        try {
            return core().asSelect();
        } catch (Exception ex) {
            throw exception(SELECT_ERROR, action, this, ex.getMessage());
        }
    }

    public DropdownSelect() {}
    public DropdownSelect(UIElement element, String errorMsg) {
        if (isNotBlank(errorMsg))
            SELECT_ERROR = errorMsg;
        selector = new Selector();
        selector.base().setCore(element.base());
        this.uiElement = element;
    }
    private static String SELECT_ERROR =
        "Can't %s element in DropdownSelect '%s'. DropdownSelect locator should point to select tag: %s";

    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(String value) {
        getSelect(format("Select '%s'", value)).selectByVisibleText(value);
    }

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(int index) {
        if (index < 1)
            throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
        getSelect(format("Select '%s'", index)).selectByIndex(index-1);
    }

    /**
     * Get text
     * @return String text
     */
    @JDIAction("Get '{name}' text") @Override
    public String getText() {
        return getSelect("getText").getFirstSelectedOption().getText();
    }
    @JDIAction("Get '{name}' text") @Override
    public String text(TextTypes type) { return getText(); }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }
    @JDIAction("Check that '{name}' is displayed") @Override
    public String selected() { return getText(); }
    public boolean wait(JFunc1<DropdownSelect, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }
    @Override
    public boolean selected(String option) {
        return selected().equals(option);
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        return map(getSelect("values").getOptions(), WebElement::getText);
    }

    /**
     * Get values as text of specific type
     * @return List
     */
    @JDIAction("Get '{name}' values")
    public List<String> values(TextTypes type) {
        return map(getSelect("values").getOptions(), el -> $(el).text(type));
    }

    public String getValue() { return selected(); }
    public void setValue(String value) { select(value); }
    @JDIAction(level = DEBUG)
    public int size() { return values().size(); }

    @Override
    public UISelectAssert is() {
        return new UISelectAssert<>().set(this);
    }
}
