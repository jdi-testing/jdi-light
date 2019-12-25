package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.dressCode2;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Fancy;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class Dropdown2ExampleTests implements TestsInit {
    List<String> dropdownValues = asList("Fancy", "Casual", "Disabled", "Pirate");
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    @Test
    public void selectTest() {
        dressCode2.select("Pirate");
        dressCode2.is().selected("Pirate");
    }

    @Test
    public void selectEnumTest() {
        dressCode2.select(Fancy);
        dressCode2.is().selected("Fancy");
    }
    @Test
    public void selectNumTest() {
        dressCode2.select(1);
        dressCode2.is().selected(Fancy);
    }
    @Test
    public void checkValues() {
        dressCode2.is().values(is(dropdownValues)) ;
        dressCode2.assertThat().values(hasItem("Pirate"));
        dressCode2.assertThat().values(hasItems("Fancy", "Pirate", "Casual", "Disabled"));
        dressCode2.is().values(not(hasItem("Item")));
    }
    @Test
    public void size() {
        System.out.println("---size " + dressCode2.size());

        dressCode2.assertThat().size(7);
    }

}
