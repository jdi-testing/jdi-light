package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.TableAssert;
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

    @JDIAction("Get row '{0}' for '{name}' table")
    public D data(int rowNum) {
        return getLineData(row(rowNum));
    }
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(int rowNum) {
        return row(rowNum).asLine(lineClass);
    }

    @JDIAction("Get row '{0}' for '{name}' table")
    public D data(String rowName) {
        return getLineData(row(rowName));
    }
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(String rowName) {
        return row(rowName).asLine(lineClass);
    }

    @JDIAction("Get row '{0}' for '{name}' table")
    public D data(Enum rowName) {
        return data(getEnumValue(rowName));
    }
    @JDIAction("Get row '{0}' for '{name}' table")
    public L line(Enum rowName) {
        return row(rowName).asLine(lineClass);
    }

    @JDIAction("Get first '{name}' table row that match criteria")
    public D data(TableMatcher... matchers) {
        return getLineData(row(matchers));
    }
    @JDIAction("Get first '{name}' table row that match criteria")
    public L line(TableMatcher... matchers) {
        return row(matchers).asLine(lineClass);
    }

    @JDIAction("Get first '{name}' table row that match criteria")
    public D data(JFunc1<D, Boolean> matcher) {
        for (int i = 1; i <= count.get(); i++) {
            D data = getLineData(row(i));
            if (matcher.execute(data))
                return data;
        }
        return null;
    }

    @JDIAction("Get first '{name}' table row that match criteria")
    public L line(JFunc1<D, Boolean> matcher) {
        for (int i = 1; i <= count.get(); i++) {
            if (matcher.execute(data(i)))
                return line(i);
        }
        return null;
    }

    @JDIAction("Get first '{name}' table row that match criteria")
    public List<D> datas(JFunc1<D, Boolean> matcher) {
        return filter(allData(), matcher::execute);
    }
    @JDIAction("Get first '{name}' table row that match criteria")
    public List<L> lines(JFunc1<D, Boolean> matcher) {
        return ifSelect(rows(), r -> matcher.execute(getLineData(r)),
                r -> r.asLine(lineClass));
    }

    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<D> datas(TableMatcher... matchers) {
        return map(rows(matchers), this::getLineData);
    }
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<L> lines(TableMatcher... matchers) {
        return map(rows(matchers), l -> l.asLine(lineClass));
    }

    @JDIAction("Get all '{name}' rows")
    public List<D> allData() {
        return map(rows(), this::getLineData);
    }
    @JDIAction("Get all '{name}' rows")
    public List<L> allLines() {
        return map(rows(), l -> l.asLine(lineClass));
    }

    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<D> filterData(Matcher<String> matcher, Column column) {
        return map(filterRows(matcher, column), this::getLineData);
    }
    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<L> filterLines(Matcher<String> matcher, Column column) {
        return map(filterRows(matcher, column), l -> l.asLine(lineClass));
    }

    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<D> filterDatas(Pair<Matcher<String>, Column>... matchers) {
        return map(filterRows(matchers), this::getLineData);
    }
    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<L> filterLines(Pair<Matcher<String>, Column>... matchers) {
        return map(filterRows(matchers), l -> l.asLine(lineClass));
    }

    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public D data(Matcher<String> matcher, Column column) {
        return getLineData(row(matcher, column));
    }

    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public L line(Matcher<String> matcher, Column column) {
        return row(matcher, column).asLine(lineClass);
    }
    @JDIAction("Get '{name}' table row that match criteria")
    public D data(Pair<Matcher<String>, Column>... matchers) {
        return getLineData(row(matchers));
    }
    @JDIAction("Get '{name}' table row that match criteria")
    public L line(Pair<Matcher<String>, Column>... matchers) {
        return row(matchers).asLine(lineClass);
    }

    public TableAssert is() {
        return new TableAssert(this);
    }
    public TableAssert assertThat() {
        return is();
    }
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
}
