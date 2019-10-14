package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupBasicExample1;
import static io.github.com.pages.BootstrapPage.inputGroupBasicExample2;
import static io.github.com.pages.BootstrapPage.inputGroupBasicExample3;
import static io.github.com.pages.BootstrapPage.inputGroupBasicExample4;
import static io.github.com.pages.BootstrapPage.inputGroupBasicExample5;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Iulia Litvin on 23.09.2019
 * Email: iulia.litwin@yandex.ru
 */

public class InputGroupBaseExample extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String textExample1 = "setting text",
            addonExample1 = "@",
            placeholderExample2 = "Recipient's username",
            partOfAddonExample2 = "example.com",
            addonExample3 = "https://example.com/users/",
            labelExample3 = "Your vanity URL",
            addonPretendExample4 = "$",
            addonAppendExample4 = ".00",
            addonAppendExample5 = "With textarea";

    private String[] linesTextArea = {"line 1", "line 2", "line 3"};

    @Test(priority = 1)
    public void setTextTestExample1() {
        inputGroupBasicExample1.input.setText(textExample1);
        inputGroupBasicExample1.input.is().text(is(textExample1));
    }

    @Test(priority = 2)
    public void assertValidationInputTestExample1() {
        inputGroupBasicExample1.text.assertThat().text(is(addonExample1));
    }

    @Test(priority = 3)
    public void placeholderTestExample2() {
        assertEquals(inputGroupBasicExample2.input.placeholder(), placeholderExample2);
    }

    @Test(priority = 4)
    public void checkAddonConsistTextTestExample2() {
        inputGroupBasicExample2.text.is().text(containsString(partOfAddonExample2));
    }

    @Test(priority = 5)
    public void checkAddonTextTestExample3() {
        inputGroupBasicExample3.text.is().enabled();
        inputGroupBasicExample3.text.is().text(is(addonExample3));
    }

    @Test(priority = 6)
    public void checkLabelExample3() {
        assertEquals(inputGroupBasicExample3.input.core().label().getText(), labelExample3);
    }

    @Test(priority = 7)
    public void checkAddonsExample4() {
        inputGroupBasicExample4.text_append.is().enabled();
        inputGroupBasicExample4.text_append.is().text(is(addonAppendExample4));
        inputGroupBasicExample4.text_pretend.is().enabled();
        inputGroupBasicExample4.text_pretend.is().text(is(addonPretendExample4));
    }

    @Test(priority = 8)
    public void focusTestExample4() {
        inputGroupBasicExample4.input.focus();
    }

    @Test(priority = 9)
    public void getLinesTestExample5() {
        inputGroupBasicExample5.area.setLines(linesTextArea);
        assertEquals(inputGroupBasicExample5.area.getLines(), asList(linesTextArea));
    }

    @Test(priority = 10)
    public void assertValidationTextTestExample5() {
        inputGroupBasicExample5.text.assertThat().text(is(addonAppendExample5));
    }

}
