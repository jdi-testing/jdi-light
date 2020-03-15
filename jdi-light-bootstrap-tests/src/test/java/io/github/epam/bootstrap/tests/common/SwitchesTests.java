package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;

/**
 * Created by Dmitrii Pavlov on 08.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class SwitchesTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        switcher.show();
        switcher.uncheck();
    }

    @Test
    public void clickableTests() {
        switcher.check();
        switcher.is().selected();
        switcher.uncheck();
        switcher.is().deselected();
    }

    @Test
    public void labelTest() {
        switcher.label().has().text("Toggle this switch element");
    }

    @Test
    public void labelClickTests() {
        switcher.label().click();
        switcher.is().selected();
        switcher.label().click();
        switcher.is().deselected();
    }

    @Test
    public void disabledClickableTests() {
        disabledSwitcher.is().disabled();
        disabledSwitcher.check();
        disabledSwitcher.is().deselected();
        disabledSwitcher.label().click();
        disabledSwitcher.is().deselected();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(switcher);
    }
}
