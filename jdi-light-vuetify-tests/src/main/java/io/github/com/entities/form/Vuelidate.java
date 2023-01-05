package io.github.com.entities.form;

import com.jdiai.tools.DataClass;

public class Vuelidate extends DataClass<Vuelidate> {
    public String name;
    public String email;
    public String item;
    public boolean confirmingCheckBox;

    public Vuelidate(String name, String email, String item, boolean confirmingCheckBox) {
        this.name = name;
        this.email = email;
        this.item = item;
        this.confirmingCheckBox = confirmingCheckBox;
    }
}
