package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.core.DataListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.asEntity;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataList<T extends ICoreElement, D> extends ListBase<T, DataListAssert<T,D>> {
    public Class<D> dataType;

    public DataList() {}
    public DataList(Class<T> type, Class<D> dataType) { initClass = type; this.dataType = dataType; }

    public D getData(String name) {
        return asEntity(get(name), dataType);
    }
    public D getData(Enum name) {
        return getData(getEnumValue(name));
    }
    public D getData(int index) {
        return asEntity(get(index), dataType);
    }

    public List<D> asData() {
        try {
            if (dataType == null) return null;
            List<T> elements = elements(0);
            return LinqUtils.map(elements, v -> asEntity(v, dataType));
        } catch (Exception ex) {
            throw exception(ex, "Can't get DataList data");
        }
    }
    @Override
    public String getValue() {
        return print(asData(), Object::toString);
    }
    
    @Override
    public DataListAssert<T, D> is() {
        refresh();
        return new DataListAssert<T, D>().set(this);
    }
    /**
     * Match passed value with elements
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that {name} data meet condition")
    public DataListAssert<T, D> isData(Matcher<? super List<D>> condition) {
        MatcherAssert.assertThat(asData(), condition);
        return is();
    }
    @JDIAction("Assert that {name} data meet condition")
    public DataListAssert<T, D> assertThat(Matcher<? super List<D>> condition) {
        return isData(condition);
    }
    public DataListAssert<T, D> verify(Matcher<? super List<D>> condition) {
        assertSoft();
        return isData(condition);
    }
    public void setup(Field field) {
        try {
            Type[] types = getGenericTypes(field);
            if (types.length == 0)
                throw exception("Can't setup DataList generic parameters for field '%s'. Actual 0 but expected 1 or 2",
                        field.getName());
            if (types.length > 2)
                throw exception("Can't setup DataList generic parameters for field '%s'. Actual more than %s but expected 1 or 2",
                        field.getName(), types.length);
                initClass = types[0].toString().equals("?") ? null : (Class<T>) types[0];
                dataType = types.length == 1 || types[1].toString().equals("?") ? null : (Class<D>) types[1];
        } catch (Exception ignore) { }
    }
    public int getIndex(String name) {
        int i = list().getStartIndex();
        if (list().map.hasValue() && list().isActualMap()) {
            for (Pair<String, UIElement> pair : list().map.get().pairs) {
                if (ELEMENT.namesEqual.execute(pair.key, name)) {
                    if (list().isActual(pair.value))
                        return i;
                    else break;
                }
                i++;
            }
        }
        for (UIElement element : list().elements(1)) {
            String title = elementTitle(element);
            if (ELEMENT.namesEqual.execute(title, name))
                return i;
            i++;
        }
        return -1;
    }
    @Override
    public List<String> values() {
        return LinqUtils.map(asData(), Object::toString);
    }
    public List<String> keys() {
        asData();
        return list().map.get().keys();
    }
}