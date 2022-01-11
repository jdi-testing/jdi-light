package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.epam.jdi.light.material.interfaces.feedback.HasDialog;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.annotations.JDIButtonWithDialog;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class ButtonWithDialog extends Button implements ISetup, HasDialog {

    protected String root = "//div[contains(@class, 'MuiButton-root')";
    protected String dialogLocator = "//div[contains(@class, 'MuiDialog-container')";
    protected String actionTextLocator = "";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIButtonWithDialog.class, ButtonWithDialog.class)) {
            return;
        }
        JDIButtonWithDialog annotation = field.getAnnotation(JDIButtonWithDialog.class);
        root = annotation.root();
        dialogLocator = annotation.dialog();
        actionTextLocator = annotation.actionText();
        base().setLocator(root);
    }

    @JDIAction("Get '{name}'s dialog")
    @Override
    public Dialog dialog() {
        return new Dialog().setCore(Dialog.class, new UIElement().setLocator(dialogLocator));
    }

    @JDIAction("Get '{name}'s action text")
    public Text actionText() {
        return new Text().setCore(Text.class, new UIElement().setLocator(actionTextLocator));
    }

}
