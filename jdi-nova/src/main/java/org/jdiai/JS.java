package org.jdiai;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import com.google.gson.JsonObject;
import org.jdiai.annotations.UI;
import org.jdiai.asserts.Condition;
import org.jdiai.interfaces.HasCore;
import org.jdiai.interfaces.HasLocators;
import org.jdiai.interfaces.HasName;
import org.jdiai.interfaces.HasParent;
import org.jdiai.jsbuilder.IJSBuilder;
import org.jdiai.jsdriver.JSDriver;
import org.jdiai.jsdriver.JSDriverUtils;
import org.jdiai.jsdriver.JSException;
import org.jdiai.jsproducer.Json;
import org.jdiai.jswraper.JSSmart;
import org.jdiai.scripts.Whammy;
import org.jdiai.tools.ClientRect;
import org.jdiai.tools.GetTextTypes;
import org.jdiai.tools.JSImages;
import org.jdiai.visual.Direction;
import org.jdiai.visual.ImageTypes;
import org.jdiai.visual.OfElement;
import org.jdiai.visual.StreamToImageVideo;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.jdiai.jsbuilder.GetTypes.dataType;
import static org.jdiai.jsbuilder.JSTemplates.XPATH_FUNC;
import static org.jdiai.jsbuilder.QueryLogger.logger;
import static org.jdiai.jsdriver.JSDriverUtils.*;
import static org.jdiai.jsdriver.JSException.THROW_ASSERT;
import static org.jdiai.jswraper.JSWrappersUtils.*;
import static org.jdiai.page.objects.PageFactoryUtils.getLocatorFromField;
import static org.jdiai.tools.FilterConditions.textEquals;
import static org.jdiai.tools.GetTextTypes.INNER_TEXT;
import static org.jdiai.tools.VisualSettings.*;
import static org.jdiai.visual.Direction.VECTOR_SIMILARITY;
import static org.jdiai.visual.ImageTypes.VIDEO_WEBM;
import static org.jdiai.visual.RelationsManager.*;
import static org.openqa.selenium.OutputType.*;

public class JS implements WebElement, HasLocators, HasName, HasParent, HasCore {
    public static String JDI_STORAGE = "src/test/jdi";
    public JSSmart js;
    private Supplier<WebDriver> driver;
    private Safe<Actions> actions;
    private String name = "";
    private Object parent = null;
    private JSImages imagesData;
    public int renderTimeout = 5000;
    protected String objectMap;

    public JS() { }
    public JS(Supplier<WebDriver> driver, List<By> locators) {
        this.driver = driver;
        this.js = new JSSmart(driver, locators);
        this.js.multiSearch();
        this.actions = new Safe<>(() -> new Actions(driver()));
    }
    public JS(WebDriver driver, List<By> locators) {
        this(() -> driver, locators);
    }
    public JS(Supplier<WebDriver> driver, By... locators) {
        this(driver, newList(locators));
    }
    public JS(WebDriver driver, By... locators) {
        this(() -> driver, locators);
    }

    public JS(JS parent, By locator) {
        this(parent::driver, locator, parent, true);
    }
    public JS(Supplier<WebDriver> driver, By locator, Object parent) {
        this(driver, locator, parent, true);
    }
    public JS(WebDriver driver, By locator, Object parent) {
        this(() -> driver, locator, parent);
    }
    public JS(JS parent, By locator, boolean useParentLocators) {
        this(parent::driver, locator, parent, useParentLocators);
    }
    public JS(Supplier<WebDriver> driver, By locator, Object parent, boolean useParentLocators) {
        this(driver, locatorsFromParent(locator, parent, useParentLocators));
        this.parent = parent;
        if (parent != null && isClass(parent.getClass(), HasCore.class)) {
            this.js.updateDriver(((HasCore) parent).core().js.jsDriver());
        }
    }
    public JS(WebDriver driver, By locator, Object parent, boolean useParentLocators) {
        this(() -> driver, locator, parent, useParentLocators);
    }
    public WebDriver driver() {
        return this.driver.get();
    }
    public JavascriptExecutor js() {
        return (JavascriptExecutor) driver();
    }
    public JS core() { return this; }
    public void setCore(JS core) {
        this.js = core.js;
        this.driver = core.driver;
        this.actions = core.actions;
        this.name = core.name;
        this.parent = core.parent;
        this.imagesData = core.imagesData;
        this.renderTimeout = core.renderTimeout;
        this.objectMap = core.objectMap;
    }

