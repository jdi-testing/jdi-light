package io.github.com.entities.textareas;

import com.jdiai.tools.DataClass;

import java.util.List;

public class SignUpData extends DataClass<SignUpData> {

    protected final String password;
    protected final String phone;
    protected final String email;
    protected final List<String> bio;
    protected final boolean agree;

    public SignUpData(String password, String phone, String email, List<String> bio, boolean agree) {
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.bio = bio;
        this.agree = agree;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getBio() {
        return bio;
    }

    public boolean isAgree() {
        return agree;
    }
}
