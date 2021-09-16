package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.asserts.inputs.ButtonGroupAssert;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ButtonGroup extends UIBaseElement<ButtonGroupAssert> implements ISetup {

    private static String BUTTON_FIND_STRATEGY = "//button[contains(@class, 'MuiButton-root')]";
    private static final String TEXT_FIND_PATTERN = "//*[text() = '%s']";

    @JDIAction("Get Button with index '{0}'")
    public Button getButtonByIndex(int index) {
        return buttonFromUIElement(core().finds(BUTTON_FIND_STRATEGY).get(index));
    }

    @JDIAction("Get Button with text '{0}'")
    public Button getButtonByText(String text) {
        return buttonFromUIElement(core().find(String.format(TEXT_FIND_PATTERN, text)));
    }

    @JDIAction("Get all Buttons from '{name}'")
    public Collection<Button> getAllButtons() {
        // this method returns Collection instead of List due to breaking startIndex invariant
        // you can iterate by them or transform to an array
        return core().finds(BUTTON_FIND_STRATEGY).stream()
                .map(this::buttonFromUIElement).collect(Collectors.toList());
    }

    private Button buttonFromUIElement(UIElement element) {
        return new Button().setCore(Button.class, element);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIButtonGroup.class, ButtonGroup.class))
            return;
        JDIButtonGroup j = field.getAnnotation(JDIButtonGroup.class);
        BUTTON_FIND_STRATEGY = j.list();
    }
}
