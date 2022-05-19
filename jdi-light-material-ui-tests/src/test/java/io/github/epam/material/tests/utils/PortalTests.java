package io.github.epam.material.tests.utils;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.portalPage;
import static io.github.com.pages.utils.PortalPage.portal;

public class PortalTests extends TestsInit {

    private static final String FIRST_FIELD_TEXT = "It looks like I will render here.";

    @BeforeMethod
    public void beforeTest() {
        portalPage.open();
        portalPage.isOpened();
    }

    @Test
    public void portalTest() {
        Button button = portal.button();
        Text textFirst = portal.text(1);
        Text textSecond = portal.text(2);

        button.has().text("Mount children");
        textFirst.has().text(FIRST_FIELD_TEXT);
        textSecond.has().text(StringUtils.EMPTY);

        button.click();
        button.has().text("Unmount children");
        textFirst.has().text(FIRST_FIELD_TEXT);
        textSecond.has().text("But I actually render here!");

        button.click();
        button.has().text("Mount children");
        textFirst.has().text(FIRST_FIELD_TEXT);
        textSecond.has().text(StringUtils.EMPTY);
    }
}
