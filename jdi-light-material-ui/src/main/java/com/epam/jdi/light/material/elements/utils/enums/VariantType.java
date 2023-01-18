package com.epam.jdi.light.material.elements.utils.enums;

public enum VariantType {
    SQUARE("square"),
    ROUNDED("rounded"),
    CIRCULAR("circular");
    String variant = "circular";

    VariantType(String variant) {
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }

    public static VariantType fromString(String variant) {
        for (VariantType v: VariantType.values()) {
            if (v.getVariant().equalsIgnoreCase(variant)) {
                return v;
            }
        }
        return CIRCULAR;
    }
}
