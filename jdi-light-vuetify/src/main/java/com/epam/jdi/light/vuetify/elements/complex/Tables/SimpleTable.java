package com.epam.jdi.light.vuetify.elements.complex.Tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.BaseTable;
import com.epam.jdi.light.vuetify.asserts.SimpleTableAssert;
import com.epam.jdi.light.vuetify.elements.enums.TableTestData;

/**
 * To see an example of Simple Table web element please visit https://vuetifyjs.com/en/components/simple-tables/
 **/

public class SimpleTable extends BaseTable<SimpleTable, SimpleTableAssert> {

    public SimpleTableAssert is() {
        return new SimpleTableAssert().set(this);
    }

    @JDIAction("Get {name} first column required element")
    public String firstColumnElement(int elNum) {
        return this.getColumn(1).get(elNum).text();
    }

    @JDIAction("Get {name} first column required element")
    public String firstColumnElement(TableTestData data) {
        return this.getColumn(1).get(data.value()).text();
    }

    @JDIAction("Get {name} second column required element")
    public String secondColumnElement(int elNum) {
        return this.getColumn(2).get(elNum).text();
    }

    @JDIAction("Get {name} second column required element")
    public String secondColumnElement(TableTestData data) {
        return this.getColumn(2).get(data.value()).text();
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
