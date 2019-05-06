package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import io.github.com.sections.MainSection;
import org.openqa.selenium.WebElement;

public class BasePage extends Section {
    @UI("#passport-number")
    public static WebElement passportNumber;
}
