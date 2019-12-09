package com.epam.jdi.light.common;

import com.epam.jdi.tools.PathUtils;

import java.io.File;
import java.util.regex.Matcher;

public class AdditionalPathUtils extends PathUtils {

    public static String getCrossPlatformPath(String path) {
        return path.replaceAll("[\\\\|/]", Matcher.quoteReplacement(File.separator));
    }
}
