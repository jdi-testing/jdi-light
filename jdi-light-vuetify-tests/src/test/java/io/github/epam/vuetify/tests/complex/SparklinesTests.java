package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
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
        // open() can perform too fast, forcing subsequent checks to fail
        waitCondition(() -> sparklinesPage.isOpened());
    }

    @Test
    public void fillSparklineTests() {
        Map<String, String> expectedLinearGradientMap1 = Collections.singletonMap("0", "#222");
        Map<String, String> expectedLinearGradientMap2 = Collections.singletonMap("0", "#42b3f4");
        Map<String, String> expectedLinearGradientMap3 = Stream.of(new String[][] {
                { "0", "yellow" },
                { "0.5", "orange" },
                { "1", "red"},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> expectedLinearGradientMap4 = Stream.of(new String[][] {
                { "0", "violet" },
                { "1", "purple" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> expectedLinearGradientMap5 = Stream.of(new String[][] {
                { "0", "#FF0"  },
                { "0.5", "#F0F" },
                { "1", "#00c6ff"},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> expectedLinearGradientMap6 = Stream.of(new String[][] {
                { "0", "#1feaea" },
                { "0.5", "#ffd200" },
                { "1", "#f72047" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        fillSparklineColorSwitches.get(1).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap1);
        fillSparklineColorSwitches.get(2).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap2);
        fillSparklineColorSwitches.get(3).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap3);
        fillSparklineColorSwitches.get(4).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap4);
        fillSparklineColorSwitches.get(5).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap5);
        fillSparklineColorSwitches.get(6).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap6);

        fillSparklineWidthSlider.slideHorizontalTo(1);
        fillSparkline.has().lineWidth(1.0);
        fillSparklineWidthSlider.slideHorizontalTo(7);
        fillSparkline.has().lineWidth(7.0);

        String pathShapeBeforeRadiusSliderInteraction = fillSparkline.getPathShape();
        fillSparklineRadiusSlider.slideHorizontalTo(1);
        fillSparkline.has().pathShapeNotEqualTo(pathShapeBeforeRadiusSliderInteraction);

        String pathShapeBeforePaddingSliderInteraction = fillSparkline.getPathShape();
        fillSparklinePaddingSlider.slideHorizontalTo(13);
        fillSparkline.has().pathShapeNotEqualTo(pathShapeBeforePaddingSliderInteraction);

        fillSparklineFilledSwitch.uncheck();
        fillSparkline.is().notFilled();

        fillSparklineFilledSwitch.check();
        fillSparkline.is().filled();
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
