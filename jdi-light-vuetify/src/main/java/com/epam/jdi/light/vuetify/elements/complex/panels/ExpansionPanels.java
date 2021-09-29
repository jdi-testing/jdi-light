package com.epam.jdi.light.vuetify.elements.complex.panels;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDIExpansionPanels;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Expansion Panels web element please visit
 * https://vuetifyjs.com/en/components/expansion-panels/
 */
public class ExpansionPanels extends UIListBase<UISelectAssert<UISelectAssert<?, ?>, WebList>> implements ISetup {

    protected String ROOT_LOCATOR = ".v-expansion-panels";
    protected String PANELS_LOCATOR = ".v-expansion-panel";
    protected String HEADER_LOCATOR = ".v-expansion-panel-header";
    protected String ICON_LOCATOR = ".v-expansion-panel-header__icon";
    protected String CONTENT_LOCATOR = ".v-expansion-panel-content";
    protected String WRAPPER_LOCATOR = ".v-expansion-panel-content__wrap";

    @Override
    public WebList list() {
        return $$(PANELS_LOCATOR, this).setName(getName() + " expansion panels");
    }

    @JDIAction("Get Panels from '{name}'")
    public List<ExpansionPanel> panels() {
        return list().map(this::createPanel);
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return panels().stream()
                .allMatch(ExpansionPanel::isEnabled);
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIExpansionPanels.class, ExpansionPanels.class)) {
            JDIExpansionPanels annotation = field.getAnnotation(JDIExpansionPanels.class);
            initializeLocators(annotation);
        }
        this.setCore(ExpansionPanels.class, $(ROOT_LOCATOR));
        this.setName(String.format("Expansion panels container %s", field.getName()));
    }

    private void initializeLocators(JDIExpansionPanels annotation) {
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.panels().isEmpty()) {
            PANELS_LOCATOR = annotation.panels();
        }
        if (!annotation.header().isEmpty()) {
            HEADER_LOCATOR = annotation.header();
        }
        if (!annotation.icon().isEmpty()) {
            ICON_LOCATOR = annotation.icon();
        }
        if (!annotation.content().isEmpty()) {
            CONTENT_LOCATOR = annotation.content();
        }
        if (!annotation.wrapper().isEmpty()) {
            WRAPPER_LOCATOR = annotation.wrapper();
        }
    }

    private ExpansionPanel createPanel(UIElement panelCore) {
        ExpansionPanel panel =  new ExpansionPanel().setCore(ExpansionPanel.class, panelCore);
        panel.HEADER_LOCATOR = HEADER_LOCATOR;
        panel.ICON_LOCATOR = ICON_LOCATOR;
        panel.CONTENT_LOCATOR = CONTENT_LOCATOR;
        panel.WRAPPER_LOCATOR = WRAPPER_LOCATOR;
        return panel;
    }
}

