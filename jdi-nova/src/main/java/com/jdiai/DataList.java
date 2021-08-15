package com.jdiai;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.Timer;
import com.jdiai.annotations.ListLabel;
import com.jdiai.asserts.Conditions;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.interfaces.ISetup;
import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jswraper.JSEngine;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.jdiai.JDI.findConditions;
import static com.jdiai.asserts.Conditions.have;
import static com.jdiai.jswraper.JSWrappersUtils.getValueType;
import static com.jdiai.page.objects.PageFactoryUtils.getLocatorFromField;

public class DataList<T> implements List<T>, ISetup, HasCore, HasName {
    private JS core;
    protected Class<T> dataClass;
    protected String labelName;

    public JS getElement(String value) {
        Field labelField = getLabelField();
        By labelLocator = getLocatorFromField(labelField);
        if (labelLocator == null) {
            return null;
        }
        Function<JS, String> condition = getCondition(labelField, value, "#element#");
        return core().findFirst(labelLocator, condition);
    }

    private HasCore getLabelElement() {
        Field labelField = getLabelField();
        By labelLocator = getLocatorFromField(labelField);
        if (labelLocator == null) {
            throw new JDINovaException("Failed to get labelElement");
        }
        return core().find(labelLocator).setName(getName() + " " + labelField.getName());
    }
    private void haveLabelElement(String value) {
        Function<JS, String> condition = getCondition(getLabelField(), value, "#element#");
        getLabelElement().core().findFirst(condition).shouldHave(have(value));
    }

    public JS getElement(Enum<?> name) {
        return getElement(getEnumValue(name));
    }

    public JS getElement(int index) {
        return core().get(index);
    }

    public T get(String value) {
        haveLabelElement(value);
        return getElement(value).getEntity(dataClass);
    }

    public T get(Enum<?> name) {
        return get(getEnumValue(name));
    }

    @Override
    public T get(int index) {
        shouldHave(Conditions.size(s -> s > index));
        return getElement(index).getEntity(dataClass);
    }

    public void select(String value) {
        haveLabelElement(value);
        getLabelElement().core().get(value).click();
    }

    public void select(Enum<?> name) {
        select(getEnumValue(name));
    }

    public void select(int index) {
        getElement(index).click();
    }

    public void select(T element) {
        select(getLabelFieldValue(element));
    }

    private String getLabelFieldValue(T element) {
        try {
            Field labelField = getLabelField();
            return getValueField(labelField, element).toString();
        } catch (Exception ignore) {
            throw new JDINovaException("Failed to get labelField");
        }
    }

    private Function<JS, String> getCondition(Field labelField, String value, String elementName) {
        return el -> getValueType(labelField, elementName) + " === '" + value + "'";
    }
    private Field getLabelField() {
        if (labelName != null) {
            try {
                return dataClass.getField(labelName);
            } catch (Exception ex) {
                throw new JDINovaException("Failed to get labelField: " + labelName);
            }
        }
        Field[] allFields = dataClass.getDeclaredFields();
        if (allFields.length == 0) {
            throw new JDINovaException("Section should gave at least one field");
        }
        Field labelField = LinqUtils.first(allFields,
            f -> f.isAnnotationPresent(ListLabel.class));
        if (labelField == null) {
            labelField = Arrays.stream(allFields).filter(
                f -> isClass(f.getType(), String.class))
                .findFirst().orElseGet(() -> allFields[0]);
        }
        labelName = labelField.getName();
        return labelField;
    }

