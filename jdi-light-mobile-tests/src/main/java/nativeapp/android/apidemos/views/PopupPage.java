package nativeapp.android.apidemos.views;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.ios.app.Menu;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class PopupPage {

    @MobileFindBy(accessibilityId = "Make a Popup!")
    public static Button makePopupButton;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    public static Button searchItem;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    public static Button addItem;

    @MobileFindBy(id = "android:id/submenuarrow")
    public static Menu editItem;

    @MobileFindBy(id = "android:id/icon")
    public static Button shareItem;

    @MobileFindBy(className = "android.widget.LinearLayout")
    public static UIElement screen;

}
