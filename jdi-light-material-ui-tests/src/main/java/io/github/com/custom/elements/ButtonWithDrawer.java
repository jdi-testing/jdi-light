package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.custom.annotations.JButtonWithDrawer;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class ButtonWithDrawer extends Button implements ISetup {

    protected String root = "";
    protected String drawerLocator = ".MuiDrawer-root";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JButtonWithDrawer.class, ButtonWithDrawer.class)) {
            return;
        }
        JButtonWithDrawer annotation = field.getAnnotation(JButtonWithDrawer.class);
        root = annotation.root();
        drawerLocator = annotation.drawer();
        base().setLocator(root);
    }

    @JDIAction("Get '{name}'s drawer")
    public Drawer drawer() {
        return new Drawer().setCore(Drawer.class, new UIElement().setLocator(drawerLocator));
    }


}
