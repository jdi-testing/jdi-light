package com.epam.jdi.light.vuetify.elements.complex.breadcrumbs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.vuetify.asserts.breadcrumbs.BreadcrumbsAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Breadcrumb web element please visit https://vuetifyjs.com/en/components/breadcrumbs
 *
 * Created by Nikita Nechepurenko on 20.09.2021
 */
public class Breadcrumbs extends UIListBase<BreadcrumbsAssert> implements ISetup, HasTheme {

    protected static final String DISABLED_LINK_CLASS = "v-breadcrumbs__item--disabled";

    // these locators are default and can be modified by JDIBreadcrumbs annotation
    private String rootLocator = ".v-breadcrumbs";
    private String dividersLocator = ".v-breadcrumbs__divider";
    private String itemsLocator = ".v-breadcrumbs__item";

    @Override
    public BreadcrumbsAssert is() {
        return new BreadcrumbsAssert().set(this);
    }

    @Override
    public WebList list() {
        return finds(itemsLocator);
    }

    @JDIAction("Get selected element from '{name}'")
    public String selected() {
        return list().first(this::isElementSelected).getText();
    }

    @Override
    @JDIAction("Check if selected option is '{0}'")
    public boolean selected(String option) {
        return selected().equals(option);
    }

    @JDIAction("Get dividers list from '{name}'")
    public WebList dividers() {
        return $$(dividersLocator, this).setName(getName() + " dividers");
    }

    @JDIAction("Get items list from '{name}'")
    public List<Breadcrumb> items() {
        return list().stream().map((e) -> new Breadcrumb().setCore(Breadcrumb.class, e)).collect(Collectors.toList());
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIBreadcrumbs.class, Breadcrumbs.class)) {
            JDIBreadcrumbs annotation = field.getAnnotation(JDIBreadcrumbs.class);
            setup(annotation.root(), annotation.items(), annotation.dividers());
        }
        this.setName(String.format("Breadcrumbs container %s", field.getName()));
    }

    public Breadcrumbs setup(String root, String items, String dividers) {
        if (!root.isEmpty()) {
            rootLocator = root;
        }
        if (!items.isEmpty()) {
            itemsLocator = items;
        }
        if (!dividers.isEmpty()) {
            dividersLocator = dividers;
        }
        base().setLocator(rootLocator);
        return this;
    }

    protected Boolean isElementSelected(UIElement element) {
        return element.hasClass(DISABLED_LINK_CLASS)
                || element.hasAttribute("active");
    }

    @JDIAction("Check that '{name}' is large")
    public boolean isLarge() {
        return hasClass("v-breadcrumbs--large");
    }
}
