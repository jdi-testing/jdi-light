package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.annotations.JBreadcrumbs;
import com.epam.jdi.light.material.asserts.navigation.BreadcrumbAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * Represents Breadcrumbs MUI component on GUI.
 * <p>Breadcrumbs allow users to make selections from a range of values.</p>
 *
 * @see ISetup
 * @see <a href="https://v4.mui.com/components/breadcrumbs/">Breadcrumbs MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_breadcrumbs">MUI test page</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/router_breadcrumbs">MUI test page</a>
 */
public class Breadcrumbs extends UIListBase<BreadcrumbAssert> implements ISetup {

    /**
     * Locator for Breadcrumbs' root.
     */
    protected String rootLocator = ".MuiBreadcrumbs-root";

    /**
     * Locator for Breadcrumbs' items.
     */
    protected String itemsLocator = ".MuiBreadcrumbs-li";

    /**
     * Locator for Breadcrumbs' separators.
     */
    protected String separatorsLocator = ".MuiBreadcrumbs-separator";

    /**
     * Gets Breadcrumbs' list items.
     *
     * @return Breadcrumbs' list items as {@link WebList}
     */
    @Override
    @JDIAction("Get '{name}' items")
    public WebList list() {
        return core().finds(this.itemsLocator).setName(getName() + " breadcrumb");
    }

    /**
     * Gets Breadcrumbs' list separators.
     *
     * @return Breadcrumbs' list separators as {@link WebList}
     */
    @JDIAction("Get '{name}' separators")
    public WebList separators() {
        return core().finds(this.separatorsLocator).setName(getName() + " breadcrumb separators");
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JBreadcrumbs.class, Breadcrumbs.class)) {
            JBreadcrumbs annotation = field.getAnnotation(JBreadcrumbs.class);
            initializeLocators(annotation);
        }
        this.setCore(Breadcrumbs.class, $(this.rootLocator));
        this.setName(String.format("Breadcrumbs container %s", field.getName()));
    }

    private void initializeLocators(JBreadcrumbs annotation) {
        if (!annotation.root().isEmpty()) {
            this.rootLocator = annotation.root();
        }
        if (!annotation.items().isEmpty()) {
            this.itemsLocator = annotation.items();
        }
        if (!annotation.separators().isEmpty()) {
            this.separatorsLocator = annotation.separators();
        }
    }

    @Override
    public BreadcrumbAssert is() {
        return new BreadcrumbAssert().set(this);
    }
}
