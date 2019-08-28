package io.github.epam.html.tests.issues.issue67;

import com.epam.jdi.light.asserts.core.SoftAssert;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.usersPage;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.com.pages.UsersPage.users;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


public class SoftAsserts extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        assertStrict();
    }
    @AfterMethod
    public void after() {
        clearResults();
        assertStrict();
    }

    @Test
    public void noErrorsTest() {
        assertSoft();
        redButton.is().hidden().displayed().disabled().enabled();
    }
    @Test
    public void buttonSoftAssertTest() {
        try {
            redButton.verify().hidden().displayed()
                .disabled().enabled()
                .disappear();
            redButton.is().text(is("Big Red *** Button-Input"))
                .text(containsString("Red Button"))
                .core().cssClass(is("uui-button red"))
                .attr("type", is("button"))
                .tag(is("input"))

                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertThat(tr.getMessage().replaceAll("\r\n", "").replace("\n", ""),
                is("Expected: is \"hidden\"     " +
                            "but: was \"displayed\"," +
                        "Expected: is \"disabled\"     " +
                            "but: was \"enabled\"," +
                        "Expected: is \"disappeared\"     " +
                            "but: was \"displayed\"," +
                        "Expected: is \"Big Red *** Button-Input\"     " +
                            "but: was \"Big Red Button-Input\""));
        }
    }
    @Test
    public void multipleValidationsTest() {
        try {
            assertSoft();
            redButton.is().hidden().displayed().disabled().enabled();
            jdiLogo.is().alt(is("Jdi Logo 777"))
                .src(containsString("jdi-logo.jpg777"))
                .height(is(100))
                .width(is(1000));

            SoftAssert.assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertThat(tr.getMessage(), is("[java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is \"hidden\"" + LINE_BREAK +
                "     but: was \"displayed\", java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is \"disabled\"" + LINE_BREAK +
                "     but: was \"enabled\", java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is \"Jdi Logo 777\"" + LINE_BREAK +
                "     but: was \"Jdi Logo 2\", java.lang.AssertionError: " + LINE_BREAK +
                "Expected: a string containing \"jdi-logo.jpg777\"" + LINE_BREAK +
                "     but: was \"https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg\", java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is <1000>" + LINE_BREAK +
                "     but: was <101>]"));
        }
    }

    @Test
    public void imageSoftAssertTest() {
        try {
            jdiLogo.verify()
                .alt(is("Jdi Logo 777"))
                .src(containsString("jdi-logo.jpg777"))
                .height(is(100))
                .width(is(1000))

                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertThat(tr.getMessage(), is("[java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is \"Jdi Logo 777\"" + LINE_BREAK +
                "     but: was \"Jdi Logo 2\", java.lang.AssertionError: " + LINE_BREAK +
                "Expected: a string containing \"jdi-logo.jpg777\"" + LINE_BREAK +
                "     but: was \"https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg\", java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is <1000>" + LINE_BREAK +
                "     but: was <101>]"));
        }
    }

    @Test
    public void checkboxSoftAssertTest() {
        try {
            acceptConditions.verify().deselected().selected().disabled().displayed()
                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertThat(tr.getMessage(), is("[java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is \"not selected\"" + LINE_BREAK +
                "     but: was \"selected\", java.lang.AssertionError: " + LINE_BREAK +
                "Expected: is \"disabled\"" + LINE_BREAK +
                "     but: was \"enabled\"]"));
        }
    }

    @Test
    public void dataTableSoftAssertTest(){
        try {
            usersPage.open();
            users.verify()
                .row(d -> d.user.contains("Ivannn"))
                .all().rows(d -> d.user.length() > 4)
                .atLeast(3).rows(d -> d.type.contains("Userrr"))
                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertThat(tr.getMessage(), is("[java.lang.AssertionError: " + LINE_BREAK +
                "Expected: not null" + LINE_BREAK +
                "     but: was null, java.lang.AssertionError: " + LINE_BREAK +
                "Expected: a collection with size <3>" + LINE_BREAK +
                "     but: collection size was <0>]"));
        }
    }
    @Test
    public void customFailTest(){
        try {
            usersPage.open();
            users.verify()
                .row(d -> d.user.contains("Ivannn"))
                .all().rows(d -> d.user.length() > 4)
                .atLeast(3).rows(d -> d.type.contains("Userrr"))
                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertThat(tr.getMessage(), is("[java.lang.AssertionError: " + LINE_BREAK +
                    "Expected: not null" + LINE_BREAK +
                    "     but: was null, java.lang.AssertionError: " + LINE_BREAK +
                    "Expected: a collection with size <3>" + LINE_BREAK +
                    "     but: collection size was <0>]"));
        }
    }
}
