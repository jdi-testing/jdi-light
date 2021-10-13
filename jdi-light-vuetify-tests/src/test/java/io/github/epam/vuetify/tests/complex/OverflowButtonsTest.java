package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.overflowButtonsPage;
import static io.github.com.pages.OverflowButtonsPage.*;

public class OverflowButtonsTest extends TestsInit {

    @BeforeClass
    public void before() {
        overflowButtonsPage.open();
    }

    @Test
    public void baseFunctionalityOverflowButtonTest() {
        counterOverflowButton.is().enable();
        counterOverflowButton.is().placeholder("Overflow Btn w/ counter");
        counterOverflowButton.expand();
        counterOverflowButton.is().expanded();
        counterOverflowButton.close();
        counterOverflowButton.is().closed();
        counterOverflowButton.select("50%");
        counterOverflowButton.is().selected("50%");
        counterOverflowButton.select(1);
        counterOverflowButton.is().selected("100%");
    }

    @Test
    public void counterOverflowButtonTest() {
        counterOverflowButton.select("100%");
        counterOverflowButton.is().counter("4");
        counterOverflowButton.select(5);
        counterOverflowButton.is().counter("2");
    }

    @Test
    public void disabledOverflowButton() {
        disabledOverflowButton.is().disable();
    }

    @Test
    public void editableOverflowButton() {
        editableOverflowButton.isEditable();
        editableOverflowButton.sendText("1");
        editableOverflowButton.dropDownList().get(1).is().text("100%");
        editableOverflowButton.clear();
        editableOverflowButton.sendText("7");
        editableOverflowButton.dropDownList().get(1).is().text("75%");
    }

    @Test
    public void hintOverflowButton() {
        hintOverflowButton.is().hint("Hint doesn't exist");
        hintOverflowButton.expand();
        hintOverflowButton.is().hint("Select font");
    }

    @Test
    public void loadingOverflowButton() {
        loadingOverflowButton.is().hasProgressBar();
    }

    @Test
    public void readonlyOverflowButton() {
        readonlyOverflowButton.is().readOnly();
    }
}
