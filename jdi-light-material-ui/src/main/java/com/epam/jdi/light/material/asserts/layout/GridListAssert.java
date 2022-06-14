package com.epam.jdi.light.material.asserts.layout;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.GridList;
import org.hamcrest.Matchers;

/**
 * Assertions for {@link GridList}.
 */
public class GridListAssert extends UISelectAssert<GridListAssert, GridList> implements HasAssert<GridListAssert> {

    /**
     * Check if element has required title or not
     *
     * @param index item to check
     * @param reqTitle required title
     * @return {@link GridListAssert}
     */
    @JDIAction("Assert that '{name}' element {0} has title '{1}'")
    public GridListAssert title(int index, String reqTitle) {
        jdiAssert(element().title(index), Matchers.is(reqTitle));
        return this;
    }

    /**
     * Checks if element item has image or not
     *
     * @param index item to check
     * @return {@link GridListAssert}
     */
    @JDIAction("Assert that '{name}' element {0} has image")
    public GridListAssert image(int index) {
        jdiAssert(element().hasImage(index) ? "has image" : "hasn't image", Matchers.is("has image"));
        return this;
    }

    /**
     * Checks if element item has alternative image text or not
     *
     * @param index item to check
     * @param altText required text
     * @return {@link GridListAssert}
     */
    @JDIAction("Assert that '{name}' image {0} has alternative name '{1}'")
    public GridListAssert alternativeImageText(int index, String altText) {
        jdiAssert(element().image(index).alt(), Matchers.is(altText));
        return this;
    }
}
