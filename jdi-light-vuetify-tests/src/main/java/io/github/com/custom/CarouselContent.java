package io.github.com.custom;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.elements.common.Image;
import io.github.com.custom.asserts.CarouselContentAssert;

public class CarouselContent extends UIBaseElement<CarouselContentAssert> {

    private static final String IMAGES_LOCATOR = ".v-image";

    private static final String TEXT_LOCATOR = ".text-h2";

    public String contentText() {
        return core().find(TEXT_LOCATOR).getText();
    }

    public Image contentImage() {
        return new Image().setCore(Image.class, find(IMAGES_LOCATOR));
    }

    @Override
    public CarouselContentAssert is() {
        return new CarouselContentAssert().set(this);
    }
}
