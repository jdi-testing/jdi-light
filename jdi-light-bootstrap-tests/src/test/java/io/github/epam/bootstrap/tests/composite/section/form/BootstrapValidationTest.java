package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.entities.FormContacts;
import io.github.com.entities.SimpleContact;
import io.github.com.sections.form.FormValidationForm;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.github.com.StaticSite.formPage;
import static io.github.com.pages.BootstrapPage.formCustomStyles;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class BootstrapValidationTest extends TestsInit {



    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        formPage.shouldBeOpened();
        //refresh();
    }

    @DataProvider
    public Object[][] positiveData() {
        return new Object[][] {
                {new SimpleContact("Peter", "peter@dailybugle.com", "+44 (589)-23-11")},
                {new SimpleContact("Peter Parker", "spidey@photo.com", "")},
                {new SimpleContact("With great power there must also come—great responsibility!", "doesnt@matter", "123")},
        };
    }

    @Test(description = "Test validation rules with positive data", dataProvider = "positiveData")
    public void simpleValidationPositiveTest(SimpleContact entity) {

        FormValidationForm form = formPage.formValidationSection.form();
        formPage.formValidationSection.swithToBrowserValidation();

        form.fill(entity);
        Assert.assertTrue(form.isValid());

        form.pressButton("reset");

        formPage.formValidationSection.swithToCustomValidation();

        form.fill(entity);
        Assert.assertTrue(form.isValid());

        form.pressButton("reset");
    }

    @DataProvider
    public Object[][] negativeData() {
        return new Object[][] {
                {new SimpleContact("", "", "")},
                {new SimpleContact("Norman", "gg@oscorp.com", "Ha ha ha!")},
                {new SimpleContact("", "gg@oscorp.com", "123")},
        };
    }

    @Test(description = "Test validation rules with negative data", dataProvider = "negativeData")
    public void simpleValidationNegativeTest(SimpleContact entity) {

        FormValidationForm form = formPage.formValidationSection.form();
        formPage.formValidationSection.swithToBrowserValidation();

        form.fill(entity);
        Assert.assertFalse(form.isValid());

        form.pressButton("reset");

        formPage.formValidationSection.swithToCustomValidation();

        form.fill(entity);
        Assert.assertFalse(form.isValid());

        form.pressButton("reset");
    }

/*
    @Test
    public void formValidationTest() {

        boolean browserValidation = formCustomStyles.isBrowserValidation();
        Assert.assertFalse(browserValidation);

        formCustomStyles.submit(contact());
        Alerts.validateAlert(is("Form filled and submitted successfully"));

        WebList nameInvalidFeedback = formCustomStyles.getInvalidFeedback(formCustomStyles.name);
        nameInvalidFeedback.is().size(0);

        WebList nameValidFeedback = formCustomStyles.getValidFeedback(formCustomStyles.name);
        nameValidFeedback.is().size(1);
        nameValidFeedback.get(1).is()
                .displayed()
                .text("Looks good!")
                .css("color", "rgba(40, 167, 69, 1)");

        WebList userNameInvalidFeedback = formCustomStyles.getInvalidFeedback(formCustomStyles.userName);
        userNameInvalidFeedback.is().size(1);
        userNameInvalidFeedback.get(1).is()
                .displayed()
                .text("Please choose a username.")
                .css("color","rgba(220, 53, 69, 1)");

        WebList userNameValidFeedback = formCustomStyles.getValidFeedback(formCustomStyles.userName);
        userNameValidFeedback.is().size(0);
    }*/

    @Test
    public void validationAgainstMapTest() {


        formCustomStyles.submit(contact());
        Alerts.validateAlert(is("Form filled and submitted successfully"));

        Map<String, UIElement> map = formCustomStyles.getAllFeedbackElements();



        System.out.println(map);
    }

    private SimpleContact entity(String name, String email, String phone) {
        return new SimpleContact(name, email, phone);
    }

    private FormContacts contact() {
        return new FormContacts().set(c -> {
            c.name = "NAME";
            c.lastName = "LAST NAME";
            c.userName = "";
            c.city = "";
            c.state = "";
            c.zip = "";
            c.accept = "";
            c.radio = "";
            c.email = "";
            c.password = "";
        });
    }
}
