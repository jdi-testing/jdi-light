package com.epam.jdi.bdd;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.*;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.tools.map.MapArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.DataTable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.PropertyReader.getProperty;

/**
 * Created by Dmitry_Lebedev1 on 1/13/2016.
 */
public final class BDDUtils {
    public static final String PAGE_OBGECTS_DIR =
		System.getProperty("user.dir") + "/src/test/resources/page/objects";
    private BDDUtils() { }

	public static Map<String, String> deserializeJsonToMap(String jsonName) {	
		Gson gson = (new GsonBuilder()).create();
		Map<String, String> map = new HashMap<String, String>();
		String json = readFileData(getProperty("jsonTestDataFolder") + jsonName + ".json");
		map = gson.fromJson(json, map.getClass());
		return map;
    }

    public static String readFileData(String filePath) {
        String data;
	    try(InputStream inputStream = BDDUtils.class.getResourceAsStream(filePath)) {
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

	static List<String> scanFolder(String folderName) {
    	try {
			return Files.walk(Paths.get(folderName))
				.filter(Files::isRegularFile)
				.map(f -> f.toAbsolutePath().toString())
				.collect(Collectors.toList());
		} catch (Exception ex) { throw exception("Can't get element: " + safeException(ex)); }
	}
	static MapArray<String, String> elements = new MapArray<>();
    static void getElements() {
		List<String> filePaths = scanFolder(PAGE_OBGECTS_DIR);
		elements = new MapArray<>();
		for (String filePath : filePaths)
			try {
				elements.addAll(new ObjectMapper().readValue(new File(filePath), HashMap.class));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

    static UIElement element(String locatorName) {
    	if (!locatorName.matches("[A-Z].*"))
    		return $(locatorName);
		if (elements.size() == 0)
			getElements();
		return elements.keys().contains(locatorName)
			? $(elements.get(locatorName))
			: new UIElement().setName(locatorName);
    }

    public static UIElement core(String name) {
		return getUI(name).core();
	}
	public static IsAssert isAssert(String name) {
		return getUI(name).core().is();
	}
	public static SelectedAssert selectedAssert(String name) {
		return ((HasAssert<SelectedAssert>)getUI(name, SelectedAssert.class)).is();
	}
	public static CommonAssert uiAssert(String name) {
		return ((HasAssert<CommonAssert>)getUI(name, HasAssert.class)).is();
	}
	public static UISelectAssert selectAssert(String name) {
		return ((HasAssert<UISelectAssert>)getUI(name, HasAssert.class)).is();
	}
	public static IsInput input(String name) {
		return getUI(name, IsInput.class);
	}
	public static Label label(String name) {
		return getUI(name, HasLabel.class).label();
	}
    public static ITextAssert textAssert(String name) {
		return (ITextAssert)getUI(name, HasAssert.class).is();
	}


}
