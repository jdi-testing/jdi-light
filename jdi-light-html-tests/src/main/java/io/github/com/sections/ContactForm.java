package io.github.com.sections;

import com.epam.jdi.light.elements.complex.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import io.github.com.entities.Contacts;
import org.openqa.selenium.WebElement;


public class ContactForm extends Form<Contacts> {
	@Css("select[ui=dropdown]") public Dropdown gender;
	@Css("div[ui=combobox] input") public Combobox religion;
	@Css("div[ui=droplist]") public MultiSelect wheather;
	@XPath(".//button[@type='submit']") public Button submit;
	@Css("#Passport") public TextField passport;
	@Css("#accept-conditions") public Checkbox acceptConditions;
	@Css("#Name") public TextField userName;
	@Css("#LastName") public TextField lastName;
	@Css("#Position") public TextField position;
	@Css("#Number") public TextField number;
	@Css("#Seria") public TextField seria;
	@Css("textarea") public TextArea description;

}