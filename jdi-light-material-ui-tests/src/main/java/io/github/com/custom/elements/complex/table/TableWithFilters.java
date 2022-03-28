package io.github.com.custom.elements.complex.table;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.interactions.Actions;

import static io.github.com.StaticSite.tablePage;

public class TableWithFilters<L extends PageObject, D> extends DataTable<L, D> {
    @UI(".MuiDataGrid-menuIconButton svg")
    public Button filterButton;

    @UI("//ancestor::body//li")
    public Menu westerosFilterMenu;

    @UI("//ancestor::body//button[contains (@class,'MuiButton-textPrimary')][2]")
    public Button showAllButton;

    @UI("#columns-filter-select")
    public UIElement columnFilter;

    @UI("#columns-operators-select")
    public UIElement operatorFilter;

    @UI("//ancestor::body//input[@placeholder='Filter value']")
    public UIElement valueFilter;

    @UI("//ancestor::body//input[@placeholder='Filter value']/svg")
    public UIElement preloader;

    public void click(Button button) {
        new Actions(tablePage.driver()).moveToElement(button.core().getWebElement()).click().perform();
    }
}
