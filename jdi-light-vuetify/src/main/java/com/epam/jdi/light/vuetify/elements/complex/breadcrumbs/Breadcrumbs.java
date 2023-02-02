package com.epam.jdi.light.vuetify.elements.complex.breadcrumbs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.breadcrumbs.BreadcrumbsAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.List;
import java.util.stream.Collectors;


/**
 * To see an example of Breadcrumb web element please visit https://vuetifyjs.com/en/components/breadcrumbs
 */
public class Breadcrumbs extends UIBaseElement<BreadcrumbsAssert> implements HasTheme {

    private String dividersLocator = ".v-breadcrumbs__divider";
    private String itemsLocator = ".v-breadcrumbs__item";

    @Override
    public BreadcrumbsAssert is() {
        return new BreadcrumbsAssert().set(this);
    }

    public WebList list() {
        return finds(itemsLocator);
    }

    @JDIAction("Get dividers list from '{name}'")
    public WebList dividers() {
        return finds(dividersLocator).setName(getName() + " dividers");
    }

    @JDIAction("Get items list from '{name}'")
    public List<Breadcrumb> items() {
        return list().stream().map((e) -> new Breadcrumb().setCore(Breadcrumb.class, e)).collect(Collectors.toList());
    }

    @JDIAction("Get items list from '{name}'")
    public Breadcrumb item(String label) {
        return list().stream().filter(e -> e.text().equalsIgnoreCase(label))
                .map((e) -> new Breadcrumb().setCore(Breadcrumb.class, e))
                .findFirst().get();
    }

    @JDIAction("Check that '{name}' is large")
    public boolean isLarge() {
        return hasClass("v-breadcrumbs--large");
    }
}
