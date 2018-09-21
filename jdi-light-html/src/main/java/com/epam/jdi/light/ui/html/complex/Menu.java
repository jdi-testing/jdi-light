package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface Menu extends IList<WebElement> {
    void select(String name);
    String getSelected();
    default List<String> allOptions() { return LinqUtils.map(elements(), WebElement::getText); }
}
