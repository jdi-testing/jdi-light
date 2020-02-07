package com.epam.jdi.mobile.elements.complex;

import com.epam.jdi.mobile.asserts.core.DataListAssert;
import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.interfaces.base.IListBase;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.PrintUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.mobile.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.common.Exceptions.safeException;
import static com.epam.jdi.mobile.common.UIUtils.asEntity;
import static com.epam.jdi.mobile.elements.init.InitActions.getGenericTypes;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataList<T extends IListBase, D> extends ListBase<T, DataListAssert<T,D>> {
    public Class<D> dataType;

    public DataList() {}
    public DataList(Class<T> type) { initClass = type; }

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
            return LinqUtils.map(elements(1).values(), v -> asEntity(v, dataType));
        } catch (Exception ex) {
            throw exception(ex, "Can't get DataList data");
        }
    }
    @Override
    public String getValue() {
        return PrintUtils.print(LinqUtils.map(asData(), Object::toString));
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
            initClass = types[0].toString().equals("?") ? null : (Class<T>)types[0];
            dataType = types.length == 1 || types[1].toString().equals("?") ? null : (Class<D>)types[1];
        } catch (Exception ex) {
            throw exception(ex, "Can't instantiate List<%s, %s> field '%s'", initClass == null
                            ? "?" : initClass.getSimpleName(), dataType == null ? "?" : dataType.getSimpleName(),
                    field.getName());
        }
    }
}