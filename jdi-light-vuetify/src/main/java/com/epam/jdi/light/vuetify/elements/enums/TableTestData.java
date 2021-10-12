package com.epam.jdi.light.vuetify.elements.enums;

public enum TableTestData {
    FROZEN_YOGURT("Frozen Yogurt"),
    FROZEN_YOGURT_CALORIES("159"),
    ICE_CREAM_SANDWICH("Ice cream sandwich"),
    ICE_CREAM_SANDWICH_CALORIES("237"),
    ECLAIR("Eclair"),
    ECLAIR_CALORIES("262"),
    CUPCAKE("Cupcake"),
    CUPCAKE_CALORIES("305"),
    GINGERBREAD("Gingerbread"),
    GINGERBREAD_CALORIES("356"),
    JELLY_BEAN("Jelly bean"),
    JELLY_BEAN_CALORIES("375"),
    LOLLIPOP("Lollipop"),
    LOLLIPOP_CALORIES("392"),
    HONEYCOMB("Honeycomb"),
    HONEYCOMB_CALORIES("408"),
    DONUT("Donut"),
    DONUT_CALORIES("452"),
    KITKAT("KitKat"),
    KITKAT_CALORIES("518");


    private final String value;

    TableTestData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String value() {
        return toString();
    }
}
