package io.github.com.enums;

public enum Weather {
    Hot("Hot option"), Cold("Cold"), Rainy("Rainy day"), Sunny("Sunny"), Disabled("Disabled");

    public String value;
    Weather(String value) { this.value = value; }
}