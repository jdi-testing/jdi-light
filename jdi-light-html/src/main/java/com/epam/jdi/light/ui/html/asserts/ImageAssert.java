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
    public ImageAssert src(Matcher<String> condition, String... messages) {
        jdiAssert(element.src(), condition, messages);
        return this;
    }
    
    public ImageAssert src(String src, String... messages) {
        return src(Matchers.is(src), messages);
    }
    
    @JDIAction("Assert that '{name}' fileName {0}")
    public ImageAssert fileName(Matcher<String> condition, String... messages) {
        jdiAssert(element.fileName(), condition, messages);
        return this;
    }
    
    public ImageAssert fileName(String src, String... messages) {
        return fileName(Matchers.is(src), messages);
    }
    
    @JDIAction("Assert that '{name}' alt {0}")
    public ImageAssert alt(Matcher<String> condition, String... messages) {
        jdiAssert(element.alt(), condition, messages);
        return this;
    }
    
    public ImageAssert alt(String alt, String... messages) {
        return alt(Matchers.is(alt), messages);
    }
    
    @JDIAction("Assert that '{name}' height {0}")
    public ImageAssert height(Matcher<Integer> condition, String... messages) {
        jdiAssert(element.height(), condition, messages);
        return this;
    }
    
    public ImageAssert height(int height, String... messages) {
        return height(Matchers.is(height), messages);
    }
    
    @JDIAction("Assert that '{name}' width {0}")
    public ImageAssert width(Matcher<Integer> condition, String... messages) {
        jdiAssert(element.width(), condition, messages);
        return this;
    }
    
    public ImageAssert width(int width, String... messages) {
        return width(Matchers.is(width), messages);
    }
}