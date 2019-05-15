package pseudo.site.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import org.openqa.selenium.WebElement;
import pseudo.site.entities.User;

import java.util.List;

public class SomeForm extends Form<User> {
    @FindBy(css = "#fbWebElement-id") WebElement fbWebElement;
    @FindBy(css = "#fbPublicWebElement-id") public WebElement fbPublicWebElement;
    @FindBy(css = "#fbPrivateWebElement-id") private WebElement fbPrivateWebElement;
    @FindBy(css = "#fbStaticWebElement-id") static WebElement fbStaticWebElement;
    @FindBy(css = "#fbPublicStaticWebElement-id") public static WebElement fbPublicStaticWebElement;
    @FindBy(css = "#fbPrivateStaticWebElement-id") private static WebElement fbPrivateStaticWebElement;
    @UI("#uiWebElement-id") WebElement uiWebElement;
    @UI("#uiPublicWebElement-id") public WebElement uiPublicWebElement;

    @FindBy(css = ".fbWebElementList-class") List<WebElement> fbWebElementList;
    @FindBy(css = ".fbPublicWebElementList-class") public List<WebElement> fbPublicWebElementList;
    @FindBy(css = ".fbPrivateWebElementList-class") private List<WebElement> fbPrivateWebElementList;
    @FindBy(css = ".fbStaticWebElementList-class") static List<WebElement> fbStaticWebElementList;
    @FindBy(css = ".fbPublicStaticWebElementList-class") public static List<WebElement> fbPublicStaticWebElementList;
    @FindBy(css = ".fbPrivateStaticWebElementList-class") private static List<WebElement> fbPrivateStaticWebElementList;
    @UI(".uiWebElementList-class") List<WebElement> uiWebElementList;
    @UI(".uiPublicWebElementList-class") public List<WebElement> uiPublicWebElementList;

    @FindBy(css = "#fbUIElement-id") UIElement fbUIElement;
    @FindBy(css = "#fbPublicUIElement-id") public UIElement fbPublicUIElement;
    @FindBy(css = "#fbPrivateUIElement-id") private UIElement fbPrivateUIElement;
    @FindBy(css = "#fbStaticUIElement-id") static UIElement fbStaticUIElement;
    @FindBy(css = "#fbPublicStaticUIElement-id") public static UIElement fbPublicStaticUIElement;
    @FindBy(css = "#fbPrivateStaticUIElement-id") private static UIElement fbPrivateStaticUIElement;
    @UI("#uiUIElement-id") UIElement uiUIElement;
    @UI("#uiPublicUIElement-id") public UIElement uiPublicUIElement;

    @FindBy(css = ".fbUIElementList-class") List<UIElement> fbUIElementList;
    @FindBy(css = ".fbPublicUIElementList-class") public List<UIElement> fbPublicUIElementList;
    @FindBy(css = ".fbPrivateUIElementList-class") private List<UIElement> fbPrivateUIElementList;
    @FindBy(css = ".fbStaticUIElementList-class") static List<UIElement> fbStaticUIElementList;
    @FindBy(css = ".fbPublicStaticUIElementList-class") public static List<UIElement> fbPublicStaticUIElementList;
    @FindBy(css = ".fbPrivateStaticUIElementList-class") private static List<UIElement> fbPrivateStaticUIElementList;
    @UI(".uiUIElementList-class") List<UIElement> uiUIElementList;
    @UI(".uiPublicUIElementList-class") public List<UIElement> uiPublicUIElementList;

    @FindBy(css = "#fbButton-id") Button fbButton;
    @FindBy(css = "#fbPublicButton-id") public Button fbPublicButton;
    @FindBy(css = "#fbPrivateButton-id") private Button fbPrivateButton;
    @FindBy(css = "#fbStaticButton-id") static Button fbStaticButton;
    @FindBy(css = "#fbPublicStaticButton-id") public static Button fbPublicStaticButton;
    @FindBy(css = "#fbPrivateStaticButton-id") private static Button fbPrivateStaticButton;
    @UI("#uiButton-id") Button uiButton;
    @UI("#uiPublicButton-id") public Button uiPublicButton;

