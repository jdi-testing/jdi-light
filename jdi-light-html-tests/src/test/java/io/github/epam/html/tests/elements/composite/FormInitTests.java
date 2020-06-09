package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import io.github.epam.test.data.FormDataProvider;
import org.testng.annotations.Test;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.checkInitializedElement;
import static pseudo.site.PseudoSite.pseudoHeader;
import static pseudo.site.pages.Header.pseudoFormLight;

public class FormInitTests implements TestsInit {

    @Test(dataProvider = "formDataProvider", dataProviderClass = FormDataProvider.class)
    public void formInitializationTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test(dataProvider = "smartFormDataProvider", dataProviderClass = FormDataProvider.class)
    public void smartFormInitializationTest(ICoreElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        checkInitializedElement(htmlElementToCheck, expectedLocator, expectedParent, expectedName);
    }

    @Test
    public void lightFormInitializationTest() {
        checkInitializedElement(pseudoFormLight, "smart: #pseudo-form-light", pseudoHeader, "Pseudo Form Light");
    }

}
