package selenium.seleniumPO;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.*;

public class PerformancePage {
    //Table
    @FindBy(id = "users-table") public WebElement table;

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

    // Droplist
    @FindBy(css = "select[ui=dropdown]")
    private WebElement dropdownValue;
    @FindBy(css = "#user-names option")
    private List<WebElement> dropdown;

    public void select(String name) {
        for (WebElement option : dropdown) {
            if (option.getText().equals(name)) {
                option.click();
            }
        }
    }
    public String isSelected() {
        // WebElement dropdown = getDriver().findElement(By.cssSelector("select[ui=dropdown]"));
        return new Select(((UIElement)dropdownValue).getWebElement()).getFirstSelectedOption().getText();
    }

    // Textfield
    @FindBy(css = "#textarea-performance")
    public WebElement textfield;
}
