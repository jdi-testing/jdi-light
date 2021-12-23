package io.github.com.custom.elements;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.epam.jdi.light.material.interfaces.feedback.HasDialog;
import io.github.com.custom.annotations.JDIListItemWithDialog;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class ListItemWithDialog extends ListItem implements ISetup, HasDialog {

    protected String root = "//div[contains(@class, 'MuiListItem-root')";
    protected String dialogLocator = "//div[contains(@class, 'MuiDialog-container')";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIListItemWithDialog.class, ListItemWithDialog.class)) {
            return;
        }
            JDIListItemWithDialog annotation = field.getAnnotation(JDIListItemWithDialog.class);
            root = annotation.root();
            dialogLocator = annotation.dialog();
            base().setLocator(root);
    }

    @Override
    public Dialog dialog() {
        return new Dialog().setCore(Dialog.class, new UIElement().setLocator(dialogLocator));
    }
}
