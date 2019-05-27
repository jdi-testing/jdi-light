package io.github.epam.html.tests.core;

import com.epam.jdi.light.ui.html.common.Checkbox;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.differentElementsPage;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class LocatorTests extends TestsInit {

    @BeforeMethod
    public void beforeMethod(){
        shouldBeLoggedIn();
        differentElementsPage.shouldBeOpened();
        refresh();
    }

    @Test
    public void seleniumFindByLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterSeleniumFindBy);
    }

    @Test
    public void jdiFindByCssLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterJDIFindByCss);
    }

    @Test
    public void jdiFindByTextLocatorTest() {
        differentElementsPage.waterJDIFindByText.assertThat().text(is("Water"));
    }

    @Test
    public void cssLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterCss);
    }

    @Test
    public void xpathFindByLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterXPath);
    }

    @Test
    public void byTextLocatorTest(){
        differentElementsPage.waterByText.assertThat().text(is("Water"));
    }

    @Test
    public void withTextLocatorTest(){
        differentElementsPage.waterWithText.assertThat().text(is("Water"));
    }

    @Test
    public void cssUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUICss);
    }

    @Test
    public void xpathUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIXpath);
    }

    @Test
    public void cssHasTextUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIHasText);
    }

    @Test
    public void cssWithTextUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIWithText);
    }

    @Test
    public void cssWithPositionUILocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterUIPosition);
    }

    @Test
    public void uiLocatorMovingUpTheTreeTest(){
        differentElementsPage.waterUIMoveUp.assertThat().text(is("Water"));
    }

    @Test
    @Ignore
    //TBD: unignore after functionality is fixed/added, put in independent tests
    public void complexLocatorTest() {
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterSeleniumFindBys);
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterJDIFindBys);
        checkThatCheckboxIsCorrectlySelected(differentElementsPage.waterSeleniumFindAll);
        //checkThatElementIsCorrectlySelected(differentElementsPage.waterJDIFindAll); //TBD
    }

    private static void checkThatCheckboxIsCorrectlySelected(Checkbox checkbox){
        checkbox.check();
        checkbox.is().selected();
    }
}
