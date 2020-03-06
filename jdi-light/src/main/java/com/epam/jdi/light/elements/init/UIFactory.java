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
    public static UIElement element(String locator) {
        return locator.matches("[A-Z].*]")
            ? new UIElement().setName(locator)
            : element(defineLocator(locator));
    }
    public static UIElement element(By byLocator) {
        return new UIElement(byLocator);
    }
    public static UIElement $(String locator) {
        return element(locator);
    }
    public static UIElement $(String locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }
    public static UIElement $(By locator) {
        return element(locator);
    }
    public static UIElement $(WebElement webElement) {
        return new UIElement(webElement);
    }
    public static UIElement $(By locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }

    public static WebList list(String locator) {
        return locator.matches("[A-Z].*]")
                ? new WebList().indexFromZero().setName(locator)
                : list(defineLocator(locator));
    }
    public static WebList list(By byLocator) {
        return new WebList(byLocator).indexFromZero();
    }
    public static WebList list(List<WebElement> els, String name) {
        return new WebList(els).indexFromZero().setup(e->e.setName(name));
    }
    public static WebList $$(String locator) {
        return list(locator);
    }
    public static WebList $$(String locator, Object parent) {
        return list(locator).setup(j->j.setParent(parent));
    }
    public static WebList $$(By locator) {
        return list(locator);
    }
    public static WebList $$(By locator, Object parent) {
        return list(locator).setup(j->j.setParent(parent));
    }
    public static WebList $$(List<WebElement> els, String name) {
        return list(els, name);
    }

    public static Selector selector(String locator) {
        return locator.matches("[A-Z].*]")
            ? new Selector().setup(Selector.class, b-> b.setName(locator))
            : new Selector().setup(Selector.class, b-> b.setLocator(defineLocator(locator)));
    }
    public static IsDropdown dropdown(String locator) {
        return locator.matches("[A-Z].*]")
                ? new Dropdown().setup(Dropdown.class, b-> b.setName(locator))
                : new Dropdown().setup(Dropdown.class, b-> b.setLocator(defineLocator(locator)));
    }
    public static IsDropdown dropdown(String root, String value, String list, String expand) {
        return new Dropdown().setup(root, value, list, expand);
    }
    private static <T> Form<T> formWithLocator(String locator) {
        return new Form<>().setup(Form.class, b -> b.setLocator(locator));
    }
    public static <T> Form<T> form(Class<T> entityClass) {
        return new Form<>();
    }
    public static <T> Form<T> form(String locator, Class<T> entityClass) {
        return formWithLocator(locator);
    }
    public static <T> void submitForm(T entity) {
        new Form<>().submit(entity);
    }
    public static <T> void submitForm(String locator, T entity) {
        formWithLocator(locator).submit(entity);
    }
    public static <T> void loginAs(T entity) {
        new Form<>().loginAs(entity);
    }
    public static <T> void loginAs(String locator, T entity) {
        formWithLocator(locator).loginAs(entity);
    }
    public static Table table(String locator) {
        return new Table().setup(Table.class, b -> b.setLocator(locator));
    }
    public static <D> DataTable<?, D> dataTable(String locator, Class<D> dataClass) {
        return new DataTable<>().setup(DataTable.class, b -> b.setLocator(locator));
    }
    public static WebPage page(String pageName) {
        return getPage(pageName);
    }
}
