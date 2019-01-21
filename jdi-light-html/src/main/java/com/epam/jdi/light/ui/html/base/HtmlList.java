package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.ui.html.complex.Menu;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HtmlList extends JList<HtmlElement> implements IList<HtmlElement>, Menu {
    public HtmlList() { setInitClass(HtmlElement.class); }
    public HtmlList(List<WebElement> elements) {
        this.webElements.setForce(elements);
    }
}
