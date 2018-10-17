package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Url("/performance.html")
public class JDIPerformancePage extends WebPage {
    //Table
    @Css("#users-table") public static WebElement table;

    public static WebElement getUser(String name, String email) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() == 4 && columns.get(0).getText().contains(name) &&
                columns.get(2).getText().contains(email))
                return row;
        }
        return null;
    }

    // Dropdown
    @Css("#user-names option")
    public static WebList names;
    @XPath("//*[@id='user-names']//*[text()='%s']")


    // Textfield
    @Css("#textarea-performance")
    public static UIElement textfield;
}
