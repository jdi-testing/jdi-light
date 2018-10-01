package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.WebElement;

public class HomePageFrame {
	@Css("img#user-icon") public Icon userIcon;
}