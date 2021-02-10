package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.appBarFrame;

public class AppBarTests extends TestsInit {

    @Test
    public void appBarTests() {
        appBarFrame.appBar.is().isEnabledMenu();
        appBarFrame.appBar.appBarMenuClick();
        appBarFrame.appBar.is().isEnabledLogin();
        appBarFrame.appBar.loginClick();
    }
}
