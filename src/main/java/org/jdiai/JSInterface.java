package org.jdiai;

import com.google.gson.JsonObject;

import java.util.List;

public interface JSInterface {
    String getOne();
    JsonObject getOneAsJson();
    <T> T getOne(Class<T> cl);
    String getStyle(String style);
    List<String> getList();
    String getOneChain();
    String getOneMultiSearch();
    List<String> getListChain();
    List<String> getListMultiSearch();
}
