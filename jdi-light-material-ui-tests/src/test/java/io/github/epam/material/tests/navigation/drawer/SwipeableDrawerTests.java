package io.github.epam.material.tests.navigation.drawer;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.elements.common.UIElement;
import static io.github.com.StaticSite.swipeableDrawerPage;
import static io.github.com.pages.navigation.SwipeableDrawerPage.swipeableDrawer;
import static io.github.com.pages.navigation.SwipeableDrawerPage.swipeableDrawerButtons;
import io.github.epam.TestsInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeableDrawerTests extends TestsInit {

    private final List<String> actualDrawerTexts = new ArrayList<>();
    private final List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private final String[] position = {"left", "right", "top", "bottom"};

    @BeforeMethod
    public void before() {
        swipeableDrawerPage.open();
        swipeableDrawerPage.shouldBeOpened();
    }

    @Test
    public void swipeableDrawerTest() {

        for (int i = 1; i <= swipeableDrawerButtons.size(); i++) {
            swipeableDrawerButtons.get(i).click();
            swipeableDrawer.is().visible();
            swipeableDrawer.has().position(position[i - 1]);
            swipeableDrawer.elements().forEach(element -> actualDrawerTexts.add(element.text()));

            jdiAssert(actualDrawerTexts.containsAll(expectedDrawerTexts) ? "elements text is visible"
                    : "elements text isn't visible", Matchers.is("elements text is visible"));
            actualDrawerTexts.clear();

            for (UIElement element : swipeableDrawer.elements()) {
                element.find(".MuiSvgIcon-root").is().visible();
            }
            swipeableDrawer.close();
        }
    }
}
