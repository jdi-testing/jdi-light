package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.displaydata.TablePage.*;
import static org.hamcrest.Matchers.*;

public class TableTests extends TestsInit {
    private final Timer timer = new Timer(2000L);
    private Button getCell(int row, int coll) {
        return tableCells.get((row - 1) * 6 + coll);
    }

    @BeforeMethod
    public void beforeTest() {
        tablePage.open();
        tablePage.isOpened();
    }

    @Test
    public void dataTableTest() {
        getCell( 1, 1).click();
        selectedRowCounter.has().text(containsString("9"));
        getCell(3, 1).click();
        getCell(5, 1).click();
        selectedRowCounter.has().text(containsString("7"));
        scrollButtons.get(2).click();
        getCell(2, 1).click();
        selectedRowCounter.has().text(containsString("6"));
        getCell(1, 5).click();
        timer.wait(() -> getCell(4, 5).has().text(containsString("150")));
    }
}
