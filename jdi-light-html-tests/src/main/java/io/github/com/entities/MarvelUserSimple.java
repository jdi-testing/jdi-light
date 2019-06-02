package io.github.com.entities;

import com.epam.jdi.tools.DataClass;

import java.util.Objects;

public class MarvelUserSimple extends DataClass<MarvelUserSimple> {
    public String number, type, user, description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarvelUserSimple that = (MarvelUserSimple) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, user);
    }
}
