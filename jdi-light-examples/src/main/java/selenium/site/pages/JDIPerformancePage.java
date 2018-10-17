package selenium.site.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.FastTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Url("/performance.html")
public class JDIPerformancePage extends WebPage {
    //Table
    public static FastTable usersTable;

    // Dropdown
    @Css("#user-names option")
    public WebList names;
    @FindBy(xpath = "//*[@id='user-names']//*[text()='%s']")
    public UIElement namesDropdown;
    @FindBy(css = "select[ui=dropdown]")
    private UIElement dropdownValue;
    @FindBy(css = "#user-names option")
    private List<WebElement> dropdown;

    public String isSelected() {
        return dropdownValue.select().getFirstSelectedOption().getText();
    }

    // Textfield
    @FindBy(css = "#textarea-performance")
    public UIElement textfield;
}
