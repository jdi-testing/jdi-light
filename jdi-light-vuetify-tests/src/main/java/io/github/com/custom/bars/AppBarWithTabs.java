package io.github.com.custom.bars;


import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.complex.VuetifyTabs;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import static io.github.com.pages.AppBarsPage.fadeImageOnScrollBar;

public class AppBarWithTabs extends AppBar {

    public VuetifyTabs tabs() {
        return new VuetifyTabs().setCore(VuetifyTabs.class, find(".v-tabs"));
    }

    public Image image() {
        return new Image().setCore(Image.class, fadeImageOnScrollBar.find(".v-toolbar__image"));
    }
}
