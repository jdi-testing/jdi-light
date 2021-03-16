package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.inputSliderDefaultAnfDisabledPage;
import static io.github.com.StaticSite.inputSliderRangePage;
import static io.github.com.StaticSite.inputSliderVerticalPage;
import static io.github.com.StaticSite.sliderFrame;

public class SliderTests extends TestsInit {

  @Test
  public void currentValueTest() {
    inputSliderDefaultAnfDisabledPage.open();
    sliderFrame.sliders.get(1).is().enabled().value(30);

    inputSliderVerticalPage.open();
    sliderFrame.slider.is().enabled().value(30);

    inputSliderRangePage.open();
    sliderFrame.rangeSlider.is()
        .enabled()
        .value(1, 20)
        .value(2, 37);

  }

  @Test
  public void isDisabledTest() {
    inputSliderDefaultAnfDisabledPage.open();
    sliderFrame.sliders.get(2).is().disabled();
    sliderFrame.sliders.get(2).is().displayed();
  }

  @Test
  public void setValue() {
    inputSliderDefaultAnfDisabledPage.open();
    sliderFrame.sliders.get(1).setValue(90);
    sliderFrame.sliders.get(1).is().value(90);

    inputSliderVerticalPage.open();
    sliderFrame.slider.setValue(10);
    sliderFrame.slider.is().value(10);

    inputSliderRangePage.open();
    sliderFrame.rangeSlider.setValue(1,2);
    sliderFrame.rangeSlider.setValue(2,60);
    sliderFrame.rangeSlider.is()
        .value(1, 2)
        .value(2, 60);

  }

  @Test
  public void sliderDisabledTest() {
    inputSliderDefaultAnfDisabledPage.open();
    sliderFrame.sliders.get(2).is().disabled();
  }

  @Test
  public void orientationTest() {
    inputSliderVerticalPage.open();
    sliderFrame.slider.is()
        .enabled()
        .orientation("vertical");

    inputSliderRangePage.open();
    sliderFrame.rangeSlider.is().enabled().orientation("horizontal");

    inputSliderDefaultAnfDisabledPage.open();
    sliderFrame.sliders.get(1).is().enabled().orientation("horizontal");

  }

  @Test
  public void moveTest() {
    inputSliderRangePage.open();
    sliderFrame.rangeSlider.moveLeft(1);
    sliderFrame.rangeSlider.is().value(1, 19);
    sliderFrame.rangeSlider.moveRight(2);
    sliderFrame.rangeSlider.is().value(2, 38);
    sliderFrame.rangeSlider.slideHorizontalTo(1, 5);
    sliderFrame.rangeSlider.is().value(1, 5);

    sliderFrame.rangeSlider.slideHorizontalTo(1, 99);
    sliderFrame.rangeSlider.is().value(2, 99);
    sliderFrame.rangeSlider.is().value(1, 38);

    sliderFrame.rangeSlider.slideHorizontalTo(2, 40);
    sliderFrame.rangeSlider.is().value(2, 40);

    inputSliderVerticalPage.open();
    sliderFrame.slider.moveLeft();
    sliderFrame.slider.is().value(29);
    sliderFrame.slider.moveRight();
    sliderFrame.slider.is().value(30);
    sliderFrame.slider.slideVerticalTo(80);
    sliderFrame.slider.is().value(80);


    inputSliderDefaultAnfDisabledPage.open();
    sliderFrame.sliders.get(1).moveRight();
    sliderFrame.sliders.get(1).is().value(31);
    sliderFrame.sliders.get(1).moveLeft();
    sliderFrame.sliders.get(1).is().value(30);
    sliderFrame.sliders.get(1).slideHorizontalTo(100);
    sliderFrame.sliders.get(1).is().value(100);

  }
}


