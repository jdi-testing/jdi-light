package com.epam.jdi.light.elements.init.entities.collection;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.map.MapArray;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.composite.WebPage.getCurrentPage;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;

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
    public static <T> T getUI(String name, Class<T> type) {
        try {
            return (T) getUI(name);
        } catch (Exception ex) {
            throw exception("Can't convert element to %s", type.getSimpleName());
        }
    }
    public static UIElement getUI(String name) {
        if (ELEMENTS.has(name)) {
            List<Object> elements = ELEMENTS.get(name);
            if (elements.size() == 1)
                return ((ICoreElement) elements.get(0)).core();
            ICoreElement element = (ICoreElement) LinqUtils.first(elements,
                    el -> {
                        WebPage page = ((ICoreElement) el).base().getPage();
                        return page != null && page.getName().equals(getCurrentPage());
                    });
            if (element != null)
                return element.core();
        }
        throw exception("Can't find %s element", name);
    }

    public static UIElement getUI(String name, String section) {
        if (ELEMENTS.has(name)) {
            List<Object> els = ELEMENTS.get(name);
            Object result = first(els, el -> isClass(el.getClass(), IBaseElement.class) && ((IBaseElement) el).base().hasParent(section));
            if (result == null)
                throw exception("Can't find %s element at %s", name, section);
            return ((ICoreElement) result).core();
        }
        throw exception("Can't find %s element", name);
    }

}
