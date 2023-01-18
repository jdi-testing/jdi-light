package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.inputs.RadioAssert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents Radio buttons MUI component on GUI.
 * <p>Use radio buttons when the user needs to see all available options. If available options can be collapsed, consider using a dropdown menu because it uses less space.
 * Radio buttons should have the most commonly used option selected by default.</p>
 *
 * @see <a href="https://v4.mui.com/components/radio-buttons/">Radio buttons MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/radio">MUI test page</a>
 */
public class RadioButtons extends UIListBase<RadioAssert> {

    /**
     * Gets label element of this Radio button.
     *
     * @param radio radio button element as {@link UIElement} to find label element
     * @return label element of this Radio button as {@link UIElement}
     */
    @JDIAction("Get label of '{name}' by radio '{0}'")
    protected UIElement label(UIElement radio) {
        return radio.findUp();
    }

    /**
     * Gets list label elements of this Radio buttons.
     *
     * @return list label elements of this Radio buttons as {@link List}
     */
    @Override
    @JDIAction("Get list labels of '{name}'")
    public List<Label> labels() {
        return list().stream()
                .map(this::label)
                .map(label -> new Label().setCore(Label.class, label))
                .collect(Collectors.toList());
    }

    /**
     * Gets list label texts of Radio buttons.
     *
     * @return list label texts of Radio buttons as {@link List}
     */
    @Override
    @JDIAction("Get list texts of '{name}'")
    public List<String> values() {
        return this.labels().stream()
                .map(IsText::text)
                .collect(Collectors.toList());
    }

    /**
     * Gets Radio button element by label.
     *
     * @param label expected label in list of Radio buttons' label elements as {@link String}
     * @return Radio button element as {@link UIElement}
     */
    @Override
    @JDIAction("Get '{name}' by label '{0}'")
    public UIElement get(String label) {
        return get(this.values().indexOf(label) + getStartIndex());
    }

    /**
     * Selects Radio button by label.
     *
     * @param label expected label of Radio button as {@link String}
     */
    @Override
    @JDIAction("Select '{name}' by label '{0}'")
    public void select(String label) {
        this.get(label).click();
    }

    /**
     * Gets label of selected Radio button.
     *
     * @return label of selected Radio button as {@link String}
     */
    @Override
    @JDIAction("Get label of selected '{name}'")
    public String selected() {
        return list().stream()
                .filter(radio -> radio.hasClass("Mui-checked"))
                .map(this::label)
                .map(UIElement::text)
                .findFirst().orElse("");
    }

    /**
     * Checks if this Radio button is checked or not by label of the Radio button.
     *
     * @param label expected label of the Radio button as {@link String}
     * @return {@code true} if the Radio button is checked, otherwise {@code false}
     */
    @Override
    @JDIAction("Check that '{name}' is selected by label '{0}'")
    public boolean selected(String label) {
        return this.selected().equals(label);
    }

    /**
     * Checks if this Radio button is checked or not by index of the Radio button.
     *
     * @param index expected index of the Radio button as {@code int}
     * @return {@code true} if this Radio button is checked, otherwise {@code false}
     */
    @Override
    @JDIAction("Check that '{name}' is selected by index '{0}'")
    public boolean selected(int index) {
        return this.selected().equals(this.label(get(index)).text());
    }

    /**
     * Gets list labels of enabled Radio buttons.
     *
     * @return list labels of enabled Radio buttons as {@link List}
     */
    @Override
    @JDIAction("Get list labels of enabled '{name}'")
    public List<String> listEnabled() {
        List<String> all = this.values();
        all.removeAll(listDisabled());
        return all;
    }

    /**
     * Gets list labels of disabled Radio buttons.
     *
     * @return list labels of disabled Radio buttons as {@link List}
     */
    @Override
    @JDIAction("Get list labels of disabled '{name}'")
    public List<String> listDisabled() {
        return this.labels().stream()
                .filter(element -> element.find(".MuiRadio-root").hasClass("Mui-disabled"))
                .map(IsText::text)
                .collect(Collectors.toList());
    }

    @Override
    public RadioAssert is() {
        return new RadioAssert().set(this);
    }
}

