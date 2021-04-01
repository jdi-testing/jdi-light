package com.epam.jdi.light.material.elements.inputs.Buttons;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIIconLabelButtons;
import com.epam.jdi.light.material.asserts.inputs.Buttons.IconLabelButtonAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class IconLabelButton extends UIBaseElement<IconLabelButtonAssert> implements ISetup {
    IconLabelButton() {}

    String deleteIconLabelButton;
    String deleteIconLabelIcon;
    String sendIconLabelButton;
    String sendIconLabelIcon;
    String uploadIconLabelButton;
    String uploadIconLabelIcon;
    String talkIconLabelButton;
    String talkIconLabelIcon;
    String saveIconLabelButton;
    String saveIconLabelIcon;
    String saveAllIconLabelButton;
    String saveAllIconLabelIcon;


    @JDIAction("Get delete button")
    public IconLabelButton getDeleteIconLabelButton() {
        return new IconLabelButton(core().find(deleteIconLabelButton));
    }

    @JDIAction("Get delete icon")
    public IconLabelButton getDeleteIconLabelIcon() {
        return new IconLabelButton(core().find(deleteIconLabelIcon));
    }

    @JDIAction("Get send button")
    public IconLabelButton getSendIconLabelButton() {
        return new IconLabelButton(core().find(sendIconLabelButton));
    }


    @JDIAction("Get send icon")
    public IconLabelButton getSendIconLabelIcon() {
        return new IconLabelButton(core().find(sendIconLabelIcon));
    }

    @JDIAction("Get upload button")
    public IconLabelButton getUploadIconLabelButton() {
        return new IconLabelButton(core().find(uploadIconLabelButton));
    }

    @JDIAction("Get upload icon")
    public IconLabelButton getUploadIconLabelIcon() {
        return new IconLabelButton(core().find(uploadIconLabelIcon));
    }

    @JDIAction("Get talk button")
    public IconLabelButton getTalkIconLabelButton() {
        return new IconLabelButton(core().find(talkIconLabelButton));
    }

    @JDIAction("Get talk icon")
    public IconLabelButton getTalkIconLabelIcon() {
        return new IconLabelButton(core().find(talkIconLabelIcon));
    }

    @JDIAction("Get save button")
    public IconLabelButton getSaveIconLabelButton() {
        return new IconLabelButton(core().find(saveIconLabelButton));
    }

    @JDIAction("Get save icon")
    public IconLabelButton getSaveIconLabelIcon() {
        return new IconLabelButton(core().find(saveIconLabelIcon));
    }

    @JDIAction("Get save all button")
    public IconLabelButton getSaveAllIconLabelButton() {
        return new IconLabelButton(core().find(saveAllIconLabelButton));
    }

    @JDIAction("Get save all icon")
    public IconLabelButton getSaveAllIconLabelIcon() {
        return new IconLabelButton(core().find(saveAllIconLabelIcon));
    }

    public IconLabelButton(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public IconLabelButtonAssert is() {
        return new IconLabelButtonAssert().set(this);
    }

    @Override
    public IconLabelButtonAssert has() {
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
        if (!fieldHasAnnotation(field, JDIIconLabelButtons.class, IconLabelButton.class))
            return;
        JDIIconLabelButtons iconLabelButtons = field.getAnnotation(JDIIconLabelButtons.class);
        deleteIconLabelButton = iconLabelButtons.deleteButton();
        deleteIconLabelIcon = iconLabelButtons.deleteIcon();
        sendIconLabelButton = iconLabelButtons.sendButton();
        sendIconLabelIcon = iconLabelButtons.sendIcon();
        uploadIconLabelButton = iconLabelButtons.uploadButton();
        uploadIconLabelIcon = iconLabelButtons.uploadIcon();
        talkIconLabelButton = iconLabelButtons.talkButton();
        talkIconLabelIcon = iconLabelButtons.talkIcon();
        saveIconLabelButton = iconLabelButtons.saveButton();
        saveIconLabelIcon = iconLabelButtons.saveIcon();
        saveAllIconLabelButton = iconLabelButtons.saveAllButton();
        saveAllIconLabelIcon = iconLabelButtons.saveAllIcon();
    }
}
