package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Image;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AvatarPage extends WebPage {
    @UI("//span[@class='MuiBadge-root']/span")
    public static List<Image> onlineStatus;
    @UI("//span[@class='MuiBadge-root']/following-sibling::div")
    public static List<UIElement> avatarWithoutPhoto;
    @UI("//span[@class='MuiBadge-root']/div")
    public static List<UIElement> avatarWithPhoto;
}
