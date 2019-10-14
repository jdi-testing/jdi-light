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

  /*  @Test(dataProvider = "elementsData")
    public void baseGridValidationTest(String elementId) {

        gridModalSection.openGridModalWindow();

        uiElements.stream().filter(uiElement ->
                uiElement.attr("id").equals(elementId)).forEach(
                e -> {
                    e.highlight();
                    baseValidation(e);
                    e.unhighlight();
                }
        );
    }
*/

   /* @Test(dataProvider = "elementsData")
    public void baseGridValidationTest(String elementId) {

        gridModalSection.openGridModalWindow();

        gridModalSection.gridModal.childs().stream().
                filter(uiElement -> uiElement.attr("id").equals(elementId)).forEach(
                e -> {
                    e.highlight();
                    baseValidation(e);
                    e.unhighlight();
                }
        );
    }*/

    @Test
    public void checkCloseModalButton() {
        gridModalSection.gridModal.btnClose.highlight("red");
        gridModalSection.gridModal.btnClose.click();
        gridModalSection.gridModal.is().core().disappear();
    }

    @Test
    public void checkCloseXModalButton() {
        gridModalSection.gridModal.btnCloseX.highlight("red");
        gridModalSection.gridModal.btnCloseX.click();
        gridModalSection.gridModal.is().core().disappear();
    }

    @Test
    public void checkSaveModalButton() {
        gridModalSection.gridModal.btnSave.highlight("red");
        gridModalSection.gridModal.btnSave.click();
        gridModalSection.gridModal.is().core().displayed();
    }

    @Test
    public void checkCloseByEscapeButton() {
        gridModalSection.gridModal.core().sendKeys(Keys.ESCAPE);
        gridModalSection.gridModal.is().core().disappear();
    }

    @Test
    public void baseModalValidationTest() {
        baseValidation(gridModalSection.gridModal.modalTitle);
        baseValidation(gridModalSection.gridModal.btnSave);
        baseValidation(gridModalSection.gridModal.btnCloseX);
        baseValidation(gridModalSection.gridModal.btnClose);

        gridModalSection.gridModal.modalTitle.unhighlight();
        gridModalSection.gridModal.btnSave.unhighlight();
        gridModalSection.gridModal.btnCloseX.unhighlight();
        gridModalSection.gridModal.btnClose.unhighlight();
    }
}


