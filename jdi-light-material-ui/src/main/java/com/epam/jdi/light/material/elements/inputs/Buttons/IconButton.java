package com.epam.jdi.light.material.elements.inputs.Buttons;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIIconButtons;
import com.epam.jdi.light.material.asserts.inputs.Buttons.IconButtonAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class IconButton extends UIBaseElement<IconButtonAssert> implements ISetup {
    IconButton() {}

    String deleteEnabledButton;
    String deleteEnabledIcon;
    String deleteDisabledButton;
    String deleteDisabledIcon;
    String alarmButton;
    String alarmIcon;
    String shoppingCardButton;
    String shoppingCardIcon;


    @JDIAction("Get delete button")
    public IconButton getDeleteEnabledButton() {
        return new IconButton(core().find(deleteEnabledButton));
    }

    @JDIAction("Get delete icon")
    public IconButton getDeleteEnabledIcon() {
        return new IconButton(core().find(deleteEnabledIcon));
    }

    @JDIAction("Get send button")
    public IconButton getDeleteDisabledButton() {
        return new IconButton(core().find(deleteDisabledButton));
    }


    @JDIAction("Get send icon")
    public IconButton getDeleteDisabledIcon() {
        return new IconButton(core().find(deleteDisabledIcon));
    }


    @JDIAction("Get alarm button")
    public IconButton getAlarmButton() {
        return new IconButton(core().find(alarmButton));
    }

    @JDIAction("Get alarm icon")
    public IconButton getAlarmIcon() {
        return new IconButton(core().find(alarmIcon));
    }

    @JDIAction("Get shopping card button")
    public IconButton getShoppingCardButton() {
        return new IconButton(core().find(shoppingCardButton));
    }

    @JDIAction("Get shopping card icon")
    public IconButton getShoppingCardIcon() {
        return new IconButton(core().find(shoppingCardIcon));
    }

    public IconButton(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public IconButtonAssert is() {
        return new IconButtonAssert().set(this);
    }

    @Override
    public IconButtonAssert has() {
        return this.is();
    }

    @JDIAction("Check if '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Check if '{name}' is disabled")
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }


    @JDIAction("Check text in '{name}'")
    public String getText() {
        return core().getText();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIIconButtons.class, IconButton.class))
            return;
        JDIIconButtons iconButtons = field.getAnnotation(JDIIconButtons.class);
        deleteEnabledButton = iconButtons.deleteEnabledButton();
        deleteEnabledIcon = iconButtons.deleteEnabledIcon();
        deleteDisabledButton = iconButtons.deleteDisabledButton();
        deleteDisabledIcon = iconButtons.deleteDisabledIcon();
        alarmButton = iconButtons.alarmButton();
        alarmIcon = iconButtons.alarmIcon();
        shoppingCardButton = iconButtons.shoppingCardButton();
        shoppingCardIcon = iconButtons.shoppingCardIcon();
    }
}
