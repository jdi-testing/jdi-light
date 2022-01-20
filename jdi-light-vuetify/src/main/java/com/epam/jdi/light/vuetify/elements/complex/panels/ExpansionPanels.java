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
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Expansion Panels web element please visit
 * https://vuetifyjs.com/en/components/expansion-panels/
 */
public class ExpansionPanels extends UIListBase<UISelectAssert<UISelectAssert<?, ?>, WebList>> implements ISetup {

    private String rootLocator = ".v-expansion-panels";
    private String panelsLocator = ".v-expansion-panel";

    private String headerLocator = ".v-expansion-panel-header";
    private String iconLocator = ".v-expansion-panel-header__icon .v-icon";
    private String contentLocator = ".v-expansion-panel-content";

    @Override
    public WebList list() {
        return finds(panelsLocator).setName(getName() + " expansion panels");
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
            setup(annotation.root(), annotation.panels(), annotation.header(), annotation.icon(), annotation.content());
        }
        this.setName(String.format("Expansion panels container %s", field.getName()));
    }

    public void setup(String root, String panels, String header, String icon, String content) {
        if (!root.isEmpty()) {
            rootLocator = root;
        }
        if (!panels.isEmpty()) {
            panelsLocator = panels;
        }
        if (!header.isEmpty()) {
            headerLocator = header;
        }
        if (!icon.isEmpty()) {
            iconLocator = icon;
        }
        if (!content.isEmpty()) {
            contentLocator = content;
        }
        this.setCore(ExpansionPanels.class, $(rootLocator));
    }

    private ExpansionPanel createPanel(UIElement panelCore) {
        ExpansionPanel panel = new ExpansionPanel().setCore(ExpansionPanel.class, panelCore);
        panel.setHeaderLocator(headerLocator);
        panel.setIconLocator(iconLocator);
        panel.setContentLocator(contentLocator);
        panel.setName(String.format("Expansion panel %s", panel.header().text()));
        return panel;
    }
}

