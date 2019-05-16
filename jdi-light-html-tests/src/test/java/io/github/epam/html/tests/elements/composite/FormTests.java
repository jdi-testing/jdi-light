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

import static com.epam.jdi.light.common.FormFilters.ALL;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.LinqUtils.first;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.*;
import static io.github.com.pages.ContactFormPage.main;
import static io.github.com.pages.Header.*;
import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedOut;
import static org.testng.Assert.assertEquals;
import static pseudo.site.PseudoSite.pseudoHeader;
import static pseudo.site.pages.Header.pseudoFormLight;

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
    public void loginAsTest() {
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
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }


    @Test
    public void submitEntityToContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(DEFAULT_CONTACT);
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void submitTextToContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(defaultName);
        main.contactForm.check(ONLY_LAST_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormUsingCustomButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(DEFAULT_CONTACT, "custom");
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void submitEntityToContactFormUsingNonExistentButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        TIMEOUT.set(1);
        main.customContactForm.submit(DEFAULT_CONTACT, "nonExistent");
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.submit(defaultName, "custom");
        main.contactForm.check(ONLY_LAST_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void submitTextToContactFormUsingNonExistentButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        TIMEOUT.set(1);
        main.customContactForm.submit(defaultName, "nonExistent");
    }

    @Test
    public void plainSubmitTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.contactForm.fill(DEFAULT_CONTACT);
        main.contactForm.submit();
        main.contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void pressButtonTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.fill(DEFAULT_CONTACT);
        main.customContactForm.pressButton("custom");
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void sendTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.fill(DEFAULT_CONTACT);
        main.customContactForm.send();
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void sendEntityTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.send(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void addEntityTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.add(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void publishTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.publish(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void saveTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.save(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void updateTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.update(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void cancelTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.cancel(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void closeTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.close(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void backTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.back(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void selectTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.select(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void nextTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.next(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void searchTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.search(DEFAULT_CONTACT);
        main.customContactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void onlyMandatoryTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.onlyMandatory().fill(DEFAULT_CONTACT);
        main.customContactForm.check(ONLY_LAST_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.customContactForm.getFilter(), ALL);
    }

    @Test
    public void onlyOptionalTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
        main.customContactForm.onlyOptional().fill(DEFAULT_CONTACT);
        main.customContactForm.check(ALL_EXCEPT_LAST_NAME_FILLED_DEFAULT_CONTACT);
        assertEquals(main.customContactForm.getFilter(), ALL);
    }

    @Test
    public void modifiedLambdaFillActionTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
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
            main.customContactForm.fill(LOWER_CASE_LAST_NAME_CONTACT);
            main.customContactForm.check(DEFAULT_CONTACT);
        } finally {
            Form.FILL_ACTION = initialFillActionLambda;
        }
    }

    @Test
    public void modifiedLambdaGetActionTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        refresh();
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
            main.customContactForm.fill(LOWER_CASE_LAST_NAME_CONTACT);
            main.customContactForm.check(DEFAULT_CONTACT);
        } finally {
            Form.GET_ACTION = initialGetActionLambda;
        }
    }
}
