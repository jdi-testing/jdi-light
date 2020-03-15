package io.github.com;

import com.epam.jdi.light.ui.html.elements.common.*;

import static com.epam.jdi.light.elements.init.UIFactory.*;
import static com.epam.jdi.light.ui.html.HtmlUtils.*;

public class RangeControl extends Range {
    private Button increaseRange, decreaseRange;
    public void increase(int count) {
        for (int i = 0; i < count; i++)
            increaseRange.click();
    }
    public void decrease(int count) {
        for (int i = 0; i < count; i++)
            decreaseRange.click();
    }
    @Override
    public double value() {
        return getDouble("value", $("default-range-value"));
    }
}
