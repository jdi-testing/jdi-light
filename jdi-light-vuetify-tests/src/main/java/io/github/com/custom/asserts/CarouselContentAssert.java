package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import io.github.com.custom.CarouselContent;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CarouselContentAssert extends UIAssert<CarouselContentAssert, CarouselContent> {

    @JDIAction("Assert that '{name}' has text '{0}'")
    public CarouselContentAssert text(String text) {
        jdiAssert(element().contentText().trim(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s current slide has expected color")
    public CarouselContentAssert color(String color) {
        jdiAssert(element().contentColor(), Matchers.containsString(color));
        return this;
    }

}
