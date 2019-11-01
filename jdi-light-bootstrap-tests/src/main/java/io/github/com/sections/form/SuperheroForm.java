package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Range;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Checkbox;
import io.github.com.entities.Superhero;

public class SuperheroForm extends Form<Superhero> {

    public TextField superheroCurrentAlias;
    public TextField superheroAlterEgo;
    //public RadioButton superheroRadioSymbiote;
    public Selector superheroSelectUniverse;
    public Range superheroRange;
    //@UI("#superhero-switch")
    //public Checkbox superheroSwitch; //input searching from top of Form
}
