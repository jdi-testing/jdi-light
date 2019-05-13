package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.IHasSelectAssert;
import com.epam.jdi.light.asserts.SelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.tools.LinqUtils.*;
import static java.util.Arrays.asList;
import static org.openqa.selenium.By.cssSelector;

public class HtmlRadioGroup extends Selector<HtmlElement> implements RadioButtons, IHasSelectAssert {
    By radioButton = cssSelector("input[type=radio][id='%s']");
    By label = LABEL_LOCATOR;
    private String getId(String name) { return label(name).getAttribute("for"); }
    public HtmlElement get(String value) {
        return $(fillByTemplate(radioButton, getId(value)), parent).setName(value);
    }
    private HtmlElement label(String value) {
        return $(fillByTemplate(label, value), parent).setName("label");
    }

    public HtmlRadioGroup() { }
    public HtmlRadioGroup(WebElement el) { super(el); }
    List<HtmlElement> labels() { return map(getAllElements(),
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
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        label(value).click();
    }

    /**
     * Selects radio based on index
     * @param index int to select
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        labels().get(index-1).click();
    }
    /**
     * Gets secleted radio
     * @return String
     */
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        HtmlElement result = first(radioButtons(), HtmlElement::isSelected);
        return result != null ? result.labelText() : "";
    }
    @JDIAction("Is '{0}' selected for '{name}'")
    public boolean selected(String value) {
        return get(value).isSelected();
    }

    @JDIAction("Get '{name}' list values")
    public List<String> values() {
        return map(labels(), HtmlElement::getText);
    }
    @JDIAction("Get '{name}' list values")
    public List<String> innerValues() {
        return map(labels(), HtmlElement::innerText);
    }

    @JDIAction("Get '{name}' enabled values")
    public List<String> listEnabled() {
        return ifSelect(radioButtons(), HtmlElement::isEnabled, HtmlElement::labelText);
    }
    @JDIAction("Get '{name}' disabled values")
    public List<String> listDisabled() {
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
    public SelectAssert has() {
        return is();
    }
    public SelectAssert waitFor() {
        return is();
    }
    public SelectAssert shouldBe() {
        return is();
    }

}
