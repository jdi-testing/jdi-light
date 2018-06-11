package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@JPage(url = "/performance.html")
public class JDIPerformancePage extends WebPage {
    //Table
    @FindBy(id = "users-table") public WebElement table;

    //TODO Add Tables
    public WebElement getUser(String name, String email) {
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
    public UIList names;
    @FindBy(xpath = "//*[@id='user-names']//*[text()='%s']")
    public UIElement namesDropdown;
    @FindBy(css = "select[ui=dropdown]")
    private WebElement dropdownValue;
    @FindBy(css = "#user-names option")
    private List<WebElement> dropdown;

    public String isSelected() {
        return dropdownValue.getText();
    }

    // Textfield
    @FindBy(css = "#textarea-performance")
    public UIElement textfield;
}
