package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.asserts.BaseSelectorAssert;
import com.epam.jdi.light.ui.html.asserts.SelectAssert;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import com.epam.jdi.light.ui.html.complex.RadioGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static java.util.Arrays.asList;
import static org.openqa.selenium.By.cssSelector;

public class HtmlRadioGroup extends UIElement<UIElement> implements BaseSelectorAssert, RadioGroup, RadioButtons {
    By radioButton = cssSelector("input[type=radio][id='%s']");
    By label = By.xpath(".//label[text()='%s']");
    private String getId(String name) { return label(name).getAttribute("for"); }
    public HtmlElement get(String name) {
        return $(fillByTemplate(radioButton, getId(name)), parent).setName("radioButton");
    }
    private HtmlElement label(String name) {
        return $(fillByTemplate(label, name), parent).setName("label");
    }

    public HtmlRadioGroup() { }
    public HtmlRadioGroup(WebElement el) { super(el); }
    List<UIElement> labels() { return map(getAllElements(),
        el -> new HtmlElement(el).label());
    }
    List<HtmlElement> radioButtons() { return map(getAllElements(), HtmlElement::new); }

    private List<WebElement> getAllElements() {
        if (getLocator() == null)
            throw exception("Please specify RadioButtons locator in order to get all radio buttons");
        return getAll();
    }
    /**
     * Selects radio based on value
     * @param value String to select
     */
    @Override
    public void select(String value) {
        label(value).click();
    }
    @Override
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }

    /**
     * Selects radio based on index
     * @param index int to select
     */
    public void select(int index) {
        labels().get(index-1).click();
    }
    /**
     * Gets secleted radio
     * @return String
     */
    public String selected() {
        HtmlElement result = first(radioButtons(), HtmlElement::isSelected);
        return result != null ? result.labelText() : "";
    }
    public boolean selected(String value) {
        return get(value).isSelected();
    }

    public List<String> values() {
        return map(labels(), UIElement::getText);
    }

    public List<String> checked() {
        return asList(selected());
    }

    public List<String> enabled() {
        return ifSelect(radioButtons(), HtmlElement::isEnabled, HtmlElement::labelText);
    }
    public List<String> disabled() {
        return ifSelect(radioButtons(), HtmlElement::isDisabled, HtmlElement::labelText);
    }

    @Override
    public void setValue(String value) {
        select(value);
    }
    @Override
    public String getValue() {
        return selected();
    }

    public SelectAssert is() {
        return new SelectAssert(this);
    }
    public SelectAssert assertThat() {
        return is();
    }

}
