package org.jdiai;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class ScreenshotMaker {
    private final String base64;
    private final ImageTypes imageType;
    public ScreenshotMaker(String stream, ImageTypes imageType) {
        this.base64 = stream.contains("base64") ? stream.substring(stream.indexOf("base64")+7) : "";
        this.imageType = imageType;
    }
    public String asBase64() {
        return base64;
    }
    public byte[] asByteStream() {
        try {
            return Base64.getDecoder().decode(base64);
        } catch (Exception ex) {
            throw new JSException(ex, "Failed to decode screenshot base64 stream: " + base64);
        }
    }
    public File asFile(String fileName) {
        String path = fileName + "." + imageType.suffix;
        try {
            File file = new File(path);
            FileOutputStream osf = new FileOutputStream(file);
            osf.write(asByteStream());
            osf.flush();
            return file;
        } catch (Exception ex) {
            throw new JSException(ex, "Failed to save screenshot to file: " + path);
        }
    }
}
