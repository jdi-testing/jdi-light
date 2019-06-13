package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
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

public class DropdownSelect extends UIBaseElement<UISelectAssert> implements IBaseElement {
    protected UIElement element = new UIElement();
    public UIElement element() { return element; }

    protected Select getSelect(String action) {
        try {
            return element().select();
        } catch (Exception ex) {
            throw exception(SELECT_ERROR, action, this);
        }
    }

    public DropdownSelect() {}
    public DropdownSelect(UIElement element, String errorMsg) {
        if (isNotBlank(errorMsg))
            SELECT_ERROR = errorMsg;
        this.element = element;
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
    @JDIAction("Get '{name}' text")
    public String getText() {
        return getSelect("getText").getFirstSelectedOption().getText();
    }

    /**
     * Get the element text
     * @return String text
     */
    @JDIAction(level = DEBUG)
    public String selected() {
        return getText();
    }

    public void hover() {
        element().hover();
    }
    public boolean isEnabled() {
        return element().isEnabled();
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return element().isDisplayed();
    }

    public void highlight(String color) {
        element().highlight(color);
    }
    public void highlight() {
        element().highlight();
    }
    public void show() {
        element().show();
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
     * Get the elements attribute 'innerValue'
     * @return List
     */
    @JDIAction("Get '{name}' values")
    public List<String> innerValues() {
        return map(getSelect("values").getOptions(), el -> $(el).innerText());
    }
    public List<String> listEnabled() {
        return ifSelect(getSelect("listEnabled").getAllSelectedOptions(),
            WebElement::isEnabled, WebElement::getText);
    }

    public List<String> listDisabled() {
        return ifSelect(getSelect("listDisabled").getAllSelectedOptions(),
                webElement -> !webElement.isEnabled(), WebElement::getText);
    }

}
