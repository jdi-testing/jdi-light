package io.github.epam.material.tests.navigation.drawer;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.elements.common.UIElement;
import static io.github.com.StaticSite.miniDrawerPage;
import static io.github.com.pages.navigation.MiniDrawerPage.miniDrawer;
import io.github.epam.TestsInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MiniDrawerTests extends TestsInit {

    private final List<String> actualDrawerTexts = new ArrayList<>();
    private final List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private static final String CONSEQUAT_MAURIS = "Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla facilisi etiam dignissim diam.";

    @BeforeMethod
    public void before() {
        miniDrawerPage.open();
        miniDrawerPage.shouldBeOpened();
    }

    @Test
    public void miniDrawerTest() {

        miniDrawer.is().displayed();
        miniDrawer.has().position("left");

        for (UIElement element : miniDrawer.elements()) {
            element.find(".MuiSvgIcon-root").is().visible();
        }

        miniDrawer.open();

        miniDrawer.elements().forEach(element -> actualDrawerTexts.add(element.text()));
        jdiAssert(actualDrawerTexts.containsAll(expectedDrawerTexts) ? "elements text is visible"
                : "elements text isn't visible", Matchers.is("elements text is visible"));
        actualDrawerTexts.clear();

        miniDrawer.assertThat().containerHasTitle("Mini variant drawer");
        miniDrawer.assertThat().paragraphHasText(2, containsString(CONSEQUAT_MAURIS));

        miniDrawer.close();
    }
}
