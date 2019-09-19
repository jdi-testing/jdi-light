package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
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
    public void checkWrapping() {
        assertFalse(inputGroupWrap.hasClass("flex-nowrap"));
        inputGroupWrap.assertThat().core().css("flex-wrap", "wrap");
    }

    @Test
    public void checkNoWrapping() {
        inputGroupNoWrap.hasClass("flex-nowrap");
        inputGroupNoWrap.assertThat().core().css("flex-wrap", "nowrap");
    }

}
