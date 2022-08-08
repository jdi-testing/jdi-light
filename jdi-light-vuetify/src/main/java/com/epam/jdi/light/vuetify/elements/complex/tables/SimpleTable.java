package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.BaseTable;
import com.epam.jdi.light.vuetify.asserts.tables.SimpleTableAssert;

/**
 * To see an example of Simple Table web element please visit https://vuetifyjs.com/en/components/simple-tables/
 **/

public class SimpleTable extends BaseTable<SimpleTable, SimpleTableAssert> {

    public SimpleTableAssert is() {
        return new SimpleTableAssert().set(this);
    }

    @JDIAction("Get {name} column title")
    public String columnTitle(int colNum) {
        WebList titles = finds("//thead//th");
        return titles.get(colNum).text();
    }

    @JDIAction("Check that {name} is dark theme")
    public boolean isDark() {
        return core().attr("class").contains("--dark");
    }

    @JDIAction("Check that {name} is light theme")
    public boolean isLight() {
        return core().attr("class").contains("--light");
    }

    @JDIAction("Check that {name} has fixed header")
    public boolean hasFixedHeader() {
        return core().attr("class").contains("--fixed-header");
    }

    @JDIAction("Check that {name} has fixed height")
    public boolean hasFixedHeight() {
        return core().attr("class").contains("--fixed-height");
    }

}
