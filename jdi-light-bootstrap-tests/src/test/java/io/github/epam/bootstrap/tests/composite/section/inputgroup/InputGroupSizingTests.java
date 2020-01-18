package io.github.epam.bootstrap.tests.composite.section.inputgroup;

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

    private String text = "Input text";
    private String defaultSizingLabelText = "Default";
    private String smallSizingLabelText = "Small";
    private String largeSizingLabelText = "Large";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        inputGroupDefaultSizing.input.setText(text);
        inputGroupSmallSizing.input.setText(text);
        inputGroupLargeSizing.input.setText(text);
    }


    @Test
    public void getTextFromSizingTest() {
        assertEquals(inputGroupDefaultSizing.input.getText(), text);
        assertEquals(inputGroupSmallSizing.input.getText(), text);
        assertEquals(inputGroupLargeSizing.input.getText(), text);
    }

    @Test
    public void clearSizingTest() {
        inputGroupDefaultSizing.input.clear();
        assertEquals(inputGroupDefaultSizing.input.getText(), "");
        inputGroupSmallSizing.input.clear();
        assertEquals(inputGroupDefaultSizing.input.getText(), "");
        inputGroupLargeSizing.input.clear();
        assertEquals(inputGroupDefaultSizing.input.getText(), "");
    }

    @Test
    public void labelTextSizingTest() {
        assertEquals(inputGroupDefaultSizing.label.getText(), defaultSizingLabelText);
        assertEquals(inputGroupSmallSizing.label.getText(), smallSizingLabelText);
        assertEquals(inputGroupLargeSizing.label.getText(), largeSizingLabelText);
    }
}