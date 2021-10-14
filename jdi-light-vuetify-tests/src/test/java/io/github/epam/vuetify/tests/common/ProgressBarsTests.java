package io.github.epam.vuetify.tests.common;

import io.github.com.dataproviders.ProgressBarsDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.StaticSite.progressLinearPage;
import static io.github.com.pages.ProgressLinearPage.bufferValueProgressBars;
import static io.github.com.pages.ProgressLinearPage.colorsProgressBars;
import static io.github.com.pages.ProgressLinearPage.determinateProgressBars;
import static io.github.com.pages.ProgressLinearPage.fileLoaderProgressBar;
import static io.github.com.pages.ProgressLinearPage.indeterminateProgressBars;
import static io.github.com.pages.ProgressLinearPage.queryProgressBar;
import static io.github.com.pages.ProgressLinearPage.reversedProgressBars;
import static io.github.com.pages.ProgressLinearPage.roundedProgressBars;
import static io.github.com.pages.ProgressLinearPage.startLoadingButton;
import static io.github.com.pages.ProgressLinearPage.streamProgressBars;
import static io.github.com.pages.ProgressLinearPage.stripedProgressBars;
import static io.github.com.pages.ProgressLinearPage.toolbarProgressBar;

public class ProgressBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        progressLinearPage.open();
    }

    @Test(dataProvider = "bufferValueProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void bufferValueProgressBarsTests(int number, String color) {
        bufferValueProgressBars.get(number).is().displayed();
        bufferValueProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "colorsProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void colorsProgressBarsTests(int number, String color, String barColor) {
        colorsProgressBars.get(number).is().displayed();
        colorsProgressBars.get(number).has().color(color);
        colorsProgressBars.get(number).has().barColor(barColor);
    }

    @Test(dataProvider = "indeterminateProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void indeterminateProgressBarsTests(int number, String color) {
        indeterminateProgressBars.get(number).is().displayed();
        indeterminateProgressBars.get(number).is().indeterminate();
        indeterminateProgressBars.get(number).has().color(color);
    }

    @Test()
    public void queryProgressBarTests() {
        queryProgressBar.is().displayed();
        queryProgressBar.has().color(BLUE_DARKEN_2.value());
    }

    @Test(dataProvider = "reversedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void reversedProgressBarsTests(int number, String color) {
        reversedProgressBars.get(number).is().displayed();
        reversedProgressBars.get(number).has().color(color);

        reversedProgressBars.get(2).is().indeterminate();
    }

    @Test(dataProvider = "roundedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void roundedProgressBarsTests(int number, String color) {
        roundedProgressBars.get(number).is().displayed();
        roundedProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "streamProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void streamProgressBarsTests(int number, String color) {
        streamProgressBars.get(number).is().displayed();
        streamProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "stripedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void stripedProgressBarsTests(int number, String color) {
        stripedProgressBars.get(number).is().displayed();
        stripedProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "defaultProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void defaultProgressBarsTests(int number, String color) {
        stripedProgressBars.get(number).is().displayed();
        stripedProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "determinateProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void determinateProgressBarsTests(int number, String color) {
        determinateProgressBars.get(number).is().displayed();
        determinateProgressBars.get(number).has().color(color);
    }

    @Test()
    public void fileLoaderProgressBarTests() {
        fileLoaderProgressBar.is().displayed();
        fileLoaderProgressBar.is().indeterminate();
        fileLoaderProgressBar.has().color(DEEP_PURPLE_ACCENT_4.value());
    }

    @Test()
    public void toolbarProgressBarTests() {
        startLoadingButton.click();
        toolbarProgressBar.is().displayed();
        toolbarProgressBar.is().indeterminate();
        toolbarProgressBar.has().color(DEEP_PURPLE_ACCENT_4.value());
    }
}
