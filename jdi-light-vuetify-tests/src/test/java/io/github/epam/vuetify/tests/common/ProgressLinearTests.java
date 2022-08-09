package io.github.epam.vuetify.tests.common;

import com.jdiai.tools.Timer;
import io.github.com.dataproviders.ProgressLinearDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.ElementArea.TOP_RIGHT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.StaticSite.progressLinearPage;
import static io.github.com.pages.ProgressLinearPage.bufferValueProgressLinears;
import static io.github.com.pages.ProgressLinearPage.colorsProgressLinears;
import static io.github.com.pages.ProgressLinearPage.defaultProgressLinears;
import static io.github.com.pages.ProgressLinearPage.determinateProgressLinears;
import static io.github.com.pages.ProgressLinearPage.fileLoaderProgressLinear;
import static io.github.com.pages.ProgressLinearPage.indeterminateProgressLinears;
import static io.github.com.pages.ProgressLinearPage.queryProgressLinear;
import static io.github.com.pages.ProgressLinearPage.reversedProgressLinears;
import static io.github.com.pages.ProgressLinearPage.roundedProgressLinears;
import static io.github.com.pages.ProgressLinearPage.startLoadingButton;
import static io.github.com.pages.ProgressLinearPage.streamProgressLinears;
import static io.github.com.pages.ProgressLinearPage.stripedProgressLinears;
import static io.github.com.pages.ProgressLinearPage.toolbarProgressLinear;

public class ProgressLinearTests extends TestsInit {

    @BeforeClass
    public void before() {
        progressLinearPage.open();
        waitCondition(() -> progressLinearPage.isOpened());
        progressLinearPage.checkOpened();
    }

    @Test(dataProvider = "bufferValueProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void bufferValueProgressLinearsTests(int index, String color) {
        bufferValueProgressLinears.get(index).show();
        bufferValueProgressLinears.get(index).is().displayed();
        bufferValueProgressLinears.get(index).is().reactive();
        bufferValueProgressLinears.get(index).is().determinate();
        bufferValueProgressLinears.get(index).has().color(color);
        bufferValueProgressLinears.get(index).click();
        bufferValueProgressLinears.get(index).has().value(50.0);
    }

    @Test(dataProvider = "colorsProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void colorsProgressLinearsTests(int index, String color, String barColor) {
        colorsProgressLinears.get(index).show();
        colorsProgressLinears.get(index).is().displayed();
        colorsProgressLinears.get(index).is().determinate();
        colorsProgressLinears.get(index).has().color(color);
        colorsProgressLinears.get(index).has().barColor(barColor);
    }

    @Test(dataProvider = "indeterminateProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void indeterminateProgressLinearsTests(int index, String color) {
        indeterminateProgressLinears.get(index).show();
        indeterminateProgressLinears.get(index).is().displayed();
        indeterminateProgressLinears.get(index).is().indeterminate();
        indeterminateProgressLinears.get(index).has().color(color);
    }

    @Test(invocationCount = 10)
    public void queryProgressLinearTests() {
        Timer.waitCondition(queryProgressLinear::isIndeterminate);
        queryProgressLinear.show();
        queryProgressLinear.is().displayed();
        queryProgressLinear.is().reactive();
        queryProgressLinear.has().color(BLUE_DARKEN_2.value());
        Timer.waitCondition(queryProgressLinear::isDeterminate);
        //System.out.println(queryProgressLinear.children().stream().map(e -> e.getAttribute("class")).collect(Collectors.toList()));
        queryProgressLinear.is().determinate();
        Timer.waitCondition(queryProgressLinear::isHidden);
        queryProgressLinear.is().hidden();
        Timer.waitCondition(queryProgressLinear::isIndeterminate);
        queryProgressLinear.is().indeterminate();
    }

    @Test(dataProvider = "reversedProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void reversedProgressLinearsTests(int index, String color) {
        reversedProgressLinears.get(index).show();
        reversedProgressLinears.get(index).is().displayed();
        reversedProgressLinears.get(index).has().color(color);

        reversedProgressLinears.get(1).is().determinate();
        reversedProgressLinears.get(2).is().indeterminate();
        reversedProgressLinears.get(3).has().stream();
    }

    @Test(dataProvider = "roundedProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void roundedProgressLinearsTests(int index, String color) {
        roundedProgressLinears.get(index).show();
        roundedProgressLinears.get(index).is().displayed();
        roundedProgressLinears.get(index).is().determinate();
        roundedProgressLinears.get(index).is().rounded();
        roundedProgressLinears.get(index).has().color(color);
    }

    @Test(dataProvider = "streamProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void streamProgressLinearsTests(int index, String color) {
        streamProgressLinears.get(index).show();
        streamProgressLinears.get(index).is().displayed();
        streamProgressLinears.get(index).has().color(color);
        streamProgressLinears.get(index).has().stream();
    }

    @Test(dataProvider = "stripedProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void stripedProgressLinearsTests(int index, String color) {
        stripedProgressLinears.get(index).show();
        stripedProgressLinears.get(index).is().displayed();
        stripedProgressLinears.get(index).is().determinate();
        stripedProgressLinears.get(index).is().striped();
        stripedProgressLinears.get(index).has().color(color);
    }

    @Test(dataProvider = "defaultProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void defaultProgressLinearsTests(int index, String color) {
        defaultProgressLinears.get(index).show();
        defaultProgressLinears.get(index).is().displayed();
        defaultProgressLinears.get(index).is().determinate();
        defaultProgressLinears.get(index).is().reactive();
        defaultProgressLinears.get(index).has().color(color);
        defaultProgressLinears.get(index).click(TOP_RIGHT);
        defaultProgressLinears.get(index).has().value(100.0);
        defaultProgressLinears.get(index).click();
        defaultProgressLinears.get(index).has().value(50.0);
    }

    @Test(dataProvider = "determinateProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void determinateProgressLinearsTests(int index, String color) {
        determinateProgressLinears.get(index).show();
        determinateProgressLinears.get(index).is().displayed();
        determinateProgressLinears.get(index).is().determinate();
        determinateProgressLinears.get(index).is().reactive();
        determinateProgressLinears.get(index).has().color(color);
        determinateProgressLinears.get(index).click(TOP_RIGHT);
        determinateProgressLinears.get(index).has().value(100.0);
        determinateProgressLinears.get(index).click();
        determinateProgressLinears.get(index).has().value(50.0);
    }

    @Test()
    public void fileLoaderProgressLinearTests() {
        fileLoaderProgressLinear.show();
        fileLoaderProgressLinear.is().displayed();
        fileLoaderProgressLinear.is().indeterminate();
        fileLoaderProgressLinear.is().rounded();
        fileLoaderProgressLinear.has().color(DEEP_PURPLE_ACCENT_4.value());
    }

    @Test(enabled = false)
    public void toolbarProgressLinearTests() {
        startLoadingButton.show();
        startLoadingButton.click();
        toolbarProgressLinear.is().indeterminate(); //TODO: find a way to stabilize it
        toolbarProgressLinear.is().displayed();
        toolbarProgressLinear.has().color(DEEP_PURPLE_ACCENT_4.value());
    }
}
