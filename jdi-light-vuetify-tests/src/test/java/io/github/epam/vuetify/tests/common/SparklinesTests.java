package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.sparklinesPage;
import static io.github.com.pages.SparklinesPage.customLabelsSparkline;
import static io.github.com.pages.SparklinesPage.dashboardCardSparkline;
import static io.github.com.pages.SparklinesPage.fillSparkline;
import static io.github.com.pages.SparklinesPage.fillSparklineColorSwitches;
import static io.github.com.pages.SparklinesPage.fillSparklineWidthSlider;
import static io.github.com.pages.SparklinesPage.fillSparklineRadiusSlider;
import static io.github.com.pages.SparklinesPage.fillSparklinePaddingSlider;
import static io.github.com.pages.SparklinesPage.fillSparklineFilledSwitch;
import static io.github.com.pages.SparklinesPage.heartRateSparkline;
import static io.github.com.pages.SparklinesPage.heartRateRefreshButton;

public class SparklinesTests extends TestsInit {

    @BeforeClass
    public void before() {
        sparklinesPage.open();
        sparklinesPage.checkOpened();
    }

    @DataProvider(name = "fillSparklineLinearGradientTestsData")
    public Object[][] fillSparklineLinearGradientTestsData() {
        return new Object[][]{
                {"Linear gradient map 1", Collections.singletonMap("0", "#222"), 1},
                {"Linear gradient map 2", Collections.singletonMap("0", "#42b3f4"), 2},
                {"Linear gradient map 3", Stream.of(new String[][]{
                        {"0", "yellow"},
                        {"0.5", "orange"},
                        {"1", "red"},
                }).collect(Collectors.toMap(data -> data[0], data -> data[1])), 3},
                {"Linear gradient map 4", Stream.of(new String[][]{
                        {"0", "violet"},
                        {"1", "purple"},
                }).collect(Collectors.toMap(data -> data[0], data -> data[1])), 4},
                {"Linear gradient map 5", Stream.of(new String[][]{
                        {"0", "#FF0"},
                        {"0.5", "#F0F"},
                        {"1", "#00c6ff"},
                }).collect(Collectors.toMap(data -> data[0], data -> data[1])), 5},
                {"Linear gradient map 6", Stream.of(new String[][]{
                        {"0", "#1feaea"},
                        {"0.5", "#ffd200"},
                        {"1", "#f72047"},
                }).collect(Collectors.toMap(data -> data[0], data -> data[1])), 6},
        };
    }

    @Test(dataProvider = "fillSparklineLinearGradientTestsData")
    public void fillSparklineLinearGradientTests(String testDataId,
                                                 Map<String, String> expectedLinearGradientMap,
                                                 int gradientSwitchNumber) {
        fillSparklineColorSwitches.get(gradientSwitchNumber).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap);
    }


    @Test
    public void fillSparklineTests() {
        fillSparklineWidthSlider.slideHorizontalTo(1);
        fillSparkline.has().lineWidth(1.0);

        String pathShapeBeforeRadiusSliderInteraction = fillSparkline.getPathShape();
        fillSparklineRadiusSlider.slideHorizontalTo(1);
        fillSparkline.has().pathShapeNotEqualTo(pathShapeBeforeRadiusSliderInteraction);

        String pathShapeBeforePaddingSliderInteraction = fillSparkline.getPathShape();
        fillSparklinePaddingSlider.slideHorizontalTo(13);
        fillSparkline.has().pathShapeNotEqualTo(pathShapeBeforePaddingSliderInteraction);

        fillSparkline.is().filled();
        fillSparklineFilledSwitch.uncheck();
        fillSparkline.is().notFilled();
    }

    @Test
    public void customLabelsSparklineTests() {
        customLabelsSparkline.has().labelsPrefixedWith("$");
    }

    @Test
    public void dashboardCardSparklineTests() {
        Map<String, String> expectedLinearGradientMap = Collections.singletonMap("0", "currentColor");
        dashboardCardSparkline.has().linearGradientMap(expectedLinearGradientMap);
    }

    @Test
    public void heartRateSparklineTests() {
        String initialHeartRatePathShape = heartRateSparkline.getPathShape();
        heartRateSparkline.has().pathShapeEqualTo(initialHeartRatePathShape);

        heartRateRefreshButton.click();
        waitCondition(() -> heartRateRefreshButton.hasAttribute("red--text"));

        heartRateSparkline.has().pathShapeNotEqualTo(initialHeartRatePathShape);
    }
}
