package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.TabBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class TabsPage {

    @MobileFindBy(accessibilityId = "5. Scrollable")
    public static Button scrollableButton;

    @MobileFindBy(id = "android:id/tabs")
    public static TabBar tabBar;

    @MobileFindBy(xpath =
            "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
    public static TabBar tabContent;

}
