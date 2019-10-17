package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.com.sections.modal.gridmodal.grid.GridCell;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.gridModalSection;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.core.StringStartsWith.startsWith;


/**
 * Created by Aleksandr Shiganov on 14.10.2019
 * Email: aleksandr_shiganov@epam.com;
 */

public class GridModalTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        gridModalSection.openGridModalWindow();
    }

    @Test
    public void baseGridRowsValidationTest() {
        gridModalSection.getGridModalWindow().
                getBody().
                getAllRows().
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
        gridModalSection.getGridModalWindow().
                getBody().
                getAllCells().
                forEach(
                        e -> {
                            e.highlight();
                            baseValidation(e);
                            e.unhighlight();
                        }
                );
    }

    @DataProvider
    public static Object[][] gridData() {
        return new Object[][]{
                {1, 1, ".col-md-4", "33"},
                {2, 1, ".col-md-3 .ml-auto", "25"},
                {2, 2, ".col-md-2 .ml-auto", "16"},
                {4, 2, "Level 2: .col-8 .col-sm-6", "50"},
                {4, 3, "Level 2: .col-4 .col-sm-6", "50"},
        };
    }

    @Test(dataProvider = "gridData")
    public void checkTextInCell(int rowN, int cellN, String textExpected, String max_width) {
        GridCell cell = gridModalSection.getGridModalWindow().getBody()
                .getCellInRow(rowN, cellN);
        cell.highlight("blue");
        cell.is().core().text(textExpected)
                .and()
                .css("max-width", startsWith(max_width));
        cell.unhighlight();
    }

    @Test
    public void checkCloseModalButton() {
        gridModalSection.getGridModalWindow().getBtnClose().highlight("red");
        gridModalSection.getGridModalWindow().clickBtnClose();
        gridModalSection.getGridModalWindow().is().disappear();
    }

    @Test
    public void checkSaveModalButton() {
        gridModalSection.getGridModalWindow().getBtnSave().highlight("red");
        gridModalSection.getGridModalWindow().clickBtnSave();
        gridModalSection.getGridModalWindow().is().displayed();
    }

    @Test
    public void checkCloseXModalButton() {
        gridModalSection.getGridModalWindow().getBtnCloseX().highlight("red");
        gridModalSection.getGridModalWindow().close();
        gridModalSection.getGridModalWindow().is().disappear();
    }

    @Test
    public void checkCloseByEscapeButton() {
        gridModalSection.getGridModalWindow().core().sendKeys(Keys.ESCAPE);
        gridModalSection.getGridModalWindow().is().disappear();
    }

    @Test
    public void baseModalValidationTest() {
        baseValidation(gridModalSection.getGridModalWindow().getBtnClose());
        baseValidation(gridModalSection.getGridModalWindow().getBtnSave());
        baseValidation(gridModalSection.getGridModalWindow().getBtnCloseX());
        baseValidation(gridModalSection.getGridModalWindow().getTitle());

        gridModalSection.getGridModalWindow().getTitle().unhighlight();
        gridModalSection.getGridModalWindow().getBtnCloseX().unhighlight();
        gridModalSection.getGridModalWindow().getBtnSave().unhighlight();
        gridModalSection.getGridModalWindow().getBtnClose().unhighlight();
    }
}
