package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.asserts.HtmlAssertion;
import com.epam.jdi.light.ui.html.common.*;
import com.epam.jdi.tools.PrintUtils;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static java.util.Arrays.asList;

/**
 * Base html element
 */
public class HtmlElement extends UIElement implements Text, Button, FileInput, Icon, Image, Link, TextArea,
        TextField, Title, Checkbox, ColorPicker, Range, ProgressBar, DateTimeSelector, NumberSelector {

    public HtmlElement() { }
    public HtmlElement(WebElement el) { super(el); }

    /**
     * Gets attribute 'alt'
     * @return String alt value
     */
    public String getAlt() { return getAttribute("alt"); }

    /**
     * Gets attribute 'src'
     * @return String src value
     */
    public String getSrc() { return getAttribute("src"); }

    /**
     * Gets attribute 'height'
     * @return String height value
     */
    public String getHeight() { return getAttribute("height"); }

    /**
     * Gets attribute 'width'
     * @return String width value
     */
    public String getWidth() { return getAttribute("width"); }

    /**
     * Gets attribute 'href'
     * @return String href value
     */
    public String getRef() { return getAttribute("href"); }
    public URL getUrl() {
        try { return new URL(getRef());
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }
    }
    public String placeholder() { return getAttribute("placeholder"); }
    public void setLines(String... lines) {
        setText(PrintUtils.print(asList(lines), "/n"));
    }
    public List<String> getLines() {
        return asList(getText().split("/n"));
    }
    public int rows() { return getInt("rows"); }
    public int cols() { return getInt("cols"); }
    public int minlength() { return getInt("minlength"); }
    public int maxlength() { return getInt("maxlength"); }
    public String value() { return getAttribute("value"); }
    public String min() { return getAttribute("min"); }
    public String max() { return getAttribute("max"); }
    public String step() { return getAttribute("step"); }


    private int getInt(String attr) {
        String value = getAttribute(attr);
        try {
            return Integer.parseInt(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Integer", attr, value); }
    }

    public void check() {
        if (!isSelected())
            click();
    }
    public void uncheck() {
        if (isSelected())
            click();
    }

    public String color() { return getAttribute("value"); }
    public void setColor(String color) { setAttribute("value", color); }
    public void setDateTime(String dateTime) { setAttribute("value", dateTime); }
    public void uploadFile(String path) { setAttribute("value", path); }
    public void setVolume(String volume) {
        setAttribute("value", volume);
    }
    public void setNumber(String number) {
        setAttribute("value", number);
    }
    public Title label() {
        return (Title) $("[for="+this.getAttribute("ïd")+"]");
    }
    public String labelText() {
        return label().getText();
    }

    @Override
    public HtmlAssertion is() { return new HtmlAssertion(this); }
    @Override
    public HtmlAssertion assertThat() { return is(); }
}
