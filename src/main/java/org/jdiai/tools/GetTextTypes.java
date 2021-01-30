package org.jdiai.tools;

public enum GetTextTypes {
    TEXT("textContent"), VALUE("getAttribute('value')"), INNER_HTML("innerHTML"), INNER_TEXT("innerText");

    public String value;
    GetTextTypes() { }
    GetTextTypes(String value) {
       this.value = value;
    }
}
