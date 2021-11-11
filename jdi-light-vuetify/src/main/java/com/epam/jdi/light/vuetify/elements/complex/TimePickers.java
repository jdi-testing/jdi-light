package com.epam.jdi.light.vuetify.elements.complex;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDITimePickers;

import java.lang.reflect.Field;


/**
 * To see examples of TimePickers web elements please visit https://vuetifyjs.com/en/components/time-pickers/
 */

public class TimePickers extends UIListBase<UISelectAssert<UISelectAssert<?, ?>, WebList>> implements ISetup {

    protected String ROOT_LOCATOR = ".v-time-picker-clock__container";
    protected String ITEMS_LOCATOR = ".v-time-picker-clock__item";

    @Override
    public WebList list() {
        return $$(ITEMS_LOCATOR, this).setName(getName() + " time_picker");
    }

    @JDIAction("Get list of '{name}' elements")
    public WebList items() {
        return list();
    }

    @JDIAction("Check '{name}' is enabled")
    public boolean isEnabled() {
        return list().isNotEmpty() && list().stream().anyMatch(UIElement::isEnabled)
                && list().stream().anyMatch(UIElement::isClickable);
    }

    @JDIAction("Check '{name}' is disabled")
    public boolean isDisabled() {
        return !isEnabled();
    }

    @JDIAction("Check '{name}' element is selected")
    protected Boolean isElementSelected(UIElement element) {
        return element.isEnabled() && (element.hasClass("accent") || element.hasAttribute("active")
                || element.hasClass("active"));
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

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDITimePickers.class, TimePickers.class)) {
            JDITimePickers annotation = field.getAnnotation(JDITimePickers.class);
            initializeLocators(annotation);
        }
        this.setCore(TimePickers.class, $(ROOT_LOCATOR));
        this.setName(String.format("TimePickers container %s", field.getName()));
    }

    private void initializeLocators(JDITimePickers annotation) {
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.items().isEmpty()) {
            ITEMS_LOCATOR = annotation.items();
        }
    }
}
