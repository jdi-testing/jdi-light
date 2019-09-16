package com.epam.jdi.light.elements.init.entities.collection;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.map.MapArray;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.composite.WebPage.getCurrentPage;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class EntitiesCollection {
    public static MapArray<String, WebPage> PAGES = new MapArray<>();
    public static MapArray<String, List<Object>> ELEMENTS = new MapArray<>();

    private EntitiesCollection() { }

    public static void addPage(WebPage page) {
        PAGES.update(page.getName(), page);
    }
    public static void updatePage(WebPage page) {
        String className = page.getClass().getSimpleName();
        if (PAGES.keys().contains(className))
            PAGES.removeByKey(className);
        PAGES.update(page.getName(), page);
    }
    public static WebPage getPage(String pageName) {
        WebPage page = PAGES.get(pageName);
        if (page == null)
            page = PAGES.get(pageName + " Page");
        if (page == null)
            throw exception("Can't find page with name %s. Available pages: %s", pageName,
                    print(PAGES.keys()));
        return page;
    }
    public static void addElement(Object jdi) {
        if (isInterface(jdi.getClass(), ICoreElement.class)) {
            ICoreElement element = (ICoreElement) jdi;
            if (ELEMENTS.has(element.getName()))
                ELEMENTS.get(element.getName()).add(jdi);
            else {
                List<Object> newList = new ArrayList<>();
                newList.add(element);
                ELEMENTS.add(element.getName(), newList);
            }
        }
    }

    public static <T> T getUI(String name, Class<T> type) {
        Object element = getElement(name);
        if (isClass(element.getClass(), type))
            return (T) element;
        throw exception("Can't cast element '%s' to '%s'", name, type.getSimpleName());
    }
    public static ICoreElement getUI(String name) {
        Object element = getElement(name);
        if (element != null && isInterface(element.getClass(), ICoreElement.class))
            return ((ICoreElement) element);
        throw exception("Can't find '%s' element", name);
    }
    static Object getElement(String name) {
        String[] split = name.split("\\.");
        if (split.length == 2)
            return getElementInSection(split[1], split[0]);
        if (ELEMENTS.has(name)) {
            List<Object> elements = ELEMENTS.get(name);
            return elements.size() == 1
                    ? elements.get(0)
                    : LinqUtils.first(elements, el -> {
                WebPage page = ((ICoreElement) el).base().getPage();
                return page != null && page.getName().equals(getCurrentPage());
            });
        }
        throw exception("Can't find '%s' element", name);
    }

    static Object getElementInSection(String name, String section) {
        if (ELEMENTS.has(name)) {
            List<Object> els = ELEMENTS.get(name);
            Object result = first(els, el -> isInterface(el.getClass(), IBaseElement.class) && ((IBaseElement) el).base().hasParent(section));
            if (result == null)
                throw exception("Can't find '%s' element at '%s'", name, section);
            return result;
        }
        throw exception("Can't find '%s' element", name);
    }

}
