package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Sparkline;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SparklineAssert extends UIAssert<SparklineAssert, Sparkline> {

    @JDIAction("Assert that line width of '{name}' is {0}")
    public SparklineAssert lineWidth(double width) {
            jdiAssert(element().getLineWidth(), Matchers.is(width));
            return this;
        }

    @JDIAction("Assert that '{name}' is filled")
    public SparklineAssert filled() {
        jdiAssert(element().isFilled() ? "filled" : "not filled", Matchers.is("filled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not filled")
    public SparklineAssert notFilled() {
        jdiAssert(!element().isFilled() ? "not filled" : "filled", Matchers.is("not filled"));
        return this;
    }

    @JDIAction("Assert that all '{name}' data point labels have a '{0}' prefix")
    public SparklineAssert labelsPrefixedWith(String prefix) {
        List<String> labels = element().getLabelTexts();
        for (String label: labels) {
            jdiAssert(label, Matchers.startsWith(prefix));
        }
        return this;
    }

    @JDIAction("Assert that all '{name}' data point labels have a '{0}' postfix")
    public SparklineAssert labelsPostfixedWith(String postfix) {
        List<String> labels = element().getLabelTexts();
        for (String label: labels) {
            jdiAssert(label, Matchers.endsWith(postfix));
        }
        return this;
    }

    @JDIAction("Assert that '{name}' linear gradient map corresponds to the provided map {0}")
    public SparklineAssert linearGradientMap(Map<String, String> gradientColorMap) {
        jdiAssert(element().getLinearGradientMap(), Matchers.equalTo(gradientColorMap));
        return this;
    }

    @JDIAction("Assert that '{name}' SVG path shape is equal to the provided path shape")
    public SparklineAssert pathShapeEqualTo(String pathShape) {
        jdiAssert(element().getPathShape(), Matchers.equalTo(pathShape));
        return this;
    }

    @JDIAction("Assert that '{name}' SVG path shape is not equal to the provided path shape")
    public SparklineAssert pathShapeNotEqualTo(String pathShape) {
        jdiAssert(element().getPathShape(), Matchers.not(pathShape));
        return this;
    }

}
