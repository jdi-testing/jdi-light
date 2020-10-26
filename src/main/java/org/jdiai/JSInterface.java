package org.jdiai;

import com.google.gson.JsonObject;

import java.util.List;

public interface JSInterface {
    String getOne(String text);
    JsonObject getOneJson(String json);
    <T> T getOne(Class<T> cl, String json);
    JsonObject getOneJson(String... attributes) ;
    <T> T getOne(Class<T> cl, String... attributes);
    String getStyle(String style);
    List<String> getList(String text);
    String getOneChain(String text);
    String getOneMultiSearch(String text);
    List<String> getListChain(String text);
    List<String> getListMultiSearch(String text);
}
