package io.github.epam.material.tests.navigation.drawer;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.elements.common.UIElement;
import static io.github.com.StaticSite.temporaryDrawerPage;
import static io.github.com.pages.navigation.TemporaryDrawerPage.temporaryDrawer;
import static io.github.com.pages.navigation.TemporaryDrawerPage.temporaryDrawerButtons;
import io.github.epam.TestsInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TemporaryDrawerTests extends TestsInit {

    private final List<String> actualDrawerTexts = new ArrayList<>();
    private final List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private final String[] position = {"left", "right", "top", "bottom"};

    @BeforeMethod
    public void before() {
        temporaryDrawerPage.open();
        temporaryDrawerPage.shouldBeOpened();
    }

    @Test
    public void temporaryDrawerTest() {

        for (int i = 1; i <= temporaryDrawerButtons.size(); i++) {
            temporaryDrawerButtons.get(i).click();
            temporaryDrawer.is().visible();
            temporaryDrawer.has().position(position[i - 1]);
            temporaryDrawer.elements().forEach(element -> actualDrawerTexts.add(element.text()));

            jdiAssert(actualDrawerTexts.containsAll(expectedDrawerTexts) ? "elements text is visible"
                    : "elements text isn't visible", Matchers.is("elements text is visible"));
            actualDrawerTexts.clear();

            for (UIElement element : temporaryDrawer.elements()) {
                element.find(".MuiSvgIcon-root").is().visible();
            }
            temporaryDrawer.close();
        }
    }
}