package io.github.epam.vuetify.tests.common;

import io.github.com.dataproviders.ProgressBarsDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.progressLinearPage;
import static io.github.com.pages.ProgressLinearPage.bufferValueProgressBars;
import static io.github.com.pages.ProgressLinearPage.colorsProgressBars;
import static io.github.com.pages.ProgressLinearPage.determinateProgressBars;
import static io.github.com.pages.ProgressLinearPage.fileLoaderProgressBar;
import static io.github.com.pages.ProgressLinearPage.indeterminateProgressBars;
import static io.github.com.pages.ProgressLinearPage.queryProgressBar;
import static io.github.com.pages.ProgressLinearPage.reversedProgressBars;
import static io.github.com.pages.ProgressLinearPage.roundedProgressBars;
import static io.github.com.pages.ProgressLinearPage.startLoading;
import static io.github.com.pages.ProgressLinearPage.streamProgressBars;
import static io.github.com.pages.ProgressLinearPage.stripedProgressBars;
import static io.github.com.pages.ProgressLinearPage.toolbarProgressBar;

public class ProgressBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        progressLinearPage.open();
    }

    @Test(dataProvider = "bufferValueProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void bufferValueProgressBarsTests(int number, String iconType, String color,
                                String height, String width) {
        bufferValueProgressBars.get(number).is().displayed();
        bufferValueProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "colorsProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void colorsProgressBarsTests(int number, String iconType, String color,
                                String height, String width) {
        colorsProgressBars.get(number).is().displayed();
        colorsProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "indeterminateProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void indeterminateProgressBarsTests(int number, String iconType, String color,
                                String height, String width) {
        indeterminateProgressBars.get(number).is().displayed();
        indeterminateProgressBars.get(number).has().color(color);
    }

    @Test()
    public void queryProgressBarTests() {
        queryProgressBar.is().displayed();
        queryProgressBar.has().color(color);
    }

    @Test(dataProvider = "reversedProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void reversedProgressBarsTests(int number, String iconType, String color,
                                               String height, String width) {
        reversedProgressBars.get(number).is().displayed();
        reversedProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "roundedProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void roundedProgressBarsTests(int number, String iconType, String color,
                                               String height, String width) {
        roundedProgressBars.get(number).is().displayed();
        roundedProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "streamProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void streamProgressBarsTests(int number, String iconType, String color,
                                               String height, String width) {
        streamProgressBars.get(number).is().displayed();
        streamProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "stripedProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void stripedProgressBarsTests(int number, String iconType, String color,
                                               String height, String width) {
        stripedProgressBars.get(number).is().displayed();
        stripedProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "defaultProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void defaultProgressBarsTests(int number, String iconType, String color,
                                               String height, String width) {
        stripedProgressBars.get(number).is().displayed();
        stripedProgressBars.get(number).has().color(color);
    }

    @Test(dataProvider = "determinateProgressBarsTestsDataProvider", dataProviderClass = ProgressBarsDataProvider.class)
    public void determinateProgressBarsTests(int number, String iconType, String color,
                                               String height, String width) {
        determinateProgressBars.get(number).is().displayed();
        determinateProgressBars.get(number).has().color(color);
    }

    @Test()
    public void fileLoaderProgressBarTests() {
        fileLoaderProgressBar.is().displayed();
        fileLoaderProgressBar.has().color(color);
    }

    @Test()
    public void toolbarProgressBarTests() {
        startLoading.click();
        toolbarProgressBar.is().displayed();
        toolbarProgressBar.has().color(color);
    }
}
