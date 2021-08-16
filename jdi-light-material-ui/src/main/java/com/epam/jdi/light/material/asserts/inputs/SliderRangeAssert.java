package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderRangeAssert extends UIAssert<SliderRangeAssert, SliderRange> {

  @JDIAction("Assert that '{name}' value {0}")
  public SliderRangeAssert value(Matcher<Integer> value, int index) {
    jdiAssert(element().value(index), value);
    return this;
  }

  @JDIAction("Assert that orientation is '{0}'")
  public SliderRangeAssert orientation(String orientation) {
    jdiAssert(element().orientation(), Matchers.is(orientation));
    return this;
  }

  public SliderRangeAssert value(int index, int value) {
    return value(Matchers.is(value), index);
  }
}




