package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.ui.html.base.HasLabel;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface Menu extends IList<WebElement> {
    void select(String value);
    <TEnum extends Enum> void select(TEnum value);
    String selected();
    List<String> values();
}
