package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.vuetify.annotations.JDIExpansionPanels;
import com.epam.jdi.light.vuetify.asserts.ExpansionPanelAssert;

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

    @UI(".v-expansion-panel")
    private WebList panels;

    @Override
    public WebList list() {
        return $$(PANELS_LOCATOR, this).setName(getName() + " expansion panels");
    }

    @JDIAction("Get Panels from '{name}'")
    public List<ExpansionPanel> panels() {
        return list().map(panel -> new ExpansionPanel().setCore(ExpansionPanel.class, panel));
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

    public static class ExpansionPanel extends UIBaseElement<ExpansionPanelAssert> {

        protected final static String ICON_LOCATOR = ".v-expansion-panel-header__icon .v-icon";
        protected final static String HEADER_LOCATOR = ".v-expansion-panel-header";
        protected final static String WRAPPER_LOCATOR = ".v-expansion-panel-content__wrap";

        protected final static String OPEN_PANEL_CLASS = "v-expansion-panel--active";
        protected final static String DISABLED_PANEL_CLASS = "v-expansion-panel--disabled";

        @JDIAction("Get icon from '{name}'")
        public Icon getIcon() {
            return new Icon().setCore(Icon.class, core().find(ICON_LOCATOR));
        }

        @JDIAction("Get header from '{name}'")
        public Button getHeader() {
            return new Button().setCore(Button.class, core().find(HEADER_LOCATOR));
        }

        @JDIAction("Get wrapper from '{name}'")
        public UIElement getWrapper() {
            if (isClosed()) {
                getIcon().click();
            }
            return core().find(WRAPPER_LOCATOR);
        }

        @JDIAction("Open '{name}'")
        public void open() {
            if (isClosed()) {
                getIcon().click();
            }
        }

        @JDIAction("Close '{name}'")
        public void close() {
            if (isOpen()) {
                getIcon().click();
            }
        }

        @Override
        @JDIAction("Check that '{name}' is enabled")
        public boolean isEnabled() {
            return !core().hasClass(DISABLED_PANEL_CLASS);
        }

        @Override
        @JDIAction("Check that '{name}' is disabled")
        public boolean isDisabled() {
            return !isEnabled();
        }

        @JDIAction("Check that '{name}' is open")
        public boolean isOpen() {
            return core().hasClass(OPEN_PANEL_CLASS);
        }

        @JDIAction("Check that '{name}' is closed")
        public boolean isClosed() {
            return !isOpen();
        }

        @Override
        public ExpansionPanelAssert is() {
            return new ExpansionPanelAssert().set(this);
        }
    }

}

