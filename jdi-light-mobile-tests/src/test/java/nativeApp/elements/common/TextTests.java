package nativeApp.elements.common;

import nativeapp.TestsInit;
import org.testng.annotations.Test;

import static nativeapp.contacts.ContactsMainPage.noContactsInThisAccountText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class TextTests implements TestsInit {
    private String text = "No contacts in this account";

    @Test
    public void getTextTest() {
        assertEquals(noContactsInThisAccountText.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(noContactsInThisAccountText.getValue(), text);
    }

    @Test
    public void isValidationTest() {
        noContactsInThisAccountText.is().enabled();
        noContactsInThisAccountText.is().text(is(text));
        noContactsInThisAccountText.is().text(containsString("No contacts in"));
    }

    @Test
    public void assertValidationTest() {
        noContactsInThisAccountText.assertThat().text(is(text));
    }
}
