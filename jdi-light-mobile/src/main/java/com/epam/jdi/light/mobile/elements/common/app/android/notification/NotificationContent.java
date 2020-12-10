package com.epam.jdi.light.mobile.elements.common.app.android.notification;

import com.epam.jdi.light.mobile.elements.common.Icon;
import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBys;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NotificationContent extends Section {
    private Text contentTitle;
    private Text contentText;

    @MobileFindBy(xpath = "//../android.widget.ImageView")
    private Icon largeIcon; // optional

    private String cTitle;
    private String cText;
    @MobileFindBys(@MobileFindBy(xpath = "//../android.widget.TextView")) //TODO: find way to fix this
    private List<Text> notificationTexts;

    @MobileFindBy(xpath = "//../android.widget.ImageView")
    private Text lastEventContent; // optional

    public String getContentTitle() {
        getWholeContent();
        return cTitle;
        //return contentTitle.getText();
    }

    public String getContentText() {
        getWholeContent();
        return cText;
       // return contentText.getText();
    }

    public boolean isLargeIconDisplayed() {
        return largeIcon.isDisplayed();
    }

    private void getWholeContent() { //TODO: implement more elegand search for text and title elements
        String locator = "//../android.widget.TextView";
        WebElement coreContentElement = core().driver().findElement(By.id("android:id/notification_main_column"));
        List<WebElement> contentTexts = coreContentElement.findElements(By.xpath(locator));
        if(contentTexts.isEmpty()) {
            throw new NoSuchElementException("No elements were found in \"NotificationContent\" element  by locator: "
                    + locator);
        } else {
            cTitle = contentTexts.get(0).getText();
            if(contentTexts.size() == 2) {
                cText = contentTexts.get(1).getText();
            }
        }
    }
}


