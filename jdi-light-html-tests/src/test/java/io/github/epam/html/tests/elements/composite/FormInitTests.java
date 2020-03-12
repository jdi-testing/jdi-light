package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.FormDataProvider;

import static io.github.epam.html.tests.elements.composite.CompositeUtils.*;
import static pseudo.site.PseudoSite.*;
import static pseudo.site.pages.Header.*;

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
