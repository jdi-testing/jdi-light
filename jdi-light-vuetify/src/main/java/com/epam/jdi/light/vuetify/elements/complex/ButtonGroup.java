package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.annotations.JDIButtonGroup;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Breadcrumb web element please visit https://vuetifyjs.com/en/components/button-groups/
 *
 * Created by Nikita Nechepurenko on 01.10.2021
 *
 * This element describes <b>a container</b> with buttons in it.
 * You can specify a locator for inner buttons with the JDIButtonGroup annotation.
 *
 * This container behaves like UIElement but all UIList methods operate with inner buttons due to list() method
 * redefinition.
 */
public class ButtonGroup extends UIListBase<UISelectAssert<?,?>> implements ISetup {

    protected String BUTTONS_FIND_STRATEGY = ".v-btn";
    private static final String TEXT_FIND_PATTERN = "//*[text() = '%s']";

    @JDIAction("Get Button with index '{0}'")
    public Button getButtonByIndex(int index) {
        return castToButton(list().get(index));
    }

    @JDIAction("Get Button with text '{0}'")
    public Button getButtonByText(String text) {
        return castToButton(list().find(String.format(TEXT_FIND_PATTERN, text)));
    }

    @JDIAction("Get all Buttons from '{name}'")
    public List<Button> getAllButtons() {
        return list().map(this::castToButton);
    }

    @Override
    public WebList list() {
        return core().finds(BUTTONS_FIND_STRATEGY);
    }

    private Button castToButton(UIElement element) {
        return new Button().setCore(Button.class, element);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIButtonGroup.class, ButtonGroup.class))
            return;
        JDIButtonGroup annotation = field.getAnnotation(JDIButtonGroup.class);

        if (!annotation.root().isEmpty()) {
            this.setCore(this.getClass(), $(annotation.root()));
        }
        if (!annotation.buttons().isEmpty()) {
            BUTTONS_FIND_STRATEGY = annotation.buttons();
        }
    }
}
