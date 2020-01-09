package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.common.TextTypes.INNER;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.pages.MetalAndColorsPage.colors2;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Blue;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Green;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

public class DropdownExampleTests implements TestsInit {
   
    private List<String> dropdownValues = asList("Colors", "Red", "Green", "Blue", "Yellow");

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
    }

    @Test
    public void selectStringTest() {
        colors2.select("Red");
        colors2.is().selected("Red");
    }

    @Test
    public void selectEnumTest() {
        colors2.select(Green);
        colors2.is().selected(Green);
    }

    @Test
    public void selectIndexTest() {
        colors2.select(4);
        colors2.is().selected(Blue);
    }

    @Test
    public void checkValuesTest() {
        colors2.assertThat().values(is(dropdownValues));
        colors2.is().values(hasItem("Yellow"));
        colors2.is().values(not(hasItem("Missing color")));
        colors2.is().enabled("Colors", "Red", "Green", "Blue", "Yellow");
        colors2.is().values(INNER, hasItem("Yellow"));
        colors2.assertThat().values(INNER, is(dropdownValues));
        colors2.is().values(INNER, not(hasItem("Missing color")));
    }

    @Test
    public void dropdownTestSize() {
        colors2.assertThat().notEmpty();
        colors2.assertThat().size(5);
    }

    @Test
    public void dropdownTest() {
        colors2.is().displayed().and().enabled();
    }
}
