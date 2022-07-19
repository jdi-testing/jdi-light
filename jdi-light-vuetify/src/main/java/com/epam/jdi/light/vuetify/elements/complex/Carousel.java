package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.CarouselAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.jdiai.tools.Timer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Carousel web element please visit https://vuetifyjs.com/en/components/carousels/
 */

public class Carousel extends UIBaseElement<CarouselAssert> {

    @JDIAction("Get '{name}'s delimiters")
    public ButtonGroup delimiters() {
        return new ButtonGroup(find(".v-carousel__controls"));
    }

    @JDIAction("Get '{name}'s 'next' button")
    public VuetifyButton nextButton() {
        return castToButton(find(".v-window__next button"));
    }

    @JDIAction("Get '{name}'s 'previous' button")
    public VuetifyButton previousButton() {
        return castToButton(find(".v-window__prev button"));
    }

    @JDIAction("Get '{name}'s current slide")
    private UIElement getCurrentSlide() {
        return find(".v-window-item");
    }

    @JDIAction("Get '{name}'s delimiters' icons")
    public List<Icon> getDelimitersIcons() {
        return delimiters().getAllButtons().stream()
                .map(e -> new Icon().setCore(Icon.class, e.find("i")))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}'s current slide text")
    public String getCurrentSlideText() {
        return getCurrentSlide().find(".text-h2").getText();
    }

    @JDIAction("Get '{name}'s current slide background image")
    public Image currentSlideImage() {
        return new Image().setCore(Image.class, getCurrentSlide().find(".v-image"));
    }

    @JDIAction("Get '{name}'s slide counter")
    public Text slideCounter() {
        return new Text().setCore(Text.class, find("div.justify-space-around"));
    }

    @JDIAction("Go to slide number {0}")
    public void goToSlide(int slideNumber) {
        delimiters().getButtonByIndex(slideNumber).click();
    }

    @JDIAction("Get '{name}'s 'plus' button")
    public VuetifyButton plusButton() {
        return castToButton(find("div.justify-space-around button.mdi-plus"));
    }

    @JDIAction("Get '{name}'s 'minus' button")
    public VuetifyButton minusButton() {
        return castToButton(find("div.justify-space-around button.mdi-minus"));
    }

    public void waitUntilSlideChange(String text) {
        Timer.waitCondition(() -> getCurrentSlideText().equals(text));
    }

    private VuetifyButton castToButton(UIElement element) {
        return new VuetifyButton(element);
    }

    public CarouselAssert is() {
        return new CarouselAssert().set(this);
    }
}
