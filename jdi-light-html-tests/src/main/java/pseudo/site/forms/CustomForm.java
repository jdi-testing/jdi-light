package pseudo.site.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindByUI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;
import pseudo.site.entities.User;

import java.util.List;

public class CustomForm extends Form<User> {
    @FindByUI(css = "#fbWebElement-id") WebElement fbWebElement;
    @FindByUI(css = "#fbPublicWebElement-id") public WebElement fbPublicWebElement;
    @FindByUI(css = "#fbPrivateWebElement-id") private WebElement fbPrivateWebElement;
    @UI("#uiWebElement-id") WebElement uiWebElement;
    @UI("#uiPublicWebElement-id") public WebElement uiPublicWebElement;
    @Css("#cssWebElement-id") WebElement cssWebElement;
    @XPath("//*[@id='xpathPublicWebElement-id']") public WebElement xpathPublicWebElement;

    @FindByUI(css = ".fbWebElementList-class") List<WebElement> fbWebElementList;
    @FindByUI(css = ".fbPublicWebElementList-class") public List<WebElement> fbPublicWebElementList;
    @FindByUI(css = ".fbPrivateWebElementList-class") private List<WebElement> fbPrivateWebElementList;
    @UI(".uiWebElementList-class") List<WebElement> uiWebElementList;
    @UI(".uiPublicWebElementList-class") public List<WebElement> uiPublicWebElementList;
    @Css(".cssWebElementList-class") List<WebElement> cssWebElementList;
    @XPath("//*[@class='xpathPublicWebElementList-class']") public List<WebElement> xpathPublicWebElementList;

    @FindByUI(css = "#fbUIElement-id") UIElement fbUIElement;
    @FindByUI(css = "#fbPublicUIElement-id") public UIElement fbPublicUIElement;
    @FindByUI(css = "#fbPrivateUIElement-id") private UIElement fbPrivateUIElement;
    @UI("#uiUIElement-id") UIElement uiUIElement;
    @UI("#uiPublicUIElement-id") public UIElement uiPublicUIElement;
    @Css("#cssUIElement-id") UIElement cssUIElement;
    @XPath("//*[@id='xpathPublicUIElement-id']") public WebElement xpathPublicUIElement;

    @FindByUI(css = ".fbUIElementList-class") List<UIElement> fbUIElementList;
    @FindByUI(css = ".fbPublicUIElementList-class") public List<UIElement> fbPublicUIElementList;
    @FindByUI(css = ".fbPrivateUIElementList-class") private List<UIElement> fbPrivateUIElementList;
    @UI(".uiUIElementList-class") List<UIElement> uiUIElementList;
    @UI(".uiPublicUIElementList-class") public List<UIElement> uiPublicUIElementList;
    @Css(".cssUIElementList-class") List<UIElement> cssUIElementList;
    @XPath("//*[@class='xpathPublicUIElementList-class']") public List<UIElement> xpathPublicUIElementList;

    @FindByUI(css = "#fbButton-id") Button fbButton;
    @FindByUI(css = "#fbPublicButton-id") public Button fbPublicButton;
    @FindByUI(css = "#fbPrivateButton-id") private Button fbPrivateButton;
    @UI("#uiButton-id") Button uiButton;
    @UI("#uiPublicButton-id") public Button uiPublicButton;
    @Css("#cssButton-id") Button cssButton;
    @XPath("//*[@id='xpathPublicButton-id']") public Button xpathPublicButton;

    @FindByUI(css = ".fbButtonList-class") List<Button> fbButtonList;
    @FindByUI(css = ".fbPublicButtonList-class") public List<Button> fbPublicButtonList;
    @FindByUI(css = ".fbPrivateButtonList-class") private List<Button> fbPrivateButtonList;
    @UI(".uiButtonList-class") List<Button> uiButtonList;
    @UI(".uiPublicButtonList-class") public List<Button> uiPublicButtonList;
    @Css(".cssButtonList-class") List<Button> cssButtonList;
    @XPath("//*[@class='xpathPublicButtonList-class']") public List<Button> xpathPublicButtonList;

    @FindByUI(css = ".fbWebList-class") WebList fbWebList;
    @FindByUI(css = ".fbPublicWebList-class") public WebList fbPublicWebList;
    @FindByUI(css = ".fbPrivateWebList-class") private WebList fbPrivateWebList;
    @UI(".uiWebList-class") WebList uiWebList;
    @UI(".uiPublicWebList-class") public WebList uiPublicWebList;
    @Css("#cssWebList-id") WebList cssWebList;
    @XPath("//*[@id='xpathPublicWebList-id']") public WebList xpathPublicWebList;

    @JDropdown(root = "div[ui=dropList]", value = "input", list = "li", expand = ".expand")
    Dropdown dropList;
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

    public List<WebElement> getCssWebElementList() {
        return cssWebElementList;
    }

    public List<WebElement> getXpathPublicWebElementList() {
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
