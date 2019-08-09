package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.complex.Dropdown;
import com.epam.jdi.tools.func.JFunc1;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static java.lang.String.format;

public class MultiDropdown extends Dropdown {
    public MultiDropdown() {
        expander = $(".caret");
        value = $("button");
    }
    /*
    By values = By.tagName("li");
    By valueTemplate = By.xpath(".//label[text()='%s']/../..");
    By valuesConatiner = By.tagName("ul");
    */

    @JDIAction("Select '{0}' in '{name}'") @Override
    public void select(String value) {
        expand();
        list().select(value);
    }

    protected void click() {
        if (expander != null)
            expander.click();
        else core().click();
    }
    public <TEnum extends Enum> void select(TEnum name) { select(getEnumValue(name));}

    /**
     * Select the specified element by the index
     * @param index
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        if (index < 1)
            throw exception("Can't get element with index '%s'. Index should be 1 or more", index);
        if (list() != null) {
            expand();
            list().select(index - 1);
            if (list().hasAny(UIElement::isDisplayed))
                click();
        } else {
            ds().select(index);
        }
    }

    /**
     * Get text
     * @return String text
     */
    @JDIAction("Get '{name}' text") @Override
    public String getText() {
        return getTextElement().getText();
    }
    @JDIAction("Get '{name}' text") @Override
    public String text() {
        return getTextElement().text();
    }
    @JDIAction("Get '{name}' text") @Override
    public String text(TextTypes type) {
        return getTextElement().text(type);
    }
    private IsText getTextElement() {
        return value != null ? value : ds();
    }

    /**
     * Check element is expanded
     * @return boolean
     */
    @JDIAction(value = "Is '{name}' expanded", level = DEBUG)
    public boolean isExpanded() {
        assertLinked(list(), "list", "expand");
        return list().isDisplayed();
    }
    /**
     * Expanding DropDown
     */
    @JDIAction(level = DEBUG)
    public void expand() {
        if (expander != null) {
            if (!isExpanded())
                expander.click();
        }
        else {
            try { core().click(); }
            catch (Throwable ignore) {
                assertLinked(expander, "expander", "expand");
            }
        }
    }
    /**
     * Closing DropDown
     */
    @JDIAction(level = DEBUG)
    public void close() {
        if (expander != null) {
            if (isExpanded())
                expander.click();
        }
        else { try { core().click(); }
        catch (Throwable ignore) {
            assertLinked(expander, "expander", "close");
        }
        }
    }

    /**
     * Get the element text
     * @return String text
     */
    @JDIAction(level = DEBUG)
    public String selected() {
        return getText();
    }

    @Override
    public boolean isEnabled() {
        if (list() == null || expander == null)
            return ds().isEnabled();
        expand();
        return list().listEnabled().size() > 0;
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return ds().isDisplayed() || value.isDisplayed();
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

    public boolean wait(JFunc1<Dropdown, Boolean> condition) {
        return base().timer().wait(() -> condition.execute(this));
    }

    public boolean selected(String option) {
        return selected().equals(option);
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        if (list() != null && list().size() > 0)
            return list().values();
        if (list() == null && core().getTagName().contains("select"))
            return ds().values();
        if (!list().hasAny(UIElement::isDisplayed))
            click();
        List<String> result = list().values();
        if (list().hasAny(UIElement::isDisplayed))
            click();
        return result;
    }

    /**
     * Get values as text of the specific type
     * @return List
     */
    @JDIAction("Get '{name}' values")
    public List<String> values(TextTypes type) {
        List<String> result = new ArrayList<>();
        if (list() == null && core().getTagName().contains("select"))
            return ds().values(type);
        if (list() != null) {
            if (!list().hasAny(UIElement::isDisplayed))
                click();
            result = list().values(type);
            if (list().hasAny(UIElement::isDisplayed))
                click();
        }
        return result;
    }
    public List<String> listEnabled() {
        return list() != null
                ? list().listEnabled()
                : ds().listEnabled();
    }

    public List<String> listDisabled() {
        return list() != null
                ? list().listDisabled()
                : ds().listDisabled();
    }

    protected void assertLinked(Object element, String name, String actionName) {
        if (element == null)
            throw exception(format("You must specify '%s' in Dropdown annotation in order to perform %s action", name ,actionName));
    }

}
