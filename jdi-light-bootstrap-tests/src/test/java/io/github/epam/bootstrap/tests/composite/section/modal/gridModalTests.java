package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.gridModalSection;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;


/**
 * Created by Aleksandr Shiganov on 14.10.2019
 * Email: aleksandr_shiganov@epam.com;
 */

public class gridModalTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        gridModalSection.openGridModalWindow();
    }

    @DataProvider
    public static Object[][] elementsData() {
        return new Object[][]{
                {"gridModalLabel"},
                {"close-modal-cross"},
                {"save-modal"},
                {"close-modal"},
        };
    }

    @Test
    public void baseGridRowsValidationTest() {
        gridModalSection.openGridModalWindow();
        gridModalSection.gridModalWindow.
                gridModal.
                getAllGridRows().
                forEach(
                        e -> {
                            e.highlight();
                            baseValidation(e);
                            e.unhighlight();
                        }
                );
    }

    @Test
    public void baseGridCellsValidationTest() {
        gridModalSection.openGridModalWindow();
        gridModalSection.gridModalWindow.
                gridModal.
                getAllGridCells().
                forEach(
                        e -> {
                            e.highlight();
                            baseValidation(e);
                            e.unhighlight();
                        }
                );
    }

    @Test
    public void checkCloseModalButton() {
        gridModalSection.gridModalWindow.btnClose.highlight("red");
        gridModalSection.gridModalWindow.btnClose.click();
        gridModalSection.gridModalWindow.is().core().disappear();
    }

    @Test
    public void checkCloseXModalButton() {
        gridModalSection.gridModalWindow.btnCloseX.highlight("red");
        gridModalSection.gridModalWindow.btnCloseX.click();
        gridModalSection.gridModalWindow.is().core().disappear();
    }

    @Test
    public void checkSaveModalButton() {
        gridModalSection.gridModalWindow.btnSave.highlight("red");
        gridModalSection.gridModalWindow.btnSave.click();
        gridModalSection.gridModalWindow.is().core().displayed();
    }

    @Test
    public void checkCloseByEscapeButton() {
        gridModalSection.openGridModalWindow();
        gridModalSection.gridModalWindow.core().sendKeys(Keys.ESCAPE);
        gridModalSection.gridModalWindow.is().core().disappear();
    }

    @Test
    public void baseModalValidationTest() {
        baseValidation(gridModalSection.gridModalWindow.modalTitle);
        baseValidation(gridModalSection.gridModalWindow.btnSave);
        baseValidation(gridModalSection.gridModalWindow.btnCloseX);
        baseValidation(gridModalSection.gridModalWindow.btnClose);

        gridModalSection.gridModalWindow.modalTitle.unhighlight();
        gridModalSection.gridModalWindow.btnSave.unhighlight();
        gridModalSection.gridModalWindow.btnCloseX.unhighlight();
        gridModalSection.gridModalWindow.btnClose.unhighlight();
    }
}


