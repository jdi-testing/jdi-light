package applitools.hackathon.tests.traditionalTests;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import applitools.hackathon.TestsInit;
import applitools.hackathon.entities.Transaction;
import applitools.hackathon.entities.User;
import applitools.hackathon.test.data.TestDataProvider;
import applitools.hackathon.utils.Utils;
import com.epam.jdi.light.elements.complex.table.Line;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.Timer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static applitools.hackathon.pages.AppPage.*;
import static applitools.hackathon.pages.ApplitoolsSite.*;
import static applitools.hackathon.pages.ChartPage.expensesChart;
import static applitools.hackathon.pages.ChartPage.showNextYear;
import static applitools.hackathon.utils.Utils.toArray;
import static org.hamcrest.Matchers.hasItems;

public class TraditionalTests extends TestsInit {
    @BeforeMethod
    public void before() {
        loginPage.open();
    }

    @Test(suiteName = "Login Page UI Elements Test")
    public void loginPageValidation() {
        loginPage.validatateForm();
        loginPage.alert.is().hidden();
    }

    @Test(suiteName = "Data-Driven Test", dataProvider = "correctUsers", dataProviderClass = TestDataProvider.class)
    public void loginSuccessValidation(User user) {
        loginForm().loginAs(user);
        appPage.checkOpened();
    }

    @Test(suiteName = "Data-Driven Test", dataProvider = "emptyUsers", dataProviderClass = TestDataProvider.class)
    public void loginFailedValidation(User user, String message) {
        loginForm().loginAs(user);
        loginPage.validatateAlert(message);
    }

    @Test(suiteName = "Table Sort Test")
    public void sortTableValidation() {
        loginForm().loginAs(new User());
        List<Transaction> unsortedTransactions = transactionsTable.allData();
        List<Line> images = transactionsTable.rowsImages();

        transactionsTable.headerUI().select("AMOUNT");
        transactionsTable.assertThat()
            .rows(hasItems(toArray(unsortedTransactions)))
            .sortedBy((prev,next) -> prev.amount.value() < next.amount.value())
            .rowsVisualValidation("Description", images);

        transactionsTable.headerUI().select("AMOUNT");
        transactionsTable.assertThat()
            .rows(hasItems(toArray(unsortedTransactions)))
            .sortedBy((prev,next) -> prev.amount.value() > next.amount.value())
            .rowsVisualValidation("Description", images);
    }

    @Test(suiteName = "Canvas Chart Test")
    public void canvasChartTest() {
        loginForm().loginAs(new User());
        compareExpenses.click();
        WebPage.zoom(0.8);
        Timer.sleep(1000);
        expensesChart.visualValidation("Expense Chart 2017-2018");
        showNextYear.click();
        Timer.sleep(1000);
        expensesChart.visualValidation("Expense Chart 2017-2019");
        WebPage.zoom(1);
    }

    @Test(suiteName = "Dynamic Content Test")
    public void dynamicAdTest() {
        loginPage.open("?showAd=true");
        loginForm().loginAs(new User());
        advertisement.has().size(3)
            .all().elements(Utils::advertismentPresent);
    }
}
