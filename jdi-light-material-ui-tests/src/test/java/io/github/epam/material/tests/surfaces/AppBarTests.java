package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.appBarFrame;
import static io.github.com.StaticSite.surfaceSimpleAppBarPage;
import static org.hamcrest.Matchers.hasToString;

public class AppBarTests extends TestsInit {
    @Test
    public void appBarTest(){
        surfaceSimpleAppBarPage.open();

        appBarFrame.menu.is().displayed();
        appBarFrame.menu.click();

        appBarFrame.news.is().displayed();
        appBarFrame.news.is().text(hasToString("News"));

        appBarFrame.login.is().displayed();
        appBarFrame.login.click();
        appBarFrame.login.is().text(hasToString("LOGIN"));
    }
}
