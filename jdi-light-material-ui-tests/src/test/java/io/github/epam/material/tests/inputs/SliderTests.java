package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Slider;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.material.interfaces.inputs.ISlider.Orientation.HORIZONTAL;
import static com.epam.jdi.light.material.interfaces.inputs.ISlider.Orientation.VERTICAL;
import static com.epam.jdi.light.material.interfaces.inputs.ISlider.Type.CONTINUOUS;
import static com.epam.jdi.light.material.interfaces.inputs.ISlider.Type.DISCRETE;
import static io.github.com.StaticSite.slidersPage;


public class SliderTests extends TestsInit {

    @BeforeMethod
    public void before() {
        slidersPage.open();
        slidersPage.isOpened();
    }

    @Test
    public void continuousSliderTest() {
        Slider slider = slidersPage.continuousSlider;
        slider.show();
        slider.is().enabled();
        slider.is().orientation(HORIZONTAL);
        slider.is().type(CONTINUOUS);
        slider.track().is().visible();
        slider.is().value("30");
        slider.setValue("71");
        slider.is().value("71");
    }

    @Test
    public void disabledSliderTest() {
        Slider slider = slidersPage.disabledContinuousSlider;
        slider.show();
        slider.is().disabled();
        slider.is().value("30");
    }

    @Test
    public void discreteSliderTest() {
        Slider slider = slidersPage.discreteSlider;
        slider.show();
        slider.is().type(DISCRETE);
        slider.is().value("30");
        slider.setValue("88");
        slider.is().value("90");
    }

    @Test
    public void labelSliderTest() {
        Slider slider = slidersPage.restrictedDiscreteSlider;
        slider.show();
        slider.sliderLabel().hover();
        slider.sliderLabel().has().text("2");
    }

    @Test
    public void alwaysVisibleLabelSliderTest() {
        Slider slider = slidersPage.labelSlider;
        slider.show();
        slider.sliderLabel().has().text("37");
    }

    @Test
    public void verticalSliderTest() {
        Slider slider = slidersPage.verticalSlider;
        slider.show();
        slider.is().type(CONTINUOUS);
        slider.is().orientation(VERTICAL);
        slider.is().value("30");
        slider.setValue("77");
        slider.is().value("77");
    }

    @Test
    public void sliderWithInputTest() {
        Slider slider = slidersPage.inputSlider;
        slider.show();
        slider.is().value("30");
        slidersPage.inputSliderField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
        slider.is().value("55");
        slider.setValue("80");
        slidersPage.inputSliderField.is().text("80");

    }

    @Test
    public void keyboardSliderTest() {
        List<Slider> sliders = Arrays
                .asList(slidersPage.continuousSlider, slidersPage.verticalSlider);
        for (Slider slider: sliders) {
            int current = Integer.parseInt(slider.value());
            slider.thumb().click();
            slider.thumb().sendKeys(Keys.LEFT);
            slider.is().value(String.valueOf(--current));
            slider.thumb().sendKeys(Keys.DOWN);
            slider.is().value(String.valueOf(--current));
            slider.thumb().sendKeys(Keys.RIGHT);
            slider.is().value(String.valueOf(++current));
            slider.thumb().sendKeys(Keys.UP);
            slider.is().value(String.valueOf(++current));
        }
    }

    @Test
    public void dragAndDropSliderTest() {
        List<Slider> sliders = Arrays.asList(slidersPage.continuousSlider,
                slidersPage.discreteSlider, slidersPage.verticalSlider);

        for (Slider slider: sliders) {
            slider.show();
            slider.dragAndDropThumbTo("80");
            slider.is().value("80");
            slider.dragAndDropThumbTo("20");
            slider.is().value("20");
        }
    }


//
    @Test
    public void rangeSliderTest() {
        SliderRange slider = slidersPage.rangeSlider;
        slider.is().enabled();
        slider.has().orientation(HORIZONTAL);
        slider.is().value(1, "20");
        slider.is().value(2, "37");

        slider.setValue(1, "19");
        slider.setValue(2, "95");
        slider.is().value(1, "19");
        slider.is().value(2, "95");

        int current1 = Integer.parseInt(slider.value(1));
        int current2 = Integer.parseInt(slider.value(2));
        slider.thumb(1).click();
        slider.thumb(1).sendKeys(Keys.LEFT);
        slider.thumb(2).click();
        slider.thumb(2).sendKeys(Keys.LEFT);
        slider.is().value(1,String.valueOf(--current1));
        slider.is().value(2, String.valueOf(--current2));

        slider.thumb(1).click();
        slider.thumb(1).sendKeys(Keys.RIGHT);
        slider.thumb(2).click();
        slider.thumb(2).sendKeys(Keys.RIGHT);
        slider.is().value(1, String.valueOf(++current1));
        slider.is().value(2, String.valueOf(++current2));

        slider.dragAndDropThumbTo(1, "10");
        slider.dragAndDropThumbTo(2, "80");
        slider.is().value(1, "10");
        slider.is().value(2, "80");

    }

}
