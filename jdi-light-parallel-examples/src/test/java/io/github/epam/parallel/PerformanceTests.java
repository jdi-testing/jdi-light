package io.github.epam.parallel;

import com.epam.jdi.light.elements.complex.table.Line;
import io.github.epam.TestsInit;
import io.github.epam.entities.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static io.github.epam.EpamGithubSite.homePage;
import static io.github.epam.EpamGithubSite.performancePage;

public class PerformanceTests extends TestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        Preconditions.shouldBeLoggedIn();
        performancePage.open();
    }

    @AfterMethod
    public void openHomePage() {
        homePage.open();
    }

    @Test
    public void hugeTableSearchTest() {
        Line row = performancePage.users.row(
                containsValue("Meyer", inColumn("Name")),
                containsValue("co.uk", inColumn("Email")));
        Assert.assertEquals(row.getValue(),
                "Brian Meyer;(016977) 0358;mollis.nec@seddictumeleifend.co.uk;Houston");
    }

    @Test(dataProvider = "values")
    public void tableSearchTest(String name, String email) {
        Line row = performancePage.users.row(
                containsValue(name, inColumn("Name")));
        Assert.assertEquals(row.getValue().split(";")[2], email);
    }

    @Test
    public void tableValidateTest() {
        String actualTable = performancePage.users.preview();
        Assert.assertEquals(actualTable, TestData.TABLE_SNAPSHOOT);
    }

    @DataProvider(parallel = true)
    private Iterator<Object[]> values() {
        return TestData.EMAILS
                .entrySet()
                .parallelStream()
                .map(e -> new Object[]{e.getKey(), e.getValue()})
                .limit(50)
                .iterator();
    }
}
