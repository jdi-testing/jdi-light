package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.map.MapArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.DataTable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.PropertyReader.getProperty;

/**
 * Created by Dmitry_Lebedev1 on 1/13/2016.
 */
public final class Utils {
    public static final String HTML5_PAGE_FOLDER =
            System.getProperty("user.dir") + "/src/test/resources/html5page.json";
    private Utils() { }

	public static Map<String, String> deserializeJsonToMap(String jsonName) {	
		Gson gson = (new GsonBuilder()).create();
		Map<String, String> map = new HashMap<String, String>();
		String json = readFileData(getProperty("jsonTestDataFolder") + jsonName + ".json");
		map = gson.fromJson(json, map.getClass());
		return map;
    }

    public static String readFileData(String filePath) {
        String data;
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

    static UIElement element(String locatorName) {
        HashMap<String, String> result = new HashMap<>();
        try {
            result = new ObjectMapper().readValue(new File(HTML5_PAGE_FOLDER), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.get(locatorName) != null ? $(result.get(locatorName)) :
                locatorName.matches("[A-Z].*")
                    ? new UIElement().setName(locatorName) : $(locatorName);
    }
}
