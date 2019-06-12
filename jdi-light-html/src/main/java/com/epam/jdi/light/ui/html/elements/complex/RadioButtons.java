package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.Label;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.elements.base.JDIBase.waitCondition;
import static com.epam.jdi.light.elements.complex.Selector.LABEL_LOCATOR;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.openqa.selenium.By.cssSelector;

public class RadioButtons extends UIListBase<UISelectAssert> {

    By radioButton = cssSelector("input[type=radio][id='%s']");
    By label = LABEL_LOCATOR;
    public void setLabelLocator(String locator) {
        label = defineLocator(locator);
    }

    private String getId(String name) { return label(name).getAttribute("for"); }
    public UIElement get(String value) {
        return $(fillByTemplate(radioButton, getId(value)), parent).setName(value);
    }
    private UIElement label(String value) {
        return $(fillByTemplate(label, value), parent).setName(getName()+" label");
    }

    List<Label> labels() { return map(getAllElements(), el -> $(el).label()); }

    private List<WebElement> getAllElements() {
        if (list().getLocator() == null)
            throw exception("Please specify RadioButtons locator in order to get all radio buttons");
        return list().getAll();
    }
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) { label(value).click(); }

    @JDIAction("Is '{0}' selected")
    public boolean selected(String value) {
        return label(value).isSelected();
    }
    @JDIAction("Get '{name}' list values")
    public List<String> values() {
        return map(labels(), Label::getText);
    }

    @JDIAction("Get '{name}' list values")
    public List<String> innerValues() {
        return map(labels(), Label::innerText);
    }
    public boolean wait(JFunc1<RadioButtons, Boolean> condition) {
        return waitCondition(condition, this);
    }
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) { list().select(index);  }
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String... values) {
        list().select(values);
    }
    @JDIAction("Select '{0}' in '{name}'")
    public <TEnum extends Enum> void select(TEnum... values) {
        list().select(values);
    }
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int... values) {
        list().select(values);
    }
    @JDIAction("Hover and click on last element'{0}' in '{name}'")
    public void hoverAndClick(String... values) {
        list().hoverAndClick(values);
    }
    @JDIAction("Hover and click on last element'{0}' in '{name}'")
    public void hoverAndClick(String value) {
        list().hoverAndClick(value);
    }

    @JDIAction("Get selected value")
    public String selected() { return list().selected(); }
    @JDIAction(level = DEBUG)
    public List<String> listEnabled() { return list().listEnabled(); }

    @JDIAction(level = DEBUG)
    public List<String> listDisabled() { return list().listDisabled();
    }

    @JDIAction("Hover to '{name}'")
    public void hover() {
        list().hover();
    }
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return list().isDisplayed();
    }
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return list().isHidden();
    }
    @JDIAction(level = DEBUG)
    public void highlight(String color) {
        list().highlight(color);
    }
    @JDIAction(level = DEBUG)
    public void highlight() {
        list().highlight();
    }
    @JDIAction(level = DEBUG)
    public void show() {
        list().show();
    }
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return list().listEnabled().size() > 0;
    }
}
