package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Slider;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderAssert extends UIAssert<SliderAssert, Slider> {

  @JDIAction("Assert that '{name}' is disabled")
  @Override
  public SliderAssert disabled() {
    jdiAssert(element().isDisabled(), Matchers.is(true));
    return this;
  }

  @JDIAction("Assert that '{name}' value is {0}")
  public SliderAssert value(Matcher<Integer> value) {
    jdiAssert(element().value(), value);
    return this;
  }

  @JDIAction("Assert that orientation is '{0}'")
  public SliderAssert orientation(String orientation) {
    jdiAssert(element().orientation(), Matchers.is(orientation));
    return this;
  }

  public SliderAssert value(int value) {
    return value(Matchers.is(value));
  }
}


