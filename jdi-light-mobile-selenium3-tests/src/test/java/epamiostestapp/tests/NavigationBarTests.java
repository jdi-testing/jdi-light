package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.NavigationBarPage;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuNavigationBar;

public class NavigationBarTests extends IosApplicationInit {

    @Test
    public void navigationBarTest(){
        menuNavigationBar.tap();

        NavigationBarPage.navigationBarMainPage.tapButton("Show detail view");
        NavigationBarPage.detailViewPageNavigationBar.is().displayed();
        NavigationBarPage.detailViewPageNavigationBar.tapButton("Back");
        NavigationBarPage.navigationBarMainPage.is().displayed();

    }
}
