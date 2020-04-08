package com.epam.jdi.light.driver.get;

public enum DriverVersion {
    LATEST("LATEST"), PENULT("PENULT");
    public String value;
    DriverVersion(String value) {
        this.value = value;
    }
}
