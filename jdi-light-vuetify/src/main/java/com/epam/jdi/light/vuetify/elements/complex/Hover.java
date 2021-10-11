package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.annotations.JDIHover;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * To see an example of Hover web element please visit https://vuetifyjs.com/en/components/hover/
 *
 * This element can be used to hold elements, visibility of those is toggled by mouse hovering
 */
public class Hover extends UIBaseElement<TextAssert> implements ISetup, IsText {

    protected String HOVER_TARGET_SELECTOR = "";

    @JDIAction("Move cursor inside '{name}' target element")
    public void show() {
        getHoverTarget().hover();
    }

    @JDIAction("Move cursor outside '{name}' target element")
    public void suppress() {
        getHoverTarget().actions(Actions::moveToElement);
        final Rectangle elementBounding = core().getRect();
        new Actions(core().driver()).moveByOffset(
                elementBounding.width / 2 + 1,
                elementBounding.height / 2 + 1
        ).build().perform();
    }

    private UIElement getHoverTarget() {
        if (HOVER_TARGET_SELECTOR.isEmpty()) {
            return core();
        }
        return $(HOVER_TARGET_SELECTOR);
    }

    @Override
    public void setup(Field field) {
        if (!field.isAnnotationPresent(JDIHover.class)) {
            return;
        }
        HOVER_TARGET_SELECTOR = field.getAnnotation(JDIHover.class).value();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
