package io.github.com.sections;

import com.epam.jdi.light.elements.complex.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Combobox;
import io.github.com.entities.Contacts;
import org.openqa.selenium.WebElement;


public class ContactForm extends Form<Contacts> {
	@Css("select[ui=dropdown]") public Dropdown gender;
	@Css("div[ui=combobox] input") public Combobox religion;
	/*@JDropdown(root = @FindBy(css ="div[ui=droplist]"),
			value = @FindBy(css ="button"),
			list = @FindBy(css ="li"),
			expand = @FindBy(css =".caret"),
			isselected = @FindBy(xpath ="././/input")
	) public DropList wheather;*/
	@XPath(".//button[@type='submit']") public Button submit;
	@Css("input[type=checkbox]#Passport") public TextField passport;
	@Css("input[type=checkbox]#accept-conditions") public Checkbox acceptConditions;
	@Css("input[type=text]#Name") public WebElement userName;
	@Css("input[type=text]#LastName") public WebElement lastName;
	@Css("input[type=text]#Position") public WebElement position;
	@Css("input[type=text]#Number") public WebElement number;
	@Css("input[type=text]#Seria") public WebElement seria;
	@Css("textarea") public WebElement description;

}