package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.JDILocator;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.light.mobile.elements.init.MobileUIFactory;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.SMART_LIST;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.mobile.elements.init.MobileUIFactory.$;
import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.StringUtils.namesEqual;

public class MobileWebList extends WebList {

    public MobileWebList(By locator) {
        super(locator);
    }

    @Override
    public UIElement core() {
        return new MobileUIElement(base());
    }

    @Override
    public MobileWebList setup(JAction1<JDIBase> setup) {
        return setup(MobileWebList.class, setup);
    }

    @Override
    protected SearchContext getDefaultContext() {
        return driver();
    }

    protected CacheValue<MapArray<String, MobileUIElement>> map = new CacheValue<>(MapArray::new);


    private MobileUIElement getElementByLocator(int getIndex, int index) {
        return locator.isXPath()
                ? new MobileUIElement(base(), locator.addIndex(index), index + "", parent)
                : initElement(() -> getList(getIndex + 1).get(getIndex));
    }

    protected MobileUIElement initElement(JFunc<WebElement> func) {
        return initElement(func.execute(), func);
    }

    protected MobileUIElement initElement(WebElement el, JFunc<WebElement> func) {
        try {
            MobileUIElement element = new MobileUIElement(base(), el, func);
            element.locator = new JDILocator(element);
            return element;
        } catch (Exception ex) {
            throw exception(ex, "Can't init func new element for list");
        }
    }

    private MobileUIElement getByIndex(int index) {
        if (index < getStartIndex())
            throw exception("Can't get element with index '%s'. Index should be %s or more", index, getStartIndex());
        int getIndex = index - getStartIndex();
        if (locator.isNull() && isUseCache()) {
            if (map.hasValue() && map.get().size() > 0 && map.get().size() >= getIndex && isActualMap())
                return map.get().values().get(getIndex);
            if (webElements.hasValue() && webElements.get().size() > 0 && webElements.get().size() >= getIndex && isActual(webElements.get().get(0)))
                return MobileUIFactory.$(webElements.get().get(getIndex));
        }
        MobileUIElement element = locator.isTemplate()
                ? tryGetByIndex(index)
                : getElementByLocator(getIndex, index);
        return element.setName(nameFromIndex(index));
    }

    protected MobileUIElement tryGetByIndex(int index) {
        try {
            return new MobileUIElement(base(), getLocator(index), nameFromIndex(index));
        } catch (Exception ex) {
            throw exception(ex, "Can't get element with index '%s' for template locator. " +
                    "Maybe locator is wrong or you need to get element by name", index);
        }
    }

    protected String getElementName(MobileUIElement element) {
        try {
            return nameFunc().execute(element);
        } catch (Exception ex) {
            return "";
        }
    }

    public MobileWebList() {
        webElements.useCache(true);
        webElement.useCache(true);
        textType = SMART_LIST;
    }

    public MobileWebList(List<WebElement> elements) {
        this();
        setWebElements(elements);
    }

    @JDIAction(level = DEBUG)
    @Override
    public MobileWebList elements(int minAmount) {
        return new MobileWebList(uiElements(minAmount));
    }

    public Iterator<MobileUIElement> iteratorMobile() {
        return LinqUtils.map(uiElements(0), el -> $(el)).iterator();
    }

    /**
     * @param index
     */
    @Override
    public MobileUIElement get(int index) {
        if (index < getStartIndex())
            throw exception("Can't get element with index '%s'. Index should be %s or more", index, getStartIndex());
        return getByIndex(index);
    }

    @Override
    protected MobileUIElement firstUIElement(String value) {
        MapArray<String, MobileUIElement> nameElement = new MapArray<>();
        try {
            MobileWebList elements = elements(1);
            for (int i = 0; i < elements.size(); i++) {
                MobileUIElement element = elements.get(i);
                String name = getElementName(element);
                nameElement.add(name, element);
                if (namesEqual(name, value))
                    return element;
            }
            return null;
        } finally {
            if (map.hasValue()) {
                for (Pair<String, MobileUIElement> pair : map.get())
                    if (!any(nameElement.keys(), name -> namesEqual(name, pair.key)))
                        nameElement.add(pair);
            }
            map.set(nameElement);
        }
    }

    @Override
    public MobileUIElement getUIElement(String value) {
        MobileUIElement element = locator.isTemplate()
                ? new MobileUIElement(base(), getLocator(value), nameFromValue(value))
                : getNewElementByValue(value);
        map.get().update(value, element);
        return element;
    }

    @Override
    protected MobileUIElement getNewElementByValue(String value) {
        refresh();
        if (locator.isXPath())
            return new MobileUIElement(base(), locator.addText(value), nameFromValue(value), parent);
        MobileUIElement result = firstUIElement(value);
        if (result == null)
            throw exception("Failed to get '%s' in list '%s'. No elements with this name found", value, getName());
        return result;
    }

}
