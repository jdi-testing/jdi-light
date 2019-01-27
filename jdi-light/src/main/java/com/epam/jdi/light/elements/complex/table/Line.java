package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getElementName;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.StringUtils.namesEqual;

public class Line implements IList<String> {
    private List<String> dataList;
    private List<UIElement> elements;
    private List<String> headers;

    public Line(List<UIElement> elements, List<String> headers) {
        this.elements = elements;
        this.headers = headers;
        this.dataList = LinqUtils.select(elements, WebElement::getText);
    }
    public Line(List<String> list) {
        this.dataList = new ArrayList<>(list);
    }
    @JDIAction(level = DEBUG)
    public List<String> elements() {
        return dataList;
    }

    public String getValue() {
        return PrintUtils.print(dataList);
    }
    public String print() { return getValue(); }
    public void clear() { dataList.clear(); }
    public <T> T asData(Class<T> cl) {
        T instance;
        try { instance = cl.newInstance(); }
        catch (Exception ex) { throw exception("Can't convert row to Data (%s)", cl.getSimpleName()); }
        int i = 0;
        for (Field field : cl.getFields()) {
            try {
                field.set(instance, dataList.get(i));
            } catch (Exception ex) {
                throw exception("Can't set table value '%s' to field '%s'", dataList.get(i), field.getName());
            }
            i++;
        }
        return instance;
    }
    public <T> T asEntity(Class<T> cl) {
        T instance;
        try { instance = cl.newInstance(); }
        catch (Exception ex) { throw exception("Can't convert row to Entity (%s)", cl.getSimpleName()); }
        for (int i = 0; i < headers.size(); i++) {
            String header = headers.get(i);
            Field field = LinqUtils.first(instance.getClass().getDeclaredFields(),
                f -> namesEqual(getElementName(f), header));
            if (field != null)
                try {
                    field.set(instance, initEntity(elements.get(i), field));
                } catch (Exception ex) {
                    throw exception("Can't set table entity to field '%s'", field.getName());
                }
        }
        return instance;
    }

    private Object initEntity(UIElement element, Field field) {
        try {
            Class<?> cl = field.getType();
            if (cl == UIElement.class)
                return element;
            JDIBase result = (JDIBase) cl.newInstance();
            result.setWebElement(element);
            result.setName(field.getName());
            return result;
        } catch (Exception ex) {
            throw exception("Can't init element for field '%s'", field.getName());
        }

    }

}
