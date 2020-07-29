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
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getPage;

public class JDITalk {
    public static UIElement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*")
                ? new UIElement().setName(locator)
                : element(defineLocator(locator));
    }
    public static UIElement element(@MarkupLocator By byLocator) {
        return new UIElement(byLocator);
    }

    public static WebList list(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*")
                ? new WebList()
                : list(defineLocator(locator));
    }
    public static WebList list(@MarkupLocator By byLocator) {
        return new WebList(byLocator);
    }
    public static WebList list(List<WebElement> els, String name) {
        return new WebList(els).setup(e->e.setName(name));
    }

    public static void clickOn(String locator) {
        $(locator).click();
    }
    public static InClass typeText(String text) {
        return new InClass(text);
    }
    public static void show(String locator) {
        $(locator).show();
    }
    public static DropClass drag(String locator) {
        return new DropClass(locator);
    }
    public static Selector selector(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*")
                ? new Selector().setup(Selector.class, b-> b.setName(locator))
                : new Selector().setup(Selector.class, b-> b.setLocator(defineLocator(locator)));
    }
    public static IsDropdown dropdown(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*")
                ? new Dropdown().setup(Dropdown.class, b-> b.setName(locator))
                : new Dropdown().setup(Dropdown.class, b-> b.setLocator(defineLocator(locator)));
    }
    public static IsDropdown dropdown(String root, String value, String list, String expand) {
        return new Dropdown().setup(root, value, list, expand);
    }
    private static <T> Form<T> formWithLocator(@MarkupLocator String locator) {
        return new Form<>().setup(Form.class, b -> b.setLocator(locator));
    }
    public static <T> Form<T> form(Class<T> entityClass) {
        return new Form<>();
    }
    public static <T> Form<T> form(@MarkupLocator String locator, Class<T> entityClass) {
        return formWithLocator(locator);
    }
    public static <T> void submitForm(T entity) {
        new Form<>().submit(entity);
    }
    public static <T> void submitForm(@MarkupLocator String locator, T entity) {
        formWithLocator(locator).submit(entity);
    }
    public static <T> void loginAs(T entity) {
        new Form<>().loginAs(entity);
    }
    public static <T> void loginAs(@MarkupLocator String locator, T entity) {
        formWithLocator(locator).loginAs(entity);
    }
    public static Table table(@MarkupLocator String locator) {
        return new Table().setup(Table.class, b -> b.setLocator(locator));
    }
    public static <D> DataTable<?, D> dataTable(@MarkupLocator String locator, Class<D> dataClass) {
        return new DataTable<>().setup(DataTable.class, b -> b.setLocator(locator));
    }
    public static WebPage page(String pageName) {
        return getPage(pageName);
    }
}
