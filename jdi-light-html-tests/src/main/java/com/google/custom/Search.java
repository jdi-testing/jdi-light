package com.google.custom;

import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.base.HtmlList;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Search extends HtmlElement implements ISetup {
    HtmlList list;

    public void typeAndSelect(String type, String select) {
        input(type);
        list.select(select);
        //sendKeys(Keys.RETURN);
    }

    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JSearch.class, Search.class))
            return;
        JSearch j = field.getAnnotation(JSearch.class);
        By input = isNotBlank(j.input())
            ? By.cssSelector(j.input()) : null;
        By listLocator = isNotBlank(j.list())
            ? By.cssSelector(j.list()) : null;
        if (input != null)
            setLocator(input);
        if (listLocator != null) {
            list = new HtmlList();
            list.name = getName() + " list element";
            list.setLocator(listLocator);
            list.parent = parent;
            list.driverName = driverName;
        }
    }
}
