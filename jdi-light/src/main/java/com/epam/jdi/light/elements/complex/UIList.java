package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.ISetValue;
import com.epam.jdi.tools.CacheValue;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.getByLocator;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;

public class UIList extends JDIBase implements List<WebElement>, ISetValue {
    private CacheValue<List<WebElement>> webElements = new CacheValue<>();
    public void select(String name) {
        if (getByLocator(getLocator()).contains("%s"))
            get(name).click();
        for(WebElement el : getAll())
            if (el.getText().equals(name)) {
                el.click();
                return;
            }
        throw exception("Can't select '%s'. No elements with this name found");
    }
    public void select(Enum name) {
        select(getEnumValue(name));
    }
    public void get(Enum name) {
        get(getEnumValue(name));
    }
    public void select(int index) {
        get(index).click();
    }
    public List<String> values() {
        return map(getAll(), WebElement::getText);
    }
    public void refresh() {
        webElements.get().clear();
    }

    public int size() {
        return getAll().size();
    }

    @Override
    public boolean isEmpty() {
        return getAll().size() == 0;
    }

    public boolean contains(Object o) {
        return getAll().contains(o);
    }

    public Iterator<WebElement> iterator() {
        return getAll().iterator();
    }

    public Object[] toArray() {
        return getAll().toArray();
    }

    public <T> T[] toArray(T[] a) {
        return getAll().toArray(a);
    }

    public boolean add(WebElement element) {
        throw exception("List<WebElement> readonly");
    }

    public boolean remove(Object o) {
        throw exception("List<WebElement> readonly");
    }

    public boolean containsAll(Collection<?> c) {
        return getAll().containsAll(c);
    }

    public boolean addAll(Collection<? extends WebElement> c) {
        throw exception("List<WebElement> readonly");
    }

    public boolean addAll(int index, Collection<? extends WebElement> c) {
        throw exception("List<WebElement> readonly");
    }

    public boolean removeAll(Collection<?> c) {
        throw exception("List<WebElement> readonly");
    }

    public boolean retainAll(Collection<?> c) {
        throw exception("List<WebElement> readonly");
    }

    public void clear() {
        webElements.get().clear();
    }

    public WebElement get(int index) {
        if (!webElements.hasValue())
            webElements.set(getAll());
        return webElements.get().get(index);
    }

    public WebElement set(int index, WebElement element) {
        throw exception("List<WebElement> readonly");
    }

    public void add(int index, WebElement element) {
        throw exception("List<WebElement> readonly");
    }

    public WebElement remove(int index) {
        throw exception("List<WebElement> readonly");
    }

    public int indexOf(Object o) {
        throw exception("List<WebElement> readonly");
    }

    public int lastIndexOf(Object o) {
        throw exception("List<WebElement> readonly");
    }

    public ListIterator<WebElement> listIterator() {
        return getAll().listIterator();
    }

    public ListIterator<WebElement> listIterator(int index) {
        return getAll().listIterator(index);
    }

    public List<WebElement> subList(int fromIndex, int toIndex) {
        return getAll().subList(fromIndex, toIndex);
    }

    public void setValue(String value) {
        select(value);
    }

    public String getValue() {
        return null;
    }
    public boolean isDisplayed() {
        return getWebElements().get(0).isDisplayed();
    }
}