    private static List<By> locatorsFromParent(By locator, Object parent, boolean useParentLocators) {
        List<By> locators = new ArrayList<>();
        if (useParentLocators && parent != null && isInterface(parent.getClass(), HasLocators.class)) {
            List<By> pLocators = ((HasLocators) parent).locators();
            if (isNotEmpty(pLocators)) {
                locators.addAll(copyList(pLocators));
            }
        }
        locators.add(locator);
        return locators;
    }
    public String getElement(String valueFunc) {
        return js.getValue(valueFunc);
    }
    public List<String> getList(String valueFunc) {
        return js.getValues(valueFunc);
    }
    public String filterElements(String valueFunc) {
        return js.firstValue(valueFunc);
    }
    public String getJSResult(String action) {
        return js.getAttribute(action);
    }
    public void set(String action) {
        doAction(action);
    }
    public void setOption(String option) {
        doAction("option.value = " + option);
    }
    public void selectByName(String value) {
        doAction("selectedIndex = [...element.options].findIndex(option => option.text === '" + value + "')");
    }
    public void doAction(String action) {
        js.doAction(action);
    }
    public WebElement we() {
        SearchContext ctx = driver();
        for (By locator : locators()) {
            ctx = ctx.findElement(locator);
        }
        return (WebElement) ctx;
    }
    public void actionsWithElement(JFunc2<Actions, WebElement, Actions> action) {
        action.execute(actions.get().moveToElement(this), this).build().perform();
    }
    public void actions(JFunc2<Actions, WebElement, Actions> action) {
        action.execute(actions.get(), this).build().perform();
    }
    public String getName() {
        return isNotBlank(name) ? name : print(locators(), JSDriverUtils::getByLocator); }
    public void setName(String name) {
        this.name = name;
    }
    public String getFullName() {
        String name = "";
        if (parent() != null) {
            name += isInterface(parent().getClass(), HasName.class)
                ? ((HasName)parent()).getName()
                : parent().getClass().getSimpleName();
            name += ".";
        }
        return name + getName();
    }
    public Object parent() {
        return this.parent;
    }

    public void click() {
        doAction("click()");
    }
    public void click(int x, int y) {
        js.jsExecute("document.elementFromPoint(" + x + ", " + y + ").click()");
    }
    public void select() { click(); }
    public void select(String value) {
        if (locators().get(locators().size() - 1).toString().contains("%s")) {
            js.jsDriver().builder().setTemplate(value);
            click();
        } else {
            find(format(SELECT_FIND_TEXT_LOCATOR, value)).click();
        }
    }
    public static String SELECT_FIND_TEXT_LOCATOR = ".//*[text()='%s']";
    public String selectFindTextLocator = SELECT_FIND_TEXT_LOCATOR;
    protected String selectFindTextLocator() {
        return selectFindTextLocator;
    }
    public JS setFindTextLocator(String locator) {
        selectFindTextLocator = locator;
        return this;
    }
    public void select(String... values) {
        if (locators().size() == 0) {
            return;
        }
        By locator = LinqUtils.last(locators());
        IJSBuilder builder = getByLocator(locator).contains("%s")
            ? getTemplateScriptForSelect(locator, values)
            : getScriptForSelect(locator, values);
        builder.executeQuery();
    }
    private IJSBuilder getTemplateScriptForSelect(By locator, String... values) {
        IJSBuilder builder;
        String ctx;
        if (locators().size() == 1) {
            builder = js.jsDriver().builder();
            ctx = "document";
        } else {
            builder = new JSDriver(js.jsDriver().driver(), listCopyUntil(locators(), locators().size() - 1))
                .buildOne();
            ctx = "element";
        }
        builder.registerVariable("option");
        builder.setElementName("option");
        for (String value : values) {
            By by = fillByTemplate(locator, value);
            builder.oneToOne(ctx, by).doAction("option.click();\n");
        }
        return builder;
    }
    private IJSBuilder getScriptForSelect(By locator, String... values) {
        IJSBuilder builder = js.jsDriver().buildOne();
        builder.registerVariable("option");
        builder.setElementName("option");
        for (String value : values) {
            By by = defineLocator(format(selectFindTextLocator(), value));
            builder.oneToOne("element", by).doAction("option.click();\n");
        }
        return builder;
    }
    public <TEnum extends Enum<?>> void select(TEnum name) {
        select(getEnumValue(name));
    }
    public void check(boolean condition) {
        doAction("checked=" + condition + ";");
    }
    public void check() {
        check(true);
    }
    public void uncheck() {
        check(false);
    }
    public void rightClick() {
        actionsWithElement(Actions::contextClick);
    }
    public void doubleClick() {
        actionsWithElement(Actions::doubleClick);
    }
    public void hover() {
        actions(Actions::moveToElement);
    }
    public void dragAndDropTo(WebElement to) {
        dragAndDropTo(to.getLocation().x, to.getLocation().y);
    }
    public void dragAndDropTo(int x, int y) {
        actions((a,e) -> a.dragAndDropBy(e, x, y));
    }

