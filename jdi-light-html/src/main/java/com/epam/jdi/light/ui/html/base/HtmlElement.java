package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.asserts.HtmlAssertion;
import com.epam.jdi.light.ui.html.common.*;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

public class HtmlElement extends UIElement implements Text, Button, FileInput, Icon, Image, Link,
        TextField, Title, Checkbox, ColorPicker, Range, ProgressBar, DateTimeSelector, NumberSelector {

    public HtmlElement() { }
    public HtmlElement(WebElement el) { super(el); }

    @JDIAction
    public String alt() { return getAttribute("alt"); }
    @JDIAction
    public String src() { return getAttribute("src"); }
    @JDIAction
    public String height() { return getAttribute("height"); }
    @JDIAction
    public String width() { return getAttribute("width"); }
    @JDIAction
    public String ref() { return getAttribute("href"); }
    @JDIAction
    public URL url() {
        try { return new URL(ref());
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }
    }

    @JDIAction
    public String placeholder() { return getAttribute("placeholder"); }

    @JDIAction
    public void setLines(String... lines) {
        setText(print(asList(lines), "\\n"));
    }
    @JDIAction
    public List<String> getLines() {
        return asList(getText().split("\\n"));
    }
    @JDIAction
    public int rows() { return getInt("rows"); }
    @JDIAction
    public int cols() { return getInt("cols"); }
    @JDIAction
    public int minlength() { return getInt("minlength"); }
    @JDIAction
    public int maxlength() { return getInt("maxlength"); }
    @JDIAction
    public String value() { return getAttribute("value"); }
    @JDIAction
    public String min() { return getAttribute("min"); }
    @JDIAction
    public String max() { return getAttribute("max"); }
    @JDIAction
    public String step() { return getAttribute("step"); }

    private int getInt(String attr) {
        String value = getAttribute(attr);
        try {
            return Integer.parseInt(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Integer", attr, value); }
    }

    @JDIAction
    public void check() {
        if (!isSelected())
            click();
    }
    @JDIAction
    public void uncheck() {
        if (isSelected())
            click();
    }

    @JDIAction
    public String color() { return getAttribute("value"); }
    @JDIAction
    public void setColor(String color) { setAttribute("value", color); }
    @JDIAction
    public void setDateTime(String dateTime) { setAttribute("value", dateTime); }
    @JDIAction
    public void uploadFile(String path) { sendKeys(path); }
    @JDIAction
    public void setVolume(String volume) {
        setAttribute("value", volume);
    }
    @JDIAction
    public void setNumber(String number) {
        setAttribute("value", number);
    }
    @JDIAction
    public Title label() {
        return $("[for="+getAttribute("id")+"]");
    }
    @JDIAction
    public String labelText() {
        return label().getText();
    }

    @Override
    public HtmlAssertion is() { return new HtmlAssertion(this); }
    @Override
    public HtmlAssertion assertThat() { return is(); }
}
