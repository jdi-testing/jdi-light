package io.github.com.custom.bars;


import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.complex.VueTabs;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import static io.github.com.pages.AppBarsPage.fadeImageOnScrollBar;

public class AppBarWithTabs extends AppBar {

    public VueTabs tabs() {
        return new VueTabs().setCore(VueTabs.class, core().find(".v-tabs"));
    }

    public Image image() {
        return new Image().setCore(Image.class, fadeImageOnScrollBar.find(".v_image"));
    }
}
