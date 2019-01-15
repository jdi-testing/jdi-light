package io.github.com.custom;

import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuItem extends HtmlElement {
    @Override
    public boolean isSelected() {
        return find("<<").hasClass("active");
    }
}
