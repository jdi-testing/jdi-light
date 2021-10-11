package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.Sheet;

public class SheetsPage extends VuetifyPage {
    // elevation prop
    @UI("(//*[@id = 'ElevationSheet']//*[contains(@class, 'mx-auto')])[1]")
    public static Sheet elevation6Sheet;
    @UI("(//*[@id = 'ElevationSheet']//*[contains(@class, 'mx-auto')])[2]")
    public static Sheet elevation12Sheet;
    @UI("(//*[@id = 'ElevationSheet']//*[contains(@class, 'mx-auto')])[3]")
    public static Sheet elevation18Sheet;

    // rounded prop
    @UI("(//*[@id = 'RoundedSheet']//*[contains(@class, 'mx-auto')])[1]")
    public static Sheet defaultRoundedSheet;
    @UI("(//*[@id = 'RoundedSheet']//*[contains(@class, 'mx-auto')])[2]")
    public static Sheet roundedSheet;
    @UI("(//*[@id = 'RoundedSheet']//*[contains(@class, 'mx-auto')])[3]")
    public static Sheet xlRoundedSheet;

    // color sheets
    @UI("//*[@id = 'ColorSheet']//*[contains(@class, 'theme--light') and .//*[contains(text(), '#1')]]")
    public static Sheet firstColoredSheet;
    @UI("//*[@id = 'ColorSheet']//*[contains(@class, 'theme--light') and .//*[contains(text(), '#2')]]")
    public static Sheet secondColoredSheet;
    @UI("//*[@id = 'ColorSheet']//*[contains(@class, 'theme--light') and .//*[contains(text(), '#3')]]")
    public static Sheet thirdColoredSheet;
    @UI("//*[@id = 'ColorSheet']//*[contains(@class, 'theme--light') and .//*[contains(text(), '#4')]]")
    public static Sheet fourthColoredSheet;
    @UI("//*[@id = 'ColorSheet']//*[contains(@class, 'theme--light') and .//*[contains(text(), '#5')]]")
    public static Sheet fifthColoredSheet;
    @UI("//*[@id = 'ColorSheet']//*[contains(@class, 'theme--light') and .//*[contains(text(), '#6')]]")
    public static Sheet sixthColoredSheet;
}
