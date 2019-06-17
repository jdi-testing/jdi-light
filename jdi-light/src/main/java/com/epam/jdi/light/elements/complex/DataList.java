package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.core.DataListAssert;
import com.epam.jdi.light.asserts.core.ListAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.map.MapArray;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.create;
import static com.epam.jdi.light.elements.init.InitActions.getGenericTypes;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.String.format;

public class DataList<T extends Section, E> extends UIBaseElement<DataListAssert<T, E>>
        implements IList<T>, SetValue, ISetup, ISelector {

    private CacheValue<MapArray<String, T>> map = new CacheValue<>(MapArray::new);
    public JList<T> list() {
        JList<T> list = new JList<>(core().getLocator());
        list.setParent(parent);
        list.setName(getName() + " list");
        return list;
    }
    public Class<E> dataType;

    public DataList() {}
    public DataList(Class<T> type) { initClass = type; }

    private boolean actualValuesValue() {
        return elements.hasValue() && elements.get().size() > 0 && isActual(elements.get().get(0));
    }
    private boolean actualMapValue() {
        return map.hasValue() && map.get().size() > 0 && isActual(map.get().get(0).value);
    }
    /**
     * @param minAmount
     * @return List
     */
    @JDIAction(level = DEBUG) @Override
    public List<T> elements(int minAmount) {
        if (actualValuesValue())
            return elements.get();
        if (actualMapValue())
            return map.get().values();
        elements.set(super.elements(minAmount));
        return elements.get();
    }

    /**
     * Clear
     */
    @JDIAction(level = DEBUG) @Override
    public void refresh() {
        map.clear();
        elements.clear();
    }
    
    protected MapArray<String, T> getMap(int minAmount) {
        if (actualMapValue())
            return map.get();
        List<WebElement> els = core().getList(minAmount);
        return map.set(elements.hasValue()
            ? new MapArray<>(
                LinqUtils.select(els, this::elementTitle),
                elements.get())
            : new MapArray<>(els,
                this::elementTitle,
                this::initElement));
    }

    public E getData(String name) {
        return get(name).asEntity(dataType);
    }
    public E getData(Enum name) {
        return getData(getEnumValue(name));
    }
    public E getData(int index) {
        return get(index).asEntity(dataType);
    }

    public List<E> asData() {
        try {
            if (dataType == null) return null;
            return getMap(1).select((k, v) -> UIUtils.asEntity(v, dataType));
        } catch (Exception ex) {
            throw exception("Can't get DataList data" + LINE_BREAK + ex.getMessage());
        }
    }

    /**
     * Get the element by the value
     * @param value
     */
    @JDIAction(level = DEBUG)
    public T get(String value) {
        MapArray<String, T> map = getMap(1);
        if (!map.keys().contains(value))
            map.add(value, super.get(value));
        return map.get(value);
    }

    /**
     * @param index
     */
    @JDIAction(level = DEBUG)
    public T get(int index) {
        T result = super.get(index);
        int elLength = elements.get().size();
        int mapLength = map.get().size();
        if (elLength > mapLength)
            for (int i = mapLength; i < elLength; i ++) {
                T el = elements.get().get(i);
                map.get().add(el.getText(), el);
            }
        if (elLength < mapLength)
            map.get().clear();
        return result;
    }

    /**
     * Scroll to list elements
     */
    @JDIAction("Scroll to list elements")
    public void showAll() {
        int size;
        do {
            size = size();
            get(size-1).show();
            refresh();
        } while (size < size());
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }

    public String getValue() {
        return PrintUtils.print(LinqUtils.map(asData(), Object::toString));
    }

    /**
     * Match passed value with elements
     * @param condition to compare
     * @return UIListAsserts
     */
    /*@JDIAction("Assert that {name} data meet condition")
    public DataListAssert<T, E> is(Matcher<? super List<E>> condition) {
        MatcherAssert.assertThat(asData(), condition);
        return is();
    }*/
    public UISelectAssert<UISelectAssert, DataList<T,E>> is() {
        offCache();
        return new DataListAssert<>(this, () -> { clear(); return asData(); }, core().toError(), failElement()).set(this);
    }/*
    @Override
    public DataListAssert<T, E> is() {
        return new DataListAssert<>(this, () -> { clear(); return asData(); }, core().toError(), failElement());
    }*/
/*
    public DataListAssert<T, E> assertThat(Matcher<? super List<E>> condition) {
        return is(condition);
    }
    public DataListAssert<T, E> has(Matcher<? super List<E>> condition) {
        return is(condition);
    }
    public DataListAssert<T, E> waitFor(Matcher<? super List<E>> condition) {
        return is(condition);
    }
    public DataListAssert<T, E> shouldBe(Matcher<? super List<E>> condition) {
        return is(condition);
    }
    public DataListAssert<T, E> verify(Matcher<? super List<E>> condition) {
        assertSoft();
        return is(condition);
    }*/
    public void setup(Field field) {
        try {
            Type[] types = getGenericTypes(field);
            if (types.length == 0)
                throw exception("Can't setup DataList generic parameters for field '%s'. Actual 0 but expected 1 or 2",
                        field.getName());
            if (types.length > 2)
                throw exception("Can't setup DataList generic parameters for field '%s'. Actual more than %s but expected 1 or 2",
                        field.getName(), types.length);
            initClass = types[0].toString().equals("?") ? null : (Class<T>)types[0];
            dataType = types.length == 1 || types[1].toString().equals("?") ? null : (Class<E>)types[1];
        } catch (Exception ex) {
            throw exception("Can't instantiate List<%s, %s> field '%s'", initClass == null
                            ? "?" : initClass.getSimpleName(), dataType == null ? "?" : dataType.getSimpleName(),
                    field.getName());
        }
    }
}