    public void submit() {
        doAction("submit()");
    }

    private String charToString(CharSequence... value) {
        return value.length == 1 ? value[0].toString() : "";
    }
    public void sendKeys(CharSequence... value) {
        set("value+='" + charToString(value) + "'");
    }
    public void input(CharSequence... value) {
        set("value='" + charToString(value) + "'");
    }
    public void slide(String value) {
        //Actions a = new Actions(DRIVER.get());
        //a.dragAndDropBy(DRIVER.get().findElement(By.xpath("[aria-labelledby='range-slider'][data-index='0']")),20, 0)
        //  .build().perform();
        //js.jsDriver().builder().oneToOne("document", locators.get(0))
        //  .addJSCode("element.value='" + value + "';\n")
        //  .trigger("mousedown")
        //  .trigger("mousemove", "which: 1, pageX: 460");
        //.trigger("mousedown")
        //  .trigger("mousemove", { which: 1, pageX: 460 })
    }
    public void clear() {
        doAction("clear()");
    }

    public String getTagName() {
        return getJSResult("tagName").toLowerCase();
    }
    public String tag() {
        return getTagName();
    }

    public String getAttribute(String attrName) {
        return getJSResult("getAttribute('" + attrName + "')");
    }
    public String getProperty(String property) {
        return getJSResult(property);
    }

    public Json getJson(String valueFunc) {
        return js.getMap(valueFunc);
    }
    public String attr(String attrName) {
        return getAttribute(attrName);
    }
    public List<String> allClasses() {
        String cl = attr("class");
        return cl.length() > 0
                ? newList(cl.split(" "))
                : new ArrayList<>();
    }
    public boolean hasClass(String className) {
        return allClasses().contains(className);
    }
    public boolean hasAttribute(String attrName) {
        return isNotBlank(attr(attrName));
    }

