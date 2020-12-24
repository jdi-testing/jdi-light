package org.jdiai;

public enum ImageTypes {
    PNG("image/png", "png"), JPG("image/jpeg", "jpg"), GIF("image/gif", "gif"),
    BMP("image/bmp", "bmp"), TIF("image/tiff", "tif"), VIDEO_MP4("video/mp4", "mp4"),
    VIDEO_WEBM("video/webm", "webm");

    public String value;
    public String suffix;
    ImageTypes(String value, String suffix) {
       this.value = value;
       this.suffix = suffix;
    }
}
