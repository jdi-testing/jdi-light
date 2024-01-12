package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Sheet;

import java.util.List;

public class SheetsPage extends VuetifyPage {

    // @todo #5298 Looks like locator point not to sheet, but on content. SHould be refactored
    @UI("#ElevationSheet .v-sheet div")
    public static List<Sheet> elevationSheets;

    @UI("(//*[@id = 'RoundedSheet']//*[contains(@class, 'mx-auto')])[1]")
    public static Sheet defaultRoundedSheet;
    @UI("(//*[@id = 'RoundedSheet']//*[contains(@class, 'mx-auto')])[2]")
    public static Sheet roundedSheet;
    @UI("(//*[@id = 'RoundedSheet']//*[contains(@class, 'mx-auto')])[3]")
    public static Sheet xlRoundedSheet;

    @UI("#ColorSheet .v-sheet")
    public static List<Sheet> coloredSheets;

    @UI("#OutlinedSheet .v-sheet")
    public static Sheet outlinedSheet;

    @UI("#ShapedSheet .v-sheet")
    public static Sheet shapedSheet;

    @UI("#TileSheet .v-sheet")
    public static Sheet tileSheet;
}
