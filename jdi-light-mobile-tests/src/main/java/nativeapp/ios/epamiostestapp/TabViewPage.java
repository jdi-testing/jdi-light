package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.composite.ios.app.TabBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class TabViewPage {

    @MobileFindBy(accessibilityId = "Tab Bar")
    public static TabBar tabBar;

}