    public Json allAttributes() {
        return js.getMap("return '{'+[...element.attributes].map((attr)=> `'${attr.name}'='${attr.value}'`).join()+'}'");
        //return js.getMap("return [...element.attributes].reduce((map,attr)=> { map.set('attr.name','attr.value'); return map; }, new Map())");
    }
    public String printHtml() {
        return MessageFormat.format("<{0} {1}>{2}</{0}>", getTagName().toLowerCase(),
            print(allAttributes(), el -> format("%s='%s'", el.key, el.value), " "),
            getJSResult("innerHTML"));
    }
    public void show() {
        if (isDisplayed() && !isVisible()) {
            doAction("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
        }
    }
    public void highlight(String color) {
        show();
        set("styles.border='3px dashed "+color+"'");
    }
    public void highlight() {
        highlight("red");
    }

    public String cssStyle(String style) {
        return js.getStyle(style);
    }
    public Json cssStyles(String... style) {
        return js.getStyles(style);
    }
    public Json allCssStyles() {
        return js.getAllStyles();
    }

    public boolean isSelected() {
        return getProperty("checked").equals("true");
    }
    public boolean isDeselected() {
        return !isSelected();
    }
    public boolean isEnabled() {
        return isNotBlank(getAttribute("enabled"));
    }
    public JS setTextType(GetTextTypes textType) { this.textType = textType; return this; }

    public GetTextTypes textType = INNER_TEXT;
    public String getText() {
        return getText(textType);
    }
    public String getText(GetTextTypes textType) {
        return getJSResult(textType.value);
    }

    public List<WebElement> findElements(By by) {
        return we().findElements(by);
    }

    public WebElement findElement(By by) {
        return we().findElement(by);
    }

    public boolean isDisplayed() {
        return getElement("const styles = getComputedStyle(element);\n" +
            "return element !== null && styles.visibility === 'visible' && styles.display !== 'none'")
                .equalsIgnoreCase("true");
    }
    public boolean isHidden() {
        return !isDisplayed();
    }
    public boolean isVisible() {
        if (isHidden())
            return false;
        Dimension visibleRect = getSize();
        return visibleRect.height > 0 && visibleRect.width > 0;
    }
    public boolean isNotVisible() {
        return !isVisible();
    }
    public boolean isExist() {
        return js.jsDriver().getCount() > 0;
    }
    public boolean isNotExist() {
        return !isExist();
    }
    public boolean isDisabled() {
        return !isEnabled();
    }
    public Point getLocation() {
        ClientRect rect = getClientRect();
        int x, y;
        if (inVision(rect))
            return new Point(-1, -1);
        int left = max(rect.left, 0);
        int top = max(rect.top, 0);
        x = left + getWidth(rect) / 2;
        y = top + getHeight(rect) / 2;
        return new Point(x, y);
    }

    protected boolean inVision(ClientRect rect) {
        return rect.x >= rect.windowWidth || rect.y >= rect.windowHeight || rect.bottom < 0 || rect.right < 0;
    }
    public Dimension getSize() {
        ClientRect rect = getClientRect();
        int width, height;
        if (inVision(rect))
            return new Dimension(0, 0);
        width = getWidth(rect);
        height = getHeight(rect);
        return new Dimension(width, height);
    }
    private int getWidth(ClientRect rect) {
        int left = max(rect.left, 0);
        int right = min(rect.right, rect.windowWidth);
        return right - left;
    }
    private int getHeight(ClientRect rect) {
        int top = max(rect.top, 0);
        int bottom = min(rect.bottom, rect.windowHeight);
        return bottom - top;
    }
    public Rectangle getRect() {
        ClientRect rect = getClientRect();
        return inVision(rect)
            ? new Rectangle(0, 0, 0, 0)
            : new Rectangle(rect.x, rect.y, getHeight(rect), getWidth(rect));
    }
    public ClientRect getClientRect() {
        return new ClientRect(js.getJson("let cl = element.getBoundingClientRect();\n" +
            "return { x: cl.x, y: cl.y, top: cl.top, bottom: cl.bottom, left: cl.left, right: cl.right, " +
            "wWidth: window.innerWidth, wHeight: window.innerHeight };"));
    }

    public String getCssValue(String style) {
        return js.getStyle(style);
    }
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        StreamToImageVideo screen = makeScreenshot(DEFAULT_IMAGE_TYPE);
        if (outputType == BASE64) {
            return (X) screen.asBase64();
        }
        if (outputType == BYTES) {
            return (X) screen.asByteStream();
        }
        if (outputType == FILE) {
            return (X) screen.asFile(IMAGE_TEMPLATE.execute("", this));
        }
        throw new JSException("Failed to get screenshot - unknown type: " + outputType);
    }
    private String canvas2Image(ImageTypes imageType) {
        return "toDataURL('" + imageType.value + "')";
    }
    private String element2Image(ImageTypes imageType) {
        return "html2canvas(element).then((canvas) => canvas."+canvas2Image(imageType)+")";
    }
    public StreamToImageVideo makeScreenshot() {
        return makeScreenshot(DEFAULT_IMAGE_TYPE);
    }
    public StreamToImageVideo makeScreenshot(ImageTypes imageType) {
        String stream = getElement("if (element.toDataURL) { return element."+canvas2Image(imageType)+"; }\n"
            + "try { return "+element2Image(imageType)+"; } catch {\n"
            + "return await import(`https://html2canvas.hertzen.com/dist/html2canvas.min.js`).then("
            + "() => "+element2Image(imageType)+") }"
        );
        return new StreamToImageVideo(stream, imageType);
    }
    public void startRecording() {
        startRecording(VIDEO_WEBM);
    }
    public void startRecording(ImageTypes imageType) {
        String value = getElement("let blobs = [];\n" +
            "const recorder = new MediaRecorder(element.captureStream(), { mimeType: '" + imageType.value + "' });\n" +
            "recorder.ondataavailable = (e) => {\n" +
            "  if (e.data && e.data.size > 0) { blobs.push(e.data); }\n}\n" +
            "recorder.onstop = () => {\n" +
            "  const blob = new Blob(blobs, { type: '" + imageType.value + "' });\n" +
            "  let reader = new FileReader();\n" +
            "  reader.readAsDataURL(blob);\n" +
            "  reader.onloadend = () => window.jdiVideoBase64 = reader.result;\n" +
            "}\n" +
            "recorder.start();\n" +
            "window.jdiRecorder = recorder;\n" +
            "return 'start recording'");
        if (!value.equals("start recording"))
            throw new JSException(value);
    }
    public StreamToImageVideo stopRecordingAndSave(ImageTypes imageType) {
        js.jsExecute("window.jdiRecorder.stop();");
        String stream = "";
        Timer timer = new Timer(renderTimeout);
        while (stream.length() < 10 && timer.isRunning()) {
            stream = js.jsExecute("return window.jdiVideoBase64;");
        }
        return new StreamToImageVideo(stream, imageType);
    }
    public StreamToImageVideo stopRecordingAndSave() {
        return stopRecordingAndSave(VIDEO_WEBM);
    }
    public StreamToImageVideo recordCanvasVideo(int sec) {
        return recordCanvasVideo(VIDEO_WEBM, sec);
    }
    public StreamToImageVideo recordCanvasVideo(ImageTypes imageType, int sec) {
        startRecording(imageType);
        Timer.sleep((sec+1) * 1000L);
        return stopRecordingAndSave(imageType);
    }
    // Experimental record video for any element
    public StreamToImageVideo recordVideo(int sec) {
        js.jsExecute("await import(`https://html2canvas.hertzen.com/dist/html2canvas.min.js`)");
        getElement(Whammy.script);
        Timer.sleep((sec+5) * 1000L);
        js.jsExecute("jdi.recording = false; jdi.compile();");
        String stream = "";
        Timer timer = new Timer(renderTimeout);
        while (stream.length() < 10 && timer.isRunning()) {
            stream = js.jsExecute("return jdi.videoBase64");
        }
        return new StreamToImageVideo(stream, VIDEO_WEBM);
    }

