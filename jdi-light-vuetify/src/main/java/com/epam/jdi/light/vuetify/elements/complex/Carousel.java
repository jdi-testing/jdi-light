package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.CarouselAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasImage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Carousel web element please visit https://vuetifyjs.com/en/components/carousels/
 */

public class Carousel extends UIBaseElement<CarouselAssert> implements IsText, HasImage {

    @JDIAction("Get '{name}'s delimiters")
    public ButtonGroup delimiters() {
        return new ButtonGroup(find(".v-carousel__controls"));
    }

    @JDIAction("Get '{name}'s 'next' button")
    public VuetifyButton nextButton() {
        return new VuetifyButton(find(".v-window__next button"));
    }

    @JDIAction("Get '{name}'s 'previous' button")
    public VuetifyButton previousButton() {
        return new VuetifyButton(find(".v-window__prev button"));
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

    @Override
    public String getText() {
        return find(".text-h2").getText();
    }

    @Override
    @JDIAction("Get '{name}'s current slide background image")
    public Image image() {
        return new Image().setCore(Image.class, find(".v-image"));
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
        return new VuetifyButton(find("div.justify-space-around button.mdi-plus"));
    }

    @JDIAction("Get '{name}'s 'minus' button")
    public VuetifyButton minusButton() {
        return new VuetifyButton(find("div.justify-space-around button.mdi-minus"));
    }

    public CarouselAssert is() {
        return new CarouselAssert().set(this);
    }
}
