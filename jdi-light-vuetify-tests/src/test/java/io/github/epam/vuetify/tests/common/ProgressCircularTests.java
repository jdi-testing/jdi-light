package io.github.epam.vuetify.tests.common;

import io.github.com.dataproviders.ProgressCircularDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.progressCircularPage;
import static io.github.com.pages.ProgressCircularPage.colorProgressSpinners;
import static io.github.com.pages.ProgressCircularPage.indeterminateProgressSpinners;
import static io.github.com.pages.ProgressCircularPage.rotateProgressSpinners;
import static io.github.com.pages.ProgressCircularPage.sizeWidthProgressSpinners;

public class ProgressCircularTests extends TestsInit {

    @BeforeClass
    public void before() {
        progressCircularPage.open();
        waitCondition(() -> progressCircularPage.isOpened());
        progressCircularPage.checkOpened();
    }

    @Test(dataProvider = "colorProgressSpinnersTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void colorProgressCircularsTests(int index, String color, String height, String width) {
        colorProgressSpinners.get(index).is().displayed();
        colorProgressSpinners.get(index).is().notSpinning();
        colorProgressSpinners.get(index).has().color(color);
        colorProgressSpinners.get(index).has().height(height);
        colorProgressSpinners.get(index).has().width(width);
    }

    @Test(dataProvider = "indeterminateProgressSpinnersTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void indeterminateProgressCircularsTests(int index, String color, String height, String width) {
        indeterminateProgressSpinners.get(index).is().displayed();
        indeterminateProgressSpinners.get(index).is().spinning();
        indeterminateProgressSpinners.get(index).has().color(color);
        indeterminateProgressSpinners.get(index).has().height(height);
        indeterminateProgressSpinners.get(index).has().width(width);
    }

    @Test(dataProvider = "rotateProgressSpinnersTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void rotateProgressCircularsTests(int index, String color, String height, String width) {
        rotateProgressSpinners.get(index).is().displayed();
        rotateProgressSpinners.get(index).has().color(color);
        rotateProgressSpinners.get(index).has().height(height);
        rotateProgressSpinners.get(index).has().width(width);
    }

    @Test(dataProvider = "sizeWidthProgressSpinnersTestsDataProvider",
            dataProviderClass = ProgressCircularDataProvider.class)
    public void sizeWidthProgressCircularsTests(int index, String color, String height, String width) {
        sizeWidthProgressSpinners.get(index).is().displayed();
        sizeWidthProgressSpinners.get(index).is().spinning();
        sizeWidthProgressSpinners.get(index).has().color(color);
        sizeWidthProgressSpinners.get(index).has().height(height);
        sizeWidthProgressSpinners.get(index).has().width(width);
    }
}
