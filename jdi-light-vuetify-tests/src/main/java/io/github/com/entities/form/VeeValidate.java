package io.github.com.entities.form;

import com.jdiai.tools.DataClass;

public class VeeValidate extends DataClass<VeeValidate> {
    public String name;
    public String phoneNumber;
    public String email;
    public String item;
    public boolean confirmingCheckBox;
    public String submitButton;
    public String clearButton;

    public VeeValidate(String name, String phoneNumber, String email, String item, boolean optionCheckBox) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.item = item;
        this.confirmingCheckBox = optionCheckBox;
    }
}
