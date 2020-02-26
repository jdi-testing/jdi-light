package com.epam.jdi.httptests;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Roman_Iovlev on 11/3/2017.
 */
public class IdName {
    public String Accept;

    @JsonProperty("Accept-Encoding")
    public String AcceptEncoding;

    @JsonProperty("Content-Type")
    public String ContentType;

    public String Host;
    public String Id;
    public String Name;

    @JsonProperty("User-Agent")
    public String UserAgent;
}
