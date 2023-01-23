package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Sparkline;
import com.epam.jdi.light.vuetify.interfaces.asserts.FilledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SparklineAssert extends UIAssert<SparklineAssert, Sparkline> implements
        MeasurementAssert<SparklineAssert, Sparkline>, FilledAssert<SparklineAssert, Sparkline> {
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
        Map<String, String> actualLinearGradientMap = element().getLinearGradientMap();
        jdiAssert(actualLinearGradientMap, Matchers.equalTo(gradientColorMap));
        return this;
    }

    @JDIAction("Assert that '{name}' SVG path shape is equal to the provided path shape")
    public SparklineAssert pathShapeEqualTo(String pathShape) {
        String actualPathShape = element().getPathShape();
        jdiAssert(actualPathShape, Matchers.equalTo(pathShape));
        return this;
    }

    @JDIAction("Assert that '{name}' SVG path shape is not equal to the provided path shape")
    public SparklineAssert pathShapeNotEqualTo(String pathShape) {
        String actualPathShape = element().getPathShape();
        jdiAssert(actualPathShape, Matchers.not(pathShape));
        return this;
    }

    @JDIAction("Assert that '{name}' has type bar")
    public SparklineAssert bar() {
        jdiAssert(element().isBar(), Matchers.is(true), "Element's type is not bar");
        return this;
    }

    @JDIAction("Assert that '{name}' has type bar")
    public SparklineAssert trendline() {
        jdiAssert(element().isTrendline(), Matchers.is(true), "Element's type is not trendline");
        return this;
    }

    @JDIAction("Assert that '{name}' labels has font size '{0}'")
    public SparklineAssert labelFontSize(int labelFontSize) {
        int actualLabelFontSize = element().labelFontSize();
        jdiAssert(actualLabelFontSize, Matchers.equalTo(labelFontSize));
        return this;
    }

    @JDIAction("Assert that '{name}' has visible labels")
    public SparklineAssert labels() {
        jdiAssert(element().hasLabels(), Matchers.is(true), "Element has no visible labels");
        return this;
    }

    @JDIAction("Assert that '{name}' has not visible labels")
    public SparklineAssert noLabels() {
        jdiAssert(element().hasLabels(), Matchers.is(false), "Element has visible labels");
        return this;
    }

    @JDIAction("Assert that '{name}' has visible labels")
    public SparklineAssert labelTexts(List<String> labelTexts) {
        List<String> actualLabelTexts = element().getLabelTexts();
        jdiAssert(actualLabelTexts, Matchers.equalTo(labelTexts));
        return this;
    }

    @JDIAction("Assert that '{name}' has line width '{0}'")
    public SparklineAssert lineWidth(int lineWidth) {
        int actualLineWidth = element().lineWidth();
        jdiAssert(actualLineWidth, Matchers.equalTo(lineWidth));
        return this;
    }

    @JDIAction("Assert that '{name}' has bars width '{0}'")
    public SparklineAssert barsWidth(List<Integer> barWidth) {
        List<Integer> actualBarWidth = element().getBarsWidths();
        jdiAssert(actualBarWidth.toArray(), Matchers.arrayContaining(barWidth.toArray()));
        return this;
    }

    @JDIAction("Assert that '{name}' has bar width '{0}'")
    public SparklineAssert barWidth(int barWidth) {
        int actualBarWidth = element().getBarWidth();
        jdiAssert(actualBarWidth, Matchers.equalTo(barWidth));
        return this;
    }

    @JDIAction("Assert that '{name}' has bars height '{0}'")
    public SparklineAssert barsHeight(List<Integer> barHeight) {
        List<Integer> actualBarHeight = element().getBarsHeights();
        jdiAssert(actualBarHeight.toArray(), Matchers.arrayContaining(barHeight.toArray()));
        return this;
    }
}
