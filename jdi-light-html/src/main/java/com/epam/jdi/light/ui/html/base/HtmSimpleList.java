package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.complex.Menu;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HtmSimpleList extends WebList<HtmlElement> implements IList<HtmlElement>, Menu {
    public HtmSimpleList() {}
    public HtmSimpleList(List<WebElement> elements) {
        this.webElements.setForce(elements);
    }
    //endregion
}
