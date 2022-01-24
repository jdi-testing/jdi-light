package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDIButtonGroup;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

/**
 * To see an example of Button Group web element please visit https://vuetifyjs.com/en/components/button-groups/
 * <p>
 * Created by Nikita Nechepurenko on 01.10.2021
 * <p>
 * This element describes <b>a container</b> with buttons in it.
 * You can specify a locator for inner buttons with the JDIButtonGroup annotation.
 * <p>
 * This container behaves like UIElement but all UIList methods operate with inner buttons due to list() method
 * redefinition.
 */
public class ButtonGroup extends UIListBase<UISelectAssert<?, ?>> implements ISetup {

    private static final String TEXT_FIND_PATTERN = "//*[text() = '%s']";

    private String buttonsFindStrategy = ".v-btn";

    protected ButtonGroup() {
    }

    public ButtonGroup(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Get Button with index '{0}'")
    public VuetifyButton getButtonByIndex(int index) {
        return castToButton(list().get(index));
    }

    @JDIAction("Get Button with text '{0}'")
    public VuetifyButton getButtonByText(String text) {
        return castToButton(list().find(String.format(TEXT_FIND_PATTERN, text)));
    }

    @JDIAction("Get all Buttons from '{name}'")
    public List<VuetifyButton> getAllButtons() {
        return list().map(this::castToButton);
    }

    @Override
    public WebList list() {
        return core().finds(buttonsFindStrategy);
    }

    private VuetifyButton castToButton(UIElement element) {
        return new VuetifyButton(element);
    }

    public ButtonGroup setup(String root, String buttons) {
        if (isNotBlank(root)) {
            base().setLocator(root);
        }
        if (isNotBlank(buttons)) {
            buttonsFindStrategy = buttons;
        }
        return this;
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIButtonGroup.class, ButtonGroup.class)) {
            return;
        }
        JDIButtonGroup annotation = field.getAnnotation(JDIButtonGroup.class);

        if (!annotation.root().isEmpty()) {
            this.setCore(this.getClass(), $(annotation.root()));
        }
        if (!annotation.buttons().isEmpty()) {
            buttonsFindStrategy = annotation.buttons();
        }
    }

    public UISelectAssert<?, ?> have() {
        return is();
    }

    public UISelectAssert<?, ?> are() {
        return is();
    }
}
