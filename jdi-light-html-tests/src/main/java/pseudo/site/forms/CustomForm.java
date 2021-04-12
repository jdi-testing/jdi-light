package pseudo.site.forms;

import com.epam.jdi.light.elements.complex.webList;
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
    @FindBy(css = "#fbWebElement-id") WebElement fbWebElement;
    @FindBy(css = "#fbPublicWebElement-id") public WebElement fbPublicWebElement;
    @FindBy(css = "#fbPrivateWebElement-id") private WebElement fbPrivateWebElement;
    @UI("#uiWebElement-id") WebElement uiWebElement;
    @UI("#uiPublicWebElement-id") public WebElement uiPublicWebElement;
    @Css("#cssWebElement-id") WebElement cssWebElement;
    @XPath("//*[@id='xpathPublicWebElement-id']") public WebElement xpathPublicWebElement;

    @FindBy(css = ".fbWebElementList-class") List<WebElement> fbWebElementList;
    @FindBy(css = ".fbPublicWebElementList-class") public List<WebElement> fbPublicWebElementList;
    @FindBy(css = ".fbPrivateWebElementList-class") private List<WebElement> fbPrivateWebElementList;
    @UI(".uiWebElementList-class") List<WebElement> uiWebElementList;
    @UI(".uiPublicWebElementList-class") public List<WebElement> uiPublicWebElementList;
    @Css(".cssWebElementList-class") List<WebElement> cssWebElementList;
    @XPath("//*[@class='xpathPublicWebElementList-class']") public List<WebElement> xpathPublicWebElementList;

    @FindBy(css = "#fbUIElement-id")
    com.epam.jdi.light.elements.common.uiElement fbUIElement;
    @FindBy(css = "#fbPublicUIElement-id") public com.epam.jdi.light.elements.common.uiElement fbPublicUIElement;
    @FindBy(css = "#fbPrivateUIElement-id") private com.epam.jdi.light.elements.common.uiElement fbPrivateUIElement;
    @UI("#uiUIElement-id")
    com.epam.jdi.light.elements.common.uiElement uiUIElement;
    @UI("#uiPublicUIElement-id") public com.epam.jdi.light.elements.common.uiElement uiPublicUIElement;
    @Css("#cssUIElement-id")
    com.epam.jdi.light.elements.common.uiElement cssUIElement;
    @XPath("//*[@id='xpathPublicUIElement-id']") public WebElement xpathPublicUIElement;

    @FindBy(css = ".fbUIElementList-class") List<com.epam.jdi.light.elements.common.uiElement> fbUIElementList;
    @FindBy(css = ".fbPublicUIElementList-class") public List<com.epam.jdi.light.elements.common.uiElement> fbPublicUIElementList;
    @FindBy(css = ".fbPrivateUIElementList-class") private List<com.epam.jdi.light.elements.common.uiElement> fbPrivateUIElementList;
    @UI(".uiUIElementList-class") List<com.epam.jdi.light.elements.common.uiElement> uiUIElementList;
    @UI(".uiPublicUIElementList-class") public List<com.epam.jdi.light.elements.common.uiElement> uiPublicUIElementList;
    @Css(".cssUIElementList-class") List<com.epam.jdi.light.elements.common.uiElement> cssUIElementList;
    @XPath("//*[@class='xpathPublicUIElementList-class']") public List<com.epam.jdi.light.elements.common.uiElement> xpathPublicUIElementList;

    @FindBy(css = "#fbButton-id") Button fbButton;
    @FindBy(css = "#fbPublicButton-id") public Button fbPublicButton;
    @FindBy(css = "#fbPrivateButton-id") private Button fbPrivateButton;
    @UI("#uiButton-id") Button uiButton;
    @UI("#uiPublicButton-id") public Button uiPublicButton;
    @Css("#cssButton-id") Button cssButton;
    @XPath("//*[@id='xpathPublicButton-id']") public Button xpathPublicButton;

    @FindBy(css = ".fbButtonList-class") List<Button> fbButtonList;
    @FindBy(css = ".fbPublicButtonList-class") public List<Button> fbPublicButtonList;
    @FindBy(css = ".fbPrivateButtonList-class") private List<Button> fbPrivateButtonList;
    @UI(".uiButtonList-class") List<Button> uiButtonList;
    @UI(".uiPublicButtonList-class") public List<Button> uiPublicButtonList;
    @Css(".cssButtonList-class") List<Button> cssButtonList;
    @XPath("//*[@class='xpathPublicButtonList-class']") public List<Button> xpathPublicButtonList;

    @FindBy(css = ".fbWebList-class")
    webList fbWebList;
    @FindBy(css = ".fbPublicWebList-class") public webList fbPublicWebList;
    @FindBy(css = ".fbPrivateWebList-class") private webList fbPrivateWebList;
    @UI(".uiWebList-class")
    webList uiWebList;
    @UI(".uiPublicWebList-class") public webList uiPublicWebList;
    @Css("#cssWebList-id")
    webList cssWebList;
    @XPath("//*[@id='xpathPublicWebList-id']") public webList xpathPublicWebList;

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

    public com.epam.jdi.light.elements.common.uiElement getFbUIElement() {
        return fbUIElement;
    }

    public com.epam.jdi.light.elements.common.uiElement getFbPublicUIElement() {
        return fbPublicUIElement;
    }

    public com.epam.jdi.light.elements.common.uiElement getFbPrivateUIElement() {
        return fbPrivateUIElement;
    }

    public com.epam.jdi.light.elements.common.uiElement getUiUIElement() {
        return uiUIElement;
    }

    public com.epam.jdi.light.elements.common.uiElement getUiPublicUIElement() {
        return uiPublicUIElement;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getFbUIElementList() {
        return fbUIElementList;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getFbPublicUIElementList() {
        return fbPublicUIElementList;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getFbPrivateUIElementList() {
        return fbPrivateUIElementList;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getUiUIElementList() {
        return uiUIElementList;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getUiPublicUIElementList() {
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

    public webList getFbWebList() {
        return fbWebList;
    }

    public webList getFbPublicWebList() {
        return fbPublicWebList;
    }

    public webList getFbPrivateWebList() {
        return fbPrivateWebList;
    }

    public webList getUiWebList() {
        return uiWebList;
    }

    public webList getUiPublicWebList() {
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

    public com.epam.jdi.light.elements.common.uiElement getCssUIElement() {
        return cssUIElement;
    }

    public WebElement getXpathPublicUIElement() {
        return xpathPublicUIElement;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getCssUIElementList() {
        return cssUIElementList;
    }

    public List<com.epam.jdi.light.elements.common.uiElement> getXpathPublicUIElementList() {
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

    public webList getCssWebList() {
        return cssWebList;
    }

    public webList getXpathPublicWebList() {
        return xpathPublicWebList;
    }
}
