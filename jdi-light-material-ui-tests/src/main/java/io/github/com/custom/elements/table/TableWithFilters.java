package io.github.com.custom.elements.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.interactions.Actions;

import static io.github.com.StaticSite.tablePage;

/**
 * Table with filter button and filter configuration section.
 *
 * @param <L> @see Data transfer object with UIElement fields from row {@link io.github.com.pages.utils.WesterosUser}
 * @param <D> @see Data transfer object with String fields from row {@link io.github.com.pages.utils.UserInfo}
 * @see <a href="https://mui.com/components/tables/#data-table">Mui example</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_table">Test page</a>
 */
public class TableWithFilters<L extends PageObject, D> extends DataTable<L, D> {

    /**
     * Filter button in header.
     */
    @UI(".MuiDataGrid-menuIconButton svg")
    public Button filterButton;

    /**
     * Filter configuration window.
     */
    @UI("//ancestor::body//li")
    public Menu westerosFilterMenu;

    /**
     * 'Show all' button in filter configuration window.
     */
    @UI("//ancestor::body//button[contains (@class,'MuiButton-textPrimary')][2]")
    public Button showAllButton;

    /**
     * 'Column filter' field in filter configuration window.
     */
    @UI("#columns-filter-select")
    public UIElement columnFilter;

    /**
     * 'Operator filter' field in filter configuration window.
     */
    @UI("#columns-operators-select")
    public UIElement operatorFilter;

    /**
     * 'Value filter' field in filter configuration window.
     */
    @UI("//ancestor::body//input[@placeholder='Filter value']")
    public UIElement valueFilter;

    /**
     * Preloader icon showed while filter request in processing.
     */
    @UI("//ancestor::body//input[@placeholder='Filter value']/svg")
    public UIElement preloader;

    /**
     * Hover and clicks on the button.
     *
     * @param button button for hover and click.
     */
    @JDIAction("Click '{name}' button '{0}' by Actions")
    public void click(Button button) {
        new Actions(tablePage.driver()).moveToElement(button.core().getWebElement()).click().perform();
    }
}
