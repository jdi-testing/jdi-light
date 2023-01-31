package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.tables.DataIteratorAssert;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.List;

/**
 * To see an example of Data Iterator web element please visit https://vuetifyjs.com/en/components/data-iterators/
 */

public class DataIterator extends UIBaseElement<DataIteratorAssert> implements HasTheme, IsText {
    private static final String TITLE = "[class*='title']";
    private static final String LIST_ITEM = "[role = 'listitem']";
    private static final String TABLE = ".v-card";

    public WebList dataIteratorElements() {
        return finds("[class^='col']");
    }

    public Integer getColumnsValue() {
        return dataIteratorElements().size();
    }

    @JDIAction("Get '{name}' column")
    public WebList getColumn(int colNum) {
        return dataIteratorElements().get(colNum).finds(LIST_ITEM);
    }

    @JDIAction("Get '{name}' column title")
    public String getColumnTitle(int colNum) {
        return dataIteratorElements().get(colNum).find(TITLE).getText();
    }

    @JDIAction("Get '{name}' iterator")
    public UIElement table() {
        return find(TABLE);
    }

    @JDIAction("Get '{name}' header")
    public UIElement tableHeader() {
        return find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' header")
    public String getTableHeader() {
        return tableHeader().getText();
    }

    @JDIAction("Get '{name}' footer")
    public UIElement tableFooter() {
        return find(".v-toolbar__title.subheading");
    }

    @JDIAction("Get '{name}' footer")
    public String getTableFooter() {
        return tableFooter().getText();
    }

    @JDIAction("Get '{name}' header theme")
    public String headerTheme() {
        return tableHeader().find("//ancestor::header[contains(@class, v-toolbar)]").classLike("theme--");
    }

    @JDIAction("Get '{name}' footer theme")
    public String footerTheme() {
        return tableFooter().find("//ancestor::header[contains(@class, v-toolbar)]").classLike("theme--");
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return table().classLike("theme--");
    }

    @Override
    public DataIteratorAssert is() {
        DataIteratorAssert dataIteratorAssert = new DataIteratorAssert();
        dataIteratorAssert.set(this);
        return dataIteratorAssert;
    }

    @Override
    public DataIteratorAssert assertThat() {
        return is();
    }

    @Override
    public DataIteratorAssert has() {
        return is();
    }
}
