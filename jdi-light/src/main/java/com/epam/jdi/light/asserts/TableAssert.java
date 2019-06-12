package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.complex.table.TableMatcher;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static org.hamcrest.Matchers.greaterThan;

public class TableAssert extends BaseTableAssert<Table, TableAssert> {

    public TableAssert(Table table) {
        super(table);
    }

    public Compare exact(int count) {
        return new Compare(count, this, true);
    }
    public Compare atLeast(int count) {
        return new Compare(count, this, false);
    }
    public Compare no() {
        return exact(0);
    }
    public Compare all() {
        return exact(table().count());
    }
    public Compare onlyOne() {
        return exact(1);
    }

    public class Compare {
        public int count;
        public String name;
        public String type;
        TableAssert tAssert;
        boolean exact;
        private Compare(int count, TableAssert tAssert, boolean exact) {
            this.count = count;
            this.tAssert = tAssert;
            this.exact = exact;
            this.type = exact ? "exactly" : "at least";
            this.name = tAssert.name;
        }

        /**
         * Make sure that the table has at least a certain number of the specified line
         * @param matchers to compare
         */
        @JDIAction("Assert that '{name}' has at least '{0}' rows that {0}")
        public TableAssert rows(TableMatcher... matchers) {
            jdiAssert(TABLE_MATCHER.execute(table, matchers).size(),
                    greaterThan(table().header().size()*count-1));
            return tAssert;
        }
    }
}
