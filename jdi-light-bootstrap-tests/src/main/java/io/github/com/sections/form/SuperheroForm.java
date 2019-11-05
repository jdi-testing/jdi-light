package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Range;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.complex.RadioButtons;
import io.github.com.entities.Superhero;

public class SuperheroForm extends Form<Superhero> {

    public TextField currentAlias;
    public TextField alterEgo;

    @UI("[name=superheroSpecies]")
    public RadioButtons species;

    public Selector selectUniverse;
    public Range superheroRange;

    @UI("#superhero-switch-div")
    public Checkbox superheroSwitch;

    @Override
    public void cancel(Superhero entity) {
        submit(entity, "clear");
    }
}
