package io.github.epam.material.tests.navigation.drawer;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.elements.common.UIElement;
import static io.github.com.StaticSite.responsiveDrawerPage;
import static io.github.com.pages.navigation.ResponsiveDrawerPage.responsiveDrawer;
import io.github.epam.TestsInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResponsiveDrawerTests extends TestsInit {

    private final List<String> actualDrawerTexts = new ArrayList<>();
    private final List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

    @BeforeMethod
    public void before() {
        responsiveDrawerPage.open();
        responsiveDrawerPage.shouldBeOpened();
    }

    @Test
    public void responsiveDrawerTest() {

        responsiveDrawer.is().displayed();
        responsiveDrawer.has().position("left");

        responsiveDrawer.elements().forEach(element -> actualDrawerTexts.add(element.text()));
        jdiAssert(actualDrawerTexts.containsAll(expectedDrawerTexts) ? "elements text is visible"
                : "elements text isn't visible", Matchers.is("elements text is visible"));
        actualDrawerTexts.clear();

        for (UIElement element : responsiveDrawer.elements()) {
            element.find(".MuiSvgIcon-root").is().visible();
        }

        responsiveDrawer.assertThat().containerHasTitle("Responsive drawer");
        responsiveDrawer.assertThat().paragraphHasText(1, containsString(LOREM_IPSUM));
    }
}
