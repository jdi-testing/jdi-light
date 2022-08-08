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

    @Test(dataProvider = "colorProgressCircularsTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void colorProgressCircularsTests(int index, String color, String height, String width) {
        colorProgressCirculars.get(index).is().displayed();
        colorProgressCirculars.get(index).is().notSpinning();
        colorProgressCirculars.get(index).has().color(color);
        colorProgressCirculars.get(index).has().height(height);
        colorProgressCirculars.get(index).has().width(width);
    }

    @Test(dataProvider = "indeterminateProgressCircularsTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void indeterminateProgressCircularsTests(int index, String color, String height, String width) {
        indeterminateProgressCirculars.get(index).is().displayed();
        indeterminateProgressCirculars.get(index).is().spinning();
        indeterminateProgressCirculars.get(index).has().color(color);
        indeterminateProgressCirculars.get(index).has().height(height);
        indeterminateProgressCirculars.get(index).has().width(width);
    }

    @Test(dataProvider = "rotateProgressCircularsTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void rotateProgressCircularsTests(int index, String color, String height, String width) {
        rotateProgressCirculars.get(index).is().displayed();
        rotateProgressCirculars.get(index).has().color(color);
        rotateProgressCirculars.get(index).has().height(height);
        rotateProgressCirculars.get(index).has().width(width);
    }

    @Test(dataProvider = "sizeWidthProgressCircularsTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void sizeWidthProgressCircularsTests(int index, String color, String height, String width) {
        sizeWidthProgressCirculars.get(index).is().displayed();
        sizeWidthProgressCirculars.get(index).is().spinning();
        sizeWidthProgressCirculars.get(index).has().color(color);
        sizeWidthProgressCirculars.get(index).has().height(height);
        sizeWidthProgressCirculars.get(index).has().width(width);
    }
}
