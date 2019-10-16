package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.readonlyInput;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class FormReadOnlyTests extends TestsInit {

    private String placeholderText = "Readonly input here...";
    private String text = "This method will throw an exception , because this element isn't user-editable ";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void checkReadonlyAttribute() {
        assertTrue(readonlyInput.attrs().has("readonly"));
        readonlyInput.highlight();
        readonlyInput.is()
                .displayed()
                .enabled();
    }

    @Test
    public void checkPlaceholder() {
        readonlyInput.assertThat().core().attr("placeholder", placeholderText);
    }

    @Test(expectedExceptions = {InvalidElementStateException.class})
    public void check() {
        readonlyInput.setValue(text);
        readonlyInput.sendKeys(text);
    }


}
