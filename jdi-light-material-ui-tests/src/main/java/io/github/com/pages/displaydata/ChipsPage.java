package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class ChipsPage extends WebPage {

    @UI("//h2[text()='Chip']/following-sibling::div/div[contains(@class, 'MuiChip-root')]")
    public static List<Chip> basicChips;

    @UI("//h2[text()='Outlined Chips']/following-sibling::div/div/div[contains(@class, 'MuiChip-root')]")
    public static List<Chip> outlinedChips;

    @UI("//a[contains(@class, 'MuiChip-root')]")
    public static List<Chip> linkChips;

    @UI("//h2[text()='Chip array']/following-sibling::div//div[contains(@class, 'MuiChip-root')]")
    public static List<Chip> arrayChips;

    @UI("//span[text() = 'Angular']/ancestor::div[contains(@class, 'MuiChip-root')]")
    public static Chip angularChip;

    @UI("//span[text() = 'jQuery']/ancestor::div[contains(@class, 'MuiChip-root')]")
    public static Chip jQueryChip;

    @UI("//span[text() = 'Polymer']/ancestor::div[contains(@class, 'MuiChip-root')]")
    public static Chip polymerChip;

    @UI("//span[text() = 'React']/ancestor::div[contains(@class, 'MuiChip-root')]")
    public static Chip reactChip;

    @UI("//span[text() = 'Vue.js']/ancestor::div[contains(@class, 'MuiChip-root')]")
    public static Chip vueJSChip;

    @UI("#lastClickInfo")
    public static Text lastClickBasicInfo;

    @UI("#lastDeleteInfo")
    public static Text lastDeleteBasicInfo;

    @UI("#lastOutlinedClickInfo")
    public static Text lastClickOutlinedInfo;

    @UI("#lastOutlinedDeleteInfo")
    public static Text lastDeleteOutlinedInfo;

    @UI("#lastChipArrayClickInfo")
    public static Text lastClickArrayInfo;
}
