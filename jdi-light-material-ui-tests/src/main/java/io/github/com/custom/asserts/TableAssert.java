package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.table.BaseTableAssert;
import com.epam.jdi.light.common.JDIAction;
import io.github.com.custom.elements.complex.table.Table;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TableAssert extends BaseTableAssert<Table, TableAssert> {

    @JDIAction("Assert that '{name}' headers has exact '{0}'")
    public TableAssert exactHeader(List<String> headers) {
        jdiAssert(
                table().header().equals(headers) ?
                        "headers exactly as expected" :
                        "headers not exactly as expected",
                Matchers.is("headers exactly as expected"));
        return this;
    }
}
