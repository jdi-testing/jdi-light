package io.github.epam.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import org.openqa.selenium.WebElement;

public class NavigationSidebar extends Section {
	@XPath(".//*[@ui='label' and contains(.,'Home')]") public WebElement home;
	@XPath(".//*[@ui='label' and contains(.,'Contact form')]") public WebElement contactForm;
	@XPath(".//*[@ui='label' and contains(.,'Support')]") public WebElement support;
	@XPath(".//*[@ui='label' and contains(.,'Dates')]") public WebElement dates;
	@XPath(".//*[@ui='label' and contains(.,'Complex Table')]") public WebElement complexTable;
	@XPath(".//*[@ui='label' and contains(.,'Simple Table')]") public WebElement simpleTable;
	@XPath(".//*[@ui='label' and contains(.,'User Table')]") public WebElement userTable;
	@XPath(".//*[@ui='label' and contains(.,'Table with pages')]") public WebElement tableWithPages;
	@XPath(".//*[@ui='label' and contains(.,'Different elements')]") public WebElement differentElements;
	@XPath(".//*[@ui='label' and contains(.,'Metals & Colors')]") public WebElement metalsColors;

}