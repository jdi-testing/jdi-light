package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/*Issue: JList does not work correctly with web elements that have the same text

  Steps:
  Use JList class to collect UIElements (f.e. with class navbar-brand) on Bootstrap page
  Pls. look at tests below.

  Actual results:
  JList has size 20. forEach loop processes only 8 UIElements.
  Pls. look at tests below.

  Expected results:
  JList has size 20. forEach loop processes 20 UIElements.
*/

public class JListIssueTests extends TestsInit {

    private int expectedNumberOfNavbarBrands = 20;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

     /* At present time we have 20 web elements of navbar-brand class on Bootstrap page.
     JList's size() method shows correct number. So test  realSizeJListIssueTest()
     "passes" */

    @Test
    public void realSizeJListIssueTest() {
        JList<UIElement> jList = new JList<>(By.cssSelector(".navbar-brand"));
        int actualNumberOfNavbarBrands = jList.size();
        assertThat(expectedNumberOfNavbarBrands, is(equalTo(actualNumberOfNavbarBrands)));
    }

     /* JList's size() method  shows correct number. Usage of  list().elements(0).size()
     will show incorrect number */

    /* JList does not collect UIElements correctly since it converts a list of elements found
    to MapArray using as a key the elements text if it exists. The elements
    with the same text will be rewritten in the MapArray and they will not be processed in
    forEach loop */

    @Test
    public void numberOfUIElementsInJListTest() {
        int[] iarr = {1};
        JList<UIElement> jList = new JList<>(By.cssSelector(".navbar-brand"));
        int NumberUIElementsInJList = jList.list().elements(0).size();
        int actualNumberOfNavbarBrands = jList.size();

        System.out.println("------------UIElements in forEach loop----------");
        jList.forEach(e -> System.out.println(iarr[0]++));

        System.out.println("------------UIElements in for loop--------------");
        for (int i = 1; i <= jList.size(); i++) {
            System.out.println(i);
        }

        assertThat(NumberUIElementsInJList, is(equalTo(actualNumberOfNavbarBrands)));
    }
}
