package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.*;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.map.MultiMap;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.*;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static java.util.Arrays.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Line implements IList<String>, IBaseElement {
    private JFunc<MultiMap<String, String>> dataMap;
    private WebList elements;
    private List<String> headers;
    public JDIBase base() {
        return elements.base();
    }

    public Line() {}
    public Line(WebList elements, List<String> headers) {
        this.elements = elements;
        this.headers = headers;
        List<String> values = elements.values();
        this.dataMap = () -> new MultiMap<>(headers, values).ignoreKeyCase();;
    }
    public static Line initLine(List<String> list, List<String> headers) {
        Line line = new Line();
        line.list = new ArrayList<>(list);
        line.headers = new ArrayList<>(headers);
        return line;
    }
    private MultiMap<String, String> data;
    private List<String> list;
    private List<String> getList(int minAmount) {
        if (list == null || list.size() < minAmount)
            list = getData(minAmount).values();
        return list;
    }
    public String get(String value) {
        int index = headers.indexOf(value);
        return getList(index+1).get(index);
    }
    private MultiMap<String, String> getData(int minAmount) {
        if (data == null || data.size() < minAmount)
            data = dataMap.execute();
        return data;
    }

    /**
     * Create list of specified size
     * @param minAmount
     * @return List
     */
    @JDIAction(level = DEBUG)
    public MultiMap<String, String> elements(int minAmount) {
        return getData(minAmount);
    }
    public MultiMap<String, UIElement> uiElements() {
        return new MultiMap<>(headers, elements.indexFromZero()).ignoreKeyCase();
    }
    public void saveCellsImages() {
        String unique = Timer.nowMSecs();
        List<UIElement> result = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            UIElement cell = elements.get(i+1);
            cell.varName = headers.get(i)+unique;
            cell.makePhoto();
            result.add(cell);
        }
        elements = new WebList().setValues(new MultiMap<>(headers, result).ignoreKeyCase());
    }
    public boolean visualCompareTo(Line line) {
        for (Pair<String, UIElement> cell : uiElements())
            try {
                cell.value.visualValidation(line.uiElements().get(cell.key));
            } catch (Exception ex) { return false; }
        return true;
    }

    public String getValue() {
        return PrintUtils.print(getList(0), ";");
    }
    public String print() { return getValue(); }

    public void clear() { data = null; }

    private <T> T getType(String methodName, Class<T> cl, JFunc1<T, T> setupInstance) {
        T instance;
        try {
            instance = create(cl);
        }
        catch (Exception ex) {
            throw exception(ex, methodName + ": Can't convert row to Entity (%s)", cl.getSimpleName());
        }
        return setupInstance.execute(instance);
    }
    public <D> D asData(Class<D> data) {
        return getType("asData", data, instance -> {
            int i = 0;
            List<Field> fields = asList(data.getDeclaredFields());
            for (String name : headers) {
                Field field = LinqUtils.first(fields, f -> namesEqual(getElementName(f), name));
                if (field != null)
                    try {
                        setPrimitiveField(field, instance, getList(i).get(i));
                    } catch (Exception ex) {
                        throw exception(ex, "Can't set table value '%s' to field '%s'", getData(i).get(i), field.getName());
                    }
                i++;
            }
            return instance;
        });
    }
    public <D> D asData(Class<D> data, MapArray<String, String> line) {
        return getType("asDataLine", data, instance -> {
            for (Pair<String, String> cell : line) {
                Field field = LinqUtils.first(instance.getClass().getDeclaredFields(),
                    f -> namesEqual(getElementName(f), cell.key));
                if (field == null) continue;
                try {
                    setPrimitiveField(field, instance, cell.value);
                } catch (Exception ex) {
                    throw exception(ex, "asDataLine: Can't set table entity to field '%s'", field.getName());
                }
            }
            return instance;
        });
    }

    public <T> T asLine(Class<T> cl) {
        return getType("asLine", cl, instance -> {
            for (int i = 1; i <= headers.size(); i++) {
                String header = headers.get(i-1);
                Field field = LinqUtils.first(instance.getClass().getDeclaredFields(),
                        f -> namesEqual(getElementName(f), header));
                if (field == null) continue;
                try {
                    IBaseElement ui = ((IBaseElement)field.get(instance));
                    UIElement listElement = elements.get(i);
                    WebElement element = ui.base().hasLocator()
                        ? listElement.findElement(ui.base().getLocator())
                        : listElement.getWebElement();
                    ui.base().setWebElement(element);
                } catch (Exception ex) {
                    throw exception(ex, "asLine: Can't set table entity to field '%s'", field.getName());
                }
            }
            return instance;
        });
    }

    @Override
    public String toString() {
        return print();
    }

    public boolean isUseCache() {
        return elements.isUseCache();
    }
}
