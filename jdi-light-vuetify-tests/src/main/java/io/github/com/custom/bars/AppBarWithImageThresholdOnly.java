package io.github.com.custom.bars;

import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;

import static io.github.com.pages.AppBarsPage.thresholdBar;

public class AppBarWithImageThresholdOnly extends AppBar {

    public Image image() {
        return new Image().setCore(Image.class, thresholdBar.find(".v-toolbar__image"));
    }
}
