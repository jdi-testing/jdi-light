package jdisite.entities;

import java.util.Objects;

import static java.lang.String.format;

public class User {
    public String name, password;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User setName(String name) {
        this.name = name;
        return this;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
    @Override
    public String toString() {
        return format("User{name='%s'; password='%s'}",name, password);
    }
}
