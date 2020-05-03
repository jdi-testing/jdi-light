package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.settings.JDISettings;
import com.epam.jdi.light.ui.html.elements.annotations.*;
import com.epam.jdi.light.ui.html.elements.enums.MenuBehaviour;
import com.epam.jdi.tools.func.JAction1;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.*;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.*;
import static java.lang.String.*;
import static java.util.Arrays.*;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * Created by Roman Iovlev on 02.05.2020
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Menu extends Selector implements ISetup {
    protected List<String> locators = new ArrayList<>();
    protected String separator = ">";
    protected String printFormat = "%s[%s]";
    protected String printSeparator = ";";
    protected JAction1<UIElement> pathAction = UIElement::click;
    protected JAction1<UIElement> lastAction = UIElement::click;
    protected boolean inheritLocators = false;

    public Menu() { }
    public Menu(String... locators) {
        this.locators = asList(locators);
    }

    protected void setSeparator(String separator) {
        this.separator = separator;
    }
    protected void setPrint(String printFormat, String printSeparator) {
        this.printFormat = printFormat;
        this.printSeparator = printSeparator;
    }
    protected void setActions(JAction1<UIElement> pathAction, JAction1<UIElement> lastAction) {
        this.pathAction = pathAction;
        this.lastAction = lastAction;
    }
    protected void setActions(MenuBehaviour behaviour) {
        switch (behaviour) {
            case HOVER:
                setActions(UIElement::hover, UIElement::hover);
                break;
            case HOVER_AND_CLICK:
                setActions(UIElement::hover, UIElement::click);
                break;
            case SELECT:
                setActions(UIElement::click, UIElement::click);
                break;
        }
    }
    protected void inheritLocators() {
        inheritLocators = true;
    }

    public UIElement get(String value) {
        String[] values = split(value);
        return get(values);
    }

    public UIElement get(String... items) {
        if (items.length == 0)
            throw exception("Failed to get '%s' element for no values");
        List<String> values = map(items, String::trim);
        preOpen(values);
        if (locators.size() == 0)
            return getElementByLocator(values, null);
        return values.size() == 1
            ? list().get(values.get(0))
            : getElementByLocator(values, locators.iterator());
    }

    protected UIElement getElementByLocator(List<String> values, Iterator<String> iterator) {
        Object parent = base().parent;
        UIElement element = null;
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            element = (iterator == null
                ? $$(base().getLocator(), parent)
                : $$(iterator.next(), parent))
                .get(value);
            if (i < values.size() - 1)
                pathAction.execute(element);
            else
                return element;
            if (inheritLocators)
                parent = element;
        }
        throw exception("Failed to get [%s] values", print(values));
    }

    /**
     * Selects particular element by index
     * @param items String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' value in '{name}'") @Override
    public void select(String... items) {
        lastAction.execute(get(items));
    }

    /**
     * Selects particular element by index
     * @param value String var arg, elements with text to select
     */
    @JDIAction("Select '{0}' value in '{name}'") @Override
    public void select(String value) {
        lastAction.execute(get(value));
    }

    protected String[] split(String value) {
        if (isBlank(value))
            throw exception("Failed to select empty value in Menu");
        String[] values = value.split(separator);
        if (value.length() == 0)
            throw exception("Failed to select '%s' value in Menu. Split '%s' has 0 elements", value, separator);
        return values;
    }

    public UIElement get(int index) {
        preOpen(asList(index));
        return list().get(index);
    }

    public UIElement get(int... indexes) {
        if (indexes.length == 0)
            throw exception("Failed to get '%s' element for no values");
        preOpen(asList(indexes));
        if (locators.size() == 0)
            return getElementByLocator(indexes, null);
        return indexes.length == 1
            ? list().get(indexes[0])
            : getElementByLocator(indexes, locators.iterator());
    }

    protected UIElement getElementByLocator(int[] indexes, Iterator<String> iterator) {
        Object parent = base().parent;
        for (int i = 0; i < indexes.length; i++) {
            UIElement element;
            if (iterator != null) {
                String locator = iterator.next();
                element = $$(locator, parent).get(indexes[i]);
            } else {
               element = $$(base().getLocator(), parent).get(indexes[i]);
            }
            if (i < indexes.length - 1)
                pathAction.execute(element);
            else
                return element;
            if (inheritLocators)
                parent = element;
        }
        throw exception("Failed to get [%s] values", print(indexes));
    }

    /**
     * Selects particular element by index
     * @param index int var arg, elements with text to select
     */
    @JDIAction("Select '{0}' value in '{name}'") @Override
    public void select(int index) {
        lastAction.execute(get(index));
    }

    /**
     * Selects particular element by index
     * @param indexes int var arg, elements with text to select
     */
    @JDIAction("Select '{0}' value in '{name}'") @Override
    public void select(int... indexes) {
        lastAction.execute(get(indexes));
    }

    @Override
    @JDIAction("Get all {name} values")
    public List<String> values() {
        return list().noValidation().values();
    }
    @Override
    @JDIAction("Get {name} value")
    public String getValue() {
        list().noValidation().is().notEmpty();
        return printValues(base().parent, 0);
    }

    protected String printValues(Object parent, int index) {
        if (index == locators.size())
            return "";
        WebList list = $$(locators.get(index), parent).noValidation();
        List<String> result = new ArrayList<>();
        for (UIElement element : list) {
            String value = element.getText();
            String subValues = printValues(inheritParent(element), index + 1);
            result.add(isBlank(subValues)
                ? value
                : format(printFormat, value, subValues));
        }
        return print(result, printSeparator);
    }

    @JDIAction("Get all {name} values")
    public List<String> allValues() {
        base().noValidation(() -> list().is().notEmpty());
        return getValues(base().parent, 0);
    }

    protected List<String> getValues(Object parent, int index) {
        if (index == locators.size())
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        WebList list = $$(locators.get(index), parent).noValidation();
        for (UIElement element : list) {
            result.add(element.getText());
            result.addAll(getValues(inheritParent(element), index + 1));
        }
        return result;
    }
    private Object inheritParent(UIElement element) {
        return inheritLocators ? element : base().parent;
    }

    protected void preOpen(List<?> objs) {
        if (locators.size() == 0) return;
        if (!base().locator.isNull())
            core().click();
        if (objs.size() > locators.size())
            throw exception("Menu has only '%s' levels but select called for '%s' levels", locators.size(), objs.size());
    }
    @JDIAction("Get selected value") @Override
    public String selected() { return list().selected(); }

    public void setup(Field field) {
        if (fieldHasAnnotation(field, JMenu.class, Menu.class)) {
            JMenu jMenu = field.getAnnotation(JMenu.class);
            locators = asList(jMenu.value());
        }

        if (fieldHasAnnotation(field, Separator.class, Menu.class)) {
            Separator jSeparator = field.getAnnotation(Separator.class);
            this.separator = jSeparator.value();
        }

        if (fieldHasAnnotation(field, MenuActions.class, Menu.class)) {
            MenuActions behaviour = field.getAnnotation(MenuActions.class);
            setActions(behaviour.value());
        }

        if (fieldHasAnnotation(field, MenuPrint.class, Menu.class)) {
            MenuPrint menuPrint = field.getAnnotation(MenuPrint.class);
            setPrint(menuPrint.format(), menuPrint.separator());
        }

        if (fieldHasAnnotation(field, InheritLocators.class, Menu.class)) {
            inheritLocators();
        }
    }

    @Override
    public WebList list() {
        By locator = locators.isEmpty()
            ? base().getLocator()
            : defineLocator(locators.get(0));
        return $$(locator, base().parent);
    }
}
