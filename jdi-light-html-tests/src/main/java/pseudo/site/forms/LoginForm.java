package pseudo.site.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.WebElement;
import pseudo.site.entities.User;

import java.util.List;

public class LoginForm extends Form<User> {
    @FindBy(css = "#some-id")
    public static WebElement publicStaticFindByWebElement;
    @UI("#user-password")
    public TextField userPassword;
    @UI("#login-button")
    public Button loginButton;
    //endregion
    @FindBy(css = ".some-list-class")
    public static List<WebElement> publicStaticFindByWebElementList;
    @FindBy(css = ".some-class")
    public static UIElement publicStaticFindByUIElement;
    @FindBy(css = "#some-id")
    static WebElement staticFindByWebElement;
    @FindBy(css = ".some-list-class")
    static List<WebElement> staticFindByWebElementList;
    @FindBy(css = ".some-class")
    static UIElement staticFindByUIElement;
    @FindBy(css = "#some-id")
    private static WebElement privateStaticFindByWebElement;
    @FindBy(css = ".some-list-class")
    private static List<WebElement> privateStaticFindByWebElementList;
    @FindBy(css = ".some-class")
    private static UIElement privateStaticFindByUIElement;
    //region Realistic pseudo elements
    @UI("#user-name")
    public TextField userName;
    @FindBy(css = "#some-id")
    public WebElement publicFindByWebElement;
    @UI("#some-id")
    public WebElement publicUiWebElement;
    @FindBy(css = ".some-list-class")
    public List<WebElement> publicFindByWebElementList;
    @UI(".some-list-class")
    public List<WebElement> publicUiWebElementList;
    @FindBy(css = ".some-class")
    public UIElement publicFindByUIElement;
    @UI(".some-class")
    public UIElement publicUiUIElement;
    //region Pseudo elements
    @FindBy(css = "#some-id")
    WebElement findByWebElement;
    @UI("#some-id")
    WebElement uiWebElement;
    @FindBy(css = ".some-list-class")
    List<WebElement> findByWebElementList;
    @UI(".some-list-class")
    List<WebElement> uiWebElementList;
    @FindBy(css = ".some-class")
    UIElement findByUIElement;
    @UI(".some-class")
    UIElement uIElement;
    @FindBy(css = "#some-id")
    private WebElement privateFindByWebElement;
    @FindBy(css = ".some-list-class")
    private List<WebElement> privateFindByWebElementList;
    @FindBy(css = ".some-class")
    private UIElement privateFindByUIElement;
    //endregion

    public WebElement getFindByWebElement() {
        return this.findByWebElement;
    }

    public List<WebElement> getFindByWebElementList() {
        return this.findByWebElementList;
    }

    public UIElement getFindByUIElement() {
        return this.findByUIElement;
    }
}
