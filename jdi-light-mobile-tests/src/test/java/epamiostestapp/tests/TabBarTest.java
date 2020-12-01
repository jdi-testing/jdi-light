package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuTabView;
import static nativeapp.ios.epamiostestapp.TabViewPage.tabBar;

public class TabBarTest  extends IosApplicationInit {

    @Test
    public void tapBarTest(){
        menuTabView.tap();

        tabBar.tapBarButton("Second");
        tabBar.is().selected("Second");

        tabBar.tapBarButton("First");
        tabBar.is().selected("First");

        tabBar.tapBarButton("Exit");
        tabBar.is().selected("Exit");
    }

}
