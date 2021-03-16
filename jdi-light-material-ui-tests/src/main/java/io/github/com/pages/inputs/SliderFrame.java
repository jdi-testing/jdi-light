package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import com.epam.jdi.light.material.elements.inputs.Slider;

import java.util.List;

public class SliderFrame extends Section {

  @UI(".MuiSlider-root")
  public Slider slider;

  @UI(".MuiSlider-root")
  public SliderRange rangeSlider;

  @UI(".MuiSlider-root")
  public List<Slider> sliders;

}