    @FindBy(css = ".fbButtonList-class") List<Button> fbButtonList;
    @FindBy(css = ".fbPublicButtonList-class") public List<Button> fbPublicButtonList;
    @FindBy(css = ".fbPrivateButtonList-class") private List<Button> fbPrivateButtonList;
    @FindBy(css = ".fbStaticButtonList-class") static List<Button> fbStaticButtonList;
    @FindBy(css = ".fbPublicStaticButtonList-class") public static List<Button> fbPublicStaticButtonList;
    @FindBy(css = ".fbPrivateStaticButtonList-class") private static List<Button> fbPrivateStaticButtonList;
    @UI(".uiButtonList-class") List<Button> uiButtonList;
    @UI(".uiPublicButtonList-class") public List<Button> uiPublicButtonList;

    @FindBy(css = ".fbWebList-class") WebList fbWebList;
    @FindBy(css = ".fbPublicWebList-class") public WebList fbPublicWebList;
    @FindBy(css = ".fbPrivateWebList-class") private WebList fbPrivateWebList;
    @FindBy(css = ".fbStaticWebList-class") static WebList fbStaticWebList;
    @FindBy(css = ".fbPublicStaticWebList-class") public static WebList fbPublicStaticWebList;
    @FindBy(css = ".fbPrivateStaticWebList-class") private static WebList fbPrivateStaticWebList;
    @UI(".uiWebList-class") WebList uiWebList;
    @UI(".uiPublicWebList-class") public WebList uiPublicWebList;

    @JDropdown(root = "div[ui=dropList]", value = "input", list = "li", expand = ".expand") Droplist dropList;
    @JDropdown(root = "div[ui=publicDropList]", value = "input", list = "li", expand = ".expand") public Droplist publicDropList;
    @JDropdown(root = "div[ui=privateDropList]", value = "input", list = "li", expand = ".expand") private Droplist privateDropList;
    @JDropdown(root = "div[ui=staticDropList]", value = "input", list = "li", expand = ".expand") static Droplist staticDropList;
    @JDropdown(root = "div[ui=publicStaticDropList]", value = "input", list = "li", expand = ".expand") public static Droplist publicStaticDropList;
    @JDropdown(root = "div[ui=privateStaticDropList]", value = "input", list = "li", expand = ".expand") private static Droplist privateStaticDropList;

    public static WebElement getFbStaticWebElement() {
        return fbStaticWebElement;
    }

    public static WebElement getFbPublicStaticWebElement() {
        return fbPublicStaticWebElement;
    }

    public static WebElement getFbPrivateStaticWebElement() {
        return fbPrivateStaticWebElement;
    }

    public static List<WebElement> getFbStaticWebElementList() {
        return fbStaticWebElementList;
    }

    public static List<WebElement> getFbPublicStaticWebElementList() {
        return fbPublicStaticWebElementList;
    }

    public static List<WebElement> getFbPrivateStaticWebElementList() {
        return fbPrivateStaticWebElementList;
    }

    public static UIElement getFbStaticUIElement() {
        return fbStaticUIElement;
    }

    public static UIElement getFbPublicStaticUIElement() {
        return fbPublicStaticUIElement;
    }

    public static UIElement getFbPrivateStaticUIElement() {
        return fbPrivateStaticUIElement;
    }

    public static List<UIElement> getFbStaticUIElementList() {
        return fbStaticUIElementList;
    }

    public static List<UIElement> getFbPublicStaticUIElementList() {
        return fbPublicStaticUIElementList;
    }

    public static List<UIElement> getFbPrivateStaticUIElementList() {
        return fbPrivateStaticUIElementList;
    }

    public static Button getFbStaticButton() {
        return fbStaticButton;
    }

    public static Button getFbPublicStaticButton() {
        return fbPublicStaticButton;
    }

    public static Button getFbPrivateStaticButton() {
        return fbPrivateStaticButton;
    }

