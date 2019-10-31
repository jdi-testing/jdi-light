package io.github.epam.bootstrap.tests.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownMenuDisabledItem;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class DisabledMenuItemTest extends TestsInit {

    private final String DISABLED_ITEM_TEXT = "Disabled link";
    private final String DISABLED_ITEM_HREF = "https://getbootstrap.com/docs/4.3/components/dropdowns/";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void itemTest() {
        dropdownMenuDisabledItem.expand();
        dropdownMenuDisabledItem.list()
                .get(DISABLED_ITEM_TEXT)
                .assertThat()
                .tag("a")
                .attr("href", DISABLED_ITEM_HREF)
                .disabled();
        dropdownMenuDisabledItem.collapse();
    }

}
