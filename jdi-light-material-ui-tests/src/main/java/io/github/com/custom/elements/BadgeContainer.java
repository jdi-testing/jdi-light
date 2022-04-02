package io.github.com.custom.elements;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.interfaces.displaydata.HasBadge;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import io.github.com.custom.annotations.JBadgeContainer;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class BadgeContainer extends UIBaseElement<UIAssert<?, ?>> implements ISetup, HasBadge, HasIcon {

    protected String root = "";
    protected String contextLocator = ".MuiSvgIcon-root";
    protected String badgeLocator = ".MuiBadge-badge";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JBadgeContainer.class, BadgeContainer.class)) {
            return;
        }
        JBadgeContainer annotation = field.getAnnotation(JBadgeContainer.class);
        root = annotation.root();
        contextLocator = annotation.context();
        badgeLocator = annotation.badge();
        base().setLocator(root);
    }

    @JDIAction("Get '{name}' badge")
    @Override
    public Badge badge() {
        return new Badge().setCore(Badge.class, core().find(badgeLocator));
    }

    @JDIAction("Get '{name}' icon")
    @Override
    public Icon icon() {
        return new Icon().setCore(Icon.class, core().find(contextLocator));
    }

}
