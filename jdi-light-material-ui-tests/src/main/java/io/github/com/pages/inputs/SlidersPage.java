package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import com.epam.jdi.light.material.elements.inputs.Slider;
import org.openqa.selenium.WebElement;

public class SlidersPage extends WebPage {

  @UI("//*[@id=\"continuous-slider\"]/following-sibling::div//span[contains(@class, \"MuiSlider-root\")]")
  public static Slider continuousSlider;

  @UI("//*[@id=\"disabled-slider\"]/following-sibling::span[contains(@class, \"MuiSlider-root\")]")
  public static Slider disabledContinuousSlider;

  @UI("(//*[@id=\"discrete-slider\"]/following-sibling::span[contains(@class, \"MuiSlider-root\")])[1]")
  public static Slider discreteSlider;

  @UI("(//*[@id=\"discrete-slider\"]/following-sibling::span[contains(@class, \"MuiSlider-root\")])[2]")
  public static Slider disabledDiscreteSlider;

  @UI("//*[@id=\"discrete-slider-restrict\"]/following-sibling::span[contains(@class, \"MuiSlider-root\")]")
  public static Slider restrictedDiscreteSlider;

  @UI("//*[@id=\"discrete-slider-always\"]/following-sibling::span[contains(@class, \"MuiSlider-root\")]")
  public static Slider labelSlider;

  @UI("//*[@id=\"range-slider\"]/following-sibling::span[contains(@class, \"MuiSlider-root\")]")
  public static SliderRange rangeSlider;

  @UI("//*[@id=\"input-slider\"]/following-sibling::div//span[contains(@class, \"MuiSlider-root\")]")
  public static Slider inputSlider;

  @UI("//*[@id=\"input-slider\"]/following-sibling::div//input[contains(@class, \"MuiInputBase-input\")]")
  public static WebElement inputSliderField;

  @UI("//*[@id=\"vertical-slider\"]/following-sibling::div//span[contains(@class, \"MuiSlider-root\")]")
  public static Slider verticalSlider;
}
