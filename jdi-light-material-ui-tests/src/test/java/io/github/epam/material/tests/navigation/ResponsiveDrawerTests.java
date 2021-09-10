package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.responsiveDrawerPage;
import static io.github.com.pages.navigation.ResponsiveDrawerPage.drawer;
import static io.github.com.pages.navigation.ResponsiveDrawerPage.drawerContent;
import static io.github.com.pages.navigation.ResponsiveDrawerPage.drawerElementsIcon;
import static io.github.com.pages.navigation.ResponsiveDrawerPage.drawerElementsText;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class ResponsiveDrawerTests extends TestsInit {

    private List<String> actualDrawerTexts = new ArrayList<>();
    private List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private String firstPartOfTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private String secondPartOfTextContent = "Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla facilisi etiam dignissim diam.";

    @BeforeMethod
    public void before() {
        responsiveDrawerPage.open();
        responsiveDrawerPage.shouldBeOpened();
    }

    @Test
    public void responsiveDrawerTest() {
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
        drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        drawerContent.get(2).is().text(containsString(secondPartOfTextContent));
    }
}
