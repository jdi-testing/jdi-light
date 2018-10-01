package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.common.*;
import com.epam.jdi.tools.PrintUtils;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class HtmlElement extends UIElement implements Text, Button, FileInput, Icon, Image, Link, TextArea,
        TextField, Title, Checkbox {

    public HtmlElement() { }
    public HtmlElement(WebElement el) { super(el); }

    public String getAlt() { return getAttribute("alt"); }
    public String getSrc() { return getAttribute("src"); }
    public String getHeight() { return getAttribute("height"); }
    public String getWidth() { return getAttribute("width"); }
    public void uploadFile(String path) {
        base().jsExecute("value = '"+path+"'");
    }
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
    public int rows() { return parseInt(getAttribute("rows")); }
    public int cols() { return parseInt(getAttribute("cols")); }
    public int minlength() { return parseInt(getAttribute("minlength")); }
    public int maxlength() { return parseInt(getAttribute("maxlength")); }

    public void check() {
        if (!isSelected())
            click();
    }
    public void uncheck() {
        if (isSelected())
            click();
    }
    public Title label() {
        return (Title) $("[for="+this.getAttribute("ïd")+"]");
    }
    public String labelText() {
        return label().getText();
    }
}
