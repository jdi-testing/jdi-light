package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import io.github.epam.test.data.MenuDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.contextMenuPage;
import static io.github.com.StaticSite.simpleMenuPage;
import static io.github.com.pages.navigation.ContextMenuPage.contextMenuList;
import static io.github.com.pages.navigation.ContextMenuPage.pageText;
import static io.github.com.pages.navigation.SimpleMenuPage.*;

public class ContextMenuTests extends TestsInit {

    private static final List<String> CONTEXT_MENU_ITEMS = Arrays.asList("Copy", "Print", "Highlight", "Email");

    @BeforeMethod
    public void before() {
        contextMenuPage.open();
        contextMenuPage.isOpened();
    }

    @Test
    public void contextMenuTest() {
        pageText.is().displayed();

        pageText.rightClick();
        menu.is().displayed().and().has().itemsTexts(CONTEXT_MENU_ITEMS);
        contextMenuList.select("Print");
        waitCondition(() -> menu.isHidden());
        menu.is().hidden();
    }
}
