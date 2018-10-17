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

  /**
   * Creating a URL
   * @return URL with value from getRef()
   */
  public URL getUrl() {
        try { return new URL(getRef());
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }
    }

  /**
   * Gets attribute 'placeholder'
   * @return String placeholder value
   */
    public String placeholder() { return getAttribute("placeholder"); }
    public void setLines(String... lines) {
        setText(PrintUtils.print(asList(lines), "/n"));
    }

  /**
   * Gets lines of text in line
   * @return List<String> divided by rows
   */
  public List<String> getLines() {
        return asList(getText().split("/n"));
    }

  /**
   * Gets attribute rows in int
   * @return int number of rows
   */
  public int rows() {
    return getInt("rows");
  }

  /**
   * Gets attribute cols in int
   * @return int number of cols
   */
  public int cols() {
    return getInt("cols");
  }

  /**
   * Gets attribute minlength in int
   * @return int value of minlength
   */
  public int minlength() {
    return getInt("minlength");
  }

  /**
   * Gets attribute maxlength in int
   * @return int value of maxlength
   */
  public int maxlength() {
    return getInt("maxlength");
  }

  /**
   * Gets attribute with name value
   * @return String
   */
  public String value() {
    return getAttribute("value");
  }

  /**
   * Gets attribute with name min
   * @return String min value
   */
  public String min() {
    return getAttribute("min");
  }

  /**
   * Gets attribute with name max
   * @return String max value
   */
  public String max() {
    return getAttribute("max");
  }

  /**
   * Gets attribute with name step
   * @return String step value
   */
  public String step() {
    return getAttribute("step");
  }

  /**
   * Gets attribute and casts it to int
   * @param attr String - attribute to find
   * @return int attribute value
   */
    private int getInt(String attr) {
        String value = getAttribute(attr);
        try {
            return Integer.parseInt(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Integer", attr, value); }
    }

  /**
   * If not selected - click to select
   */
    public void check() {
        if (!isSelected())
            click();
    }

  /**
   * If selected - click to deselect
   */
    public void uncheck() {
        if (isSelected())
            click();
    }

  /**
   * Gets attribute 'value' from color picker
   * @return String color value
   */
    public String color() { return getAttribute("value"); }

  /**
   * Sets color value
   * @param color value to set
   */
  public void setColor(String color) { setAttribute("value", color); }

  /**
   * Sets value for DateTimeSelector
   * @param dateTime value to set
   */
    public void setDateTime(String dateTime) { setAttribute("value", dateTime); }

  /**
   * Sets value for FileInput
   * @param path String value to set
   */
  public void uploadFile(String path) {
    setAttribute("value", path);
  }

  /**
   * Sets value for range element
   * @param volume String value to set
   */
  public void setVolume(String volume) {
    setAttribute("value", volume);
  }

  /**
   * Sets value for NumberSelector
   * @param number String value to set
   */
  public void setNumber(String number) {
    setAttribute("value", number);
  }

  public Title label() {
    return (Title) $("[for=" + this.getAttribute("ïd") + "]");
  }

  /**
   * Gets label text
   * @return String text
   */
  public String labelText() {
    return label().getText();
  }

  @Override
  public HtmlAssertion is() {
    return new HtmlAssertion(this);
  }

  @Override
  public HtmlAssertion assertThat() {
    return is();
  }
}
