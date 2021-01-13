package nativeapp.android;

import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.MobileFileManager;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

@JApp(appPackage = "com.android.documentsui",
        appActivity = "com.android.documentsui.files.FilesActivity")
public class AndroidFileManager {

    public static MobileFileManager fileManager;

    @MobileFindBy(xpath = "//android.widget.ImageButton[@content-desc='Show roots']")
    public static Button roots;

    @MobileFindBy(xpath = "//*[contains(@text, 'Downloads')]")
    public static Button downloads;

    @MobileFindBy(xpath = "//*[contains(@text, 'Delete')]")
    public static Button deleteButton;

    @MobileFindBy(id = "android:id/button1")
    public static Button okButton;

    @MobileFindBy(xpath = "//*[contains(@text, 'TEST.txt')]")
    public static Button fileOnAndroid;

}
