package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.complex.table.TableMatcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TableAssert extends BaseTableAssert<Table, TableAssert> {
    public Compare exact(int count, String ... messages) {
        return new Compare(count, this, true, messages);
    }
    public Compare atLeast(int count, String ... messages) {
        return new Compare(count, this, false, messages);
    }
    public Compare no(String ... messages) {
        return exact(0, messages);
    }
    public Compare all(String ... messages) {
        return exact(table().count(), messages);
    }
    public Compare onlyOne(String ... messages) {
        return exact(1, messages);
    }

    public class Compare {
        public int count;
        public String name;
        public String failElement;
        public String type;
        TableAssert tAssert;
        boolean exact;
        String[] messages;
        
        private Compare(int count, TableAssert tAssert, boolean exact, String ... messages) {
            this.count = count;
            this.tAssert = tAssert;
            this.exact = exact;
            this.type = exact ? "exactly" : "at least";
            this.name = tAssert.name;
            this.failElement = tAssert.failElement;
            this.messages = messages;
        }

        /**
         * Make sure that the table has at least a certain number of the specified line
         * @param matchers to compare
         */
        @JDIAction("Assert that '{name}' has at least '{0}' rows that {0}")
        public TableAssert rows(TableMatcher... matchers) {
            jdiAssert(TABLE_MATCHER.execute(element, matchers).size(),
                    greaterThan(table().header().size()*count-1), messages);
            return tAssert;
        }
    }
}
