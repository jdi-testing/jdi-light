package com.epam.jdi.bdd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonHelper {
 
  public static <T> T deserializeJson(Class<T> model, String json){
    GsonBuilder gsonBuilder = new GsonBuilder();    
    Gson gson = gsonBuilder.create();
    T modelInstance = gson.fromJson(json, model);        
    return modelInstance;
  }  
  
}