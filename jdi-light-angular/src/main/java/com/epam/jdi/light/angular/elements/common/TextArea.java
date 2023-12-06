package com.epam.jdi.light.angular.elements.common;

import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

import com.epam.jdi.light.angular.asserts.TextAreaAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.Keys;

public class TextArea extends UIBaseElement<TextAreaAssert> implements SetValue, IsInput {

    @JDIAction
    public int rows() {
        return getInt(core().attr("rows"));
    }

    @JDIAction
    public int minRows() {
        return getInt(core().attr("cdkautosizeminrows"));
    }

    @JDIAction
    public int maxRows() {
        return getInt(core().attr("cdkautosizemaxrows"));
    }

    @JDIAction("Check that '{name}' has auto-size attribute")
    public boolean hasAutoSize() {
        return attrs().has("cdktextareaautosize");
    }

    @JDIAction("Press button '{0}' in '{name}'")
    public TextArea pressButton(Keys key) {
        core().sendKeys(key);
        return this;
    }

    @Override
    public String getValue() {
        return core().getAttribute("value");
    }

    @Override
    public void setValue(String value) {
        input(value);
    }

    @JDIAction("Set '{name}' height to '{0}'")
    public void changeHeight(int px) {
        setAttribute("style", "height: " + px + "px");
    }

    @JDIAction("Check that '{name}' has scroll down")
    public boolean hasScrollDown() {
        return (boolean) core().js()
                .executeScript("return arguments[0].scrollHeight - arguments[0].scrollTop > arguments[0].clientHeight;",
                        core().getWebElement());
    }

    @JDIAction("Check that '{name}' has scroll up")
    public boolean hasScrollUp() {
        return (boolean) core().js()
                .executeScript("return arguments[0].scrollTop > 0;",
                        core().getWebElement());
    }

    @JDIAction("Scroll '{name}' to the top")
    public void scrollToTop() {
        core().js().executeScript("arguments[0].scrollTop = 0;", core().getWebElement());
    }

    @JDIAction("Scroll '{name}' to the bottom")
    public void scrollToBottom() {
        core().js().executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", core().getWebElement());
    }

    @JDIAction("Scroll '{name}' to '{0}' text")
    public void scrollToText(String text) {
        core().js().executeScript("var textarea = arguments[0]; " +
                "var searchText = arguments[1]; " +
                "var textPosition = textarea.value.indexOf(searchText); " +
                "if (textPosition !== -1) { " +
                "var lineHeight = parseFloat(window.getComputedStyle(textarea).lineHeight); " +
                "var linesBefore = textarea.value.substr(0, textPosition).split('\\n').length - 1; " +
                "var scrollToHeight = linesBefore * lineHeight; textarea.scrollTop = scrollToHeight; }",
                core().getWebElement(), text);
    }

    @Override
    public TextAreaAssert is() {
        return new TextAreaAssert().set(this);
    }
}
