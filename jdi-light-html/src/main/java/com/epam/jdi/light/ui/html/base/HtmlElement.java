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
import static com.epam.jdi.light.ui.html.utils.HtmlUtils.getInt;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

/**
 * Base html element
 */
public class HtmlElement extends UIElement<HtmlElement> implements Text, Button, FileInput, Icon, Image, Link, TextArea,
        TextField, Title, Checkbox, ColorPicker, Range, ProgressBar, DateTimeSelector, NumberSelector {

    public HtmlElement() { }
    public HtmlElement(WebElement el) { super(el); }

    /**
     * Gets attribute 'alt'
     * @return String alt value
     */
    @JDIAction
    public String alt() { return getAttribute("alt"); }

    /**
     * Gets attribute 'src'
     * @return String src value
     */
    @JDIAction
    public String src() { return getAttribute("src"); }

    /**
     * Gets attribute 'height'
     * @return String height value
     */
    @JDIAction
    public String height() { return getAttribute("height"); }

    /**
     * Gets attribute 'width'
     * @return String width value
     */
    @JDIAction
    public String width() { return getAttribute("width"); }

    /**
     * Gets attribute 'href'
     * @return String href value
     */
    @JDIAction
    public String ref() { return getAttribute("href"); }

    /**
     * Creating a URL
     * @return URL with value from getRef()
     */
    @JDIAction
    public URL url() {
        try { return new URL(ref());
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }
    }

    /**
     * Sets value for lines
     * @param lines String var arg
     */
    @JDIAction
    public void setLines(String... lines) {
        checkEnabled();
        setText(print(asList(lines), "\\n"));
    }

    /**
     * Gets lines of text in line
     * @return List<String> divided by rows
     */
    @JDIAction
    public List<String> getLines() {
        return asList(getText().split("\\n"));
    }

    /**
     * Gets attribute rows in int
     * @return int number of rows
     */
    @JDIAction
    public int rows() { return getInt("rows", this); }

    /**
     * Gets attribute cols in int
     * @return int number of cols
     */
    @JDIAction
    public int cols() { return getInt("cols", this); }

    /**
     * Gets attribute minlength in int
     * @return int value of minlength
     */
    @JDIAction
    public int minlength() { return getInt("minlength", this); }

    /**
     * Gets attribute maxlength in int
     * @return int value of maxlength
     */
    @JDIAction
    public int maxlength() { return getInt("maxlength", this); }

    /**
     * Gets attribute with name min
     * @return String min value
     */
    @JDIAction
    public String min() { return getAttribute("min"); }

    /**
     * Gets attribute with name max
     * @return String max value
     */
    @JDIAction
    public String max() { return getAttribute("max"); }

    /**
     * Gets attribute with name step
     * @return String step value
     */
    @JDIAction
    public String step() { return getAttribute("step"); }


  /**
   * Gets attribute 'value' from color picker
   * @return String color value
   */
    @JDIAction
    public String color() { return getAttribute("value"); }

    @JDIAction
    public int volume() { return getInt("value", this); }
    /**
     * Sets color value
     * @param color value to set
     */
    @JDIAction
    public void setColor(String color) {
        checkEnabled();
        setAttribute("value", color);
    }

    /**
     * Sets value for DateTimeSelector
     * @param dateTime value to set
     */
    @JDIAction
    public void setDateTime(String dateTime) {
        checkEnabled();
        setValue(dateTime);
    }

    /**
     * Sets value for FileInput
     * @param path String value to set
     */
    @JDIAction
    public void uploadFile(String path) {
        checkEnabled();
        sendKeys(path);
    }

    /**
     * Sets value for range element
     * @param volume String value to set
     */
    @JDIAction
    public void setVolume(int volume) {
        checkEnabled();
        setValue(volume+"");
    }

    /**
     * Sets value for NumberSelector
     * @param number String value to set
     */
    @JDIAction
    public void setNumber(String number) {
        checkEnabled();
        setValue(number);
    }

    @Override
    public HtmlAssertion is() {
        return new HtmlAssertion(this);
    }

    @Override
    public HtmlAssertion assertThat() {
      return is();
    }

    @Override
    public HtmlElement newElement(WebElement el) {
        return new HtmlElement(el);
    }
}