    public static List<Button> getFbStaticButtonList() {
        return fbStaticButtonList;
    }

    public static List<Button> getFbPublicStaticButtonList() {
        return fbPublicStaticButtonList;
    }

    public static List<Button> getFbPrivateStaticButtonList() {
        return fbPrivateStaticButtonList;
    }

    public static WebList getFbStaticWebList() {
        return fbStaticWebList;
    }

    public static WebList getFbPublicStaticWebList() {
        return fbPublicStaticWebList;
    }

    public static WebList getFbPrivateStaticWebList() {
        return fbPrivateStaticWebList;
    }

    public static Droplist getStaticDropList() {
        return staticDropList;
    }

    public static Droplist getPublicStaticDropList() {
        return publicStaticDropList;
    }

    public static Droplist getPrivateStaticDropList() {
        return privateStaticDropList;
    }

    public WebElement getFbWebElement() {
        return fbWebElement;
    }

    public WebElement getFbPublicWebElement() {
        return fbPublicWebElement;
    }

    public WebElement getFbPrivateWebElement() {
        return fbPrivateWebElement;
    }

    public WebElement getUiWebElement() {
        return uiWebElement;
    }

    public WebElement getUiPublicWebElement() {
        return uiPublicWebElement;
    }

    public List<WebElement> getFbWebElementList() {
        return fbWebElementList;
    }

    public List<WebElement> getFbPublicWebElementList() {
        return fbPublicWebElementList;
    }

    public List<WebElement> getFbPrivateWebElementList() {
        return fbPrivateWebElementList;
    }

    public List<WebElement> getUiWebElementList() {
        return uiWebElementList;
    }

    public List<WebElement> getUiPublicWebElementList() {
        return uiPublicWebElementList;
    }

    public UIElement getFbUIElement() {
        return fbUIElement;
    }

    public UIElement getFbPublicUIElement() {
        return fbPublicUIElement;
    }

    public UIElement getFbPrivateUIElement() {
        return fbPrivateUIElement;
    }

    public UIElement getUiUIElement() {
        return uiUIElement;
    }

    public UIElement getUiPublicUIElement() {
        return uiPublicUIElement;
    }

    public List<UIElement> getFbUIElementList() {
        return fbUIElementList;
    }

    public List<UIElement> getFbPublicUIElementList() {
        return fbPublicUIElementList;
    }

    public List<UIElement> getFbPrivateUIElementList() {
        return fbPrivateUIElementList;
    }

    public List<UIElement> getUiUIElementList() {
        return uiUIElementList;
    }

    public List<UIElement> getUiPublicUIElementList() {
        return uiPublicUIElementList;
    }

    public Button getFbButton() {
        return fbButton;
    }

    public Button getFbPublicButton() {
        return fbPublicButton;
    }

    public Button getFbPrivateButton() {
        return fbPrivateButton;
    }

    public Button getUiButton() {
        return uiButton;
    }

    public Button getUiPublicButton() {
        return uiPublicButton;
    }

    public List<Button> getFbButtonList() {
        return fbButtonList;
    }

    public List<Button> getFbPublicButtonList() {
        return fbPublicButtonList;
    }

    public List<Button> getFbPrivateButtonList() {
        return fbPrivateButtonList;
    }

    public List<Button> getUiButtonList() {
        return uiButtonList;
    }

    public List<Button> getUiPublicButtonList() {
        return uiPublicButtonList;
    }

    public WebList getFbWebList() {
        return fbWebList;
    }

    public WebList getFbPublicWebList() {
        return fbPublicWebList;
    }

    public WebList getFbPrivateWebList() {
        return fbPrivateWebList;
    }

    public WebList getUiWebList() {
        return uiWebList;
    }

    public WebList getUiPublicWebList() {
        return uiPublicWebList;
    }

    public Droplist getDropList() {
        return dropList;
    }

    public Droplist getPublicDropList() {
        return publicDropList;
    }

    public Droplist getPrivateDropList() {
        return privateDropList;
    }
}
