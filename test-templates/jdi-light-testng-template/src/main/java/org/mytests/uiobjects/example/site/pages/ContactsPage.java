package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import org.mytests.uiobjects.example.site.custom.MultiDropdown;

@Url("/contacts.html") @Title("Contact Form")
public class ContactsPage extends WebPage {
	TextField name, lastName, position, passportNumber, passportSeria;

	DropdownSelect gender;
	MultiDropdown weather;

	Checkbox passport, acceptConditions;
	TextArea description;

	@UI("['Submit']") public Button submit;
}