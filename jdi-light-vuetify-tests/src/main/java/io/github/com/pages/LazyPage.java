package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.lazyComponent.LazyCard;


public class LazyPage extends VuetifyPage {

    @UI(".v-lazy")
    public static LazyCard lazyCard;

    @UI(".pa-6.text-center")
    public static LazyCard scrollDownText;
}
