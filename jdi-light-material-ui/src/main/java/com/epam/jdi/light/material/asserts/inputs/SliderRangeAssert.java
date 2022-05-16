package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Orientation;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Type;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderRangeAssert extends UIAssert<SliderRangeAssert, SliderRange> {

  @JDIAction("Assert that '{name}' value {0}")
  public SliderRangeAssert value(Matcher<String> value, int index) {
    jdiAssert(element().value(index), value);
    return this;
  }

  @JDIAction("Assert that '{name}' orientation is '{0}'")
  public SliderRangeAssert orientation(Orientation orientation) {
    jdiAssert(element().orientation(), Matchers.is(orientation));
    return this;
  }

  @JDIAction("Assert that '{name}' type is '{0}'")
  public SliderRangeAssert type(Type type) {
    jdiAssert(element().type(), Matchers.is(type));
    return this;
  }

  public SliderRangeAssert value(int index, String value) {
    return value(Matchers.is(value), index);
  }
}




