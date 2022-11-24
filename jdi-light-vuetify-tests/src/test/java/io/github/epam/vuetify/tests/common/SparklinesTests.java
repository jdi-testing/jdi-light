package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SparklinesDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.sparklinesPage;
import static io.github.com.pages.SparklinesPage.barSparkline;
import static io.github.com.pages.SparklinesPage.customLabelsSparkline;
import static io.github.com.pages.SparklinesPage.dashboardCardSparkline;
import static io.github.com.pages.SparklinesPage.fillSparkline;
import static io.github.com.pages.SparklinesPage.fillSparklineColorSwitches;
import static io.github.com.pages.SparklinesPage.fillSparklineFilledSwitch;
import static io.github.com.pages.SparklinesPage.fillSparklinePaddingSlider;
import static io.github.com.pages.SparklinesPage.fillSparklineRadiusSlider;
import static io.github.com.pages.SparklinesPage.fillSparklineWidthSlider;
import static io.github.com.pages.SparklinesPage.heartRateSparkline;

public class SparklinesTests extends TestsInit {

    @BeforeClass
    public void before() {
        sparklinesPage.open();
        waitCondition(() -> sparklinesPage.isOpened());
        sparklinesPage.checkOpened();
    }

    @Test(dataProvider = "fillSparklineLinearGradientTestsData", dataProviderClass = SparklinesDataProvider.class,
    description = "Test checks sparkline's linear gradient")
    public void linearGradientSparklineTests(Map<String, String> expectedLinearGradientMap,
                                                 int gradientSwitchNumber) {
        fillSparklineColorSwitches.get(gradientSwitchNumber).click();
        fillSparkline.has().linearGradientMap(expectedLinearGradientMap);
    }


    @Test (description = "Test checks sparkline's path shape")
    public void pathShapeSparklineTests() {
        fillSparklineWidthSlider.slideHorizontalTo("1");
        fillSparkline.has().lineWidth(1);

        String pathShapeBeforeRadiusSliderInteraction = fillSparkline.getPathShape();
        fillSparkline.has().pathShapeEqualTo(pathShapeBeforeRadiusSliderInteraction);
        fillSparklineRadiusSlider.slideHorizontalTo("1");
        fillSparkline.has().pathShapeNotEqualTo(pathShapeBeforeRadiusSliderInteraction);

        String pathShapeBeforePaddingSliderInteraction = fillSparkline.getPathShape();
        fillSparklinePaddingSlider.slideHorizontalTo("13");
        fillSparkline.has().pathShapeNotEqualTo(pathShapeBeforePaddingSliderInteraction);
        fillSparklinePaddingSlider.slideHorizontalTo("1");
    }

    @Test (description = "Test checks fill feature")
    public void fillSparklineTests() {
        fillSparkline.show();
        fillSparkline.is().filled();
        fillSparklineFilledSwitch.uncheck();
        fillSparkline.is().notFilled();
    }

    @Test (description = "Test checks label prefix and postfix")
    public void customLabelsSparklineTests() {
        customLabelsSparkline.show();
        customLabelsSparkline.has().labelsPrefixedWith("$");
        dashboardCardSparkline.show();
        dashboardCardSparkline.has().labelsPostfixedWith("m");
    }

    @Test (description = "Test checks linear gradient")
    public void dashboardCardSparklineTests() {
        Map<String, String> expectedLinearGradientMap = Collections.singletonMap("0", "currentColor");
        dashboardCardSparkline.has().linearGradientMap(expectedLinearGradientMap);
    }

    @Test(description = "Check sparkline's type : type (trend/bars)")
    public void typeSparklineTests() {
        heartRateSparkline.show();
        heartRateSparkline.is().trendline();
        barSparkline.show();
        barSparkline.is().bar();
    }

    @Test(enabled = false, description = "Check sparkline's height and width : height, width")
    public void measurementsSparklineTests() {
        barSparkline.show();
        barSparkline.has().widthLessThan(1000);
        barSparkline.has().widthGreaterThan(900);
        barSparkline.has().width(959);
        barSparkline.has().heightLessThan(300);
        barSparkline.has().heightGreaterThan(200);
        barSparkline.has().height(273);
    }

    @Test(description = "Check if sparkline has visible labels or not : show labels (y/n)")
    public void labelsSparklineTests() {
        barSparkline.show();
        barSparkline.has().labels();
        barSparkline.has().labelTexts(Arrays.asList("1", "2", "3"));
        heartRateSparkline.show();
        heartRateSparkline.has().notLabels();
    }

    @Test(description = "Check sparkline's label font size : label size")
    public void labelSizeSparklineTests() {
        customLabelsSparkline.show();
        customLabelsSparkline.has().labelFontSize(8);
    }

    @Test(description = "Check sparkline's line width : line width")
    public void lineWidthSparklineTests() {
        heartRateSparkline.show();
        heartRateSparkline.has().lineWidth(3);
    }

    @Test(description = "Check sparkline's bars height and width")
    public void barsHeightAndWidthSparklineTests() {
        barSparkline.show();
        barSparkline.has().barWidth(4);
        barSparkline.has().barsWidth(Arrays.asList(4, 4, 4));
        barSparkline.has().barsHeight(Arrays.asList(25, 50, 75));
    }
}
