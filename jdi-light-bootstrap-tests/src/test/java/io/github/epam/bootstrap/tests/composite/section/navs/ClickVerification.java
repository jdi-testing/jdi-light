package io.github.epam.bootstrap.tests.composite.section.navs;

import com.epam.jdi.light.elements.common.UIElement;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 30.09.2019
 * Email: delnote@gmail.com;
 * Skype: Dmitrii Pavlov
 */

public class ClickVerification {

    public static void testElementClick(UIElement element, String pageTitle) {
        element.highlight();
        element.click();
        newWindowTitleCheck(pageTitle);
        element.unhighlight();
    }

    public static void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
