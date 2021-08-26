package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.temporaryDrawerPage;
import static io.github.com.pages.navigation.TemporaryDrawerPage.*;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class TemporaryDrawerTests extends TestsInit {

    private List<String> actualDrawerTexts = new ArrayList<>();
    private List<String> expectedDrawerTexts = Arrays.asList("Inbox", "Starred", "Send email", "Drafts", "All mail", "Trash", "Spam");

    @BeforeMethod
    public void before() {
        temporaryDrawerPage.open();
        temporaryDrawerPage.shouldBeOpened();
    }

    @Test
    public void temporaryDrawerTest() {
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