package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolBarAssert extends BasicBarAssert<ToolBar, ToolBarAssert> {

    @JDIAction("Assert that '{name}' has background image")
    public ToolBarAssert backgroundImage() {
        Timer.waitCondition(element()::hasBackgroundImage);
        jdiAssert(element().hasBackgroundImage() ? "has background image" : "does not have background image",
                Matchers.is("has background image"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'export' button")
    public ToolBarAssert exportButton() {
        jdiAssert(element().hasExportButton() ? "'export' button is displayed" : "'export' button is not displayed",
                Matchers.is("'export' button is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'GPS' button")
    public ToolBarAssert gpsButton() {
        jdiAssert(element().hasGpsButton() ? "'GPS' button is displayed" : "'GPS' button is not displayed",
                Matchers.is("'GPS' button is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'search' icon")
    public ToolBarAssert searchIcon() {
        jdiAssert(element().hasSearchIcon() ? "'search' icon is displayed" : "'search' icon is not displayed",
                Matchers.is("'search' icon is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'delete' button")
    public ToolBarAssert deleteButton() {
        jdiAssert(element().hasDeleteButton() ? "'delete' button is displayed" : "'delete' button is not displayed",
                Matchers.is("'delete' button is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'close' button")
    public ToolBarAssert closeButton() {
        jdiAssert(element().hasCloseButton() ? "'close' button is displayed" : "'close' button is not displayed",
                Matchers.is("'close' button is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}'s 'close' and 'delete' buttons are hidden")
    public ToolBarAssert hiddenButtons() {
        jdiAssert(element().hasHiddenButtons() ?
                        "'close' and 'delete' buttons are hidden" : "'close' and 'delete' buttons are visible",
                Matchers.is("'close' and 'delete' buttons are hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'apps' button")
    public ToolBarAssert appsButton() {
        jdiAssert(element().hasAppsButton() ? "'apps' button is displayed" : "'apps' button is not displayed",
                Matchers.is("'apps' button is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'map' image")
    public ToolBarAssert mapImage() {
        Timer.waitCondition(element()::hasMapImage);
        jdiAssert(element().hasMapImage() ? "has 'map' image" : "does not have 'map' image",
                Matchers.is("has 'map' image"));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'select options' field")
    public ToolBarAssert selectOptionsField() {
        jdiAssert(element().hasSelectOptionsField() ?
                        "has 'select options' field" : "does not have 'select options' field",
                Matchers.is("has 'select options' field"));
        return this;
    }

    @JDIAction("Assert that '{name}' has input field")
    public ToolBarAssert inputField() {
        jdiAssert(element().hasInput() ? "input field is visible" : "input field is not visible",
                Matchers.is("input field is visible"));
        return this;
    }

    @JDIAction("Assert that '{name}'s header is collapsed")
    public ToolBarAssert collapsedHeader() {
        jdiAssert(element().headerIsCollapsed() ? "header is collapsed" : "header is not collapsed",
                Matchers.is("header is collapsed"));
        return this;
    }

    @JDIAction("Assert that '{name}'s header is dense")
    public ToolBarAssert denseHeader() {
        jdiAssert(element().headerIsDense() ? "header is dense" : "header is not dense",
                Matchers.is("header is dense"));
        return this;
    }

    @JDIAction("Assert that '{name}'s header is extended")
    public ToolBarAssert extendedHeader() {
        jdiAssert(element().headerIsExtended() ? "header is extended" : "header is not extended",
                Matchers.is("header is extended"));
        return this;
    }

    @JDIAction("Assert that '{name}'s header has expected height")
    public ToolBarAssert heightOfHeader(String height) {
        jdiAssert(element().hasHeaderHeight(height), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s input field is focused")
    public ToolBarAssert focusedInputField() {
        jdiAssert(element().inputFieldIsFocused() ? "input field is focused" : "input field is not focused",
                Matchers.is("input field is focused"));
        return this;
    }

    @JDIAction("Assert that '{name}'s input field is not focused")
    public ToolBarAssert notFocusedInputField() {
        jdiAssert(!element().inputFieldIsFocused() ? "input field is not focused" : "input field is focused",
                Matchers.is("input field is not focused"));
        return this;
    }

    @JDIAction("Assert that '{name}'s header has expected color")
    public ToolBarAssert headerColor(String color) {
        Timer.waitCondition(() -> element().hasHeaderColor().equals(color));
        jdiAssert(element().hasHeaderColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected options selected")
    public ToolBarAssert selectedOptions(String options) {
        jdiAssert(element().hasSelectedOptions(), Matchers.is(options));
        return this;
    }
}
