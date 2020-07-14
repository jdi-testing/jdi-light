package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.formMatFeatureSelect;
import static org.hamcrest.Matchers.matchesPattern;

public class FormMatFeatureSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        formMatFeatureSelect.show();
    }

    @Test
    public void checkLabelValue() {
        formMatFeatureSelect.label().has().value("Favorite animal *");
    }

    @Test
    public void checkOptionCanBeSelectedByNameAndHintMessageWillAppear() {
        formMatFeatureSelect.select("Fox");
        formMatFeatureSelect.is().selected("Fox");
        formMatFeatureSelect.hint().assertThat().text("Wa-pa-pa-pa-pa-pa-pow!");
    }

    @Test
    public void checkEmptyOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        formMatFeatureSelect.select("--");
        formMatFeatureSelect.is().selected(matchesPattern("\\W+"));
        formMatFeatureSelect.error().assertThat().text("Please choose an animal");
    }

    @Test
    public void checkListDisabledOptions() {
        formMatFeatureSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        formMatFeatureSelect.has().listEnabled(Arrays.asList("--", "Dog", "Cat", "Fox", "Cow"));
    }

    @Test
    public void checkAvailableOptions() {
        formMatFeatureSelect.assertThat().values("--", "Cat", "Dog", "Fox", "Cow");
    }
}
