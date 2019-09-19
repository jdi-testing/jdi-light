package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupRadio;
import static io.github.com.pages.BootstrapPage.inputGroupUsername;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;

/**
 * Created by Iulia Litvin on 19.09.2019
 * Email: iulia.litwin@yandex.ru
 */

public class InputGroupWrapping extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void checkNoWrapping() {
        inputGroupUsername.hasClass("flex-nowrap");
        inputGroupUsername.assertThat().core().css("flex-wrap","nowrap");
    }

    @Test
    public void checkWrapping() {
        assertFalse(inputGroupRadio.hasClass("flex-nowrap"));
        inputGroupRadio.assertThat().core().css("flex-wrap","wrap");
    }





}
