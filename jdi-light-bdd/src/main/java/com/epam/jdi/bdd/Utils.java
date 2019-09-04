package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.HasPage;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.map.MapArray;

import java.util.List;

import static com.epam.jdi.bdd.Utils.deserializeJsonToMap;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;
import static com.epam.jdi.light.elements.composite.WebPage.getCurrentPage;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.PropertyReader.getProperty;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cucumber.api.DataTable;

/**
 * Created by Dmitry_Lebedev1 on 1/13/2016.
 */
public final class Utils {

    private Utils() {
    }

    public static <T extends HasPage> T getUI(String name, Class<T> type) {
        try {
            return (T) getUI(name);
        } catch (Exception ex) {
            throw exception("Can't convert element to %s", type.getSimpleName());
        }
    }

    public static <T extends HasPage> T getUI(String name) {
        try {
            String[] split = name.split("\\.");
            if (split.length == 2)
                return (T) getUI(split[1], split[0]);
            if (ELEMENTS.has(name)) {
                List<Object> elements = ELEMENTS.get(name);
                if (elements.size() == 1)
                    return (T) elements.get(0);
                Object element = LinqUtils.first(elements,
                    el -> {
                        WebPage page = ((T) el).getPage();
                        return page != null && page.getName().equals(getCurrentPage());
                    });
                return (T) (element != null
                    ? element
                    : elements.get(0));
            }
        } catch (Exception ignore) { }
        throw exception("Can't find %s element", name);
    }

    public static <T extends HasPage> T getUI(String name, String section) {
        if (ELEMENTS.has(name)) {
            List<Object> els = ELEMENTS.get(name);
            Object result = first(els, el -> isClass(el.getClass(), JDIBase.class) && ((JDIBase) el).hasParent(section));
            if (result == null)
                throw exception("Can't find %s element at %s", name, section);
            return (T) result;
        }
        throw exception("Can't find %s element", name);
    }

	public static Map<String, String> deserializeJsonToMap(String jsonName) {	
		Gson gson = (new GsonBuilder()).create();
		Map<String, String> map = new HashMap<String, String>();
		String json = readFileData(getProperty("jsonTestDataFolder") + jsonName + ".json");
		map = (Map<String, String>) gson.fromJson(json, map.getClass());
		return map;
    }

    public static String readFileData(String filePath) {
        String data = null;
	    try(InputStream inputStream = Utils.class.getResourceAsStream(filePath)) {
		    data = readFromInputStream(inputStream);
	    } catch (IOException e) {
	    	throw exception("Can't read from stream!");
	    } catch(NullPointerException npe) {
	    	throw exception("Can't find file by path %s !", filePath);
	    }
	    return data;	 
    }

    private static String readFromInputStream(InputStream inputStream) throws IOException {
	    StringBuilder resultStringBuilder = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
			    resultStringBuilder.append(line).append("\n");
		    }
	    }
	    return resultStringBuilder.toString();
    }
    
    public static MapArray<String, String> getMapFromTable(DataTable table) {
		return new MapArray<>(table.getGherkinRows(),
				r -> r.getCells().get(0), r -> r.getCells().get(1));
	}
	
	public static MapArray<String, String> getMapFromJson(String jsonName) {
		return MapArray.toMapArray(deserializeJsonToMap(jsonName));
	}
}
