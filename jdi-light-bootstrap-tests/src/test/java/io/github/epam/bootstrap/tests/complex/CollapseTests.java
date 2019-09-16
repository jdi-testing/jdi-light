package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CollapseTests extends TestsInit {

    // List texts to check
    String cardOneText = "Anim pariatur cliche reprehenderit.";
    String cardTwoText = "Craft beer labore wes anderson cred nesciunt sapiente ea proident.";
    String cardThreeText = "High life accusamus terry richardson ad squid. Nihil anim.";
    String groupOneText = "You probably haven't heard of them accusamus labore sustainable VHS.";
    String groupTwoText = "Nihil anim keffiyeh helvetica, craft beer labore.";
    String groupThreeText = "3 wolf moon officia aute, non cupidatat skateboard dolor brunch.";

    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(priority = 1)
    public void collapseLinkTest() throws InterruptedException {
        collapseLink.highlight();
        collapseLink.toggle();
        assertTrue(collapseLink.isExpanded());
        assertTrue(collapseLink.value().getText().contains(cardOneText));
        collapseLink.toggle();
        Thread.sleep(500);
        assertFalse(collapseLink.isExpanded());
    }

    @Test(priority = 2)
    public void collapseButtonTest() throws InterruptedException {
        collapseDataTarget.highlight();
        collapseDataTarget.toggle();
        assertTrue(collapseDataTarget.isExpanded());
        assertTrue(collapseDataTarget.value().getText().contains(cardOneText));
        collapseDataTarget.toggle();
        Thread.sleep(500);
        assertFalse(collapseDataTarget.isExpanded());
    }

    @Test(priority = 3)
    public void collapseToggleOneTest() throws InterruptedException {
        collapseToggleOne.highlight();
        collapseToggleOne.toggle();
        assertTrue(collapseToggleOne.isExpanded());
        assertTrue(collapseToggleOne.value().getText().contains(cardTwoText));
        collapseToggleOne.toggle();
        Thread.sleep(500);
        assertFalse(collapseToggleOne.isExpanded());
    }

    @Test(priority = 4)
    public void collapseToggleTwoTest() throws InterruptedException {
        collapseToggleTwo.highlight();
        collapseToggleTwo.toggle();
        assertTrue(collapseToggleTwo.isExpanded());
        assertTrue(collapseToggleTwo.value().getText().contains(cardThreeText));
        collapseToggleTwo.toggle();
        Thread.sleep(500);
        assertFalse(collapseToggleTwo.isExpanded());
    }

    @Test(priority = 5)
    public void collapseToggleBothTest() throws InterruptedException {
        collapseToggleBoth.highlight();
        collapseToggleBoth.toggle();
        collapseToggleTwo.highlight();
        assertTrue(collapseToggleBoth.isExpanded());
        assertTrue(collapseToggleBoth.value().getText().contains(cardTwoText));
        assertTrue(collapseToggleTwo.value().getText().contains(cardThreeText));
        collapseToggleBoth.toggle();
        Thread.sleep(500);
        assertFalse(collapseToggleBoth.isExpanded());
        assertFalse(collapseToggleTwo.isExpanded());
    }

    @Test(priority = 6)
    public void collapseGroupOneTest() throws InterruptedException {
        collapseGroupOne.highlight();
        collapseGroupOne.toggle();
        assertTrue(collapseGroupOne.isExpanded());
        assertTrue(collapseGroupOne.value().getText().contains(groupOneText));
        collapseGroupOne.toggle();
        Thread.sleep(500);
        assertFalse(collapseGroupOne.isExpanded());
    }

    @Test(priority = 7)
    public void collapseGroupTwoTest() throws InterruptedException {
        collapseGroupTwo.highlight();
        collapseGroupTwo.toggle();
        assertTrue(collapseGroupTwo.isExpanded());
        assertTrue(collapseGroupTwo.value().getText().contains(groupTwoText));
        collapseGroupTwo.toggle();
        Thread.sleep(500);
        assertFalse(collapseGroupTwo.isExpanded());
    }

    @Test(priority = 8)
    public void collapseGroupThreeTest() throws InterruptedException {
        collapseGroupThree.highlight();
        collapseGroupThree.toggle();
        assertTrue(collapseGroupThree.isExpanded());
        assertTrue(collapseGroupThree.value().getText().contains(groupThreeText));
        collapseGroupThree.toggle();
        Thread.sleep(500);
        assertFalse(collapseGroupThree.isExpanded());
    }
}
