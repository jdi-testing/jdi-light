package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.asserts.inputs.ButtonGroupAssert;
import org.hamcrest.Matchers;

import java.lang.reflect.Field;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class ButtonGroup extends UIBaseElement<ButtonGroupAssert> implements ISetup {

    private static final String BUTTON_PATTERN = "//button[contains(@class, 'MuiButton-root')]";
    private static final String BUTTON_WITH_TEXT_PATTERN = BUTTON_PATTERN.concat("[span[contains(text(), '%s')]]");
    private static final String LIST_WITH_TEXT = "//li[contains(text(), '%s')]";

    String mainButton;
    String expand;
    String list;

    @JDIAction("Get Button with index '{0}'")
    public Button getButtonByIndex(int index) {
        return new Button(core().finds(BUTTON_PATTERN).get(index));
    }

    @JDIAction("Get Button with text '{0}'")
    public Button getButtonByText(String text) {
        return new Button(core().find(String.format(BUTTON_WITH_TEXT_PATTERN, text)));
    }

    @JDIAction("Get main button")
    public Button getMainButton() {
        return new Button(core().find(mainButton));
    }

    @JDIAction("Select '{0}' item in '{name}'")
    public void select(String item) {
        core().find(expand).click();
        UIElement element = core().find(String.format(LIST_WITH_TEXT, item));
        jdiAssert(element.text(), Matchers.equalTo(item));
        element.click();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIButtonGroup.class, ButtonGroup.class))
            return;
        JDIButtonGroup j = field.getAnnotation(JDIButtonGroup.class);
        mainButton = j.mainButton();
        expand = j.expand();
        list = j.list();
    }
}
