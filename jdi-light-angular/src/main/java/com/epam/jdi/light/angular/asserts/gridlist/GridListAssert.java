package com.epam.jdi.light.angular.asserts.gridlist;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.LinqUtils.first;
import static com.jdiai.tools.LinqUtils.single;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridList;
import com.epam.jdi.light.angular.elements.complex.gridlist.GridTile;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.jdiai.tools.LinqUtils;
import com.jdiai.tools.func.JFunc1;
import org.hamcrest.Matchers;

public class GridListAssert extends UISelectAssert<GridListAssert, GridList> {

    @JDIAction(value = "Assert that '{name}' has number of columns '{0}'", isAssert = true)
    public GridListAssert cols(int expectedCols) {
        jdiAssert(element().cols(), Matchers.is(expectedCols));
        return this;
    }

    @JDIAction("Assert that '{name}' has row's height '{0}'")
    public GridListAssert rowHeight(String expectedRowHeight) {
        jdiAssert(element().rowHeight(), Matchers.is(expectedRowHeight));
        return this;
    }

    @JDIAction("Assert that '{name}' has gutter size '{0}'")
    public GridListAssert gutterSize(String expectedGutterSize) {
        jdiAssert(element().gutterSize(), Matchers.is(expectedGutterSize));
        return this;
    }

    /**
     * Checks that Grid List has given size.
     *
     * @param size expected size
     * @return the same assert for chaining
     */
    @JDIAction(value = "Assert that '{name}' has size {0}", isAssert = true)
    public GridListAssert size(int size) {
        jdiAssert(element().tiles().size(), Matchers.is(size));
        return this;
    }

    /**
     * Checks that Grid List is empty.
     * @return the same assert for chaining
     */
    @JDIAction(value = "Assert that '{name}' is empty", isAssert = true)
    public GridListAssert empty() {
        jdiAssert(element().tiles(), Matchers.empty());
        return this;
    }

    /**
     * Checks that Grid List is not empty.
     * @return the same assert for chaining
     */
    @JDIAction(value = "Assert that  '{name}' is not empty", isAssert = true)
    public GridListAssert notEmpty() {
        jdiAssert(element().tiles(), not(Matchers.empty()));
        return this;
    }

    /**
     * Check that all elements meet condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that each of '{name}' elements meet condition")
    public GridListAssert each(JFunc1<GridTile, Boolean> condition) {
        jdiAssert(LinqUtils.all(element().tiles(), condition::execute), Matchers.is(true), "Not all elements meet condition");
        return this;
    }

    /**
     * Check that at least one element meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that any of '{name}' elements meet condition")
    public GridListAssert any(JFunc1<GridTile, Boolean> condition) {
        jdiAssert(LinqUtils.any(element().tiles(), condition::execute), Matchers.is(true), "None of elements meets condition");
        return this;
    }

    /**
     * Check that only one of elements meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that only one of '{name}' elements meet condition")
    public GridListAssert onlyOne(JFunc1<GridTile, Boolean> condition) {
        jdiAssert(single(element().tiles(), condition::execute), Matchers.is(notNullValue()));
        return this;
    }

    /**
     * Check that none of elements meets condition
     * @param condition to compare
     * @return DataListAssert
     */
    @JDIAction("Assert that none of '{name}' meet condition")
    public GridListAssert noOne(JFunc1<GridTile, Boolean> condition) {
        jdiAssert(first(element().tiles(), condition::execute), Matchers.is(nullValue()));
        return this;
    }
}
