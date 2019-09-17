package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import io.github.epam.TestsInit;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public void collapseLinkTest() {
        collapseLink.highlight();
        collapseLink.toggle();
        assertTrue(collapseLink.isExpanded());
        assertTrue(collapseLink.value().getText().contains(cardOneText));
        collapseLink.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseLink.value()));
        assertFalse(collapseLink.isExpanded());
    }

    @Test(priority = 2)
    public void collapseButtonTest() {
        collapseDataTarget.highlight();
        collapseDataTarget.toggle();
        assertTrue(collapseDataTarget.isExpanded());
        assertTrue(collapseDataTarget.value().getText().contains(cardOneText));
        collapseDataTarget.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseDataTarget.value()));
        assertFalse(collapseDataTarget.isExpanded());
    }

    @Test(priority = 3)
    public void collapseToggleOneTest() {
        collapseToggleOne.highlight();
        collapseToggleOne.toggle();
        assertTrue(collapseToggleOne.isExpanded());
        assertTrue(collapseToggleOne.value().getText().contains(cardTwoText));
        collapseToggleOne.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseToggleOne.value()));
        assertFalse(collapseToggleOne.isExpanded());
    }

    @Test(priority = 4)
    public void collapseToggleTwoTest() {
        collapseToggleTwo.highlight();
        collapseToggleTwo.toggle();
        assertTrue(collapseToggleTwo.isExpanded());
        assertTrue(collapseToggleTwo.value().getText().contains(cardThreeText));
        collapseToggleTwo.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseToggleTwo.value()));
        assertFalse(collapseToggleTwo.isExpanded());
    }

    @Test(priority = 5)
    public void collapseToggleBothTest() {
        collapseToggleBoth.highlight();
        collapseToggleBoth.toggle();
        collapseToggleTwo.highlight();
        assertTrue(collapseToggleBoth.isExpanded());
        assertTrue(collapseToggleBoth.value().getText().contains(cardTwoText));
        assertTrue(collapseToggleTwo.value().getText().contains(cardThreeText));
        collapseToggleBoth.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseToggleBoth.value()));
        wait.until(ExpectedConditions.invisibilityOf(collapseToggleTwo.value()));
        assertFalse(collapseToggleBoth.isExpanded());
        assertFalse(collapseToggleTwo.isExpanded());
    }

    @Test(priority = 6)
    public void collapseGroupOneTest() {
        collapseGroupOne.highlight();
        collapseGroupOne.toggle();
        assertTrue(collapseGroupOne.isExpanded());
        assertTrue(collapseGroupOne.value().getText().contains(groupOneText));
        collapseGroupOne.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseGroupOne.value()));
        assertFalse(collapseGroupOne.isExpanded());
    }

    @Test(priority = 7)
    public void collapseGroupTwoTest() {
        collapseGroupTwo.highlight();
        collapseGroupTwo.toggle();
        assertTrue(collapseGroupTwo.isExpanded());
        assertTrue(collapseGroupTwo.value().getText().contains(groupTwoText));
        collapseGroupTwo.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseGroupTwo.value()));
        assertFalse(collapseGroupTwo.isExpanded());
    }

    @Test(priority = 8)
    public void collapseGroupThreeTest() {
        collapseGroupThree.highlight();
        collapseGroupThree.toggle();
        assertTrue(collapseGroupThree.isExpanded());
        assertTrue(collapseGroupThree.value().getText().contains(groupThreeText));
        collapseGroupThree.toggle();
        wait.until(ExpectedConditions.invisibilityOf(collapseGroupThree.value()));
        assertFalse(collapseGroupThree.isExpanded());
    }
}