    public JS setObjectMapping(String objectMap, Class<?> cl) {
        this.objectMap = objectMap;
        this.js.setupEntity(cl);
        return this;
    }
    public JsonObject getJSObject(String json) {
        return js.getJson(json);
    }

    public <T> T getEntity(Class<T> cl) {
        String objectMap = GET_OBJECT_MAP.execute(cl);
        if (objectMap.contains("': xpath(")) {
            js.jsDriver().builder().registerFunction("xpath", XPATH_FUNC);
        }
        return getEntity(objectMap, cl);
    }
    public <T> T getEntity() {
        return js.getEntity(objectMap);
    }
    public void setEntity() {
        js.setEntity(objectMap);
    }
    public <T> T getEntity(String objectMap, Class<?> cl) {
        js.setupEntity(cl);
        return js.getEntity(objectMap);
    }
    public void setEntity(String objectMap) {
        js.setEntity(objectMap);
    }

    public JS find(String by) {
        return find(NAME_TO_LOCATOR.execute(by));
    }
    public JS find(By by) {
        return new JS(this, by);
    }
    public JS children() { return find("*"); }
    public JS ancestor() { return find("/.."); }

    public List<String> values(GetTextTypes getTextType) {
        return js.getAttributeList(getTextType.value);
    }
    public List<String> values() {
        return values(textType);
    }
    public List<JsonObject> getObjectList(String json) {
        return js.getJsonList(json);
    }
    public <T> List<T> getEntityList() {
        return js.getEntityList(objectMap);
    }
    public void setEntityList() {
        js.setEntity(objectMap);
    }

