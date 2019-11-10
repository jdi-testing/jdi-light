package jdisite.entities;

import java.util.Objects;

import static java.lang.String.format;

public class ContactInfo {
    public String name, lastName, position, gender, religion, weather, description;
    public int passportNumber, passportSeria;
    public boolean passport, acceptConditions;
    public ContactInfo() {}
    public ContactInfo(String name, String lastName, String position, String gender,
           String religion, String weather, String description, int passportNumber,
           int passportSeria, boolean passport, boolean acceptConditions) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.gender = gender;
        this.religion = religion;
        this.weather = weather;
        this.description = description;
        this.passportNumber = passportNumber;
        this.passportSeria = passportSeria;
        this.passport = passport;
        this.acceptConditions = acceptConditions;
    }
    public ContactInfo setName(String name) {
        this.name = name;
        return this;
    }
    public ContactInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public ContactInfo setPosition(String position) {
        this.position = position;
        return this;
    }
    public ContactInfo setGender(String gender) {
        this.gender = gender;
        return this;
    }
    public ContactInfo setReligion(String religion) {
        this.religion = religion;
        return this;
    }
    public ContactInfo setWeather(String weather) {
        this.weather = weather;
        return this;
    }
    public ContactInfo setDescription(String description) {
        this.description = description;
        return this;
    }
    public ContactInfo setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }
    public ContactInfo setPassportSeria(int passportSeria) {
        this.passportSeria = passportSeria;
        return this;
    }
    public ContactInfo setPassport(boolean passport) {
        this.passport = passport;
        return this;
    }
    public ContactInfo setAcceptConditions(boolean acceptConditions) {
        this.acceptConditions = acceptConditions;
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return passportNumber == that.passportNumber &&
                passportSeria == that.passportSeria &&
                passport == that.passport &&
                acceptConditions == that.acceptConditions &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(position, that.position) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(religion, that.religion) &&
                Objects.equals(weather, that.weather) &&
                Objects.equals(description, that.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, position, gender, religion, weather,
                description, passportNumber, passportSeria, passport, acceptConditions);
    }
    @Override
    public String toString() {
        return format("ContactInfo{name='%s'; lastName='%s'; position='%s'; " +
                "gender='%s'; religion='%s'; weather='%s'; description='%s'; " +
                "passportNumber='%s'; passportSeria='%s'; passport='%s'; acceptConditions='%s'; }",
                name, lastName, position, gender, religion, weather, description,
                passportNumber, passportSeria, passport, acceptConditions);
    }
}
