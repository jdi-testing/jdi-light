package com.jdiai.jswraper.driver;

public enum DriverVersion {
    LATEST("latest"), PENULT("penult");

    public String value;

    DriverVersion(String value) {
        this.value = value;
    }

    public boolean equalTo(String version) {
        return version.equalsIgnoreCase(value);
    }
}
