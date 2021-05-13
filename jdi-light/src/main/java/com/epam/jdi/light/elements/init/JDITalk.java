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
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getPage;

public class JDITalk {
    public static JFunc1<String, UIElement> NAME_TO_ELEMENT = s -> {
        UIElement element = s.matches("[A-Z].*")
                ? new UIElement()
                : element(NAME_TO_LOCATOR.execute(s));
            return element.setName(s);
        };
    public static UIElement element(@MarkupLocator String locator) {
        return NAME_TO_ELEMENT.execute(locator);
    }
    public static UIElement element(@MarkupLocator By byLocator) {
        return new UIElement(byLocator);
    }

    public static WebList list(@MarkupLocator String locator) {
        return new WebList().setCore(NAME_TO_ELEMENT.execute(locator)).setName(locator);
    }
    public static WebList list(@MarkupLocator By byLocator) {
        return new WebList(byLocator);
    }
    public static WebList list(List<WebElement> els, String name) {
        return new WebList(els).setup(e->e.setName(name));
    }
    public static WebList list(List<WebElement> els) {
        return list(els, "Elements list");
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
        Selector selector = new Selector().setCore(Selector.class, NAME_TO_ELEMENT.execute(locator));
        selector.setName(locator);
        return selector;
    }
    public static IsDropdown dropdown(@MarkupLocator String locator) {
        Dropdown dropdown = new Dropdown().setCore(Dropdown.class, NAME_TO_ELEMENT.execute(locator));
        dropdown.setName(locator);
        return dropdown;
    }
    public static IsDropdown dropdown(String root, String value, String list, String expand) {
        return new Dropdown().setup(root, value, list, expand);
    }
    private static <T> Form<T> formWithLocator(@MarkupLocator String locator) {
        return new Form<>().setup(Form.class, b -> b.setLocator(locator));
    }
    public static <T> Form<T> form(Class<T> entityClass) {
        Form<T> form = new Form<>();
        form.setName(entityClass.getSimpleName());
        return form;
    }
    public static <T> Form<T> form(@MarkupLocator String locator, Class<T> entityClass) {
        Form<T> form = formWithLocator(locator);
        form.setName(entityClass.getSimpleName());
        return form;
    }
    public static <T> void submitForm(T entity) {
        Form<T> form = new Form<>();
        form.setName(entity.getClass().getSimpleName());
        form.submit(entity);
    }
    public static <T> void submitForm(@MarkupLocator String locator, T entity) {
        Form<T> form = formWithLocator(locator);
        form.setName(entity.getClass().getSimpleName());
        form.submit(entity);
    }
    public static <T> void loginAs(T entity) {
        Form<T> form = new Form<>();
        form.setName(entity.getClass().getSimpleName());
        form.loginAs(entity);
    }
    public static <T> void loginAs(@MarkupLocator String locator, T entity) {
        Form<T> form = formWithLocator(locator);
        form.setName(entity.getClass().getSimpleName());
        form.loginAs(entity);
    }
    public static Table table(@MarkupLocator String locator) {
        return new Table().setup(Table.class, b -> b.setLocator(locator));
    }
    public static <D> DataTable<?, D> dataTable(@MarkupLocator String locator) {
        return new DataTable<>().setup(DataTable.class, b -> b.setLocator(locator));
    }
    public static WebPage page(String pageName) {
        return getPage(pageName);
    }
}
