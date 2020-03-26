package com.epam.jdi.light.ui.html.elements.complex.vue;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.google.gson.Gson;

import static com.epam.jdi.light.driver.WebDriverFactory.*;

public class Chart extends UIBaseElement<TextAssert> implements IsText {
    static Gson gson = new Gson();
    public ChartData get() {
        Object rowChartData = jsExecute("return { " +
            "labels:  window.barChartData.labels, " +
            "dataset: window.barChartData.datasets.map(ds => ({ " +
                "bgColor: ds.backgroundColor, " +
                "borderColor: ds.borderColor, " +
                "label: ds.label, " +
                "data: ds.data })) " +
            "}");
        return gson.fromJson(gson.toJson(rowChartData), ChartData.class);
    }
    public String getText() {
        return get().toString();
    }
    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
