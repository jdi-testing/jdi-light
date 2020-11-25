package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.notification.Notification;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class NotifyPage {
    @MobileFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout")
    public static Notification notification;

    @MobileFindBy(accessibilityId = "Clear all notifications.")
    public static Button clearAllButton;


    public void sendSMS(String phoneNumber, String smsText) {
        MobileDevice.sendSMS(phoneNumber, smsText);
    }
}
