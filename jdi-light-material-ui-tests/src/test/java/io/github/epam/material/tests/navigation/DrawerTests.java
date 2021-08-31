package io.github.epam.material.tests.navigation;

import static io.github.com.StaticSite.*;
import static org.testng.Assert.*;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * To see an example of Drawer web element please visit
 * https://material-ui.com/components/drawers/
 */

public class DrawerTests extends TestsInit {

    private static Timer timer = new Timer(2000L);
    private List<String> actualDrawerTexts = new ArrayList<>();
    private List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");
    private String firstPartOfTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private String secondPartOfTextContent = "Consequat mauris nunc congue nisi vitae suscipit. Fringilla est ullamcorper eget nulla facilisi etiam dignissim diam.";

    @Test(priority = 1)
    public void temporaryDrawerTest() {
        temporaryDrawerPage.open();
        List<Button> buttons = Arrays.asList(temporaryDrawerPage.leftButton, temporaryDrawerPage.rightButton,
        temporaryDrawerPage.topButton, temporaryDrawerPage.bottomButton);
        buttons.forEach(
                button -> {
                    button.click();
                    temporaryDrawerPage.drawer.is().displayed();
                    String currentButtonName = button.getName();
                    temporaryDrawerPage.drawer.has().classValue(containsString(String.format("MuiDrawer-paperAnchor%s", currentButtonName.substring(0,currentButtonName.lastIndexOf(" ") + 1))));
                    temporaryDrawerPage.drawerElementsIcon.forEach(
                            icon -> icon.is().displayedSvg()
                    );
                    temporaryDrawerPage.drawerElementsText.forEach(
                            text -> actualDrawerTexts.add(text.getText())
                    );
                    assertEquals(actualDrawerTexts, expectedDrawerTexts);
                    actualDrawerTexts.clear();
                    temporaryDrawerPage.drawerElementsText.get(1).click();
                }
        );
    }

    @Test(priority = 2)
    public void swipeableDrawerTest() {
        swipeableDrawerPage.open();
        List<Button> buttons = Arrays.asList(swipeableDrawerPage.leftButton, swipeableDrawerPage.rightButton,
        swipeableDrawerPage.topButton, swipeableDrawerPage.bottomButton);
        buttons.forEach(
                button -> {
                    button.click();
                    swipeableDrawerPage.drawer.is().displayed();
                    String currentButtonName = button.getName();
                    swipeableDrawerPage.drawer.has().classValue(containsString(String.format("MuiDrawer-paperAnchor%s", currentButtonName.substring(0,currentButtonName.lastIndexOf(" ") + 1))));
                    swipeableDrawerPage.drawerElementsIcon.forEach(
                            icon -> icon.is().displayedSvg()
                    );
                    swipeableDrawerPage.drawerElementsText.forEach(
                            text -> actualDrawerTexts.add(text.getText())
                    );
                    assertEquals(actualDrawerTexts, expectedDrawerTexts);
                    actualDrawerTexts.clear();
                    swipeableDrawerPage.drawerElementsText.get(1).click();
                }
        );
    }

    @Test(priority = 3)
    public void responsiveDrawerTest() {
        responsiveDrawerPage.open();
        responsiveDrawerPage.drawer.is().displayed();
        responsiveDrawerPage.drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        responsiveDrawerPage.drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );
        responsiveDrawerPage.drawerElementsText.forEach(
                text -> {
                    text.click();
                    actualDrawerTexts.add(text.getText());
                }
        );
        assertEquals(actualDrawerTexts, expectedDrawerTexts);
        actualDrawerTexts.clear();
        responsiveDrawerPage.drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        responsiveDrawerPage.drawerContent.get(2).is().text(containsString(secondPartOfTextContent));
    }

    @Test(priority = 4)
    public void persistentDrawerTest() {
        persistentDrawerPage.open();
        persistentDrawerPage.drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        persistentDrawerPage.drawerContent.get(2).is().text(containsString(secondPartOfTextContent));

        persistentDrawerPage.drawerSandwichMenuButton.click();
        persistentDrawerPage.drawer.is().displayed();
        persistentDrawerPage.drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        persistentDrawerPage.drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );
        persistentDrawerPage.drawerElementsText.forEach(
                text -> {
                    text.click();
                    actualDrawerTexts.add(text.getText());
                }
        );
        assertEquals(actualDrawerTexts, expectedDrawerTexts);
        actualDrawerTexts.clear();
        persistentDrawerPage.drawerBackMenuButton.click();
    }

    @Test(priority = 5)
    public void miniDrawerTest() {
        miniDrawerPage.open();
        miniDrawerPage.drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        miniDrawerPage.drawerContent.get(2).is().text(containsString(secondPartOfTextContent));

        miniDrawerPage.drawerSandwichMenuButton.click();
        miniDrawerPage.drawer.is().displayed();
        miniDrawerPage.drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        miniDrawerPage.drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );
        miniDrawerPage.drawerElementsText.forEach(
                text -> {
                    text.click();
                    actualDrawerTexts.add(text.getText());
                }
        );
        assertEquals(actualDrawerTexts, expectedDrawerTexts);
        actualDrawerTexts.clear();
        miniDrawerPage.drawerBackMenuButton.click();
        timer.wait(() -> miniDrawerPage.drawerElementsText.get(1).is().disappear());
        miniDrawerPage.drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );

    }

    @Test(priority = 6)
    public void permanentDrawerTest() {
        permanentDrawerPage.open();
        permanentDrawerPage.drawer.is().displayed();
        permanentDrawerPage.drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        permanentDrawerPage.drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        permanentDrawerPage.drawerContent.get(2).is().text(containsString(secondPartOfTextContent));

        permanentDrawerPage.drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );
        permanentDrawerPage.drawerElementsText.forEach(
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
        clippedDrawerPage.drawer.is().displayed();
        clippedDrawerPage.drawer.has().classValue(containsString("MuiDrawer-paperAnchorLeft"));
        clippedDrawerPage.drawerContent.get(1).is().text(containsString(firstPartOfTextContent));
        clippedDrawerPage.drawerContent.get(2).is().text(containsString(secondPartOfTextContent));

        clippedDrawerPage.drawerElementsIcon.forEach(
                icon -> icon.is().displayedSvg()
        );
        clippedDrawerPage.drawerElementsText.forEach(
                text -> {
                    text.click();
                    actualDrawerTexts.add(text.getText());
                }
        );
        assertEquals(actualDrawerTexts, expectedDrawerTexts);
        actualDrawerTexts.clear();
    }
}
