package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.Conditions.and;
import static com.epam.jdi.light.elements.base.Conditions.pseudo;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.checkboxWithPseudo;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class PseudoTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.open();
    }

    @Test(description = "Check content in pseudo before and after")
    public void pseudoTest() {
        checkboxWithPseudo.show();

        checkboxWithPseudo.shouldBe(
                pseudo("::before", "\"Before pseudo-element content\""),
                and(pseudo("::after", "\"After pseudo-element content\""))
        );
    }
}
