package io.github.epam.material.tests.navigation;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.miniDrawerPage;
import static io.github.com.pages.navigation.MiniDrawerPage.drawer;
import static io.github.com.pages.navigation.MiniDrawerPage.drawerBackMenuButton;
import static io.github.com.pages.navigation.MiniDrawerPage.drawerContent;
import static io.github.com.pages.navigation.MiniDrawerPage.drawerElementsIcon;
import static io.github.com.pages.navigation.MiniDrawerPage.drawerElementsText;
import static io.github.com.pages.navigation.MiniDrawerPage.drawerSandwichMenuButton;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class MiniDrawerTests extends TestsInit {

    private static Timer timer = new Timer(2000L);
    private List<String> actualDrawerTexts = new ArrayList<>();
    private List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private String firstPartOfTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private String secondPartOfTextContent = "Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla facilisi etiam dignissim diam.";

    @BeforeMethod
    public void before() {
        miniDrawerPage.open();
        miniDrawerPage.shouldBeOpened();
    }

    @Test
    public void miniDrawerTest() {
        drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        drawerContent.get(2).is().text(containsString(secondPartOfTextContent));

        drawerSandwichMenuButton.click();
        drawer.is().displayed();
        drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );
        drawerElementsText.forEach(
                text -> {
                    text.click();
                    actualDrawerTexts.add(text.getText());
                }
        );
        assertEquals(actualDrawerTexts, expectedDrawerTexts);
        actualDrawerTexts.clear();
        drawerBackMenuButton.click();
        timer.wait(() -> drawerElementsText.get(1).is().disappear());
        drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );
    }
}
