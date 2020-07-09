package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.formMatFeatureSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
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
        formMatFeatureSelect.select("Cat");
        formMatFeatureSelect.is().selected("Cat");
        formMatFeatureSelect.hint().assertThat().text("Meow!");
    }

    @Test
    public void checkEmptyOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        formMatFeatureSelect.select("--");
        formMatFeatureSelect.is().selected(matchesPattern("\\W+"));
        formMatFeatureSelect.error().assertThat().text("Please choose an animal");
    }

    @Test
    public void checkAvailableOptions() {
        formMatFeatureSelect.assertThat().values(hasItem("Cat")).values(hasItems("Cat", "Dog", "Fox", "Cow"));
    }
}
