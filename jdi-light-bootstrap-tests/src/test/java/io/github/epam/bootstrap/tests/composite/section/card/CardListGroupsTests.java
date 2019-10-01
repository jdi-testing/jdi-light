package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardListGroups;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class CardListGroupsTests extends TestsInit {

    private String cardHeaderText = "Featured";
    private int cardListGroupsSize = 3;
    private List<String> cardListGroupsValues =
            new ArrayList<>(Arrays.asList("Cras justo odio", "Dapibus ac facilisis in", "Vestibulum at eros"));

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void checkCardListHeaderTest() {
        cardListGroups.cardHeader.assertThat().text(cardHeaderText);
    }

    @Test
    public void checkCardListCellsQuantity() {
        assertEquals(cardListGroups.listGroups.size(), cardListGroupsSize);
    }

    @Test
    public void checkCardListGroupsValues() {
        int checkedValues = 0;
        for (WebElement s : cardListGroups.listGroups) {
            if (cardListGroupsValues.contains(s.getText())) {
                checkedValues++;
            }
        }
        assertEquals(cardListGroupsValues.size(), checkedValues);
    }
}
