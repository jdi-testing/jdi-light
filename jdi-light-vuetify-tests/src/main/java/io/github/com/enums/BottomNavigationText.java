package io.github.com.enums;

public enum BottomNavigationText {
    RECENTS("Recents"),
    FAVORITES("Favorites"),
    NEARBY("Nearby"),
    VIDEO("Video"),
    MUSIC("Music"),
    BOOK("Book"),
    IMAGE("Image");

    private final String value;

    BottomNavigationText(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
