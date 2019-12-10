package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.IListSelector;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.LinqUtils.single;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ListAssert<A extends ListAssert, T, E extends IListSelector<T>> extends UISelectAssert<A, E>
        implements ITextAssert<A> {

    private List<T> list() {
        element.refresh();
        return element.elements(1).values();
    }
    /**
     * Check that all elements meet condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that each of '{name}' elements meet condition")
    public ListAssert<A, T, E> each(JFunc1<T, Boolean> condition) {
        jdiAssert(LinqUtils.all(list(), condition::execute), Matchers.is(true));
        return this;
    }
    @JDIAction("Assert that any of '{name}' elements meet condition")
    public ListAssert<A, T, E> any(JFunc1<T, Boolean> condition) {
        jdiAssert(LinqUtils.any(list(), condition::execute), Matchers.is(true));
        return this;
    }
    @JDIAction("Assert that only one of '{name}' elements meet condition")
    public ListAssert<A, T, E> onlyOne(JFunc1<T, Boolean> condition) {
        jdiAssert(single(list(), condition::execute), Matchers.is(notNullValue()));
        return this;
    }
    @JDIAction("Assert that none of '{name}' meet condition")
    public ListAssert<A, T, E> noOne(JFunc1<T, Boolean> condition) {
        jdiAssert(first(list(), condition::execute), Matchers.is(nullValue()));
        return this;
    }
}
