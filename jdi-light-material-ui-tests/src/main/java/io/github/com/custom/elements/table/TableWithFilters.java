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
 * Table with filter button and filter configuration section
 *
 * @param <L> Section extended class for deserialization in object
 * @param <D> Data extended class for deserialization in strings
 */
public class TableWithFilters<L extends PageObject, D> extends DataTable<L, D> {

    /**
     * Filter button in header
     */
    @UI(".MuiDataGrid-menuIconButton svg")
    public Button filterButton;

    /**
     * Filter configuration window
     */
    @UI("//ancestor::body//li")
    public Menu westerosFilterMenu;

    /**
     * 'Show all' button in filter configuration window
     */
    @UI("//ancestor::body//button[contains (@class,'MuiButton-textPrimary')][2]")
    public Button showAllButton;

    /**
     * 'Column filter' field in filter configuration window
     */
    @UI("#columns-filter-select")
    public UIElement columnFilter;

    /**
     * 'Operator filter' field in filter configuration window
     */
    @UI("#columns-operators-select")
    public UIElement operatorFilter;

    /**
     * 'Value filter' field in filter configuration window
     */
    @UI("//ancestor::body//input[@placeholder='Filter value']")
    public UIElement valueFilter;

    /**
     * Preloader icon showed while filter request in processing
     * Used in waiter
     */
    @UI("//ancestor::body//input[@placeholder='Filter value']/svg")
    public UIElement preloader;

    /**
     * For improve stability click on hidden element used click with selenium Actions
     *
     * @param button In test used for click on filter button that appears when hovered
     * @throws RuntimeException if element is not found
     */
    @JDIAction("Click '{name}' button '{0}' by Actions")
    public void click(Button button) {
        new Actions(tablePage.driver()).moveToElement(button.core().getWebElement()).click().perform();
    }
}
