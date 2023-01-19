package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import com.epam.jdi.light.material.elements.inputs.Slider;

public class SlidersPage extends WebPage {

  @UI("#continuousSlider")
  public Slider continuousSlider;

  @UI("#continuousSlider-disabled")
  public Slider disabledContinuousSlider;

  @UI("#discreteSlider")
  public Slider discreteSlider;

  @UI("#discreteSlider-disabled")
  public Slider disabledDiscreteSlider;

  @UI("#customDiscreteSlider")
  public Slider restrictedDiscreteSlider;

  @UI("#alwaysVisibleLabelsSlider")
  public Slider labelSlider;

  @UI("#rangeSlider")
  public SliderRange rangeSlider;

  @UI("#inputSlider")
  public Slider inputSlider;

  @UI("#inputSlider-input")
  public UIElement inputSliderField;

  @UI("#verticalSlider")
  public Slider verticalSlider;
}
