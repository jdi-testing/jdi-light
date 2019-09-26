package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardKitchenSink;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.is;

public class CardKitchenSinkTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void itemsCountTest() {
        assertEquals(cardKitchenSink.list.size(), 3);
        cardKitchenSink.list.get(0).is().text(is("Cras justo odio"));
    }
}
