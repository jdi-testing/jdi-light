package io.github.com.entities;

import com.epam.jdi.tools.DataClass;

public class SimpleContact extends DataClass<SimpleContact> {
    private String name; //NOPMD
    private String email; //NOPMD
    private String phone; //NOPMD

    public SimpleContact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
