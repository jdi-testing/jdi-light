package io.github.epam.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;

public class HomePageFrame extends Section {
	@Css("img#user-icon") public WebElement userIcon;
}