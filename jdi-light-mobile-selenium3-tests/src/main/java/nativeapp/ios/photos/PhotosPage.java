package nativeapp.ios.photos;

import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.composite.ios.app.TabBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class PhotosPage {

    @MobileFindBy(xpath = "//XCUIElementTypeTabBar")
    public static TabBar photosTabBar;

    @MobileFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"No Content\"]")
    public static Text noContentText;

}
