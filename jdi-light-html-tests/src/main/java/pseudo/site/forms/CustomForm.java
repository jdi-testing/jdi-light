package pseudo.site.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;
import pseudo.site.entities.User;

import java.util.List;

public class CustomForm extends Form<User> {
    @FindBy(css = "#fbWebElement-id")private WebElement fbWebElement;
    @FindBy(css = "#fbPublicWebElement-id") public WebElement fbPublicWebElement;
    @FindBy(css = "#fbPrivateWebElement-id") private WebElement fbPrivateWebElement;
    @UI("#uiWebElement-id")private WebElement uiWebElement;
    @UI("#uiPublicWebElement-id") public WebElement uiPublicWebElement;
    @Css("#cssWebElement-id")private WebElement cssWebElement;
    @XPath("//*[@id='xpathPublicWebElement-id']") public WebElement xpathPublicWebElement;

    @FindBy(css = ".fbWebElementList-class") public WebList fbWebElementList;
    @FindBy(css = ".fbPublicWebElementList-class") public WebList fbPublicWebElementList;
    @FindBy(css = ".fbPrivateWebElementList-class") private WebList fbPrivateWebElementList;
    @UI(".uiWebElementList-class") public WebList uiWebElementList;
    @UI(".uiPublicWebElementList-class") public WebList uiPublicWebElementList;
    @Css(".cssWebElementList-class") public WebList cssWebElementList;
    @XPath("//*[@class='xpathPublicWebElementList-class']") public WebList xpathPublicWebElementList;

    @FindBy(css = "#fbUIElement-id")private UIElement fbUIElement;
    @FindBy(css = "#fbPublicUIElement-id") public UIElement fbPublicUIElement;
    @FindBy(css = "#fbPrivateUIElement-id") private UIElement fbPrivateUIElement;
    @UI("#uiUIElement-id") private UIElement uiUIElement;
    @UI("#uiPublicUIElement-id") public UIElement uiPublicUIElement;
    @Css("#cssUIElement-id")private UIElement cssUIElement;
    @XPath("//*[@id='xpathPublicUIElement-id']") public WebElement xpathPublicUIElement;

    @FindBy(css = ".fbUIElementList-class")private List<UIElement> fbUIElementList;
    @FindBy(css = ".fbPublicUIElementList-class") public List<UIElement> fbPublicUIElementList;
    @FindBy(css = ".fbPrivateUIElementList-class") private List<UIElement> fbPrivateUIElementList;
    @UI(".uiUIElementList-class") private List<UIElement> uiUIElementList;
    @UI(".uiPublicUIElementList-class") public List<UIElement> uiPublicUIElementList;
    @Css(".cssUIElementList-class")private List<UIElement> cssUIElementList;
    @XPath("//*[@class='xpathPublicUIElementList-class']") public List<UIElement> xpathPublicUIElementList;

    @FindBy(css = "#fbButton-id")private Button fbButton;
    @FindBy(css = "#fbPublicButton-id") public Button fbPublicButton;
    @FindBy(css = "#fbPrivateButton-id") private Button fbPrivateButton;
    @UI("#uiButton-id") private Button uiButton;
    @UI("#uiPublicButton-id") public Button uiPublicButton;
    @Css("#cssButton-id") private Button cssButton;
    @XPath("//*[@id='xpathPublicButton-id']") public Button xpathPublicButton;

    @FindBy(css = ".fbButtonList-class")private List<Button> fbButtonList;
    @FindBy(css = ".fbPublicButtonList-class") public List<Button> fbPublicButtonList;
    @FindBy(css = ".fbPrivateButtonList-class") private List<Button> fbPrivateButtonList;
    @UI(".uiButtonList-class")private List<Button> uiButtonList;
    @UI(".uiPublicButtonList-class") public List<Button> uiPublicButtonList;
    @Css(".cssButtonList-class")private List<Button> cssButtonList;
    @XPath("//*[@class='xpathPublicButtonList-class']") public List<Button> xpathPublicButtonList;

    @FindBy(css = ".fbWebList-class")private WebList fbWebList;
    @FindBy(css = ".fbPublicWebList-class") public WebList fbPublicWebList;
    @FindBy(css = ".fbPrivateWebList-class") private WebList fbPrivateWebList;
    @UI(".uiWebList-class")private WebList uiWebList;
    @UI(".uiPublicWebList-class") public WebList uiPublicWebList;
    @Css("#cssWebList-id")private WebList cssWebList;
    @XPath("//*[@id='xpathPublicWebList-id']") public WebList xpathPublicWebList;

    @JDropdown(root = "div[ui=dropList]", value = "input", list = "li", expand = ".expand")
    private Dropdown dropList;
    @JDropdown(root = "div[ui=publicDropList]", value = "input", list = "li", expand = ".expand") public Dropdown publicDropList;
    @JDropdown(root = "div[ui=privateDropList]", value = "input", list = "li", expand = ".expand") private Dropdown privateDropList;

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

    public WebList getFbWebElementList() {
        return fbWebElementList;
    }

    public WebList getFbPublicWebElementList() {
        return fbPublicWebElementList;
    }

    public WebList getFbPrivateWebElementList() {
        return fbPrivateWebElementList;
    }

    public WebList getUiWebElementList() {
        return uiWebElementList;
    }

    public WebList getUiPublicWebElementList() {
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

    public Dropdown getDropList() {
        return dropList;
    }

    public Dropdown getPublicDropList() {
        return publicDropList;
    }

    public Dropdown getPrivateDropList() {
        return privateDropList;
    }

    public WebElement getCssWebElement() {
        return cssWebElement;
    }

    public WebElement getXpathPublicWebElement() {
        return xpathPublicWebElement;
    }

    public WebList getCssWebElementList() {
        return cssWebElementList;
    }

    public WebList getXpathPublicWebElementList() {
        return xpathPublicWebElementList;
    }

    public UIElement getCssUIElement() {
        return cssUIElement;
    }

    public WebElement getXpathPublicUIElement() {
        return xpathPublicUIElement;
    }

    public List<UIElement> getCssUIElementList() {
        return cssUIElementList;
    }

    public List<UIElement> getXpathPublicUIElementList() {
        return xpathPublicUIElementList;
    }

    public Button getCssButton() {
        return cssButton;
    }

    public Button getXpathPublicButton() {
        return xpathPublicButton;
    }

    public List<Button> getCssButtonList() {
        return cssButtonList;
    }

    public List<Button> getXpathPublicButtonList() {
        return xpathPublicButtonList;
    }

    public WebList getCssWebList() {
        return cssWebList;
    }

    public WebList getXpathPublicWebList() {
        return xpathPublicWebList;
    }
}
