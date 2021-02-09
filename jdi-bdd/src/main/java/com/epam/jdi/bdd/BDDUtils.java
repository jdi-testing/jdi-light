package com.epam.jdi.bdd;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.*;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.tools.map.MapArray;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public final class BDDUtils {
    private BDDUtils() {
    }

    public static MapArray<String, String> getMapFromTable(DataTable table) {
        return new MapArray<>(table.asMap(String.class, String.class));
    }

    public static UIElement core(String name) {
        return getUI(name).core();
    }

    public static IsAssert isAssert(String name) {
        return getUI(name).core().is();
    }

    public static SelectedAssert selectedAssert(String name) {
        return ((HasAssert<SelectedAssert>) getAssert(name)).is();
    }

    public static CommonAssert uiAssert(String name) {
        return ((HasAssert<CommonAssert>) getAssert(name)).is();
    }

    public static UISelectAssert selectAssert(String name) {
        return ((HasAssert<UISelectAssert>) getAssert(name)).is();
    }

    static HasAssert getAssert(String name) {
        return getUI(name, HasAssert.class);
    }

    public static IsInput input(String name) {
        return getUI(name, IsInput.class);
    }

    public static Label label(String name) {
        return getUI(name, HasLabel.class).label();
    }

    public static ITextAssert textAssert(String name) {
        return (ITextAssert) getUI(name, HasAssert.class).is();
    }

    public static <T> List<T> getListFromData(List<List<T>> data) {
        if (isEmpty(data))
            return new ArrayList<>();
        if (data.size() == 1) {
            return data.get(0);
        }
        List<T> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            List<T> list = data.get(i);
            if (list.size() == 1) {
                result.add(getValue(list.get(0)));
            } else {
                throw exception("Expected list data but found 2D array: " + data);
            }
        }
        return result;
    }
    private static <T> T getValue(T value) {
        try {
            return value != null ? value : (T) "";
        } catch (Exception ex) {
            throw exception("Failed to cast null value to String. Empty values are allowed only for String lists");
        }
    }
}
