package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.basicMatSelect;
import static org.hamcrest.Matchers.hasItems;

public class BasicMatSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.shouldBeOpened();
        basicMatSelect.show();
    }

    @Test
    public void checkLabelValue() {
        basicMatSelect.label().has().value("Favorite food");
    }

    @Test
    public void checkSelectorExpanded() {
        basicMatSelect.expand();
        basicMatSelect.is().expanded();
        basicMatSelect.collapse();
        basicMatSelect.is().collapsed();
    }

    @Test
    public void checkSelectorCollapsed() {
        basicMatSelect.collapse();
        basicMatSelect.is().collapsed();
    }

    @Test
    public void checkOptionCanBeSelectedByIndex() {
        basicMatSelect.select(ELEMENT.startIndex + 1);
        basicMatSelect.is().selected(PIZZA);
    }

    @Test
    public void checkListDisabledOptions() {
        basicMatSelect.has().listDisabled(Collections.EMPTY_LIST);
    }

    @Test
    public void checkListEnabledOptions() {
        basicMatSelect.has().listEnabled(Arrays.asList(STEAK, PIZZA, TACOS));
    }

    @Test
    public void checkAvailableOptions() {
        basicMatSelect.assertThat().values(hasItems(TACOS, STEAK, PIZZA));
    }

}
