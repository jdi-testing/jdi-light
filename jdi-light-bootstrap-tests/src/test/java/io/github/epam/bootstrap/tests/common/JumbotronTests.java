package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class JumbotronTests extends TestsInit {
    private String mFluidJombotron = "FLUID JUMBOTRON\n" +
            "This is a modified jumbotron that occupies the entire horizontal space of its parent.";
    private String mHelloWorld = "HELLO, WORLD!\n" +
            "This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.\n" +
            "It uses utility classes for typography and spacing to space content out within the larger container.\n" +
            "Learn more";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTextTest() {
        assertEquals(jumbotronFluid.getText(), mFluidJombotron);
        assertEquals(jumbotron.getText(), mHelloWorld);
    }

    @Test
    public void getValueTest() {
        assertEquals(jumbotronFluid.getValue(), mFluidJombotron);
        assertEquals(jumbotron.getValue(), mHelloWorld);
    }

    @Test
    public void clickTest() {
        learnMoreBtn.click();
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));
        assertEquals("https://getbootstrap.com/docs/4.3/components/jumbotron/", getUrl());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValidationTest() {
        jumbotronFluid.is().displayed();
        jumbotronFluid.is().enabled();
        jumbotronFluid.is().text(is(mFluidJombotron));
        jumbotronFluid.is().text(containsString("FLUID"));
        assertThat(jumbotronFluid.core().css("font-size"), is("14px"));
        jumbotronFluid.assertThat().displayed()
                .and().text(is(mFluidJombotron))
                .core()
                .css("font-size", is("14px"))
                .cssClass("jumbotron jumbotron-fluid")
                .tag(is("div"));

        jumbotron.is().displayed();
        jumbotron.is().enabled();
        jumbotron.is().text(is(mHelloWorld));
        jumbotron.is().text(containsString("HELLO, WORLD!"));
        assertThat(jumbotron.core().css("font-size"), is("14px"));
        jumbotron.assertThat().displayed()
                .and().text(is(mHelloWorld))
                .core()
                .css("font-size", is("14px"))
                .cssClass("jumbotron")
                .tag(is("div"));
    }

    @Test
    public void assertValidationTest() {
        jumbotronFluid.assertThat().text(is(mFluidJombotron));
        jumbotron.assertThat().text(is(mHelloWorld));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(jumbotronFluid);
        baseValidation(jumbotron);
    }
}