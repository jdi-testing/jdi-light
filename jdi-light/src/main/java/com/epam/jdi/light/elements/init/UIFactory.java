package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getPage;

/**
 * Created by Roman Iovlev on 03.28.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class UIFactory {
    @Deprecated
    public static UIElement element(@MarkupLocator String locator) {
        return JDITalk.element(locator);
    }
    @Deprecated
    public static UIElement element(@MarkupLocator By byLocator) {
        return JDITalk.element(byLocator);
    }
    public static UIElement $(@MarkupLocator String locator) {
        return JDITalk.element(locator);
    }
    public static UIElement $(@MarkupLocator String locator, Object parent) {
        return JDITalk.element(locator).setup(j->j.setParent(parent));
    }
    public static UIElement $(@MarkupLocator By locator) {
        return JDITalk.element(locator);
    }
    public static UIElement $(WebElement webElement) {
        return new UIElement(webElement);
    }
    public static UIElement $(@MarkupLocator By locator, Object parent) {
        return JDITalk.element(locator).setup(j->j.setParent(parent));
    }
    @Deprecated
    public static WebList list(@MarkupLocator String locator) {
        return JDITalk.list(locator);
    }
    @Deprecated
    public static WebList list(@MarkupLocator By byLocator) {
        return JDITalk.list(byLocator);
    }
    @Deprecated
    public static WebList list(List<WebElement> els, String name) {
        return JDITalk.list(els, name);
    }
    public static WebList $$(@MarkupLocator String locator) {
        return JDITalk.list(locator);
    }
    public static WebList $$(@MarkupLocator String locator, Object parent) {
        return JDITalk.list(locator).setup(j->j.setParent(parent));
    }
    public static WebList $$(@MarkupLocator By locator) {
        return JDITalk.list(locator);
    }
    public static WebList $$(@MarkupLocator By locator, Object parent) {
        return JDITalk.list(locator).setup(j->j.setParent(parent));
    }
    public static WebList $$(List<WebElement> els, String name) {
        return JDITalk.list(els, name);
    }

    @Deprecated
    public static Selector selector(@MarkupLocator String locator) {
        return JDITalk.selector(locator);
    }
    @Deprecated
    public static IsDropdown dropdown(@MarkupLocator String locator) {
        return JDITalk.dropdown(locator);
    }
    @Deprecated
    public static IsDropdown dropdown(String root, String value, String list, String expand) {
        return JDITalk.dropdown(root, value, list, expand);
    }
    @Deprecated
    public static <T> Form<T> form(Class<T> entityClass) {
        return JDITalk.form(entityClass);
    }
    @Deprecated
    public static <T> Form<T> form(@MarkupLocator String locator, Class<T> entityClass) {
        return JDITalk.form(locator, entityClass);
    }
    @Deprecated
    public static <T> void submitForm(T entity) {
        JDITalk.submitForm(entity);
    }
    @Deprecated
    public static <T> void submitForm(@MarkupLocator String locator, T entity) {
        JDITalk.submitForm(locator, entity);
    }
    @Deprecated
    public static <T> void loginAs(T entity) {
        JDITalk.loginAs(entity);
    }
    @Deprecated
    public static <T> void loginAs(@MarkupLocator String locator, T entity) {
        JDITalk.loginAs(locator, entity);
    }
    @Deprecated
    public static Table table(@MarkupLocator String locator) {
        return JDITalk.table(locator);
    }
    @Deprecated
    public static <D> DataTable<?, D> dataTable(@MarkupLocator String locator) {
        return JDITalk.dataTable(locator);
    }
    @Deprecated
    public static WebPage page(String pageName) {
        return JDITalk.page(pageName);
    }
}
