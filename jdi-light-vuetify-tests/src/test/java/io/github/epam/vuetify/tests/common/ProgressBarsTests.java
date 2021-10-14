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
    public void bufferValueProgressBarsTests(int number) {
        bufferValueProgressBars.get(number).is().displayed();
    }

    @Test(dataProvider = "colorsProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void colorsProgressBarsTests(int number) {
        colorsProgressBars.get(number).is().displayed();
    }

    @Test(dataProvider = "indeterminateProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void indeterminateProgressBarsTests(int number) {
        indeterminateProgressBars.get(number).is().displayed();
    }

    @Test()
    public void queryProgressBarTests() {
        queryProgressBar.is().displayed();
    }

    @Test(dataProvider = "reversedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void reversedProgressBarsTests(int number) {
        reversedProgressBars.get(number).is().displayed();
    }

    @Test(dataProvider = "roundedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void roundedProgressBarsTests(int number) {
        roundedProgressBars.get(number).is().displayed();
    }

    @Test(dataProvider = "streamProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void streamProgressBarsTests(int number) {
        streamProgressBars.get(number).is().displayed();
    }

    @Test(dataProvider = "stripedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void stripedProgressBarsTests(int number) {
        stripedProgressBars.get(number).is().displayed();
    }

    @Test(dataProvider = "defaultProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void defaultProgressBarsTests(int number) {
        stripedProgressBars.get(number).is().displayed();
    }

    @Test(dataProvider = "determinateProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void determinateProgressBarsTests(int number) {
        determinateProgressBars.get(number).is().displayed();
    }

    @Test()
    public void fileLoaderProgressBarTests() {
        fileLoaderProgressBar.is().displayed();
    }

    @Test()
    public void toolbarProgressBarTests() {
        startLoadingButton.click();
        toolbarProgressBar.is().displayed();
    }
}
