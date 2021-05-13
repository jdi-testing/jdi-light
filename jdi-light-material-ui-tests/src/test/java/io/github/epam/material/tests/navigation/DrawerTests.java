package io.github.epam.material.tests.navigation;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.navigation.DrawerPage.*;
import static org.testng.Assert.*;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawerTests extends TestsInit {

    private static Timer timer = new Timer(2000L);
    private List<String> actualDrawerTexts = new ArrayList<>();
    private List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private String firstPartOfTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private String secondPartOfTextContent = "Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla facilisi etiam dignissim diam.";

    @Test(priority = 1)
    public void temporaryDrawerTest() {
        temporaryDrawerPage.open();
        List<Button> buttons = Arrays.asList(leftButton, rightButton, topButton, bottomButton);
        buttons.forEach(
                button -> {
                    button.click();
                    drawer.is().displayed();
                    String currentButtonName = button.getName();
                    drawer.has().classValue(containsString(String.format("MuiDrawer-paperAnchor%s", currentButtonName.substring(0,currentButtonName.lastIndexOf(" ") + 1))));
                    drawerElementsIcon.forEach(
                            icon -> icon.is().displayedSvg()
                    );
                    drawerElementsText.forEach(
                            text -> actualDrawerTexts.add(text.getText())
                    );
                    assertEquals(actualDrawerTexts, expectedDrawerTexts);
                    actualDrawerTexts.clear();
                    drawerElementsText.get(1).click();
                }
        );
    }

    @Test(priority = 2)
    public void swipeableDrawerTest() {
        swipeableDrawerPage.open();
        List<Button> buttons = Arrays.asList(leftButton, rightButton, topButton, bottomButton);
        buttons.forEach(
                button -> {
                    button.click();
                    drawer.is().displayed();
                    String currentButtonName = button.getName();
                    drawer.has().classValue(containsString(String.format("MuiDrawer-paperAnchor%s", currentButtonName.substring(0,currentButtonName.lastIndexOf(" ") + 1))));
                    drawerElementsIcon.forEach(
                            icon -> icon.is().displayedSvg()
                    );
                    drawerElementsText.forEach(
                            text -> actualDrawerTexts.add(text.getText())
                    );
                    assertEquals(actualDrawerTexts, expectedDrawerTexts);
                    actualDrawerTexts.clear();
                    drawerElementsText.get(1).click();
                }
        );
    }

    @Test(priority = 3)
    public void responsiveDrawerTest() {
        responsiveDrawerPage.open();
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

    @Test(priority = 4)
    public void persistentDrawerTest() {
        persistentDrawerPage.open();
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
    }

    @Test(priority = 5)
    public void miniDrawerTest() {
        miniDrawerPage.open();
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

    @Test(priority = 6)
    public void permanentDrawerTest() {
        permanentDrawerPage.open();
        drawer.is().displayed();
        drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        drawerContent.get(2).is().text(containsString(secondPartOfTextContent));

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
    }

    @Test(priority = 7)
    public void clippedDrawerTest() {
        clippedDrawerPage.open();
        drawer.is().displayed();
        drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        drawerContent.get(2).is().text(containsString(secondPartOfTextContent));

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
    }
}

