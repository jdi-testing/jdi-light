package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.table.IDataGridAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasInit;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.Safe;
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
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.setPrimitiveField;
import static java.util.Arrays.asList;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataGrid<L extends PageObject, D> extends UIBaseElement<IDataGridAssert<D, IDataGrid<L, D>,?>>
        implements ISetup, IGrid<D>, IDataGrid<L, D>, HasInit {
    protected Class<D> dataClass = null;
    protected Class<L> lineClass = null;
    protected Safe<Grid> grid = new Safe<>(Grid::new);
    public JFunc1<String, String> SIMPLIFY = ELEMENT.simplifyString;
    protected int startIndex = ELEMENT.startIndex;

    public Grid grid() {
        return grid.get();
    }
    public void init() {
        Grid element = grid.get();
        element.init();
        grid = new Safe<>(() -> element);
    }
    @Override
    public UIElement core() {
        return grid().core();
    }
    @Override
    public boolean isEmpty() {
        return IDataGrid.super.isEmpty();
    }
    @Override
    public int size() {
        return IDataGrid.super.size();
    }
    @Override
    public int count() {
        return IDataGrid.super.count();
    }
    @Override
    public WebList webRow(int rowNum) {
        return IDataGrid.super.webRow(rowNum);
    }
    @Override
    public WebList webColumn(int colNum) {
        return IDataGrid.super.webColumn(colNum);
    }
    @Override
    public WebList webColumn(String colName) {
        return IDataGrid.super.webColumn(colName);
    }
    @Override
    public UIElement webCell(int colNum, int rowNum) {
        return IDataGrid.super.webCell(colNum, rowNum);
    }
    @Override
    public List<String> header() {
        return IDataGrid.super.header();
    }
    @Override
    public WebList footerUI() {
        return IDataGrid.super.footerUI();
    }

    public D rowAsData(WebList row) {
        return lineClass != null
            ? lineToData(rowAsLine(row))
            : new Line(header(), row).asData(dataClass);
    }
    public L rowAsLine(WebList row) {
        return new Line(header(), row).asLine(lineClass);
    }
    public List<D> elements(int minAmount) {
        return allData();
    }
    public List<D> dataEqualsTo(D data) { return dataMatches(d -> d == data); }
    public List<D> dataMatches(JFunc1<D, Boolean> matcher) { return filter(matcher); }
    public D get(String value) {
        return data(value);
    }
    @Override
    public WebList webCells() {
        return grid().webCells();
    }
    @Override
    public void clear() {
        grid().clear();
    }
    @Override
    public WebList headerUI() {
        WebList headerUI = grid().headerUI();
        return headerUI.size() == grid().size
            ? headerUI
            : tryFilterHeader(headerUI);
    }

    @Override
    public IDataGridAssert<D, IDataGrid<L, D>,?> is() {
        return new IDataGridAssert<>(this);
    }

    public void setup(Field field) {
        grid().setup(field);
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
            grid().header = LinqUtils.map(entityFields, field1 -> ELEMENT.name.execute(field1))
                .stream().distinct().collect(Collectors.toList());
            grid().size = grid().header.size();
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
    protected WebList tryFilterHeader(WebList headerUI) {
        if (headerUI.size() < grid().size) {
            throw exception("Header has size less than expected - %s. Please verify header locator or override headerUI() method", grid().size);
        }
        int i = 1;
        int j = 0;
        List<WebElement> elements = new ArrayList<>();
        grid().columnsMapping = new ArrayList<>();
        for (WebElement element : headerUI) {
            if (SIMPLIFY.execute(element.getText()).equalsIgnoreCase(SIMPLIFY.execute(grid().header.get(j)))) {
                grid().columnsMapping.add(i);
                elements.add(element);
                j++;
            }
            i++;
        }
        if (elements.size() != grid().size)
            throw exception("Header has size more than expected - %s. Please verify header locator or override headerUI() method", grid().size);
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
    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int index) {
        startIndex = index;
    }
}
