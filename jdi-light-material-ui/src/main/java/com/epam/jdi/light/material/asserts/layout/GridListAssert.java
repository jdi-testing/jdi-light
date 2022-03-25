package com.epam.jdi.light.material.asserts.layout;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.GridList;
import org.hamcrest.Matchers;

public class GridListAssert extends UISelectAssert<GridListAssert, GridList> implements HasAssert<GridListAssert> {

    @JDIAction("Assert that '{name}' element {0} has title '{1}'")
    public GridListAssert title(int elNum, String reqTitle) {
        jdiAssert(element().getTitle(elNum), Matchers.is(reqTitle));
        return this;
    }

    @JDIAction("Assert that '{name}' element {0} has image")
    public GridListAssert image(int elNum) {
        jdiAssert(element().hasImage(elNum) ? "has image" : "hasn't image", Matchers.is("has image"));
        return this;
    }

    @JDIAction("Assert that '{name}' image {0} has alternative name '{1}'")
    public GridListAssert altImgName(int elNum, String reqAltName) {
        jdiAssert(element().getAltImgName(elNum), Matchers.is(reqAltName));
        return this;
    }
}
