package com.epam.jdi.light.common;

public enum SearchTypes {
    Single, // only one element allowed after filter
    First,  // if more than one element found take first
    Smart   // if more than one element but zero after filtering than take first
}
