package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.TableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.HasValue;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.assertSoft;
import static com.epam.jdi.light.elements.complex.table.Line.initLine;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;

public class Table extends BaseTable<Table> implements ISetup, HasValue {

    public TableAssert is() {
        return new TableAssert(this);
    }
    public TableAssert assertThat() {
        return is();
    }
    public TableAssert has() {
        return is();
    }
    public TableAssert waitFor() {
        return is();
    }
    public TableAssert shouldBe() { return is(); }
    public TableAssert verify() { assertSoft(); return is(); }
}
