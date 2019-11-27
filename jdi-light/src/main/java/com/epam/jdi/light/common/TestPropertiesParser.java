package com.epam.jdi.light.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesParser {

    Properties testProperties = new Properties();
    FileInputStream fileInputStream;
    String filePath;


    public TestPropertiesParser(String filePath) {

        this.filePath = filePath;
    }

    public String getValue(String key) {

        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found in path: "+filePath);
            e.printStackTrace();
        }

        try {
            testProperties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testProperties.getProperty(key);
    }

    public boolean checkRegEx(String value, String regex) {

        return value.matches(regex);
    }
}
