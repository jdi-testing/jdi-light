package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.TableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.init.InitActions;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.LinqUtils.*;

public class DataTable<E extends Section, D> extends Table {
    private Class<E> entityClass;
    private Class<D> dataClass;

    @JDIAction("Get row '{0}' for '{name}' table")
    public D data(int rowNum) {
        return row(rowNum).asData(dataClass);
    }
    @JDIAction("Get row '{0}' for '{name}' table")
    public E entity(int rowNum) {
        return row(rowNum).asEntity(entityClass);
    }

    @JDIAction("Get first '{name}' table row that match criteria")
    public D data(JFunc1<D, Boolean> filter) {
        return row(toMatcher(filter)).asData(dataClass);
    }
    //TODO rewrite
    private TableMatcher toMatcher(JFunc1<D, Boolean> filter) {
        return new TableMatcher("", Column.column(1), "");
    }
    @JDIAction("Get first '{name}' table row that match criteria")
    public E entity(TableMatcher... matchers) {
        return row(matchers).asData(entityClass);
    }
    
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<D> datas(TableMatcher... matchers) {
        return map(rows(matchers), l -> l.asData(dataClass));
    }
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<E> entities(TableMatcher... matchers) {
        return map(rows(matchers), l -> l.asData(entityClass));
    }
    @JDIAction("Get all '{name}' rows")
    public List<D> allData() {
        return map(rows(), l -> l.asData(dataClass));
    }
    @JDIAction("Get all '{name}' rows")
    public List<E> allEntities() {
        return map(rows(), l -> l.asData(entityClass));
    }

    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<D> filterData(Matcher<String> matcher, Column column) {
        return map(filterRows(matcher, column), l -> l.asData(dataClass));
    }
    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<E> filterEntities(Matcher<String> matcher, Column column) {
        return map(filterRows(matcher, column), l -> l.asData(entityClass));
    }

    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<Line> filterRows(Pair<Matcher<String>, Column>... matchers) {
        return filter(rows(), line ->
                all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }


    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public Line row(Matcher<String> matcher, Column column) {
        return first(rows(),
                line -> matcher.matches(line.get(column.getIndex(header()))));
    }
    @JDIAction("Get '{name}' table row that match criteria")
    public Line row(Pair<Matcher<String>, Column>... matchers) {
        return first(rows(), line ->
                all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }

    public TableAssert is() {
        return new TableAssert(this);
    }
    public TableAssert assertThat() {
        return is();
    }

    @Override
    public void setup(Field field) {
        super.setup(field);
        Type[] types = InitActions.getGenericTypes(field);
        if (types.length != 2)
            return;
        try {
            entityClass = types[0].toString().equals("?") ? null : (Class<E>) types[0];
            dataClass = types[1].toString().equals("?") ? null : (Class<D>) types[1];
        } catch (Exception ex) {
            throw exception("Can't get DataTable %s data or entity class", getName());
        }
        Type type = null;
        if (entityClass != null)
            type = types[0];
        else if (dataClass != null)
            type = types[1];
        if (type != null) {
            List<String> entityFields = map(type.getClass().getDeclaredFields(),
                    Field::getName);
            if (entityFields.size() > 0)
                header.setForce(entityFields);
        }
    }
}
