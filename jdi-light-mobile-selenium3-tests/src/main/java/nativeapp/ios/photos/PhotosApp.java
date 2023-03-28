package nativeapp.ios.photos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

@JApp(app = "com.apple.mobileslideshow")
public class PhotosApp {

    public static PhotosPage photosPage;

    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    public static Button continueButton;

}
