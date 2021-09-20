package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDIBreadcrumbs;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Breadcrumb web element please visit https://vuetifyjs.com/en/components/breadcrumbs
 *
 * Created by Nikita Nechepurenko on 20.09.2021
 */
public class Breadcrumbs extends UIListBase<UISelectAssert<UISelectAssert<?,?>, WebList>> implements ISetup {

    // these locators are default and can be modified by JDIBreadcrumbs annotation
    protected String ROOT_LOCATOR = ".v-breadcrumbs";
    protected String ITEMS_LOCATOR = ".v-breadcrumbs__item";
    protected String DIVIDERS_LOCATOR = ".v-breadcrumbs__divider";

    protected String DISABLED_LINK_CLASS = "v-breadcrumbs__item--disabled";

    @Override
    public WebList list() {
        return $$(ITEMS_LOCATOR, this).setName(getName() + " breadcrumb");
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
        return $$(DIVIDERS_LOCATOR, this);
    }

    @JDIAction("Get items list from '{name}'")
    public WebList items() {
        return list();
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIBreadcrumbs.class, Breadcrumbs.class)) {
            JDIBreadcrumbs annotation = field.getAnnotation(JDIBreadcrumbs.class);
            initializeLocators(annotation);
        }
        this.setCore(Breadcrumbs.class, $(ROOT_LOCATOR));
    }

    private void initializeLocators(JDIBreadcrumbs annotation) {
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.items().isEmpty()) {
            ITEMS_LOCATOR = annotation.items();
        }
        if (!annotation.dividers().isEmpty()) {
            DIVIDERS_LOCATOR = annotation.dividers();
        }
    }

    protected Boolean isElementSelected(UIElement element) {
        return element.hasClass(DISABLED_LINK_CLASS)
                || element.hasAttribute("active");
    }

}
