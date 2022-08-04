package io.github.com.entities.form;

import com.jdiai.tools.DataClass;

public class Rules extends DataClass<Rules> {
    public String firstName;
    public String maxCharacters;
    public Boolean allowSpaces;
    public String valueMustMatch;

    public Rules(String firstName, String maxCharacters, Boolean allowSpaces, String valueMustMatch) {
        this.firstName = firstName;
        this.maxCharacters = maxCharacters;
        this.allowSpaces = allowSpaces;
        this.valueMustMatch = valueMustMatch;
    }
}
