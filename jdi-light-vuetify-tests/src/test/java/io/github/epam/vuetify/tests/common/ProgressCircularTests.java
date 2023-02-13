package io.github.epam.vuetify.tests.common;

import io.github.com.dataproviders.ProgressCircularDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.progressCircularPage;
import static io.github.com.pages.ProgressCircularPage.colorProgressCirculars;
import static io.github.com.pages.ProgressCircularPage.indeterminateProgressCirculars;
import static io.github.com.pages.ProgressCircularPage.rotateProgressCirculars;
import static io.github.com.pages.ProgressCircularPage.sizeWidthProgressCirculars;

public class ProgressCircularTests extends TestsInit {

    @BeforeClass
    public void before() {
        progressCircularPage.open();
        waitCondition(() -> progressCircularPage.isOpened());
        progressCircularPage.checkOpened();
    }

    @Test(dataProvider = "colorProgressCircularsTestsDataProvider", dataProviderClass = ProgressCircularDataProvider.class,
            description = "Test checks parameters of progress circular")
    public void colorProgressCircularsTests(int index, String color, int height, int width, int value) {
        colorProgressCirculars.get(index).is()
                .displayed()
                .notSpinning()
                .color(color)
                .height(height)
                .width(width)
                .value(value)
                .text(String.valueOf(index));
    }

    @Test(dataProvider = "indeterminateProgressCircularsTestsDataProvider", dataProviderClass = ProgressCircularDataProvider.class,
            description = "Test checks parameters of indeterminate progress circular")
    public void indeterminateProgressCircularsTests(int index, String color, int height, int width) {
        indeterminateProgressCirculars.get(index).is()
                .displayed()
                .spinning()
                .color(color)
                .height(height)
                .width(width);
    }

    @Test(dataProvider = "rotateProgressCircularsTestsDataProvider", dataProviderClass = ProgressCircularDataProvider.class,
            description = "Test checks parameters of rotate progress circular")
    public void rotateProgressCircularsTests(int index, String color, int height, int width, int rotate) {
        rotateProgressCirculars.get(index).is()
                .displayed()
                .color(color)
                .height(height)
                .width(width)
                .rotation(rotate);
    }

    @Test(dataProvider = "sizeWidthProgressCircularsTestsDataProvider", dataProviderClass = ProgressCircularDataProvider.class,
            description = "Test checks size and width of progress circular")
    public void sizeWidthProgressCircularsTests(int index, String color, int height, int width, int thickness) {
        sizeWidthProgressCirculars.get(index).is()
                .displayed()
                .spinning()
                .color(color)
                .height(height)
                .width(width)
                .thickness(thickness);
    }
}