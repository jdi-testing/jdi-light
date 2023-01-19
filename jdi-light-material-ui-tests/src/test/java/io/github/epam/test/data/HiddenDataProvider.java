package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class HiddenDataProvider {

    @DataProvider(name = "Screen Width")
    public Object[][] screenWidthDividers() {
        return new Object[][]{
                {599, 0, "xs"},
                {600, 1, "sm"},
                {959, 1, "sm"},
                {960, 2, "md"},
                {1279, 2, "md"},
                {1280, 3, "lg"},
                {1919, 3, "lg"},
                {1920, 4, "xl"}};
    }
}
