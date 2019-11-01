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
import static org.hamcrest.Matchers.containsString;

public class ComplicatedFormTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsFormsPage.shouldBeOpened();
    }

    @Test
    public void fillAndVerifyForm() {
        superheroForm.fill(EXAMPLE_HERO);
        superheroForm.verify(EXAMPLE_HERO);
    }

    @Test
    public void submitForm() {
        superheroForm.submit(EXAMPLE_HERO);
        lastLogEntry.has().text(containsString("superhero-button-submit:button clicked"));
        superheroForm.check(EXAMPLE_HERO);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(superheroForm);
    }
}
