package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardListGroups;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class CardListGroupsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }


    @Test
    public void checkCardListHeaderTest() {
        cardListGroups.cardHeader.assertThat().text("Featured");
    }

    @Test
    public void checkCardListCellsQuantity() {
        assertEquals(cardListGroups.listGroups.size(), 3);
    }
}
