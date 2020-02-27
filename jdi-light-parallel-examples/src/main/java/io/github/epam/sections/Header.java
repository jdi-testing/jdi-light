package io.github.epam.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import org.openqa.selenium.WebElement;

public class Header extends Section {
    @Css("form")
    public LoginForm loginForm;

    @Css(".fa-sign-out")
    public WebElement logout;

    @Css("img#epam_logo")
    public WebElement epamLogo;

    @Css("img#user-icon")
    public WebElement userIcon;

    @XPath(".//*[@ui='label']")
    public WebElement userName;

    @Css("input[type=text]")
    public WebElement textField437465;

}