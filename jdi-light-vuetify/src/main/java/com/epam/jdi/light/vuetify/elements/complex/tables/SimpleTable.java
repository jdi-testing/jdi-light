package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.BaseTable;
import com.epam.jdi.light.vuetify.asserts.tables.SimpleTableAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;

/**
 * To see an example of Simple Table web element please visit https://vuetifyjs.com/en/components/simple-tables/
 **/

public class SimpleTable<T extends SimpleTable<T, A>, A extends SimpleTableAssert<T, A>>
    extends BaseTable<T, A> implements IsDense, HasTheme {

    @Override
    public A is() {
        return (A) new SimpleTableAssert().set(this);
    }

    @Override
    public A has() {
        return this.is();
    }

    @JDIAction("Get {name}'s height")
    public int height() {
        return core().getSize().getHeight();
    }

    @JDIAction("Get if{name} is dark theme")
    public boolean isDark() {
        return core().attr("class").contains("--dark");
    }

    @JDIAction("Get if{name} is light theme")
    public boolean isLight() {
        return core().attr("class").contains("--light");
    }

    @JDIAction("Get if{name} has fixed header")
    public boolean hasFixedHeader() {
        return core().hasClass("v-data-table--fixed-header");
    }

    @JDIAction("Get if{name} has fixed height")
    public boolean hasFixedHeight() {
        return core().hasClass("v-data-table--fixed-height");
    }

}
