package com.epam.jdi.bdd;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.*;
import com.epam.jdi.light.elements.common.*;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.tools.map.MapArray;
import cucumber.api.DataTable;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public final class BDDUtils {
    private BDDUtils() {
    }

    public static MapArray<String, String> getMapFromTable(DataTable table) {
        return new MapArray<>(table.getGherkinRows(),
                r -> r.getCells().get(0), r -> r.getCells().get(1));
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
}
