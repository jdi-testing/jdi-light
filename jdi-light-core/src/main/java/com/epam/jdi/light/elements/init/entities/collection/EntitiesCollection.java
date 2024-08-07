package com.epam.jdi.light.elements.init.entities.collection;

import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdiai.tools.LinqUtils;
import com.jdiai.tools.Safe;
import com.jdiai.tools.map.MapArray;
import com.jdiai.tools.pairs.Pair;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.composite.WebPage.getCurrentPage;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.settings.WebSettings.init;
import static com.jdiai.tools.JsonUtils.getMapFromJson;
import static com.jdiai.tools.JsonUtils.scanFolder;
import static com.jdiai.tools.LinqUtils.first;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.PropertyReader.getProperty;
import static com.jdiai.tools.ReflectionUtils.isClass;
import static com.jdiai.tools.ReflectionUtils.isInterface;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class EntitiesCollection {
    public static Safe<MapArray<String, WebPage>> PAGES = new Safe<>(MapArray::new);
    public static Safe<MapArray<String, List<Object>>> ELEMENTS = new Safe<>(MapArray::new);
    static MapArray<String, String> jsonPages;
    static MapArray<String, String> jsonElements;

    private EntitiesCollection() { }

    public static void addPage(WebPage page) {
        PAGES.get().update(page.getName(), page);
    }
    public static void updatePage(WebPage page) {
        String className = page.getClass().getSimpleName();
        if (PAGES.get().keys().contains(className))
            PAGES.get().removeByKey(className);
        PAGES.get().update(page.getName(), page);
    }
    static void readPagesFromJson() {
        jsonPages = getMapFromJson("pages", "json.page.objects");
    }
    public static WebPage getPage(String pageName) {
        init();
        WebPage page = PAGES.get().get(pageName);
        if (page == null)
            page = PAGES.get().get(pageName + " Page");
        if (page == null) {
            if (jsonPages == null)
                readPagesFromJson();
            if (jsonPages == null) {
                throw runtimeException("Can't find page with name %s. Available pages: %s", pageName,
                        print(PAGES.get().keys()));
            } else page = new WebPage(jsonPages.get(pageName));
        }
        return page;
    }
    public static WebPage getPageByUrl(String url) {
        Pair<String, WebPage> result = PAGES.get().first((k, v) -> v.isOnPage(url));
        return result != null ? result.value : null;
    }
    public static void addElement(Object jdi) {
        if (isInterface(jdi.getClass(), ICoreElement.class)) {
            ICoreElement element = (ICoreElement) jdi;
            String name = element.getName();
            if (ELEMENTS.get().has(name))
                ELEMENTS.get().get(name).add(jdi);
            else {
                List<Object> newList = new ArrayList<>();
                newList.add(element);
                ELEMENTS.get().add(name, newList);
            }
        }
    }

    public static <T extends UIListBase<?>> WebList getList(String name, Class<T> type) {
        Object element = getElement(name);
        if (element != null) {
            if (isClass(element.getClass(), type)) {
                return ((T) element).list();
            }
            if (isClass(element.getClass(), WebList.class)) {
                return (WebList) element;
            }
        }
        throw runtimeException("Can't cast element '%s' to '%s'", name, type.getSimpleName());
    }

    public static <T> T getUI(String name, Class<T> type) {
        Object element = getElement(name);
        if (element != null && isClass(element.getClass(), type)) {
            return (T) element;
        }
        throw runtimeException("Can't cast element '%s' to '%s'", name, type.getSimpleName());
    }

    public static <T> T getByType(ICoreElement element, Class<T> type) {
        try {
            ICoreElement core = isClass(element.getClass(), type)
                ? element
                : element.core();
            return (T) core;
        } catch (Exception ex) {
            throw exception(ex, "Can't get element '%s' of type '%s'", element.getName(), type.getSimpleName());
        }
    }

    public static ICoreElement getUI(String name) {
        Object element = getElement(name);
        if (element != null && isInterface(element.getClass(), ICoreElement.class))
            return ((ICoreElement) element);
        throw runtimeException("Can't find '%s' element", name);
    }

    static void readElementsFromJson() {
        List<String> filePaths = scanFolder("src/test/resources"+getProperty("json.page.objects"));
        jsonElements = new MapArray<>();
        for (String filePath : filePaths)
            try {
                jsonElements.addAll(new ObjectMapper().readValue(new File(filePath), HashMap.class));
            } catch (IOException e) {
                throw new RuntimeException("Can't read elements from json");
            }
    }

    static Object getElement(String name) {
        if (!name.matches("[A-Z].*"))
            return $(name);
        String[] split = name.split("\\.");
        if (split.length == 2)
            return getElementInSection(split[1], split[0]);
        if (ELEMENTS.get().has(name)) {
            List<Object> elements = ELEMENTS.get().get(name);
            if (ELEMENTS.get().size() > 1) {
                Object element = LinqUtils.first(elements, el -> {
                    WebPage page = ((ICoreElement) el).base().getPage();
                    return page != null && page.getName().equals(getCurrentPage());
                });
                if (element != null) {
                    return element;
                }
            }
            return ELEMENTS.get().get(name).get(0);
        }
        if (jsonElements == null)
            readElementsFromJson();
        return jsonElements.keys().contains(name)
            ? $(jsonElements.get(name))
            : new UIElement().setName(name);
    }

    static Object getElementInSection(String name, String section) {
        if (ELEMENTS.get().has(name)) {
            List<Object> els = ELEMENTS.get().get(name);
            Object result = first(els, el -> isInterface(el.getClass(), IBaseElement.class) && ((IBaseElement) el).base().hasParent(section));
            if (result == null)
                throw runtimeException("Can't find '%s' element at '%s'", name, section);
            return result;
        }
        throw runtimeException("Can't find '%s' element", name);
    }

}
