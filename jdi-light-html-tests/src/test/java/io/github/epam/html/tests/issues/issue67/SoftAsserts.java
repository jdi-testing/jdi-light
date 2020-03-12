package io.github.epam.html.tests.issues.issue67;

import com.epam.jdi.light.asserts.core.SoftAssert;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.com.pages.UsersPage.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static java.util.Arrays.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class SoftAsserts implements TestsInit {
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
            assertList(tr.getMessage(), asList(
                "Expected: is \"hidden\"", "but: was \"displayed\",",
                "Expected: is \"disabled\"",  "but: was \"enabled\",",
                "Expected: is \"hidden\"", "but: was \"displayed\",",
                "Expected: is \"Big Red *** Button-Input\"", "but: was \"Big Red Button-Input\""
            ));
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
            assertList(tr.getMessage(), asList(
                "Expected: is \"hidden\"", "but: was \"displayed\",",
                "Expected: is \"disabled\"",  "but: was \"enabled\",",
                "Expected: is \"Jdi Logo 777\"", "but: was \"Jdi Logo 2\",",
                "Expected: a string containing \"jdi-logo.jpg777\"",
                "but: was \"https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg\"",
                "Expected: is <1000>", "but: was <101>"
            ));
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
            assertList(tr.getMessage(), asList(
                "Expected: is \"Jdi Logo 777\"", "but: was \"Jdi Logo 2\"",
                "Expected: a string containing \"jdi-logo.jpg777\"",
                "but: was \"https://jdi-testing.github.io/jdi-light/images/jdi-logo.jpg\"",
                "Expected: is <1000>", "but: was <101>"
            ));
        }
    }

    @Test
    public void checkboxSoftAssertTest() {
        try {
            acceptConditions.verify().deselected().selected().disabled().displayed()
                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertList(tr.getMessage(), asList(
                "Expected: is \"not selected\"", "but: was \"selected\"",
                "Expected: is \"disabled\"", "but: was \"enabled\""
            ));
        }
    }

    @Test
    public void dataTableSoftAssertTest(){
        try {
            usersPage.open();
            // TODO fix performance
            users.verify()
                .row(d -> d.user.contains("Ivannn"))
                .all().rows(d -> d.user.length() > 4)
                .atLeast(3).rows(d -> d.type.contains("Userrr"))
                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertList(tr.getMessage(), asList(
                "Expected: not null", "but: was null",
                "Expected: a collection with size <3>", "but: collection size was <0>"
            ));
        }
    }
    @Test
    public void customFailTest(){
        try {
            usersPage.open();
            // TODO fix performance
            users.verify()
                .row(d -> d.user.contains("Ivannn"))
                .all().rows(d -> d.user.length() > 4)
                .atLeast(3).rows(d -> d.type.contains("Userrr"))
                .assertResults();
            Assert.fail("Test should throw asserts");
        } catch (Throwable tr) {
            assertList(tr.getMessage(), asList(
                "Expected: not null", "but: was null",
                "Expected: a collection with size <3>", "but: collection size was <0>"
            ));
        }
    }

    void assertList(String actual, List<String> strings) {
        for (String str : strings)
            assertThat(actual, containsString(str));
    }
}
