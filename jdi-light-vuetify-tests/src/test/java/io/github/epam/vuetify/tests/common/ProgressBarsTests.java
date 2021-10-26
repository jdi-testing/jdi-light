package io.github.epam.vuetify.tests.common;

import com.epam.jdi.tools.Timer;
import io.github.com.dataproviders.ProgressBarsDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static com.epam.jdi.light.common.ElementArea.TOP_RIGHT;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.StaticSite.progressLinearPage;
import static io.github.com.pages.ProgressLinearPage.bufferValueProgressBars;
import static io.github.com.pages.ProgressLinearPage.colorsProgressBars;
import static io.github.com.pages.ProgressLinearPage.defaultProgressBars;
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
    public void bufferValueProgressBarsTests(int index, String color) {
        bufferValueProgressBars.get(index).is().displayed();
        bufferValueProgressBars.get(index).is().reactive();
        bufferValueProgressBars.get(index).is().determinate();
        bufferValueProgressBars.get(index).has().color(color);
        bufferValueProgressBars.get(index).click();
        bufferValueProgressBars.get(index).has().value(50.0);
    }

    @Test(dataProvider = "colorsProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void colorsProgressBarsTests(int index, String color, String barColor) {
        colorsProgressBars.get(index).is().displayed();
        colorsProgressBars.get(index).is().determinate();
        colorsProgressBars.get(index).has().color(color);
        colorsProgressBars.get(index).has().barColor(barColor);
    }

    @Test(dataProvider = "indeterminateProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void indeterminateProgressBarsTests(int index, String color) {
        indeterminateProgressBars.get(index).is().displayed();
        indeterminateProgressBars.get(index).is().indeterminate();
        indeterminateProgressBars.get(index).has().color(color);
    }

    @Test()
    public void queryProgressBarTests() {
        Timer.waitCondition(queryProgressBar::isIndeterminate);
        queryProgressBar.is().displayed();
        queryProgressBar.is().reactive();
        queryProgressBar.has().color(BLUE_DARKEN_2.value());
        Timer.waitCondition(queryProgressBar::isDeterminate);
        System.out.println(queryProgressBar.children().stream().map(e -> e.getAttribute("class")).collect(Collectors.toList()));
        queryProgressBar.is().determinate();
        Timer.waitCondition(queryProgressBar::isHidden);
        queryProgressBar.is().hidden();
        Timer.waitCondition(queryProgressBar::isIndeterminate);
        queryProgressBar.is().indeterminate();
    }

    @Test(dataProvider = "reversedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void reversedProgressBarsTests(int index, String color) {
        reversedProgressBars.get(index).is().displayed();
        reversedProgressBars.get(index).has().color(color);

        reversedProgressBars.get(1).is().determinate();
        reversedProgressBars.get(2).is().indeterminate();
        reversedProgressBars.get(3).has().stream();
    }

    @Test(dataProvider = "roundedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void roundedProgressBarsTests(int index, String color) {
        roundedProgressBars.get(index).is().displayed();
        roundedProgressBars.get(index).is().determinate();
        roundedProgressBars.get(index).is().rounded();
        roundedProgressBars.get(index).has().color(color);
    }

    @Test(dataProvider = "streamProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void streamProgressBarsTests(int index, String color) {
        streamProgressBars.get(index).is().displayed();
        streamProgressBars.get(index).has().color(color);
        streamProgressBars.get(index).has().stream();
    }

    @Test(dataProvider = "stripedProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void stripedProgressBarsTests(int index, String color) {
        stripedProgressBars.get(index).is().displayed();
        stripedProgressBars.get(index).is().determinate();
        stripedProgressBars.get(index).is().striped();
        stripedProgressBars.get(index).has().color(color);
    }

    @Test(dataProvider = "defaultProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void defaultProgressBarsTests(int index, String color) {
        defaultProgressBars.get(index).is().displayed();
        defaultProgressBars.get(index).is().determinate();
        defaultProgressBars.get(index).is().reactive();
        defaultProgressBars.get(index).has().color(color);
        defaultProgressBars.get(index).click(TOP_RIGHT);
        defaultProgressBars.get(index).has().value(100.0);
        defaultProgressBars.get(index).click();
        defaultProgressBars.get(index).has().value(50.0);
    }

    @Test(dataProvider = "determinateProgressBarsTestsDataProvider",
            dataProviderClass = ProgressBarsDataProvider.class)
    public void determinateProgressBarsTests(int index, String color) {
        determinateProgressBars.get(index).is().displayed();
        determinateProgressBars.get(index).is().determinate();
        determinateProgressBars.get(index).is().reactive();
        determinateProgressBars.get(index).has().color(color);
        determinateProgressBars.get(index).click(TOP_RIGHT);
        determinateProgressBars.get(index).has().value(100.0);
        determinateProgressBars.get(index).click();
        determinateProgressBars.get(index).has().value(50.0);
    }

    @Test()
    public void fileLoaderProgressBarTests() {
        fileLoaderProgressBar.is().displayed();
        fileLoaderProgressBar.is().indeterminate();
        fileLoaderProgressBar.is().rounded();
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
