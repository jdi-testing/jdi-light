package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.BootstrapPage.breadcrumb;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Olga Ivanova on 16.09.2019
 * Email: olga_ivanova@epam.com
 */

//APPROVED
public class BreadcrumbTests extends TestsInit {
    static final String[] BREADCRUMB = new String[] {"Home", "HTML 5", "Bootstrap"};
    static final String HOME_NODE = "<a href=\"https://jdi-testing.github.io/jdi-light/index.html\" target=\"_blank\">Home</a>";
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        breadcrumb.show();
    }
    @Test
    public void getValuesTest() {
        List<String> values = breadcrumb.values();
        assertThat(values, hasItems(BREADCRUMB));
    }
    @Test
    public void selectTest() {
        breadcrumb.select("Home");
        homePage.checkOpenedInNewWindow();
        closeWindow();
    }
    @Test
    public void selectIndexTest() {
        breadcrumb.select(0);
        homePage.checkOpenedInNewWindow();
        closeWindow();
    }
    @Test
    public void getTest() {
        String homeNode = breadcrumb.get("Home").find("a").printHtml();
        assertThat(homeNode, is(HOME_NODE));
    }
    @Test
    public void getIndexTest() {
        String homeNode = breadcrumb.get(0).find("a").printHtml();
        assertThat(homeNode, is(HOME_NODE));
    }
    @Test
    public void selectedTest() {
        String selected = breadcrumb.selected();
        assertThat(selected, is("Bootstrap"));
    }
    @Test
    public void assertValuesTest() {
        breadcrumb.has().size(BREADCRUMB.length);
        breadcrumb.has().values(BREADCRUMB);
        breadcrumb.assertThat().values(hasItem("HTML 5"))
            .and().selected("Bootstrap");
        breadcrumb.assertThat().values(hasItems("Home", "Bootstrap"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(breadcrumb);
    }
}
