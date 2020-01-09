package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.multiDropdown;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Steam;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

public class MultiDropdownExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        multiDropdown.check(text);
    }
    String text = "Steam";

    @Test
    public void selectTest() {
        multiDropdown.check("Electro", "Metalic");
        multiDropdown.checked().equals(asList("Electro", "Metalic"));
        multiDropdown.is().selected("Electro");
        multiDropdown.uncheck("Metalic");
    }

    @Test
    public void disabledTest() {
        multiDropdown.select("Disabled");
        multiDropdown.is().selected("Steam");
    }

    @Test
    public void labelTest() {
        multiDropdown.label().is().text("Multi dropdown:");
        multiDropdown.label().is().text(containsString("Multi"));
    }

    @Test
    public void isValidationTest() {
        multiDropdown.is().selected("Steam");
        multiDropdown.is().selected(Steam);
        multiDropdown.assertThat().values(hasItem("Wood"));
        multiDropdown.shouldBe().value("Wood");
        multiDropdown.assertThat().disabled(hasItem("Disabled"))
                .enabled(not(hasItem("Disabled")))
                .enabled(hasItems("Electro", "Metalic"));
    }
}
