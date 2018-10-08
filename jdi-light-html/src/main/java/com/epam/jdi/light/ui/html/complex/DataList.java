package com.epam.jdi.light.ui.html.complex;

// Implements TextField + Dropdown
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public interface DataList extends Dropdown {
    void sendKeys(CharSequence... value);
    void setText(String value);
    void clear();
    void input(String value);
    void focus();
    String placeholder();

}
