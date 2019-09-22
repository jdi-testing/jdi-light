package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Aleksandr Sudiarov by 22.09.2019
 * Email: aleksandr_sudiarov@epam.com
 */

public class InputGroupSizingTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        inputGroupDefaultSizing.setText(text);
        inputGroupSmallSizing.setText(text);
        inputGroupLargeSizing.setText(text);
    }

    private String text = "Input text";

    @Test
    public void getTextFromSizingTest() {
        assertEquals(inputGroupDefaultSizing.getText(), text);
        assertEquals(inputGroupSmallSizing.getText(), text);
        assertEquals(inputGroupLargeSizing.getText(), text);
    }

    @Test
    public void clearSizingTest() {
        inputGroupDefaultSizing.clear();
        assertEquals(inputGroupDefaultSizing.getText(), "");
    }
}