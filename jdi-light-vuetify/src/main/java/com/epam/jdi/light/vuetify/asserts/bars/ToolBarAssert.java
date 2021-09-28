package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolBarAssert extends BasicBarAssert<ToolBar, ToolBarAssert> {

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert backgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert exportButton() {
        jdiAssert(element().hasExportButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert gpsButton() {
        jdiAssert(element().hasGpsButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert deleteButton() {
        jdiAssert(element().hasDeleteButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert closeButton() {
        jdiAssert(element().hasCloseButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert appsButton() {
        jdiAssert(element().hasAppsButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert mapImage() {
        jdiAssert(element().hasMapImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert selectOptionsField() {
        jdiAssert(element().hasSelectOptionsField(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert input() {
        jdiAssert(element().hasInput(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert dense() {
        jdiAssert(element().isDense(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert extended() {
        jdiAssert(element().isExtended(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert height(String height) {
        jdiAssert(element().getHeight(height), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert inputFocused() {
        jdiAssert(element().isInputFocused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert inputNotFocused() {
        jdiAssert(element().isInputFocused(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert headerColor(String color) {
        jdiAssert(element().getHeaderColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert selectedOptions(String options) {
        jdiAssert(element().getSelectedOptions(), Matchers.is(options));
        return this;
    }


}
