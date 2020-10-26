package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.map.MultiMap;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getElementName;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.ReflectionUtils.create;
import static com.epam.jdi.tools.StringUtils.setPrimitiveField;
import static java.util.Arrays.asList;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Line implements IList<String>, IBaseElement {
    private JFunc<MultiMap<String, String>> dataMap;
    private WebList elements;
    private List<String> headers;
    protected int startIndex = ELEMENT.startIndex;

    public Line(List<String> list, List<String> headers, JDIBase base) {
        if (list == null || headers == null || list.size() == 0 || headers.size() == 0
                || list.size() != headers.size())
            throw exception("Failed to init Line[list: %s; headers: %s;]",
                list == null ? "null" : list.toString(), headers == null ? "null" : headers.toString());
        this.list = new ArrayList<>(list);
        this.headers = new ArrayList<>(headers);
        this.data = new MultiMap<>(headers, list).ignoreKeyCase();
        this.elements = new WebList(base);
    }
    public Line(List<String> headers, List<WebElement> elements) {
        this(headers, new WebList(elements));
    }
    public Line(List<String> headers, WebList elements) {
        if (headers == null) {
            throw exception("Failed to create Line. Header has null value");
        }
        if (elements == null) {
            throw exception("Failed to create Line. Elements has null value");
        }
        this.elements = elements;
        this.headers = headers;
        List<String> values = elements.values();
        if (headers.size() != values.size()) {
            throw exception("Failed to create Line. Headers size='%s' is not equal to Elements size='%s'", headers.size(), values.size());
        }
        this.dataMap = () -> new MultiMap<>(headers, values).ignoreKeyCase();
    }

    public JDIBase base() {
        return elements.base();
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
    public List<String> elements(int minAmount) {
        return getData(minAmount).values();
    }
    public MultiMap<String, UIElement> uiMap() {
        return new MultiMap<>(headers, elements.indexFromZero()).ignoreKeyCase();
    }
    public WebList uiElements() {
        return elements;
    }
    public void saveCellsImages() {
        String unique = Timer.nowMSecs();
        List<UIElement> result = new ArrayList<>();
        int i = 0;
        for (UIElement element : elements) {
            element.show();
            element.varName = headers.get(i++)+unique;
            element.makePhoto();
            result.add(element);
        }
        elements = new WebList(headers, result);
    }
    public boolean visualCompareTo(Line line) {
        for (Pair<String, UIElement> cell : uiMap())
            try {
                cell.value.visualValidation(line.uiMap().get(cell.key));
            } catch (Exception ex) { return false; }
        return true;
    }

    public String getValue() {
        return PrintUtils.print(getList(0), ";");
    }
    public String print() {
        return getData(0).toString();
    }

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
        return getType("asData", data, instance -> getInstance(this, data, headers, instance));
    }
    public <D> D asData(Class<D> data, MapArray<String, String> line) {
        return getType("asDataLine", data, instance -> getLineInstance(instance, line));
    }
    protected static <D> D getInstance(Line line, Class<D> data, List<String> headers, D instance) {
        int i = 0;
        List<Field> fields = asList(data.getDeclaredFields());
        for (String name : headers) {
            Field field = LinqUtils.first(fields, f -> ELEMENT.namesEqual.execute(getElementName(f), name));
            if (field != null)
                try {
                    setPrimitiveField(field, instance, line.getList(i).get(i));
                } catch (Exception ex) {
                    throw exception(ex, "Can't set table value '%s' to field '%s'", line.getData(i).get(i), field.getName());
                }
            i++;
        }
        return instance;
    }
    protected static <D> D getLineInstance(D instance, MapArray<String, String> line) {
        for (Pair<String, String> cell : line) {
            Field field = LinqUtils.first(instance.getClass().getDeclaredFields(),
                    f -> ELEMENT.namesEqual.execute(getElementName(f), cell.key));
            if (field == null) continue;
            try {
                setPrimitiveField(field, instance, cell.value);
            } catch (Exception ex) {
                throw exception(ex, "asDataLine: Can't set table entity to field '%s'", field.getName());
            }
        }
        return instance;
    }

    public <T> T asLine(Class<T> cl) {
        return getType("asLine", cl, instance -> {
            int i = getStartIndex();
            for (String header : headers) {
                Field field = LinqUtils.first(instance.getClass().getDeclaredFields(),
                        f -> ELEMENT.namesEqual.execute(getElementName(f), header));
                if (field == null) continue;
                try {
                    IBaseElement ui = ((IBaseElement)field.get(instance));
                    UIElement listElement = elements.get(i++);
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
    public int size() {
        return headers.size();
    }

    @Override
    public String toString() {
        return print();
    }

    public boolean isUseCache() {
        return elements.isUseCache();
    }

    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int index) {
        startIndex = index;
    }
}
