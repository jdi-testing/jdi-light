package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.complex.Menu;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;

public class HtmlList extends WebList implements Menu {

    @Override @JDIAction
    public UIElement get(String name) {
        if (getLocator().toString().contains("%s"))
            return getUI(name);
        List<WebElement> elements = getAll();
        if (elements.size() == 1) {
            String tagName = elements.get(0).getTagName();
            WebElement element = elements.get(0);
            switch (tagName) {
                case "ul" : elements = element.findElements(By.tagName("li")); break;
                case "select" : elements = element.findElements(By.tagName("option")); break;
            }
        }
        List<UIElement> uiElements = LinqUtils.map(elements,
            el -> new UIElement().setWebElement(el));
        UIElement el = LinqUtils.first(uiElements, e -> e.getText().equals(name));
        if (el == null) {
            el = LinqUtils.first(uiElements, e -> verifyLabel(e, name));
            if (el == null)
                throw exception("Can't select '%s'. No elements with this name found");
        }
        return el;
    }
    private boolean verifyLabel(WebElement element, String name) {
        List<WebElement> els =  element.findElements(By.xpath("//../label"));
        return els.size() == 1 && els.get(0).getText().equals(name);
    }

    public String getSelected() {
        List<String> selected = getSelectedOptions();
        if (selected.size() == 1)
            return selected.get(0);
        throw exception("Get selected");
    }

    public List<String> getSelectedOptions() {
        return LinqUtils.ifSelect(allUI(), UIElement::isSelected, UIElement::getText);
    }
    // TODO locators for ul > li and select > option

}
