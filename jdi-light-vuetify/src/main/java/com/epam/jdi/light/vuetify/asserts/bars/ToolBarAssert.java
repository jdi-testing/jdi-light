package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolBarAssert extends BasicBarAssert<ToolBar, ToolBarAssert> {

    @JDIAction("Assert that {name} has background image")
    public ToolBarAssert backgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'export' button")
    public ToolBarAssert exportButton() {
        jdiAssert(element().hasExportButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'GPS' button")
    public ToolBarAssert gpsButton() {
        jdiAssert(element().hasGpsButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'delete' button")
    public ToolBarAssert deleteButton() {
        jdiAssert(element().hasDeleteButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'close' button")
    public ToolBarAssert closeButton() {
        jdiAssert(element().hasCloseButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'apps' button")
    public ToolBarAssert appsButton() {
        jdiAssert(element().hasAppsButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'map' image")
    public ToolBarAssert mapImage() {
        jdiAssert(element().hasMapImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has 'select options' field")
    public ToolBarAssert selectOptionsField() {
        jdiAssert(element().hasSelectOptionsField(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has input field")
    public ToolBarAssert input() {
        jdiAssert(element().hasInput(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} header is collapsed")
    public ToolBarAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} header is dense")
    public ToolBarAssert dense() {
        jdiAssert(element().isDense(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} header is extended")
    public ToolBarAssert extended() {
        jdiAssert(element().isExtended(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} header has proper height")
    public ToolBarAssert height(String height) {
        jdiAssert(element().getHeaderHeight(height), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} input field is focused")
    public ToolBarAssert inputFocused() {
        jdiAssert(element().isInputFocused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} input field is not focused")
    public ToolBarAssert inputNotFocused() {
        jdiAssert(element().isInputFocused(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} header has proper color")
    public ToolBarAssert headerColor(String color) {
        jdiAssert(element().getHeaderColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that {name} has proper options selected")
    public ToolBarAssert selectedOptions(String options) {
        jdiAssert(element().getSelectedOptions(), Matchers.is(options));
        return this;
    }
}
