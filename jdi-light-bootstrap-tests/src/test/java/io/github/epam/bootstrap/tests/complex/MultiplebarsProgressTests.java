package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multiplebarsProgress;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MultiplebarsProgressTests extends TestsInit {

    private List<String> multipleprogressValues = Arrays.asList("15", "30", "20");

    @BeforeClass
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] progressMultipleBarsData() {
        return new Object[][] {
                {multiplebarsProgress.getProgress(1), "rgba(0, 123, 255, 1)", "15", "0", "100"},
                {multiplebarsProgress.getProgress(2), "rgba(40, 167, 69, 1)", "30", "0", "100"},
                {multiplebarsProgress.getProgress(3), "rgba(23, 162, 184, 1)", "20", "0", "100"}
        };
    }

    @Test(dataProvider = "progressMultipleBarsData")
    public void separateBarTest(Progress progress, String color, String value, String minValue, String maxValue) {
        baseValidation(progress);
        progress.is()
                .displayed()
                .enabled()
                .color(color)
                .value(value)
                .minValue(minValue)
                .maxValue(maxValue);
    }

    @Test
    public void entireMultiplebarsProgressTest() {
        multiplebarsProgress.getProgresses().is().size(3);
        multiplebarsProgress.is()
                .displayed()
                .enabled();
        assertThat(multiplebarsProgress.core().css("background-color"), is("rgba(233, 236, 239, 1)"));
        baseValidation(multiplebarsProgress);
    }

    @Test
    public void getValuesTest() {
        assertThat(multiplebarsProgress.getValues(), is(multipleprogressValues));
        assertThat(multiplebarsProgress.getValues().get(1), is("30"));
    }
}
