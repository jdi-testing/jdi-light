package io.github.com.custom.lazyComponent;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.complex.Lazy;


public class LazyCard extends Lazy {
    @UI(".v-card__title")
    private Text title;

    @UI(".v-card__text")
    private Text contentText;

    public Text title() {
        return title;
    }
    public Text contentText() {
        return contentText;
    }
}
