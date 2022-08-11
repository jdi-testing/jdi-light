package io.github.com.entities.form;

import com.jdiai.tools.DataClass;

public class ValidationWithSubmitClear extends DataClass<ValidationWithSubmitClear> {
    public String name;
    public String email;
    public String item;
    public boolean confirmingCheckBox;
    public String validateButton;
    public String resetFormButton;
    public String resetValidationButton;

    public ValidationWithSubmitClear(String name, String email, String item, boolean confirmingCheckBox) {
        this.name = name;
        this.email = email;
        this.item = item;
        this.confirmingCheckBox = confirmingCheckBox;
    }
}
