package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.FormContacts;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.FormUsers.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.BLANK_CONTACT;
import static io.github.com.entities.FormUsers.DEFAULT_CHECK;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.pages.BootstrapPage.formCustomStyles;
import static io.github.com.pages.BootstrapPage.formGrid;
import static io.github.com.pages.BootstrapPage.formServerSide;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class FormGridTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] layoutData() {
        return new Object[][]{
                {formGrid.name, "input", "form-control", "text", "First name"},
                {formGrid.lastName, "input", "form-control", "text", "Last name"},
        };
    }

    @Test(dataProvider = "layoutData")
    public void isValidationTests(TextField element, String tagPresent, String classPresent,
                                  String type, String placeHolder) {
        element.highlight();
        element
                .is()
                .enabled()
                .displayed()
                .core()
                .tag(is(tagPresent))
                .hasClass(classPresent)
                .attr("type", type)
                .attr("placeholder", placeHolder);
        element.unhighlight();
    }

    @DataProvider
    public Object[][] personalData() {
        return new Object[][]{
                {"edgar", "poe"},
                {"Mark", ""},
                {"", "Twain"},
                {"", ""}
        };
    }

    @Test (dataProvider = "personalData")
    public void fillTest(String firstName, String lastName) {
        formGrid.fill(BLANK_CONTACT.set(c -> {c.name = firstName; c.lastName = lastName; }));
        formGrid.check(BLANK_CONTACT);
        checkContactFormSubmitted();
    }

    private void checkContactFormSubmitted() {
        formGrid.submit();
        validateAlert(is("Form filled and submitted successfully"));
        formGrid.check(BLANK_CONTACT.set(c -> {c.name = ""; c.lastName = ""; }));
    }
}
