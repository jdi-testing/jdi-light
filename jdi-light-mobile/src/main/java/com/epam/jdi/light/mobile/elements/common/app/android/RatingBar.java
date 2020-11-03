package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.mobile.asserts.RatingBarAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;

public class RatingBar extends MobileAppBaseElement implements HasTouchActions {

    public double getRating(){
        return Double.parseDouble(core().getText());
    }

    public void setRatingByClick(double value, double fullStars){
        if (value > fullStars || value < 1.0) {
            throw new IllegalArgumentException("New value should be in the range [1.0, " + fullStars + "].");
        }
        Rectangle position = core().getRect();
        int stepLength = (int) (position.width / fullStars);
        int offset = (int) (stepLength * (value - 1));
        int newRatingPositionX = position.x + offset + (int) (stepLength * 0.6);
        int newRatingPositionY = position.y + position.height / 2;
        TouchAction touchAction = new TouchAction((PerformsTouchActions) core().driver());
        touchAction.tap(PointOption.point(newRatingPositionX, newRatingPositionY)).perform();
    }

    public void setRating(double value){
        core().setValue(String.valueOf(value));
    }


    public RatingBarAssert is(){
        return new RatingBarAssert().set(this);
    }
}
