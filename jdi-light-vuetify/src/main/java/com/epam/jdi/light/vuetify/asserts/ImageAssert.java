package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ImageAssert extends UIAssert<ImageAssert, Image> {

    @JDIAction("Assert that '{name}' is displayed")
    public ImageAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        element().show();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected height")
    public ImageAssert height(double height) {
        if (height % 1 == 0) {
            int intHeight = (int) height;
            jdiAssert(element().hasHeight(), Matchers.is(String.format("%spx", intHeight)));
        } else {
            jdiAssert(element().hasHeight(), Matchers.is(String.format("%spx", height)));
        }
        return this;
    }

    @JDIAction("Assert that '{name}' has expected width")
    public ImageAssert width(double width) {
        if (width % 1 == 0) {
            int intWidth = (int) width;
            jdiAssert(element().hasWidth(), Matchers.is(String.format("%spx", intWidth)));
        } else {
            jdiAssert(element().hasWidth(), Matchers.is(String.format("%spx", width)));
        }
        return this;
    }

    @JDIAction("Assert that '{name}' has expected source path")
    public ImageAssert sourcePath(String path) {
        Timer.waitCondition(() -> element().hasSourcePath().contains("http"));
        jdiAssert(element().hasSourcePath(), Matchers.is(path));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected 'primary' or 'lazy' source path")
    public ImageAssert sourcePath(String lazySrc, String primarySrc) {
        Timer.waitCondition(() -> element().hasSourcePath().contains("http"));
        if (element().hasSourcePath().equals(lazySrc)) {
            jdiAssert(element().hasSourcePath(), Matchers.is(lazySrc));
        } else {
            jdiAssert(element().hasSourcePath(), Matchers.is(primarySrc));
        }
        return this;
    }

    @JDIAction("Assert that '{name}' has gradient")
    public ImageAssert gradient() {
        jdiAssert(element().hasGradient() ? "has gradient" : "does not have gradient", Matchers.is("has gradient"));
        return this;
    }

    @JDIAction("Assert that '{name}' has limited height")
    public ImageAssert limitedHeight() {
        jdiAssert(element().hasLimitedHeight() ? "has limited height" : "does not have limited height",
                Matchers.is("has limited height"));
        return this;
    }

    @JDIAction("Assert that '{name}' is loading")
    public ImageAssert loading() {
        jdiAssert(element().isLoading() ? "loading" : "is not loading",
                Matchers.is("loading"));
        return this;
    }
}
