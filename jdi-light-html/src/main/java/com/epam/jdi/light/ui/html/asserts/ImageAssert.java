package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Image;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ImageAssert extends UIAssert<ImageAssert, Image> {
    @JDIAction("Assert that '{name}' src {0}")
    public ImageAssert src(Matcher<String> condition) {
        jdiAssert(element().src(), condition);
        return this;
    }
    public ImageAssert src(String src) { return src(Matchers.is(src)); }
    @JDIAction("Assert that '{name}' fileName {0}")
    public ImageAssert fileName(Matcher<String> condition) {
        jdiAssert(element().fileName(), condition);
        return this;
    }
    public ImageAssert fileName(String src) { return fileName(Matchers.is(src)); }

    @JDIAction("Assert that '{name}' alt {0}")
    public ImageAssert alt(Matcher<String> condition) {
        jdiAssert(element().alt(), condition);
        return this;
    }
    public ImageAssert alt(String alt) { return alt(Matchers.is(alt)); }

    @JDIAction("Assert that '{name}' height {0}")
    public ImageAssert height(Matcher<Integer> condition) {
        jdiAssert(element().height(), condition);
        return this;
    }
    public ImageAssert height(int height) { return height(Matchers.is(height)); }

    @JDIAction("Assert that '{name}' width {0}")
    public ImageAssert width(Matcher<Integer> condition) {
        jdiAssert(element().width(), condition);
        return this;
    }
    public ImageAssert width(int width) { return width(Matchers.is(width)); }
}