package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.bsPage;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class MultipleProgressBarsTests extends TestsInit {

    private List<String> multipleProgressBarsValues = Arrays.asList("15", "30", "20");

    @BeforeClass
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    //@DataProvider
    //public Object[][] multipleProgressBarsData() {
    //    return new Object[][] {
    //            {multipleProgressBars.getProgress(1), "rgba(0, 123, 255, 1)", "15", "0", "100"},
    //            {multipleProgressBars.getProgress(2), "rgba(40, 167, 69, 1)", "30", "0", "100"},
    //            {multipleProgressBars.getProgress(3), "rgba(23, 162, 184, 1)", "20", "0", "100"}
    //    };
    //}

    //@Test(dataProvider = "multipleProgressBarsData")
    //public void separateBarTest(Progress progress, String color, String value, String minValue, String maxValue) {
    //    baseValidation(progress);
    //    progress.is()
    //            .displayed()
    //            .enabled()
    //            .color(color)
    //            .value(value)
    //            .minValue(minValue)
    //            .maxValue(maxValue);
    //}

    //@Test
    //public void entireMultipleProgressBarsTest() {
    //    multipleProgressBars.getProgresses().is().size(3);
    //    multipleProgressBars.is()
    //            .displayed()
    //            .enabled();
    //    assertThat(multipleProgressBars.core().css("background-color"), is("rgba(233, 236, 239, 1)"));
    //    baseValidation(multipleProgressBars);
    //}
    //@Test
    //public void getValuesTest() {
    //    assertThat(multipleProgressBars.getValues(), is(multipleProgressBarsValues));
    //    assertThat(multipleProgressBars.getValues().get(1), is("30"));
    //}
}
