package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.material.asserts.navigation.BreadcrumbsAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Breadcrumbs extends UIBaseElement<BreadcrumbsAssert> implements ISetup {
    String breadcrumb;
    String separator;
    String icon;

    private static final String BUTTON_PATTERN = "//a[contains(@class, 'MuiButtonBase-root')]";
    private static final String BUTTON_WITH_TEXT_PATTERN = BUTTON_PATTERN.concat("//span[contains(text(), '%s')]");

    @JDIAction("Get breadcrumb with index '{index}'")
    public UIElement getBreadcrumbByIndex(int index) {
        return core().finds(breadcrumb).get(index);
    }

    @JDIAction("Get separator with index '{index}'")
    public UIElement getSeparatorByIndex(int index) {
        return core().finds(separator).get(index);
    }

    @JDIAction("Get icon with index '{index}'")
    public UIElement getIconByIndex(int index) {
        return core().finds(icon).get(index);
    }

    @JDIAction("Get Button with text '{text}'")
    public UIElement getButtonByText(String text) {
        return core().find(String.format(BUTTON_WITH_TEXT_PATTERN, text));
    }

    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIBreadcrumbs.class, Breadcrumbs.class))
            return;
        JDIBreadcrumbs j = field.getAnnotation(JDIBreadcrumbs.class);
        breadcrumb = j.breadcrumb();
        separator = j.separator();
        icon = j.icon();
    }
}
