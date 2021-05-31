package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIChip;
import com.epam.jdi.light.material.elements.displaydata.Chip;

public class ChipsPage extends WebPage {
    @JDIChip
    @UI("//h2[text() = 'Chip']/following-sibling::*[1]")
    public static Chip defaultChips;

    @JDIChip
    @UI("//h2[text() = 'Outlined Chips']/following-sibling::*[1]")
    public static Chip outlinedChips;

    @JDIChip
    @UI("//h2[text() = 'Chip array']/following-sibling::*[1]")
    public static Chip chipArrays;
}
