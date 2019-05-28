package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.DataTableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.init.InitActions;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.getFieldsExact;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static java.util.Arrays.asList;

public class DataTable<L extends Section, D> extends Table {
    private Class<L> lineClass;
    private Class<D> dataClass;

    protected CacheAll<MapArray<String, L>> lines
        = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, D>> datas
        = new CacheAll<>(MapArray::new);

    /**
     * Get table row by the row number
     * @param rowNum
     * @return D refers to user data object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public D data(int rowNum) {
        if (!datas.get().has(rowNum+""))
            datas.get().add(rowNum+"", getLineData(row(rowNum)));
        return datas.get().get(rowNum+"");
    }

    /**
     * Get table row by the row number
     * @param rowNum
     * @return L refers to table line object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(int rowNum) {
        if (!lines.get().has(rowNum+""))
            lines.get().add(rowNum+"", row(rowNum).asLine(lineClass));
        return lines.get().get(rowNum+"");
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return D refers to user data object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public D data(String rowName) {
        return data(getRowIndexByName(rowName));
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return L refers to table line object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(String rowName) {
        return line(getRowIndexByName(rowName));
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return D refers to user data object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public D data(Enum rowName) {
        return data(getEnumValue(rowName));
    }

    /**
     * Get table row by the row name
     * @param rowName
     * @return L refers to table line object
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(Enum rowName) {
        return line(getEnumValue(rowName));
    }

    /**
     * Get first table row that match criteria
     * @param matchers to compare
     * @return D refers to user data object
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public D data(TableMatcher... matchers) {
        return getLineData(row(matchers));
    }

    /**
     * Get first table row that match criteria
     * @param matchers to compare
     * @return L refers to table line object
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public L line(TableMatcher... matchers) {
        return row(matchers).asLine(lineClass);
    }

    /**
     * Get first table row that match criteria
     * @param matcher to compare
     * @return D refers to user data object
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public D data(JFunc1<D, Boolean> matcher) {
        for (int i = 1; i <= count.get(); i++) {
            D data = data(i);
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
        for (int i = 1; i <= count.get(); i++) {
            if (matcher.execute(data(i)))
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
    public List<D> datas(JFunc1<D, Boolean> matcher) {
        return filter(allData(), matcher::execute);
    }

    /**
     * Get at least a specified number of rows of the table that meet the criteria
     * @param matcher to compare
     * @param amount
     * @return List
     */
    @JDIAction("Get at least {1} '{name}' table rows that match criteria")
    public List<D> datas(JFunc1<D, Boolean> matcher, int amount) {
        List<D> result = new ArrayList<>();
        for (int i = 1; i <= count.get(); i++) {
            if (matcher.execute(data(i)))
                result.add(data(i));
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
        return ifSelect(rows(), r -> matcher.execute(getLineData(r)),
                r -> r.asLine(lineClass));
    }

    /**
     * Get all table rows that match criteria
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<D> datas(TableMatcher... matchers) {
        if (matchers.length == 0) return allData();
        return map(rows(matchers), this::getLineData);
    }

    /**
     * Get all table rows that match criteria
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<L> lines(TableMatcher... matchers) {
        return map(rows(matchers), l -> l.asLine(lineClass));
    }

    /**
     * Get all table rows
     * @return List
     */
    @JDIAction("Get all '{name}' rows")
    public List<D> allData() {
        if (datas.isGotAll()) return datas.get().values();
        MapArray<String, D> result = new MapArray<>();
        for (int i = 1; i <= count.get(); i++)
            result.add(i+"", data(i));
        datas.gotAll();
        return datas.set(result).values();
    }

    /**
     * Get all table rows
     * @return List
     */
    @JDIAction("Get all '{name}' rows")
    public List<L> allLines() {
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
        return map(filterRows(matcher, column), this::getLineData);
    }

    /**
     * Get table rows that match criteria in column
     * @param matcher to compare
     * @param column
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<L> filterLines(Matcher<String> matcher, Column column) {
        return map(filterRows(matcher, column), l -> l.asLine(lineClass));
    }

    /**
     * Get table rows that match criteria in column
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<D> filterDatas(Pair<Matcher<String>, Column>... matchers) {
        return map(filterRows(matchers), this::getLineData);
    }

    /**
     * Get table rows that match criteria in column
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<L> filterLines(Pair<Matcher<String>, Column>... matchers) {
        return map(filterRows(matchers), l -> l.asLine(lineClass));
    }

    /**
     * Get table row that match criteria in column
     * @param matcher to compare
     * @param column
     * @return D refers to user data object
     */
    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public D data(Matcher<String> matcher, Column column) {
        return getLineData(row(matcher, column));
    }

    /**
     * Get table row that match criteria in column
     * @param matcher to compare
     * @param column
     * @return L refers to table line object
     */
    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public L line(Matcher<String> matcher, Column column) {
        return row(matcher, column).asLine(lineClass);
    }

    /**
     * Get table row that match criteria in column
     * @param matchers to compare
     * @return D refers to user data object
     */
    @JDIAction("Get '{name}' table row that match criteria")
    public D data(Pair<Matcher<String>, Column>... matchers) {
        return getLineData(row(matchers));
    }

    /**
     * Get table row that match criteria in column
     * @param matchers to compare
     * @return L refers to table line object
     */
    @JDIAction("Get '{name}' table row that match criteria")
    public L line(Pair<Matcher<String>, Column>... matchers) {
        return row(matchers).asLine(lineClass);
    }

    /**
     * Get table value
     * @return String
     */
    @Override
    @JDIAction("Get '{name}' table value")
    public String getValue() {
        getTable();
        String value = "||X||" + print(header.get(), "|") + "||" + LINE_BREAK;
        List<D> data = allData();
        for (int i = 1; i <= count.get(); i++) {
            D instance = data.get(i-1);
            List<String> list = new ArrayList<>();
            List<Field> fields = getFieldsExact(instance.getClass());
            for (String h : header()) {
                Field field = first(fields, f -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(f.getName())));
                if (field != null)
                    try {
                        list.add(field.get(instance).toString());
                    } catch (Exception ex) { throw exception("Can't get field %s", field.getName()); }
            }
            value += "||" + i + "||" + print(map(list, TRIM_VALUE::execute), "|") + "||" + LINE_BREAK;
        }
        return value;
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
        Type[] types = InitActions.getGenericTypes(field);
        if (types.length != 2)
            return;
        try {
            lineClass = types[0].toString().equals("?") ? null : (Class<L>) types[0];
            dataClass = types[1].toString().equals("?") ? null : (Class<D>) types[1];
        } catch (Exception ex) {
            throw exception("Can't get DataTable %s data or entity class", getName());
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

    private D getLineData(Line row) {
        L line = row.asLine(lineClass);
        List<Field> fields = getFieldsExact(line.getClass(), f -> isInterface(f, HasValue.class));
        MapArray<String, String> map = new MapArray<>(fields,
            Field::getName, f -> ((HasValue)f.get(line)).getValue());
        return row.asData(dataClass, map);
    }

    @Override
    public DataTableAssert<D> is() {
        return new DataTableAssert<>(this);
    }
    @Override
    public DataTableAssert<D> assertThat() {
        return is();
    }
    @Override
    public DataTableAssert<D> has() {
        return is();
    }
    @Override
    public DataTableAssert<D> waitFor() {
        return is();
    }
    @Override
    public DataTableAssert<D> shouldBe() {
        return is();
    }
    public DataTableAssert<D> verify() {
        assertSoft();
        return is();
    }
}