    public static JFunc1<Field, String> GET_COMPLEX_VALUE = field -> {
        if (!field.isAnnotationPresent(FindBy.class) && !field.isAnnotationPresent(UI.class))
            return null;
        By locator = getLocatorFromField(field);
        if (locator != null) {
            String element = MessageFormat.format(dataType(locator).get, "element", getByLocator(locator));
            return format("'%s': %s", field.getName(), getValueType(field, element));
        }
        return null;
    };
    public static JFunc2<Field, Object, String> SET_COMPLEX_VALUE = (field, value)-> {
        if (!field.isAnnotationPresent(FindBy.class) && !field.isAnnotationPresent(UI.class))
            return null;
        By locator = getLocatorFromField(field);
        if (locator == null) {
            return null;
        }
        String element = MessageFormat.format(dataType(locator).get, "element", getByLocator(locator));
        return setValueType(field, element, value);
    };
    public static JFunc1<Class<?>, String> GET_OBJECT_MAP = cl -> {
        Field[] allFields = cl.getDeclaredFields();
        List<String> mapList = new ArrayList<>();
        for (Field field : allFields) {
            String value = GET_COMPLEX_VALUE.execute(field);
            if (value != null) {
                mapList.add(value);
            }
        }
        return "{ " + print(mapList, ", ") + " }";
    };
    public <T> List<T> getEntityList(Class<T> cl) {
        return getEntityList(GET_OBJECT_MAP.execute(cl), cl);
    }
    public void fill(Object obj) {
        setEntity(obj);
    }
    public void submit(Object obj, String locator) {
        setEntity(obj);
        find(locator).click();
    }
    public void submit(Object obj) {
        submit(obj, SUBMIT_LOCATOR);
    }
    public void loginAs(Object obj, String locator) {
        submit(obj, locator);
    }
    public void loginAs(Object obj) {
        submit(obj);
    }

    public static String SUBMIT_LOCATOR = "[type=submit]";

    public void setEntity(Object obj) {
        Field[] allFields = obj.getClass().getDeclaredFields();
        List<String> mapList = new ArrayList<>();
        for (Field field : allFields) {
            Object fieldValue = getValueField(field, obj);
            if (fieldValue == null) {
                continue;
            }
            String value = SET_COMPLEX_VALUE.execute(field, fieldValue);
            if (value != null) {
                mapList.add(value);
            }
        }
        setEntity(print(mapList, ";\n") + ";\nreturn ''");
    }

    public <T> List<T> getEntityList(String objectMap, Class<?> cl) {
        js.setupEntity(cl);
        return js.getEntityList(objectMap);
    }
    public void setEntityList(String objectMap) {
        js.setEntity(objectMap);
    }

    public JS findFirst(String by, Function<JS, String> condition) {
        return findFirst(NAME_TO_LOCATOR.execute(by), condition.apply(this));
    }
    public JS findFirst(By by, Function<JS, String> condition) {
        return findFirst(by, condition.apply(this));
    }
    public JS findFirst(String by, String condition) {
        return findFirst(NAME_TO_LOCATOR.execute(by), condition);
    }
    public JS get(int index) {
        return listToOne("element = elements[" + index + "];\n");
    }
    public JS get(String by, int index) {
        return get(NAME_TO_LOCATOR.execute(by), index);
    }
    public JS get(By by, int index) {
        return listToOne("element = elements.filter(e => "+
            MessageFormat.format(dataType(by).get, "e", selector(by, js.jsDriver().builder()))+
            ")[" + index + "];\n");
    }

    public JS get(Function<JS, String> filter) {
        return findFirst(filter);
    }
    public JS get(String value) {
        return get(textEquals(value));
    }
    public JS findFirst(Function<JS, String> condition) {
        return findFirst(condition.apply(this));
    }
    public JS findFirst(String condition) {
        return listToOne("element = elements.find(e => e && e."+ condition + ");\n");
    }
    public JS findFirst(By by, String condition) {
        String script = "element = elements.find(e => { const fel = " +
            MessageFormat.format(dataType(by).get, "e", selector(by, js.jsDriver().builder()))+"; " +
            "return fel && " + condition.replace("element", "fel") + "; });\n";
        return listToOne(script);
    }
    private JS listToOne(String script) {
        JS result = new JS(driver);
        result.js.jsDriver().builder().addContextCode(js.jsDriver().buildList().rawQuery() + script);
        result.js.jsDriver().elementCtx();
        result.js.jsDriver().builder().updateFromBuilder(js.jsDriver().builder());
        js.jsDriver().builder().cleanup();
        return result;
    }
    // TODO
    // public WebList finds(@MarkupLocator String by) {
    //     return $$(by, this);
    // }
    // public WebList finds(@MarkupLocator By by) {
    //     return $$(by, this);
    // }

