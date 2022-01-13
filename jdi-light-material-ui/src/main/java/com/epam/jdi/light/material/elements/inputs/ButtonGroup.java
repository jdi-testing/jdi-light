package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.asserts.inputs.ButtonGroupAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Button group web element please visit
 * https://mui.com/components/button-group/
 */

public class ButtonGroup extends UIListBase<ButtonGroupAssert> implements ISetup {

    private static String buttonFindStrategy = "button.MuiButtonBase-root";
    private static final String TEXT_FIND_PATTERN = "//*[text() = '%s']";

    @JDIAction("Get Button with index '{0}'")
    public Button getButtonByIndex(int index) {
        return castToButton(list().get(index));
    }

    @JDIAction("Get Button with text '{0}'")
    public Button getButtonByText(String text) {
        return castToButton(core().find(String.format(TEXT_FIND_PATTERN, text)));
    }

    @JDIAction("Get all Buttons from '{name}'")
    public Collection<Button> getAllButtons() {
        return list().stream()
                .map(this::castToButton)
                .collect(Collectors.toList());
    }

    private Button castToButton(UIElement element) {
        return new Button().setCore(Button.class, element);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIButtonGroup.class, ButtonGroup.class)) {
            return;
        }
        JDIButtonGroup annotation = field.getAnnotation(JDIButtonGroup.class);
        buttonFindStrategy = annotation.list();
    }

    @Override
    public WebList list() {
        return core().finds(buttonFindStrategy);
    }

    @Override
    public ButtonGroupAssert is() {
        return new ButtonGroupAssert().set(this);
    }
}
