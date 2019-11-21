package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsFormsPage;
import static io.github.com.pages.BootstrapFormsPage.lastLogEntry;
import static io.github.com.pages.BootstrapFormsPage.superheroForm;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.Superheroes.EXAMPLE_HERO;
import static io.github.epam.test.data.Superheroes.TEMPLATE_HERO;
import static org.hamcrest.Matchers.containsString;

public class ComplicatedFormTests extends TestsInit {

    private final String logLineSubmit = "superhero-button-submit:button clicked";
    private final String logLineClear = "superhero-button-clear:button clicked";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsFormsPage.shouldBeOpened();
    }

    @Test
    public void submitButtonTest() {
        superheroForm.superheroButtonSubmit.click();
        lastLogEntry.has().text(containsString(logLineSubmit));
    }

    @Test
    public void clearButtonTest() {
        superheroForm.superheroButtonClear.click();
        lastLogEntry.has().text(containsString(logLineClear));
    }

    @Test
    public void submitFormTest() {
        setDefaultValues();
        superheroForm.submit(EXAMPLE_HERO);
        lastLogEntry.has().text(containsString(logLineSubmit));
        superheroForm.check(EXAMPLE_HERO);
    }

    @Test
    public void clearFormTest() {
        setDefaultValues();
        superheroForm.clear(EXAMPLE_HERO);
        lastLogEntry.has().text(containsString(logLineClear));
        superheroForm.check(TEMPLATE_HERO);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(superheroForm);
    }

    private void setDefaultValues() {
        superheroForm.currentAlias.setValue(TEMPLATE_HERO.currentAlias);
        superheroForm.alterEgo.setValue(TEMPLATE_HERO.alterEgo);
        superheroForm.species.setValue(TEMPLATE_HERO.species);
        superheroForm.selectUniverse.setValue(TEMPLATE_HERO.selectUniverse);
        superheroForm.superheroRange.setValue(TEMPLATE_HERO.superheroRange);
        superheroForm.superheroSwitch.setValue(TEMPLATE_HERO.superheroSwitch);
    }
}
