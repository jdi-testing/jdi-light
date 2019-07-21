package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextType;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasLabel;
import com.epam.jdi.light.elements.interfaces.HasText;
import com.epam.jdi.light.elements.interfaces.IBaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.base.JDIBase.waitCondition;
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

public class DropdownSelect extends UIBaseElement<UISelectAssert> implements IBaseElement,
        HasLabel, SetValue, HasText {

    protected Select getSelect(String action) {
        try {
            return core().asSelect();
        } catch (Exception ex) {
            throw exception(SELECT_ERROR, action, this);
        }
    }

    public DropdownSelect() {}
    public DropdownSelect(UIElement element, String errorMsg) {
        if (isNotBlank(errorMsg))
            SELECT_ERROR = errorMsg;
        this.uiElement = element;
    }
    private static String SELECT_ERROR =
        "Can't %s element in DropdownSelect '%s'. DropdownSelect locator should point to select tag";

    /**
     * Select the specified element by the value
     * @param value
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        getSelect(format("Select '%s'", value)).selectByVisibleText(value);
    }
    public <TEnum extends Enum> void select(TEnum name) { select(getEnumValue(name));}

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
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
    public String text() { return getText(); }
    @JDIAction("Get '{name}' text") @Override
    public String text(TextType type) { return getText(); }

    /**
     * Get the element text
     * @return String text
     */
    @JDIAction(level = DEBUG)
    public String selected() {
        return getText();
    }

    public void hover() {
        core().hover();
    }
    public boolean isEnabled() {
        return core().isEnabled();
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    public void highlight(String color) {
        core().highlight(color);
    }
    public void highlight() {
        core().highlight();
    }
    public void show() {
        core().show();
    }

    public boolean wait(JFunc1<DropdownSelect, Boolean> condition) {
        return waitCondition(condition, this);
    }

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
    public List<String> values(TextType type) {
        return map(getSelect("values").getOptions(), el -> $(el).text(type));
    }
    public List<String> listEnabled() {
        return ifSelect(getSelect("listEnabled").getAllSelectedOptions(),
            WebElement::isEnabled, WebElement::getText);
    }

    public List<String> listDisabled() {
        return ifSelect(getSelect("listDisabled").getAllSelectedOptions(),
                webElement -> !webElement.isEnabled(), WebElement::getText);
    }

    @Override
    public void setValue(String value) {
        select(value);
    }

    public String getValue() {
        return selected();
    }
}
