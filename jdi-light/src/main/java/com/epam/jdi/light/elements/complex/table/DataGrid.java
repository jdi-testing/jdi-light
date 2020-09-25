package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.HasDataTableAssert;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getElementName;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static java.util.Arrays.asList;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataGrid<L extends PageObject, D> extends Grid
        implements HasDataTableAssert, IDataGrid<L, D> {

    protected Class<D> dataClass = null;
    protected Class<L> lineClass = null;

    public D rowAsData(WebList row) {
        return lineClass != null
            ? lineToData(rowAsLine(row))
            : new Line(header(), row).asData(dataClass);
    }
    public L rowAsLine(WebList row) {
        return new Line(header(), row).asLine(lineClass);
    }

    @Override
    public List<String> header() {
        return header;
    }
    @Override
    public WebList headerUI() {
        WebList headerUI = super.headerUI();
        return headerUI.size() == size
            ? headerUI
            : tryFilterHeader(headerUI);
    }
    @Override
    public int size() {
        return size;
    }
    public void setup(Field field) {
        super.setup(field);
        try {
            setupGenericFields(field);
        } catch (Exception ignore) { // ignore if can't setup
        }
        List<Field> entityFields = new ArrayList<>();
        if (lineClass != null)
            entityFields.addAll(getFieldsExact(lineClass, f -> isInterface(f, HasValue.class)));
        if (dataClass != null)
            entityFields.addAll(asList(dataClass.getDeclaredFields()));
        if (entityFields.size() > 0) {
            header = map(entityFields, field1 -> splitCamelCase(field1.getName()))
                .stream().distinct().collect(Collectors.toList());
            size = header.size();
        }
    }

    protected void setupGenericFields(Field field) {
        Type[] types = getGenericTypes(field);
        if (types.length != 2)
            return;
        try {
            lineClass = types[0].toString().equals("?") ? null : (Class<L>) types[0];
            dataClass = types[1].toString().equals("?") ? null : (Class<D>) types[1];
        } catch (Exception ex) {
            throw exception(ex, "Can't get DataTable %s data or entity class", getName());
        }
    }

    protected List<Integer> columnsMapping;
    public JFunc1<String, String> SIMPLIFY = ELEMENT.simplifyString;
    protected WebList tryFilterHeader(WebList headerUI) {
        if (headerUI.size() < size) {
            throw exception("Header has size less than expected - %s. Please verify header locator or override headerUI() method", size);
        }
        int i = 1;
        int j = 0;
        List<WebElement> elements = new ArrayList<>();
        columnsMapping = new ArrayList<>();
        for (WebElement element : headerUI) {
            if (SIMPLIFY.execute(element.getText()).equalsIgnoreCase(SIMPLIFY.execute(header.get(j)))) {
                columnsMapping.add(i);
                elements.add(element);
                j++;
            }
            i++;
        }
        if (elements.size() != size)
            throw exception("Header has size more than expected - %s. Please verify header locator or override headerUI() method", size);
        return new WebList(elements);
    }

    protected D lineToData(L line) {
        D instance;
        try {
            instance = create(dataClass);
        }
        catch (Exception ex) {
            throw exception(ex, "Can't create %s instance in lineToData(line)", dataClass.getSimpleName());
        }
        Field[] dataFields = instance.getClass().getDeclaredFields();
        Field[] lineFields = line.getClass().getDeclaredFields();
        for (Field lineField : lineFields) {
            for (Field dataField : dataFields) {
                if (ELEMENT.namesEqual.execute(getElementName(lineField), getElementName(dataField))) {
                    Object lineFieldValue;
                    try {
                        lineFieldValue = lineField.get(line);
                    } catch (Exception ex) {
                        throw exception(ex, "Can't get lineField '%s' value", lineField.getName());
                    }
                    String value = isInterface(lineField.getType(), HasValue.class)
                            ? ((HasValue)lineFieldValue).getValue()
                            : lineFieldValue.toString();
                    try {
                        setPrimitiveField(dataField, instance, value);
                    } catch (Exception ex) {
                        throw exception(ex, "Can't set table value '%s' to field '%s'", value, dataField.getName());
                    }
                }
            }
        }
        return instance;
    }
}
