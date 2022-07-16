package com.epam.jdi.light.material.elements.utils.enums;

public enum VariantType {
    SQUARE("square"),
    ROUNDED("rounded"),
    CIRCULAR("circular");

    VariantType(String variant) {
        this.variant = variant;
    }
    String variant = "circular";

    public String getVariant() {
        return variant;
    }

    public static VariantType fromString(String variant) {
        for (VariantType v: VariantType.values()) {
            if (v.getVariant().equalsIgnoreCase(variant)) {
                return v;
            }
        }
        return SQUARE;
    }
}
