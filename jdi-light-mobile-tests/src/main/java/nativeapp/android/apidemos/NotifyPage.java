package nativeapp.android.apidemos;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class NotifyPage {
    @MobileFindBy(id = "com.android.systemui:id/notification_panel")
    public static Text notificationPanel;

    @MobileFindBy(accessibilityId = "Clear all notifications.")
    public static Button clearAllButton;

    @MobileFindBy(id = "android:id/message_text")
    public static Text notificationMessagingContent;

    @MobileFindBy(xpath = "//android.widget.Button[@content-desc=\"Mark as read\"]")
    public static Button markAsRead;

    @MobileFindBy(accessibilityId = "Reply")
    public static Button reply;

    @MobileFindBy(id = "com.android.systemui:id/remote_input_send")
    public static Button send;

    @MobileFindBy(xpath = "//android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[@resource-id='android:id/icon']")
    public static Button appIcon;

    @MobileFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
    public static Text appName;

    @MobileFindBy(id = "android:id/message_name")
    public static Text notificationName;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")
    public static Text timeStamp;

    public static UIElement findNotificationMessageText(String parameter, String name) {
        WebElement foundElement = getDriver().findElements(By.id("android:id/message_" + parameter))
                .stream().filter(item -> item.getText().contains(name)).findAny().get();
        return new UIElement(foundElement);
    }
}