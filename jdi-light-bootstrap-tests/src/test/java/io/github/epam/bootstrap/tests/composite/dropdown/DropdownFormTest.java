package io.github.epam.bootstrap.tests.composite.dropdown;

import com.epam.jdi.light.elements.common.WindowsManager;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.FormContacts;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownForm;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DropdownFormTest extends TestsInit {

    private static FormContacts USER = new FormContacts().set(c -> {
        c.email = "testEmail@example.com";
        c.password = "qwerty";
        c.accept = "true";
    });

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(dropdownForm);
        dropdownForm.unhighlight();

        dropdownForm.expand();
        baseValidation(dropdownForm.expander());
        dropdownForm.expander().unhighlight();

        baseValidation(dropdownForm.form);
        dropdownForm.form.unhighlight();
        baseValidation(dropdownForm.form.email);
        dropdownForm.form.email.unhighlight();
        baseValidation(dropdownForm.form.password);
        dropdownForm.form.password.unhighlight();
        baseValidation(dropdownForm.form.checkbox);
        dropdownForm.form.checkbox.unhighlight();
        baseValidation(dropdownForm.form.accept);
        dropdownForm.form.accept.unhighlight();

        dropdownForm.collapse();
    }

    @DataProvider
    public Object[][] listFields() {
        return new Object[][]{
                {dropdownForm.form.email, "email", "Email address", "email@example.com"},
                {dropdownForm.form.password, "password", "Password", "Password"}
        };
    }

    @Test(dataProvider = "listFields")
    public void isValidationTests(TextField element, String type, String label, String value) {
        dropdownForm.expand();

        element.clear();
        element
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .attr("type", type)
                .attr("placeholder", value)
                .tag(is("input"));
        element.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .text(is(label));

        dropdownForm.collapse();
    }

    @Test
    public void isCheckboxValidationTest() {
        dropdownForm.expand();

        dropdownForm.form.checkbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check")
                .tag(is("div"));
        dropdownForm.form.checkbox.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("Remember me"))
                .tag(is("label"));

        dropdownForm.collapse();
    }

    @Test
    public void checkboxTests() {
        dropdownForm.expand();

        dropdownForm.form.checkbox.check();
        dropdownForm.form.checkbox.is().selected();
        dropdownForm.form.checkbox.uncheck();
        dropdownForm.form.checkbox.is().deselected();

        dropdownForm.collapse();
    }

    @Test
    public void fillTest() {
        dropdownForm.expand();

        dropdownForm.form.fill(USER);
        dropdownForm.form.check(USER);

        dropdownForm.collapse();
    }

    @Test
    public void testButton(){
        dropdownForm.expand();

        dropdownForm.form.submit();
        validateAlert(is("Sign in"));

        dropdownForm.collapse();
    }

    @DataProvider(name = "linksDataProvider")
    public Object[][] linksDataProvider() {
        return new Object[][]{
                {"New around here? Sign up", "https://jdi-testing.github.io/jdi-light/index.html"},
                {"Forgot password?", "https://jdi-testing.github.io/jdi-light/index.html"},

        };
    }

    @Test(dataProvider = "linksDataProvider")
    public void linkItemsTest(String itemText, String itemHref) {
        dropdownForm.expand();

        int currWindowNum = WindowsManager.windowsCount();
        dropdownForm.select(itemText);

        WindowsManager.switchToWindow(currWindowNum + 1);
        String url = WebPage.getUrl();
        assertEquals(url, itemHref);

        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(currWindowNum);

        dropdownForm.collapse();
    }
}
