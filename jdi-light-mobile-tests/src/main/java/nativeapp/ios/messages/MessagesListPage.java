package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class MessagesListPage {

    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"Kate Bell, 1/1/01 \"][1]/XCUIElementTypeOther/XCUIElementTypeOther")
    public static Button firstMenInMessages;

}
