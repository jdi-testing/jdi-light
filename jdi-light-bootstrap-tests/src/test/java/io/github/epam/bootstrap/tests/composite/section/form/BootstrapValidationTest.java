package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.com.entities.SimpleContact;
import io.github.com.sections.form.FormValidationForm;
import io.github.epam.TestsInit;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.github.com.StaticSite.formPage;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class BootstrapValidationTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        formPage.shouldBeOpened();
        //refresh();
    }

    @DataProvider
    public Object[][] positiveData() {
        return new Object[][]{
                {new SimpleContact("Peter", "peter@dailybugle.com", "+44 (589)-23-11")},
                {new SimpleContact("Peter Parker", "spidey@photo.com", "")},
                {new SimpleContact("With great power there must also come—great responsibility!", "doesnt@matter", "123")},
        };
    }

    @Test(description = "Test validation rules with positive data", dataProvider = "positiveData")
    public void simpleValidationPositiveTest(SimpleContact entity) {

        FormValidationForm form = formPage.formValidationSection.form();
        formPage.formValidationSection.switchToBrowserValidation();

        form.fill(entity);
        Assert.assertTrue(form.isValid());

        form.reset();

        formPage.formValidationSection.switchToCustomValidation();

        form.fill(entity);
        Assert.assertTrue(form.isValid());

        form.reset();
    }

    @DataProvider
    public Object[][] negativeData() {
        return new Object[][]{
                {new SimpleContact("", "", "")},
                {new SimpleContact("Norman", "gg@oscorp.com", "Ha ha ha!")},
                {new SimpleContact("", "gg@oscorp.com", "123")},
        };
    }

    @Test(description = "Test validation rules with negative data", dataProvider = "negativeData")
    public void simpleValidationNegativeTest(SimpleContact entity) {

        FormValidationForm form = formPage.formValidationSection.form();
        formPage.formValidationSection.switchToBrowserValidation();

        form.fill(entity);
        Assert.assertFalse(form.isValid());

        form.reset();

        formPage.formValidationSection.switchToCustomValidation();

        form.fill(entity);
        Assert.assertFalse(form.isValid());

        form.reset();
    }

    @Test
    public void bootstrapValidationTest() {

        String name = "ValidName";
        String email = "InvalidEmail";
        String phone = "InvalidPhone";

        SimpleContact entity = new SimpleContact(name, email, phone);

        FormValidationForm form = formPage.formValidationSection.form();
        formPage.formValidationSection.switchToCustomValidation();

        form.fill(entity);
        form.submit();

        Map<String, String> validFeedback = form.getValidFeedback();

        MatcherAssert.assertThat("Number of valid feedbacks not equals 1", validFeedback.size() == 1);
        MatcherAssert.assertThat(validFeedback.keySet(), Matchers.hasItems("Name"));
        MatcherAssert.assertThat(validFeedback.values(), Matchers.hasItem("Hi, " + name + "!"));

        Map<String, String> invalidFeedback = form.getInvalidFeedback();
        MatcherAssert.assertThat("Number of invalid feedbacks not equals 2", invalidFeedback.size() == 2);
        MatcherAssert.assertThat(invalidFeedback.keySet(), Matchers.hasItems("Email", "Phone"));
        MatcherAssert.assertThat(invalidFeedback.values(), Matchers.hasItems("Enter valid email!", "It doesn't look like a valid phone number"));

        form.reset();

    }

    @AfterMethod
    public void reset() {
        formPage.formValidationSection
                .form()
                .reset();
    }

}
