package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.tools.func.JAction4;
import com.epam.jdi.tools.func.JFunc3;
import io.github.com.custom.FirstTokenCapitalisation;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.FormDataProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static com.epam.jdi.light.common.FormFilters.ALL;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.LinqUtils.first;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.Header.*;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedOut;
import static io.github.epam.html.tests.site.steps.States.shouldContactPageBeOpenedAndRefreshed;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pseudo.site.PseudoSite.pseudoHeader;
import static pseudo.site.sections.Header.pseudoFormLight;

public class FormTests extends TestsInit {

    @Test(dataProvider = "formDataProvider", dataProviderClass = FormDataProvider.class)
    public void formInitializationTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "smartFormDataProvider", dataProviderClass = FormDataProvider.class)
    public void smartFormInitializationTest(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test
    public void lightFormInitializationTest() {
        checkInitializedElement(pseudoFormLight, "", pseudoHeader, "Pseudo Form Light");
    }

    @Test
    public void loginWithUserTest() {
        shouldBeLoggedOut();
        loginForm.shouldBeOpened();
        loginForm.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginWithUserToSmartFormTest() {
        shouldBeLoggedOut();
        loginFormSmart.shouldBeOpened();
        loginFormSmart.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginWithUserToLightFormTest() {
        shouldBeLoggedOut();
        refresh();
        userIcon.click();
        loginFormLight.login(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void loginAsUserTest() {
        shouldBeLoggedOut();
        loginForm.shouldBeOpened();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void plainLoginTest() {
        shouldBeLoggedOut();
        loginForm.shouldBeOpened();
        loginForm.fill(DEFAULT_USER);
        loginForm.login();
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.submit(defaultName);
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitEntityToContactFormTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.submit(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.submit(defaultName, "custom");
        main.contactForm.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void submitTextToContactFormUsingNonExistentButtonTest() {
        shouldContactPageBeOpenedAndRefreshed();
        TIMEOUT.set(1);
        main.contactFormCustom.submit(defaultName, "nonExistent");
    }

    @Test
    public void submitEntityToContactFormUsingCustomButtonTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.submit(DEFAULT_CONTACT, "custom");
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void submitEntityToContactFormUsingNonExistentButtonTest() {
        shouldContactPageBeOpenedAndRefreshed();
        TIMEOUT.set(1);
        main.contactFormCustom.submit(DEFAULT_CONTACT, "nonExistent");
    }

    @Test
    public void plainSubmitTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.submit();
        main.contactForm.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void pressButtonTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.fill(DEFAULT_CONTACT);
        main.contactFormCustom.pressButton("custom");
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void verifyMethodPositiveTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(DEFAULT_CONTACT);
        List<String> verified = main.contactForm.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 0);
    }

    @Test
    public void verifyMethodNegativeTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = main.contactForm.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 1);
        assertTrue(verified.get(0).contains(defaultName));
    }

    @Test
    public void checkMethodPositiveTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
        assertEquals(main.contactForm.verify(DEFAULT_CONTACT).size(), 0);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void checkMethodNegativeTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactForm.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        TIMEOUT.set(1);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void sendMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.fill(DEFAULT_CONTACT);
        main.contactFormCustom.send();
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void sendEntityMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.send(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void addEntityMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.add(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void publishMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.publish(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void saveMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.save(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void updateMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.update(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void cancelMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.cancel(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void closeMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.close(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void backMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.back(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void selectMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.select(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void nextMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.next(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void searchMethodTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.search(DEFAULT_CONTACT);
        main.contactFormCustom.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void onlyMandatoryOptionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.onlyMandatory().fill(DEFAULT_CONTACT);
        main.contactFormCustom.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactFormCustom.getFilter(), ALL);
    }

    @Test
    public void onlyOptionalOptionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustom.onlyOptional().fill(DEFAULT_CONTACT);
        main.contactFormCustom.check(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.contactFormCustom.getFilter(), ALL);
    }

    @Test
    public void modifiedLambdaFillActionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        JAction4<Field, Object, Object, String> initialFillActionLambda = Form.FILL_ACTION;
        JAction4<Field, Object, Object, String> newFillActionLambda = (field, element, parent, setValue) -> {
            if (field != null) {
                Method[] methods = field.getType().getDeclaredMethods();
                Method setMethod = first(methods, m -> m.isAnnotationPresent(FillValue.class));
                if (setMethod != null) {
                    if (field.isAnnotationPresent(FirstTokenCapitalisation.class)) {
                        setMethod.invoke(element, (setValue.substring(0, 1).toUpperCase() + setValue.substring(1)));
                    } else {
                        setMethod.invoke(element, setValue);
                    }
                    return;
                }
            }
            ((SetValue) element).setValue(setValue);
        };
        try {
            Form.FILL_ACTION = newFillActionLambda;
            main.contactFormCustom.fill(LOWER_CASE_NAME_CONTACT);
            main.contactFormCustom.check(DEFAULT_CONTACT);
        } finally {
            Form.FILL_ACTION = initialFillActionLambda;
        }
    }

    @Test
    public void modifiedLambdaGetActionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        JFunc3<Field, Object, Object, String> initialGetActionLambda = Form.GET_ACTION;
        JFunc3<Field, Object, Object, String> newGetActionLambda = (field, element, parent) -> {
            if (field != null) {
                Method[] methods = field.getType().getDeclaredMethods();
                Method getMethod = first(methods, m -> m.isAnnotationPresent(VerifyValue.class));
                if (getMethod != null) {
                    if (field.isAnnotationPresent(FirstTokenCapitalisation.class)) {
                        String getValue = getMethod.invoke(element).toString();
                        return (getValue.substring(0, 1).toUpperCase() + getValue.substring(1));
                    } else {
                        return getMethod.invoke(element).toString();
                    }
                }
            }
            return ((HasValue) element).getValue().trim();
        };
        try {
            Form.GET_ACTION = newGetActionLambda;
            main.contactFormCustom.fill(LOWER_CASE_NAME_CONTACT);
            main.contactFormCustom.check(DEFAULT_CONTACT);
        } finally {
            Form.GET_ACTION = initialGetActionLambda;
        }
    }

    @Test
    public void overriddenFillActionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustomFill.fill(LOWER_CASE_NAME_CONTACT);
        main.contactFormCustomFill.check(DEFAULT_CONTACT);
    }

    @Test
    public void overriddenGetActionTest() {
        shouldContactPageBeOpenedAndRefreshed();
        main.contactFormCustomGet.fill(LOWER_CASE_NAME_CONTACT);
        main.contactFormCustomGet.check(DEFAULT_CONTACT);
    }

    private void checkContactFormSubmitted() {
        lastLogEntry.assertThat()
                .text(containsString("submit:button clicked"));
    }
}