    public T last() {
        return LinqUtils.last(getList(1));
    }
    public T first() {
        return get(0);
    }
    public List<T> where(Function<T, Boolean> condition) {
        return LinqUtils.where(getList(0), condition);
    }
    public List<T> filter(Function<T, Boolean> condition) {
        return where(condition);
    }
    public <R> List<R> select(Function<T, R> transform) {
        return LinqUtils.select(getList(0), transform);
    }
    public <R> List<R> map(Function<T, R> transform) {
        return select(transform);
    }
    public T first(Function<T, Boolean> condition) {
        return LinqUtils.first(getList(condition), condition);
    }
    public T last(Function<T, Boolean> condition) {
        return LinqUtils.last(getList(condition), condition);
    }
    public void ifDo(Function<T, Boolean> condition, Consumer<T> action) {
        LinqUtils.ifDo(getList(1), condition, action);
    }
    public <R> List<R> ifSelect(Function<T, Boolean> condition, Function<T, R> transform) {
        return LinqUtils.ifSelect(getList(1), condition, transform);
    }
    public void foreach(Consumer<T> action) {
        LinqUtils.foreach(getList(1), action);
    }
    public boolean hasAny(Function<T, Boolean> condition) {
        return any(getList(0), condition);
    }
    public boolean all(Function<T, Boolean> condition) {
        return LinqUtils.all(getList(0), condition);
    }
    public List<T> slice(int from, int to) {
        return listCopy(getList(to - 1), from, to);
    }
    public List<T> slice(int from) {
        return listCopy(getList(from - 1), from);
    }
    public List<T> sliceTo(int to) {
        return listCopyUntil(getList(to - 1), to);
    }
    public void refresh() { clear(); }
    public <R> List<R> selectMany(Function<T, List<R>> func) {
        return LinqUtils.selectMany(getList(0), func);
    }
    @Override
    public int size() {
        return core().size();
    }
    @Override
    public boolean isEmpty() { return size() == 0; }
    // List methods
    @Override
    public boolean contains(Object o) {
        return getList(0).contains(o);
    }
    @Override
    public Iterator<T> iterator() {
        return getList(0).iterator();
    }
    @Override
    public Object[] toArray() {
        return getList(0).toArray();
    }
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return getList(0).toArray(a);
    }
    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return getList(c.size()).containsAll(c);
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() { }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public T remove(int index) {
        return getList(index - 1).remove(index);
    }
    @Override
    public int indexOf(Object o) {
        return getList(0).indexOf(o);
    }
    @Override
    public int lastIndexOf(Object o) {
        return getList(0).lastIndexOf(o);
    }
    @Override
    public ListIterator<T> listIterator() {
        return getList(0).listIterator();
    }
    @Override
    public ListIterator<T> listIterator(int index) {
        return getList(0).listIterator(index);
    }
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return slice(fromIndex, toIndex);
    }

    public List<T> getList(Function<T, Boolean> condition) {
        List<T> list;
        Timer timer = new Timer();
        do {
            list = core().getEntityList(dataClass);
        } while (!any(list, condition) && timer.isRunning());
        return any(list, condition) ? list : new ArrayList<>();
    }

    public List<T> getAll() {
        return getList(0);
    }

    public List<T> getList(int minAmount) {
        List<T> list;
        Timer timer = new Timer();
        do {
            list = core().getEntityList(dataClass);
        } while (list.size() < minAmount && timer.isRunning());
        if (list.size() < minAmount) {
            throw new JDINovaException("Failed to get list '%s' with minimum '%s' elements in %s seconds", getName(), minAmount, new DecimalFormat("#.##").format(timer.timePassedInMSec() / 1000));
        }
        return list;
    }

    public JS core() { return core; }

    public JS setCore(JS core) {
        this.core = core;
        this.core.setFilter(findConditions.isDisplayed);
        return core;
    }

    public void setup(Field field) {
        Type[] types = getGenericTypes(field);
        if (types.length != 1) {
            return;
        }
        try {
            dataClass = types[0].toString().equals("?") ? null : (Class<T>) types[0];
        } catch (Exception ex) {
            throw new JDINovaException(ex, "Can't get DataList '%s' data class", getName());
        }
    }

    public String getName() {
        return core().getName();
    }

    public DataList<T> setName(String name) {
        core().setName(name);
        return this;
    }

    public JSEngine engine() {
        return core().engine();
    }
}
