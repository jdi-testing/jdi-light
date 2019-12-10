package applitools.hackathon.pages;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import applitools.hackathon.custom.TransactionRow;
import applitools.hackathon.entities.Transaction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.GetVisible;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class AppPage extends WebPage {
    @UI("#transactionsTable")
    public static DataTable<TransactionRow, Transaction> transactionsTable;
    @UI("#showExpensesChart") public static Link compareExpenses;
    @GetVisible @UI("div.balance") public static WebList advertisement;
    @UI(".element-balances") public static UIElement advertisements;

    public static boolean advertismentPresent(Object element) {
        UIElement adv = (UIElement)element;
        Dimension size = adv.getSize();
        return adv.isDisplayed() && adv.childs().size() > 0 &&
                size.getWidth() >= 5 && size.height >= 5;
    }
}
