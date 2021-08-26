package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.swipeableDrawerPage;
import static io.github.com.pages.navigation.SwipeableDrawerPage.*;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class SwipeableDrawerTests extends TestsInit {

    private List<String> actualDrawerTexts = new ArrayList<>();
    private List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");

    @BeforeMethod
    public void before() {
        swipeableDrawerPage.open();
        swipeableDrawerPage.shouldBeOpened();
    }

    @Test
    public void swipeableDrawerTest() {
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
}
