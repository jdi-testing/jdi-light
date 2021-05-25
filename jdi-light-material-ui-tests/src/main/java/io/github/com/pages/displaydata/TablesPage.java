package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.sections.tables.PersonTable;

import java.util.List;
import java.util.Map;

public class TablesPage extends WebPage {

    @UI("//h2[contains(., 'Data table')]")
    public PersonTable personsTable;

    public Map<String, Object> getFormsFields(int i, List<String> forms) {
//        return personsTable.table.getFormFields(forms);
        return null;
    }
}
