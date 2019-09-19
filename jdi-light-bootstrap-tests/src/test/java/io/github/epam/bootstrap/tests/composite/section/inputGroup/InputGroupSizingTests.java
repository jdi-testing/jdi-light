package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupDefaultSizing;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Aleksandr Sudiarov by 19.09.2019
 * Email: aleksandr_sudiarov@epam.com
 */

public class InputGroupSizingTests {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        inputGroupDefaultSizing.input.setText(text);
    }

    private String text = "Input text";

    @Test
    public void getTextFromDefaultSizingTest() {
        assertEquals(inputGroupDefaultSizing.input.getText(), text);
    }
}