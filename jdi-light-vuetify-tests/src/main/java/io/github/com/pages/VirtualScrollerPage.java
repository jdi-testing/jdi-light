package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.complex.VirtualScroller;

public class VirtualScrollerPage extends VuetifyPage {

    @UI(".v-text-field")
    public static TextField totalBenched;

    @UI("#BenchVirtualScroller .v-virtual-scroll")
    public static VirtualScroller benchScroller;

    @UI("#UserDirectoryVirtualScroller .v-virtual-scroll")
    public static VirtualScroller userScroller;
}
