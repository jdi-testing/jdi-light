package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.table.DataTableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.*;
import static com.epam.jdi.tools.EnumUtils.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static java.util.Arrays.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataTable<L extends PageObject, D> extends BaseTable<DataTable<L, D>, DataTableAssert<L, D>> {
    private Class<L> lineClass;
    private Class<D> dataClass;

    protected CacheAll<MapArray<String, L>> lines
        = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, D>> datas
        = new CacheAll<>(MapArray::new);

    private void hasLineClass() {
        if (lineClass == null || !isClass(lineClass, PageObject.class))
            throw exception("In order to use this method you must specify LineClass that extends PageObject for '%s' DataTable<LineClass, ?>", getName());
    }
    private void hasDataClass() {
        if (dataClass == null)
            throw exception("In order to use this method you must specify DataClass for '%s' DataTable<?, DataClass>", getName());
    }
    /**
     * Get table row by the row number
     * @param rowNum
     * @return D refers to user data object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public D dataRow(int rowNum) {
        hasDataClass();
        if (datas.get().has(rowNum+""))
            return datas.get().get(rowNum+"");
        D data = lineClass != null
            ? lineToData(line(rowNum))
            : row(rowNum).asData(dataClass);
        datas.get().update(rowNum + "", data);
        return data;
    }

    /**
     * Get table row by the row number
     * @param rowNum
     * @return L refers to table line object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(int rowNum) {
        hasLineClass();
        if (lines.get().has(rowNum+""))
            return lines.get().get(rowNum+"");
        L value = row(rowNum).asLine(lineClass);
        lines.get().update(rowNum + "", value);
        return value;
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return D refers to user data object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public D dataRow(String rowName) {
        hasDataClass();
        return dataRow(getRowIndexByName(rowName));
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return L refers to table line object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(String rowName) {
        hasLineClass();
        return line(getRowIndexByName(rowName));
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return D refers to user data object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public D dataRow(Enum rowName) {
        hasDataClass();
        return dataRow(getEnumValue(rowName));
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return L refers to table line object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(Enum rowName) {
        hasLineClass();
        return line(getEnumValue(rowName));
    }

    /**
     * Get first table row that match criteria
     * @param matchers to compare
     * @return D refers to user data object
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public D dataRow(TableMatcher... matchers) {
        hasDataClass();
        return row(matchers).asData(dataClass);
    }

    /**
     * Get first table row that match criteria
     * @param matchers to compare
     * @return L refers to table line object
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public L line(TableMatcher... matchers) {
        hasLineClass();
        return row(matchers).asLine(lineClass);
    }

    /**
     * Get first table row that match criteria
     * @param matcher to compare
     * @return D refers to user data object
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public D dataRow(JFunc1<D, Boolean> matcher) {
        hasDataClass();
        for (int i = 1; i <= count.get(); i++) {
            D data = dataRow(i);
            if (matcher.execute(data))
                return data;
        }
        return null;
    }

    /**
     * Get first table row that match criteria
     * @param matcher to compare
     * @return L refers to table line object
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public L line(JFunc1<D, Boolean> matcher) {
        hasLineClass();
        for (int i = 1; i <= count.get(); i++) {
            if (matcher.execute(dataRow(i)))
                return line(i);
        }
        return null;
    }

    /**
     * Get all table rows that match criteria
     * @param matcher to compare
     * @return List
     */
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<D> dataRows(JFunc1<D, Boolean> matcher) {
        hasDataClass();
        return LinqUtils.filter(allData(), matcher::execute);
    }

    /**
     * Get at least a specified number of rows of the table that meet the criteria
     * @param matcher to compare
     * @param amount
     * @return List
     */
    @JDIAction("Get at least {1} '{name}' table rows that match criteria")
    public List<D> dataRows(JFunc1<D, Boolean> matcher, int amount) {
        hasDataClass();
        List<D> result = new ArrayList<>();
        for (int i = 1; i <= count.get(); i++) {
            if (matcher.execute(dataRow(i)))
                result.add(dataRow(i));
            if (result.size() == amount)
                return result;
        }
        return result;
    }

    /**
     * Get first table row that match criteria
     * @param matcher to compare
     * @return List
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public List<L> lines(JFunc1<D, Boolean> matcher) {
        hasLineClass();
        return ifSelect(rows(), r -> matcher.execute(r.asData(dataClass)),
                r -> r.asLine(lineClass));
    }

    /**
     * Get all table rows that match criteria
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<D> dataRows(TableMatcher... matchers) {
        hasDataClass();
        if (matchers.length == 0) return allData();
        return map(rows(matchers), r -> r.asData(dataClass));
    }

    /**
     * Get all table rows that match criteria
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<L> lines(TableMatcher... matchers) {
        hasLineClass();
        return map(rows(matchers), l -> l.asLine(lineClass));
    }

    /**
     * Get all table rows
     * @return List
     */
    @JDIAction("Get all '{name}' rows")
    public List<D> allData() {
        hasDataClass();
        if (datas.isGotAll()) return datas.get().values();
        MapArray<String, D> result = new MapArray<>();
        for (int i = 1; i <= count.get(); i++)
            result.update(i+"", dataRow(i));
        datas.gotAll();
        return datas.set(result).values();
    }

    /**
     * Get all table rows
     * @return List
     */
    @JDIAction("Get all '{name}' rows")
    public List<L> allLines() {
        hasLineClass();
        if (lines.isGotAll()) return lines.get().values();
        MapArray<String, L> result = new MapArray<>();
        for (int i = 1; i <= count.get(); i++)
            result.add(i+"", line(i));
        lines.gotAll();
        return lines.set(result).values();
    }

    /**
     * Get table rows that match criteria in column
     * @param matcher to compare
     * @param column
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<D> filterData(Matcher<String> matcher, Column column) {
        hasDataClass();
        return map(filterRows(matcher, column), r -> r.asData(dataClass));
    }

    /**
     * Get table rows that match criteria in column
     * @param matcher to compare
     * @param column
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<L> filterLines(Matcher<String> matcher, Column column) {
        hasLineClass();
        return map(filterRows(matcher, column), l -> l.asLine(lineClass));
    }

    /**
     * Get table rows that match criteria in column
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<D> filterDatas(Pair<Matcher<String>, Column>... matchers) {
        hasDataClass();
        return map(filterRows(matchers), r -> r.asData(dataClass));
    }

    /**
     * Get table rows that match criteria in column
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<L> filterLines(Pair<Matcher<String>, Column>... matchers) {
        hasLineClass();
        return map(filterRows(matchers), l -> l.asLine(lineClass));
    }

    /**
     * Get table row that match criteria in column
     * @param matcher to compare
     * @param column
     * @return D refers to user data object
     */
    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public D dataRow(Matcher<String> matcher, Column column) {
        hasDataClass();
        return row(matcher, column).asData(dataClass);
    }

    /**
     * Get table row that match criteria in column
     * @param matcher to compare
     * @param column
     * @return L refers to table line object
     */
    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public L line(Matcher<String> matcher, Column column) {
        hasLineClass();
        return row(matcher, column).asLine(lineClass);
    }

    /**
     * Get table row that match criteria in column
     * @param matchers to compare
     * @return D refers to user data object
     */
    @JDIAction("Get '{name}' table row that match criteria")
    public D dataRow(Pair<Matcher<String>, Column>... matchers) {
        hasDataClass();
        return row(matchers).asData(dataClass);
    }

    /**
     * Get table row that match criteria in column
     * @param matchers to compare
     * @return L refers to table line object
     */
    @JDIAction("Get '{name}' table row that match criteria")
    public L line(Pair<Matcher<String>, Column>... matchers) {
        hasLineClass();
        return row(matchers).asLine(lineClass);
    }
    public <C extends HasValue> List<C> columnValues(String columnName, Class<C> cl) {
        WebList column = webColumn(columnName);
        List<C> result = column.map(el -> el.asEntity(cl));
        return result;
    }

    /**
     * Get table value
     * @return String
     */
    @Override
    @JDIAction("Get '{name}' table value")
    public String getValue() {
        if (dataClass == null && lineClass == null)
            super.getValue();
        getTable();
        String value = "||X||" + print(header.get(), "|") + "||" + LINE_BREAK;
        List<Object> rows = dataClass != null
            ? map(allData(), l -> l)
            : map(allLines(), l -> l);
        List<List<Field>> fields = map(rows, d -> getFieldsExact(d.getClass()));
        for (int i = 1; i <= count.get(); i++) {
            List<String> list = new ArrayList<>();
            for (String h : header()) {
                Field field = first(fields.get(i-1), f -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(f.getName())));
                if (field != null)
                    try {
                        Object fieldObj = field.get(rows.get(i-1));
                        String val = isInterface(field.getType(), HasValue.class)
                            ? ((HasValue)fieldObj).getValue()
                            : fieldObj.toString();
                        list.add(val);
                    } catch (Exception ex) { throw exception(ex, "Can't get field %s", field.getName()); }
            }
            value += "||" + i + "||" + print(map(list, TRIM_VALUE::execute), "|") + "||" + LINE_BREAK;
        }
        return value;
    }
    private D lineToData(L line) {
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
                if (namesEqual(getElementName(lineField), getElementName(dataField))) {
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
    @Override
    public void refresh() {
        super.refresh();
        datas.clear();
        lines.clear();
    }
    public void offCache() {
        super.offCache();
        datas.useCache(false);
        lines.useCache(false);
    }
    @Override
    public void setup(Field field) {
        super.setup(field);
        Type[] types = getGenericTypes(field);
        if (types.length != 2)
            return;
        try {
            lineClass = types[0].toString().equals("?") ? null : (Class<L>) types[0];
            dataClass = types[1].toString().equals("?") ? null : (Class<D>) types[1];
        } catch (Exception ex) {
            throw exception(ex, "Can't get DataTable %s data or entity class", getName());
        }
        if (header.hasValue()) return;
        List<Field> entityFields = new ArrayList<>();
        if (lineClass != null)
            entityFields.addAll(getFieldsExact(lineClass, f -> isInterface(f, HasValue.class)));
        if (dataClass != null)
            entityFields.addAll(asList(dataClass.getDeclaredFields()));
        if (entityFields.size() > 0) {
            List<String> headers = map(entityFields, field1 -> splitCamelCase(field1.getName()))
                .stream().distinct().collect(Collectors.toList());
            header.setFinal(headers);
            if (!size.hasValue())
                size.setFinal(headers.size());
        }
    }

    @Override
    public DataTableAssert<L, D>  is() {
        return new DataTableAssert<L, D>().set(this);
    }

    public DataTableAssert<L, D>  is(Matcher<? super List<D>> condition) {
        MatcherAssert.assertThat(allData(), condition);
        return is();
    }
    public DataTableAssert<L, D> assertThat(Matcher<? super List<D>> condition) {
        return is(condition);
    }
    public DataTableAssert<L, D> verify(Matcher<? super List<D>> condition) {
        assertSoft();
        return is(condition);
    }
}