    public boolean isClickable() {
        Dimension dimension = getSize();
        if (dimension.getWidth() == 0) return false;
        return isClickable(dimension.getWidth()/2, dimension.getHeight()/2-1);
    }
    public boolean isClickable(int xOffset, int yOffset) {
        return getElement("rect = element.getBoundingClientRect();\n" +
            "cx = rect.left + " + xOffset + ";\n" +
            "cy = rect.top + " + yOffset + ";\n" +
            "e = document.elementFromPoint(cx, cy);\n" +
            "for (; e; e = e.parentElement) {\n" +
            "  if (e === element)\n" +
            "    return true;\n" +
            "}\n" +
            "return false;").equals("true");
    }
    public String fontColor() {
        return js.color();
    }
    public String bgColor() {
        return js.bgColor();
    }
    public String pseudo(String name, String value) {
        return js.pseudo(name, value);
    }
    public boolean focused() { return getElement("element === document.activeElement").equalsIgnoreCase("true"); }

    @Override
    public List<By> locators() { return js.jsDriver().locators(); }
    public JSImages imagesData() {
        if (imagesData == null) {
            imagesData = new JSImages();
        }
        return imagesData;
    }

    public File getImageFile() {
        return getImageFile("");
    }
    public File getImageFile(String tag) {
        return imagesData().images.has(tag) ? new File(imagesData().images.get(tag)) : null;
    }
    public void visualValidation() {
        visualValidation("");
    }
    public void visualValidation(String tag) {
        VISUAL_VALIDATION.execute(tag, this);
    }
    public void visualCompareWith(JS element) {
        COMPARE_IMAGES.execute(imagesData().imageFile, element.imagesData().imageFile);
    }
    public Direction getDirectionTo(JS element) {
        ClientRect destinationCoordinates = element.getClientRect();
        ClientRect elementCoordinates = getClientRect();
        Direction direction = new Direction(getCenter(elementCoordinates), getCenter(destinationCoordinates));
        if (relations == null) {
            relations = new MapArray<>(element.getFullName(), direction);
        } else {
            relations.update(element.getFullName(), direction);
        }
        return direction;
    }
    public boolean relativePosition(JS element, Direction expected) {
        return COMPARE_POSITIONS.execute(getDirectionTo(element), expected);
    }
    public OfElement isOn(JFunc1<Direction, Boolean> expected) {
        return new OfElement(expected, this);
    }
    public boolean relativePosition(JS element, JFunc1<Direction, Boolean> expected) {
        return expected.execute(getDirectionTo(element));
    }
    public MapArray<String, Direction> relations;
    public void clearRelations() {
        relations = null;
    }
    public MapArray<String, Direction> getRelativePositions(JS... elements) {
        relations = new MapArray<>();
        for (JS element : elements) {
            relations.update(element.getName(), getDirectionTo(element));
        }
        storeRelations(this, relations);
        return relations;
    }
    public List<String> validateRelations() {
        MapArray<String, Direction> storedRelations = readRelations(this);
        if (isEmpty(storedRelations)) {
            return newList("No relations found in: " + RELATIONS_STORAGE);
        }
        List<String> failures = new ArrayList<>();
        if (isEmpty(relations)) {
            return newList("No element relations found: use getRelativePosition(...) first and save element relations");
        }
        MapArray<String, Direction> newRelations = new MapArray<>();
        for (Pair<String, Direction> relation : relations) {
            if (storedRelations.has(relation.key)) {
                Direction expectedRelation = storedRelations.get(relation.key);
                if (!VECTOR_SIMILARITY.execute(relation.value, expectedRelation)) {
                    failures.add(format("Elements '%s' and '%s' are misplaced: angle: %s => %s; length: %s => %s",
                        getFullName(), relation.key, relation.value.angle(), expectedRelation.angle(),
                        relation.value.length(), expectedRelation.length()));
                }
            } else {
                newRelations.add(relation);
            }
        }
        if (isNotEmpty(newRelations)) {
            storeRelations(this, newRelations);
        }
        return failures;
    }

    public Point getCenter() {
        return getCenter(getClientRect());
    }
    protected Point getCenter(ClientRect rect) {
        int x = rect.left + (rect.right - rect.left) / 2;
        int y = rect.top + (rect.bottom - rect.top) / 2;
        return new Point(x, y);
    }
    public JS shouldBe(Condition... conditions) {
        for (Condition condition : conditions) {
            String message = "Assert that " + condition.getName(this);
            logger.info(message);
            boolean result = condition.execute(this);
            if (!result) {
                THROW_ASSERT.accept(message + " failed");
            }
        }
        return this;
    }
    public JS should(Condition... conditions) {
        return shouldBe(conditions);
    }
    public JS waitFor(Condition... conditions) {
        return shouldBe(conditions);
    }
}
