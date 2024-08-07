package io.github.epam.vuetify.tests.common;

import com.jdiai.tools.Timer;
import io.github.com.dataproviders.ProgressLinearDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.progressLinearPage;
import static io.github.com.pages.ProgressLinearPage.bufferValueProgressLinears;
import static io.github.com.pages.ProgressLinearPage.colorsProgressLinears;
import static io.github.com.pages.ProgressLinearPage.defaultProgressLinears;
import static io.github.com.pages.ProgressLinearPage.indeterminateProgressLinears;
import static io.github.com.pages.ProgressLinearPage.queryProgressLinear;
import static io.github.com.pages.ProgressLinearPage.reversedProgressLinears;
import static io.github.com.pages.ProgressLinearPage.roundedProgressLinears;
import static io.github.com.pages.ProgressLinearPage.streamProgressLinears;
import static io.github.com.pages.ProgressLinearPage.stripedProgressLinears;

public class ProgressLinearTests extends TestsInit {

    @BeforeClass
    public void before() {
        progressLinearPage.open();
        waitCondition(() -> progressLinearPage.isOpened());
        progressLinearPage.checkOpened();
    }

    @Test(description = "Test checks that progress linear is reactive or not")
    public void reactiveProgressLinearTests() {
        bufferValueProgressLinears.get(1).show();
        bufferValueProgressLinears.get(1).is().displayed().and().reactive();
        colorsProgressLinears.get(1).show();
        colorsProgressLinears.get(1).is().notReactive();
    }

    @Test(description = "Test checks that progress linear is determinate or not")
    public void determinateIndeterminateProgressLinearTests() {
        bufferValueProgressLinears.get(1).show();
        bufferValueProgressLinears.get(1).is().determinate();
        indeterminateProgressLinears.get(1).show();
        indeterminateProgressLinears.get(1).is().indeterminate();
    }

    @Test(description = "Test checks progress linear color", dataProvider = "colorsProgressLinearsTestsDataProvider",
            dataProviderClass = ProgressLinearDataProvider.class)
    public void colorsProgressLinearTests(int index, String color, String barColor) {
        colorsProgressLinears.get(index).show();
        colorsProgressLinears.get(index).has().backgroundColor(color)
                .and().barColor(barColor);
    }

    @Test(description = "Test checks absolute value of progress linear and checks if it is hidden : value")
    public void absoluteValueHiddenProgressLinearTests() {
        queryProgressLinear.show();
        Timer.waitCondition(() -> queryProgressLinear.getValue() == 25);
        Timer.waitCondition(() -> queryProgressLinear.getValue() == 50);
        Timer.waitCondition(() -> queryProgressLinear.getValue() == 75);
        Timer.waitCondition(() -> queryProgressLinear.getValue() == 100);
        Timer.waitCondition(queryProgressLinear::isHidden);
        Timer.waitCondition(queryProgressLinear::isDisplayed);
        queryProgressLinear.has().valueMax(100.0);
    }

    @Test(description = "Test checks if progress linear is reversed or not : reversed")
    public void reversedProgressLinearTests() {
        reversedProgressLinears.get(1).show();
        reversedProgressLinears.get(1).is().reversed();
        roundedProgressLinears.get(1).show();
        roundedProgressLinears.get(1).is().notReversed();
    }

    @Test(description = "Test checks if progress linear is rounded or not")
    public void roundedProgressLinearTests() {
        roundedProgressLinears.get(1).show();
        roundedProgressLinears.get(1).is().rounded();
        streamProgressLinears.get(1).show();
        streamProgressLinears.get(1).is().notRounded();
    }

    @Test(description = "Test checks if progress linear has stream or not")
    public void streamProgressLinearsTests() {
        streamProgressLinears.get(1).show();
        streamProgressLinears.get(1).has().stream();
        stripedProgressLinears.get(1).show();
        stripedProgressLinears.get(1).has().noStream();
    }

    @Test(description = "Test checks if progress linear is striped or not")
    public void stripedProgressLinearTests() {
        stripedProgressLinears.get(1).show();
        stripedProgressLinears.get(1).is().striped();
        defaultProgressLinears.get(1).show();
        defaultProgressLinears.get(1).is().notStriped();
    }

    @Test(description = "Test checks if progress linear's height : height")
    public void heightProgressLinearTests() {
        defaultProgressLinears.get(1).show();
        defaultProgressLinears.get(1).has().heightGreaterThan(20)
                .and().heightLessThan(30)
                .and().height(25);
    }

    @Test(description = "Test checks progress linear's theme : theme")
    public void themeProgressLinearTests() {
        stripedProgressLinears.get(1).show();
        stripedProgressLinears.get(1).has().darkTheme();
        defaultProgressLinears.get(1).show();
        defaultProgressLinears.get(1).has().lightTheme();
    }
}
