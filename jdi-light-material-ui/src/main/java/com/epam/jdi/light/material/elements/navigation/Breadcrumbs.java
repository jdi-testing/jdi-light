package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.annotations.JDIBreadcrumbs;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://mui.com/components/breadcrumbs/
 */
public class Breadcrumbs extends UIListBase<UISelectAssert<UISelectAssert<?, ?>, WebList>>
        implements ISetup {

    protected String ROOT_LOCATOR = ".MuiBreadcrumbs-root";
    protected String ITEMS_LOCATOR = ".MuiBreadcrumbs-li";
    protected String SEPARATORS_LOCATOR = ".MuiBreadcrumbs-separator";

    @Override
    @JDIAction("Get '{name}' items")
    public WebList list() {
        return finds(ITEMS_LOCATOR).setName(getName() + " breadcrumb");
    }

    @JDIAction("Get '{name}' separators")
    public WebList separators(){
        return finds(SEPARATORS_LOCATOR).setName(getName() + " breadcrumb separators");
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIBreadcrumbs.class, Breadcrumbs.class)) {
            JDIBreadcrumbs annotation = field.getAnnotation(JDIBreadcrumbs.class);
            initializeLocators(annotation);
        }
        this.setCore(Breadcrumbs.class, $(ROOT_LOCATOR));
        this.setName(String.format("Breadcrumbs container %s", field.getName()));
    }

    private void initializeLocators(JDIBreadcrumbs annotation) {
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.items().isEmpty()) {
            ITEMS_LOCATOR = annotation.items();
        }
        if (!annotation.separators().isEmpty()) {
            SEPARATORS_LOCATOR = annotation.separators();
        }
    }
}
