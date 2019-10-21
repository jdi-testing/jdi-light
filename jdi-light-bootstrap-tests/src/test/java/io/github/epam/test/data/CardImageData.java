package io.github.epam.test.data;

public class CardImageData {
    private final String srcAttr;
    private final String altAttr;
    private final String imageClass;
    private final String text;
    private final int width;
    private final int height;

    public String getSrcAttr() {
        return srcAttr;
    }

    public String getAltAttr() {
        return altAttr;
    }

    public String getImageClass() {
        return imageClass;
    }

    public String getText() {
        return text;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static class Builder {
        private String srcAttr = "https://jdi-testing.github.io/jdi-light/images/captain-america.jpg";
        private String altAttr = "Captain America image";
        private String imageClass = "card-img-top";
        private String text = "CARD TITLE\nThis is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.\nLast updated 3 mins ago";
        private int width = 86;
        private int height = 105;

        public Builder srcAttr(String srcAttr) {
            this.srcAttr = srcAttr;
            return this;
        }

        public Builder altAttr(String altAttr) {
            this.altAttr = altAttr;
            return this;
        }

        public Builder imageClass(String imageClass) {
            this.imageClass = imageClass;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }
        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public CardImageData build() {
            return new CardImageData(this);
        }
    }

    private CardImageData(Builder b) {
        this.srcAttr = b.srcAttr;
        this.altAttr = b.altAttr;
        this.imageClass = b.imageClass;
        this.text = b.text;
        this.width = b.width;
        this.height = b.height;
    }
}
