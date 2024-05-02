package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.elements.displaydata.list.ListItem;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.epam.jdi.light.material.interfaces.feedback.HasDialog;
import io.github.com.custom.annotations.JListItemWithDialog;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class MUIListItemWithDialog extends ListItem implements ISetup, HasDialog {

    protected String root = "//div[contains(@class, 'MuiListItem-root')";
    protected String dialogLocator = "//div[contains(@class, 'MuiDialog-container')";

    public MUIListItemWithDialog() {
        super();
    }

    public MUIListItemWithDialog(UIElement base) {
        setCore(MUIListItemWithDialog.class, base);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JListItemWithDialog.class, MUIListItemWithDialog.class)) {
            return;
        }
        JListItemWithDialog annotation = field.getAnnotation(JListItemWithDialog.class);
        root = annotation.root();
        dialogLocator = annotation.dialog();
        base().setLocator(root);
    }


    @JDIAction("Get '{name}'s dialog")
    @Override
    public Dialog dialog() {
        return new Dialog().setCore(Dialog.class, new UIElement().setLocator(dialogLocator));
    }
}
