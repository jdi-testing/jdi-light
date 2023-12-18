package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.selectPage;
import static io.github.com.pages.SelectPage.basicMatSelect;
import static org.hamcrest.Matchers.hasItems;

public class BasicMatSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        selectPage.open();
        waitCondition(() -> selectPage.isOpened());
        selectPage.checkOpened();
    }

    @Test(description = "Test checks label value")
    public void checkLabelValue() {
        basicMatSelect.label().has().value("Favorite food");
    }

    @Test(description = "Test checks expand-collapse functionality")
    public void checkSelectorExpanded() {
        basicMatSelect.expand();
        basicMatSelect.is().expanded();
        basicMatSelect.collapse();
        basicMatSelect.is().collapsed();
    }

    @Test(description = "Test checks that element does not contain disabled options")
    public void checkListDisabledOptions() {
        basicMatSelect.has().listDisabled(Collections.EMPTY_LIST);
    }

    @Test(description = "Test checks that element contains certain enabled options")
    public void checkListEnabledOptions() {
        basicMatSelect.has().listEnabled(Arrays.asList(STEAK, PIZZA, TACOS));
    }

    @Test(description = "Test checks that element contains certain options")
    public void checkAvailableOptions() {
        basicMatSelect.assertThat().values(hasItems(TACOS, STEAK, PIZZA));
    }

}
