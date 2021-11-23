package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.inputs.RadioAssert;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Radio web element please visit
 * https://mui.com/components/radio-buttons/
 */
public class RadioButtons extends UIListBase<RadioAssert> {

    protected UIElement getLabel(UIElement radio) {
        return radio.find("./..");
    }

    @Override
    @JDIAction(level = DEBUG)
    public List<Label> labels() {
        return list().stream()
                .map(this::getLabel)
                .map(label -> new Label().setCore(Label.class, label))
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction(level = DEBUG)
    public List<String> values() {
        return labels().stream()
                .map(IsText::text)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction(level = DEBUG)
    public UIElement get(String value) {
        return get(values().indexOf(value) + getStartIndex());
    }

    @Override
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        get(value).click();
    }

    @Override
    @JDIAction("Get selected value")
    public String selected() {
        return list().stream()
                .filter(radio -> radio.hasClass("Mui-checked"))
                .map(this::getLabel)
                .map(UIElement::text)
                .findFirst().orElse("");
    }

    @Override
    @JDIAction("Is '{0}' selected")
    public boolean selected(String option) {
        return selected().equals(option);
    }

    @Override
    @JDIAction("Is '{0}' selected")
    public boolean selected(int index) {
        return selected().equals(getLabel(get(index)).text());
    }

    @Override
    @JDIAction(level = DEBUG)
    public List<String> listEnabled() {
        List<String> all = values();
        all.removeAll(listDisabled());
        return all;
    }

    @Override
    @JDIAction(level = DEBUG)
    public List<String> listDisabled() {
        return labels().stream()
                .filter(element -> element.find(".MuiRadio-root").hasClass("Mui-disabled"))
                .map(IsText::text)
                .collect(Collectors.toList());
    }

    @Override
    public RadioAssert is() {
        return new RadioAssert().set(this);
    }
}