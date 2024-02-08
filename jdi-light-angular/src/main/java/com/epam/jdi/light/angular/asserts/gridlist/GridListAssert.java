package com.epam.jdi.light.angular.asserts.gridlist;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.jdiai.tools.LinqUtils.first;
import static com.jdiai.tools.LinqUtils.single;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridList;
import com.epam.jdi.light.angular.elements.complex.gridlist.GridTile;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.jdiai.tools.LinqUtils;
import com.jdiai.tools.func.JFunc1;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GridListAssert extends UISelectAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridListAssert cols(int expectedCols) {
        jdiAssert(element().cols(), Matchers.is(expectedCols),
            String.format("\nActual number of columns in Grid List: '%s'\n" +
                "is not equal to expected: '%s'", element().cols(), expectedCols));
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
        jdiAssert(element().tiles().isEmpty(), Matchers.is(true), "List is not empty");
        return this;
    }

    /**
     * Checks that Grid List is not empty.
     * @return the same assert for chaining
     */
    @JDIAction(value = "Assert that '{name}' is not empty", isAssert = true)
    public GridListAssert notEmpty() {
        jdiAssert(element().tiles().isEmpty(), Matchers.is(false), "List is empty");
        return this;
    }

    /**
     * Checks that list contains only items with given texts.
     *
     * @param itemTexts expected items
     * @return the same assert for chaining
     */
    @JDIAction(value = "Assert that '{name}' contains all items with texts '{0}'", isAssert = true)
    public GridListAssert itemsWithTexts(String... itemTexts) {
        if (itemTexts.length == 0) {
            throw runtimeException("Set containing expected item names should not be empty");
        } else {
            List<String> expList = Arrays.asList(itemTexts);
            List<GridTile> items = element().tiles();
            String[] notExistsTexts = items.stream()
                .map(el -> el.core().text())
                .filter(s -> !expList.contains(s))
                .toArray(String[]::new);
            jdiAssert(notExistsTexts, Matchers.emptyArray());
            return this;
        }
    }

    /**
     * Checks that Grid List contains given texts in tiles.
     *
     * @param itemTexts expected items
     * @return the same assert for chaining
     */
    @JDIAction(value = "Assert that '{name}' contains items with texts '{0}'", isAssert = true)
    public GridListAssert textsInItems(String... itemTexts) {
        if (itemTexts.length == 0) {
            throw runtimeException("Set containing expected item names should not be empty");
        } else {
            List<String> expList = Arrays.asList(itemTexts);
            List<String> items = element().tiles().stream().map(GridTile::text).collect(Collectors.toList());
            String[] notExistsTexts = expList.stream()
                .filter(s -> !items.contains(s))
                .toArray(String[]::new);
            jdiAssert(notExistsTexts, Matchers.emptyArray());
            return this;
        }
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
