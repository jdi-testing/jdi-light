package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.SoftAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.ui.html.asserts.HtmlAssertion;
import com.epam.jdi.light.ui.html.common.*;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.utils.HtmlUtils.getInt;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;

/**
 * Base html element
 */
public class HtmlElement extends BaseUIElement<HtmlElement> implements Text, Button, FileInput, Icon, Image, Link, TextArea,
        TextField, Label, Checkbox, ColorPicker, Range, ProgressBar, DateTimeSelector, NumberSelector {

    public HtmlElement() { setInitClass(HtmlElement.class); }
    public HtmlElement(WebElement el) { super(el); setInitClass(HtmlElement.class); }

    /**
     * Gets attribute 'alt'
     * @return String alt value
     */
    public String alt() { return getAttribute("alt"); }

    /**
     * Gets attribute 'src'
     * @return String src value
     */
    public String src() { return getAttribute("src"); }

    /**
     * Gets attribute 'height'
     * @return String height value
     */
    public String height() { return getAttribute("height"); }

    /**
     * Gets attribute 'width'
     * @return String width value
     */
    public String width() { return getAttribute("width"); }

    /**
     * Gets attribute 'href'
     * @return String href value
     */
    public String ref() { return getAttribute("href"); }

    /**
     * Creating a URL
     * @return URL with value from getRef()
     */
    public URL url() {
        try { return new URL(ref());
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }
    }

    /**
     * Sets value for lines
     * @param lines String var arg
     */
    @JDIAction("Input '{0}' in '{name}'")
    public void setLines(String... lines) {
        checkEnabled();
        setText(print(asList(lines), "\\n"));
    }

    /**
     * Gets lines of text in line
     * @return List<String> divided by rows
     */
    @JDIAction("Get '{name}' lines")
    public List<String> getLines() {
        return asList(getText().split("\\n"));
    }

    /**
     * Gets attribute rows in int
     * @return int number of rows
     */
    public int rows() { return getInt("rows", this); }

    /**
     * Gets attribute cols in int
     * @return int number of cols
     */
    public int cols() { return getInt("cols", this); }

    /**
     * Gets attribute minlength in int
     * @return int value of minlength
     */
    public int minlength() { return getInt("minlength", this); }

    /**
     * Gets attribute maxlength in int
     * @return int value of maxlength
     */
    public int maxlength() { return getInt("maxlength", this); }

    /**
     * Adds text to the next line.
     * @param line String
     */
    public void addNewLine(String line) {
        sendKeys("\n" + line);
    }

    /**
     * Gets attribute with name min
     * @return String min value
     */
    public String min() { return getAttribute("min"); }

    /**
     * Gets attribute with name max
     * @return String max value
     */
    public String max() { return getAttribute("max"); }

    /**
     * Gets attribute with name step
     * @return String step value
     */
    public String step() { return getAttribute("step"); }

  /**
   * Gets attribute 'value' from color picker
   * @return String color value
   */
    public String color() { return getAttribute("value"); }

    /**
     * Gets attribute value by range and casts it to int
     * @return int attribute value by range
     */
    @JDIAction(value = "Get '{name}' volume", level = DEBUG)
    public int volume() {
        return getInt("value", this);
    }

    /**
     * Sets color value
     * @param color value to set
     */
    @JDIAction("Set color '{0}' for '{name}'")
    public void setColor(String color) {
        checkEnabled();
        setAttribute("value", color);
    }

    /**
     * Sets value for DateTimeSelector
     * @param dateTime value to set
     */
    @JDIAction("Set date '{0}' for '{name}'")
    public void setDateTime(String dateTime) {
        checkEnabled();
        setValue(dateTime);
    }

    /**
     * Sets value for FileInput
     * @param path String value to set
     */
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        checkEnabled();
        sendKeys(path);
    }

    /**
     * Sets value for range element
     * @param volume String value to set
     */
    @JDIAction(value = "Set volume '{0}' for '{name}'", level = DEBUG)
    public void setVolume(int volume) {
        checkEnabled();
        setValue(volume+"");
    }

    /**
     * Sets value for NumberSelector
     * @param number String value to set
     */
    @JDIAction("Select number '{0}' for '{name}'")
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
    public HtmlAssertion has() {
        return is();
    }
    @Override
    public HtmlAssertion waitFor() {
        return is();
    }
    @Override
    public HtmlAssertion shouldBe() {
        return is();
    }
    @Override
    public HtmlAssertion verify() {
        assertSoft();
        return is();
    }

    /**
     * Create new HtmlElement by WebElement
     * @param el WebElement
     * @return HtmlElement
     */
    @Override
    public HtmlElement newElement(WebElement el) {
        return new HtmlElement(el);
    }
}
