package com.jdiai;

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import com.google.gson.JsonObject;
import com.jdiai.interfaces.HasCore;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.jsdriver.JSDriverUtils;
import com.jdiai.jsproducer.Json;
import com.jdiai.jswraper.JSEngine;
import com.jdiai.scripts.Whammy;
import com.jdiai.tools.*;
import com.jdiai.visual.Direction;
import com.jdiai.visual.ImageTypes;
import com.jdiai.visual.OfElement;
import com.jdiai.visual.StreamToImageVideo;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.jdiai.JDI.*;
import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static com.jdiai.jswraper.JSWrappersUtils.defineLocator;
import static com.jdiai.tools.FilterConditions.textEquals;
import static com.jdiai.tools.GetTextTypes.INNER_TEXT;
import static com.jdiai.tools.JSUtils.getLocators;
import static com.jdiai.tools.Keyboard.pasteText;
import static com.jdiai.tools.VisualSettings.*;
import static com.jdiai.visual.Direction.VECTOR_SIMILARITY;
import static com.jdiai.visual.ImageTypes.VIDEO_WEBM;
import static com.jdiai.visual.RelationsManager.*;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.OutputType.*;

public class JSLight implements JS {
    protected JSEngine engine;
    protected Supplier<WebDriver> driver;
    protected Safe<Actions> actions;
    protected String name = "";
    protected Object parent = null;
    protected JSImages imagesData;
    public int renderTimeout = 5000;
    protected String objectMap;

    public JSLight() {
        this(JDI::driver, new ArrayList<>());
    }
    public JSLight(Supplier<WebDriver> driver, List<By> locators) {
        this.driver = driver;
        this.engine = initEngine.apply(driver, locators);
        // this.js.multiSearch();
        this.actions = new Safe<>(() -> new Actions(driver()));
    }
    public JSLight(WebDriver driver, List<By> locators) {
        this(() -> driver, locators);
    }
    public JSLight(Supplier<WebDriver> driver, By... locators) {
        this(driver, newList(locators));
    }
    public JSLight(WebDriver driver, By... locators) {
        this(() -> driver, locators);
    }
    public JSLight(Object parent, By locator) {
        this(JDI::driver, locator);
        setParent(parent);
    }
    public JSLight(WebDriver driver, By locator, Object parent) {
        this(() -> driver, locator);
        setParent(parent);
    }
    public JSLight(Supplier<WebDriver> driver, By locator, Object parent) {
        this(driver, getLocators(locator, parent));
        this.parent = parent;
        if (parent != null && isInterface(parent.getClass(), HasCore.class)) {
            this.engine().updateDriver(((HasCore) parent).core().engine().jsDriver());
        }
    }

    public WebDriver driver() {
        return this.driver.get();
    }

    public JavascriptExecutor js() {
        return (JavascriptExecutor) driver();
    }

    public JS core() { return this; }

    public JS setCore(JS core) {
        if (!isClass(core.getClass(), JSLight.class)) {
            return this;
        }
        JSLight jsLight = (JSLight) core;
        this.engine = jsLight.engine;
        this.driver = jsLight.driver;
        this.actions = jsLight.actions;
        this.name = jsLight.name;
        this.parent = jsLight.parent;
        this.imagesData = jsLight.imagesData;
        this.renderTimeout = jsLight.renderTimeout;
        this.objectMap = jsLight.objectMap;
        return this;
    }
    // public void setCore(JS core) {
    //     List<Field> coreFields = getFieldsDeep(core);
    //     for (Field field : coreFields) {
    //         try {
    //             Field thisField = getClass().getField(field.getName());
    //             thisField.set(this, getValueField(field, core));
    //         } catch (Exception ignore) { }
    //     }
    // }

    /**
     * @param valueFunc = element !== null
     *        valueFunc = element !== null && styles.visibility === 'visible'
     *        ...
     * @return value
     */
    public String getElement(String valueFunc) {
        return engine().getValue(valueFunc);
    }

    public List<String> getList(String valueFunc) {
        return engine().getValues(valueFunc);
    }
    
    public String filterElements(String valueFunc) {
        return engine().firstValue(valueFunc);
    }

    /**
     * @param action = getAttribute('value')
     *        action = innerText;
     *        ...
     * @return value
     */
    public String getJSResult(String action) {
        return engine().getAttribute(action);
    }

    public JS set(String action) {
        return doAction(action);
    }

    public JS setOption(String option) {
        if (option == null) {
            return this;
        }
        return doAction("option.value = " + option + ";\nelement.dispatchEvent(new Event('change'));");
    }
    
    public JS selectByName(String name) {
        if (name == null) {
            return this;
        }
        return doAction("dispatchEvent(new Event('change'));\n" +
            "element.selectedIndex = [...element.options]" +
            ".findIndex(option => option.text === '" + name + "');\n" +
            "element.dispatchEvent(new Event('change'));");
    }

    public String selectedValueOption() {
        return core().getJSResult("selectedOptions[0].value").trim();
    }

    public String selectedOption() {
        return core().getJSResult("selectedOptions[0].innerText").trim();
    }

    public JS doAction(String action) {
        engine().doAction(action);
        return this;
    }

    public WebElement rawWe() {
        if (isEmpty(locators())) {
            throw new JDINovaException("Failed to use we() because element has no locators");
        }
        SearchContext ctx = driver();
        for (By locator : locators()) {
            ctx = ctx.findElement(locator);
        }
        return (WebElement) ctx;
    }

    public WebElement we() {
        Timer timer = new Timer(timeout);
        while (timer.isRunning()) {
            try {
                WebElement element = rawWe();
                element.getTagName();
                return element;
            } catch (Exception ignore) { }
        }
        return rawWe();
    }

    public JS actionsWithElement(BiFunction<Actions, WebElement, Actions> action) {
        action.apply(actions.get().moveToElement(this), this).build().perform();
        return this;
    }

    public JS actions(BiFunction<Actions, WebElement, Actions> action) {
        action.apply(actions.get(), this).build().perform();
        return this;
    }

    public String getName() {
        return isNotBlank(name)
            ? name
            : print(locators(), by -> JSDriverUtils.getByType(by) + ":" + JSDriverUtils.getByLocator(by), " > ");
    }

    public JS setName(String name) {
        this.name = name;
        return this;
    }

    public Object parent() {
        return this.parent;
    }

    public JS setParent(Object parent) {
        List<By> locators = getLocators(parent);
        locators.addAll(locators());
        setLocators(locators);
        this.parent = parent;
        if (parent != null && isInterface(parent.getClass(), HasCore.class)) {
            this.engine().updateDriver(((HasCore) parent).core().engine().jsDriver());
        }
        return this;
    }

    public void click() {
        doAction("click();");
    }
    
    public JS clickCenter() {
        return doAction("let rect = element.getBoundingClientRect();" +
            "let x = rect.x + rect.width / 2;" +
            "let y = rect.y + rect.height / 2;" +
            "document.elementFromPoint(x, y).click();");
    }
    
    public JS click(int x, int y) {
        engine().jsExecute("document.elementFromPoint(" + x + ", " + y + ").click();");
        return this;
    }

    public JS select() { click(); return this; }

    public JS select(String value) {
        if (value == null || isEmpty(locators())) {
            return this;
        }
        By lastLocator = last(locators());
        if (lastLocator.toString().contains("%s")) {
            List<By> locators = locators().size() == 1
                ? new ArrayList<>()
                : locators().subList(0, locators().size() - 2);
            locators.add(fillByTemplate(lastLocator, value));
            initJSFunc.apply(null, locators).click();
        } else {
            findFirst(textEquals(value)).click();
        }
        return this;
    }
    
    public JS selectSubList(String value) {
        if (value == null || isEmpty(locators())) {
            return this;
        }
        find(format(SELECT_FIND_TEXT_LOCATOR, value)).click();
        return this;
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
    
    public JS select(String... values) {
        if (isEmpty(values) || isEmpty(locators())) {
            return this;
        }
        By locator = last(locators());
        IJSBuilder builder = getByLocator(locator).contains("%s")
            ? getTemplateScriptForSelect(locator, values)
            : getScriptForSelect(values);
        builder.executeQuery();
        return this;
    }

    protected IJSBuilder getTemplateScriptForSelect(By locator, String... values) {
        IJSBuilder builder;
        String ctx;
        if (locators().size() == 1) {
            builder = engine().jsDriver().builder();
            ctx = "document";
        } else {
            builder = new JSDriver(engine().jsDriver().driver(), listCopyUntil(locators(), locators().size() - 1))
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

    protected IJSBuilder getScriptForSelect(String... values) {
        IJSBuilder builder = engine().jsDriver().buildOne();
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

    public JS check(boolean condition) {
        return doAction("checked=" + condition + ";");
    }

    public JS check() {
        return check(true);
    }
    
    public JS uncheck() {
        return check(false);
    }

    public JS rightClick() {
        return actionsWithElement(Actions::contextClick);
    }
    
    public JS doubleClick() {
        return actionsWithElement(Actions::doubleClick);
    }

    public JS hover() {
        return actions(Actions::moveToElement);
    }
    
    public JS dragAndDropTo(WebElement to) {
        return dragAndDropTo(to.getLocation().x, to.getLocation().y);
    }
    
    public JS dragAndDropTo(int x, int y) {
        return actions((a,e) -> a.dragAndDropBy(e, x, y));
    }

    public void submit() {
        click();
        // AFTER_SUBMIT_CHECK;
    }

    protected String charToString(CharSequence... value) {
        return value.length == 1 ? value[0].toString() : "";
    }

    public void sendKeys(CharSequence... value) {
        if (value == null) {
            return;
        }
        we().sendKeys(value);
    }

    public JS input(CharSequence... value) {
        if (value == null) {
            return this;
        }
        return set("setAttribute('value', '');\nelement.value='" + charToString(value) + "';\nelement.dispatchEvent(new Event('input'));");
    }

    public JS slide(String value) {
        throw new NotImplementedException();
        // TODO
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
        doAction("setAttribute('value', '');\nelement.value='';");
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
        return engine().getAsMap(valueFunc);
    }

    public String attr(String attrName) {
        return getAttribute(attrName);
    }

    public List<String> getAttributesAsList(String attr) {
        return engine().getAttributeList(attr);
    }

    public List<String> attrList(String attr) {
        return getAttributesAsList(attr);
    }

    public List<Json> getAttributesAsList(String... attributes) {
        return engine().getMultiAttributes(attributes);
    }

    public List<Json> attrList(String... attributes) {
        return getAttributesAsList(attributes);
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
        return getJSResult("hasAttribute('" + attrName + "')").equals("true");
    }

    public Json allAttributes() {
        return engine().getAsMap("return '{'+[...element.attributes].map((attr)=> `'${attr.name}'='${attr.value}'`).join()+'}'");
    }

    public String printHtml() {
        return MessageFormat.format("<{0} {1}>{2}</{0}>", getTagName().toLowerCase(),
            print(allAttributes(), el -> format("%s='%s'", el.key, el.value), " "),
            getJSResult("innerHTML"));
    }

    public JS show() {
        if (isDisplayed() && !isInView()) {
            doAction("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
        }
        return this;
    }
    
    public JS highlight(String color) {
        return show().set("styles.border='3px dashed "+color+"'");
    }

    public void highlight() {
        highlight("red");
    }

    public String cssStyle(String style) {
        return engine().getStyle(style);
    }
    
    public Json cssStyles(String... styles) {
        return engine().getStyles(styles);
    }
    
    public Json allCssStyles() {
        return engine().getAllStyles();
    }

    public boolean isSelected() {
        return getProperty("checked").equals("true") || getProperty("selected").equals("true");
    }

    public boolean isDeselected() {
        return !isSelected();
    }

    public boolean isEnabled() {
        return hasAttribute("enabled");
    }
    
    public JS setTextType(GetTextTypes textType) {
        this.textType = textType; return this;
    }

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
        return getElement(conditions.isDisplayed).equalsIgnoreCase("true");
    }

    public boolean isVisible() {
        return getElement(conditions.isVisible).equalsIgnoreCase("true");
    }

    public boolean isInView() {
        if (isHidden()) {
            return false;
        }
        Dimension visibleRect = getSize();
        return visibleRect.height > 0 && visibleRect.width > 0;
    }

    public boolean isExist() {
        return engine().jsDriver().getSize() > 0;
    }

    public Point getLocation() {
        ClientRect rect = getClientRect();
        int x, y;
        if (inVision(rect)) {
            return new Point(-1, -1);
        }
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

    protected int getWidth(ClientRect rect) {
        int left = max(rect.left, 0);
        int right = min(rect.right, rect.windowWidth);
        return right - left;
    }

    protected int getHeight(ClientRect rect) {
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
        return new ClientRect(engine().getJson("let rect = element.getBoundingClientRect();\n" +
            "return { x: rect.x, y: rect.y, top: rect.top, bottom: rect.bottom, left: rect.left, right: rect.right, " +
            "wWidth: window.innerWidth, wHeight: window.innerHeight };"));
    }

    public String getCssValue(String style) {
        return engine().getStyle(style);
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
            return (X) screen.asFile(IMAGE_TEMPLATE.apply("", this));
        }
        throw new JDINovaException("Failed to get screenshot - unknown type: " + outputType);
    }

    protected String canvas2Image(ImageTypes imageType) {
        return "toDataURL('" + imageType.value + "')";
    }

    protected String element2Image(ImageTypes imageType) {
        return "html2canvas(element).then((canvas) => canvas."+canvas2Image(imageType)+")";
    }

    public StreamToImageVideo makeScreenshot() {
        return makeScreenshot(DEFAULT_IMAGE_TYPE);
    }
    
    public File makeScreenshot(String tag) {
        show();
        File imageFile = makeScreenshot().asFile(getScreenshotName(tag));
        imagesData().images.update(tag, imageFile.getPath());
        imagesData().imageFile = imageFile;
        return imageFile;
    }

    protected String getScreenshotName(String tag) {
        return IMAGE_TEMPLATE.apply(tag, this);
    }

    public StreamToImageVideo makeScreenshot(ImageTypes imageType) {
        String stream = getElement("if (element.toDataURL) { return element."+canvas2Image(imageType)+"; }\n"
            + "try { return " + element2Image(imageType) + "; } catch {\n"
            + "return await import(`https://html2canvas.hertzen.com/dist/html2canvas.min.js`).then("
            + "() => " + element2Image(imageType) + ") }"
        );
        return new StreamToImageVideo(stream, imageType);
    }

    public JS startRecording() {
        return startRecording(VIDEO_WEBM);
    }

    public JS startRecording(ImageTypes imageType) {
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
        if (!value.equals("start recording")) {
            throw new JDINovaException(value);
        }
        return this;
    }

    public StreamToImageVideo stopRecordingAndSave(ImageTypes imageType) {
        engine().jsExecute("window.jdiRecorder.stop();");
        String stream = "";
        Timer timer = new Timer(renderTimeout);
        while (stream.length() < 10 && timer.isRunning()) {
            stream = engine().jsExecute("return window.jdiVideoBase64;");
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
        engine().jsExecute("await import(`https://html2canvas.hertzen.com/dist/html2canvas.min.js`)");
        getElement(Whammy.script);
        Timer.sleep((sec+5) * 1000L);
        engine().jsExecute("jdi.recording = false; jdi.compile();");
        String stream = "";
        Timer timer = new Timer(renderTimeout);
        while (stream.length() < 10 && timer.isRunning()) {
            stream = engine().jsExecute("return jdi.videoBase64");
        }
        return new StreamToImageVideo(stream, VIDEO_WEBM);
    }
    
    public JS setObjectMapping(String objectMap, Class<?> cl) {
        this.objectMap = objectMap;
        this.engine().setupEntity(cl);
        return this;
    }
    
    public JsonObject getJSObject(String json) {
        return engine().getJson(json);
    }

    public <T> T getEntity(Class<T> cl) {
        return getEntity(GET_OBJECT_MAP.apply(cl), cl);
    }

    public <T> T getEntity() {
        return engine().getEntity(objectMap);
    }

    public <T> T getEntity(String objectMap, Class<?> cl) {
        engine().setupEntity(cl);
        return engine().getEntity(objectMap);
    }

    public void setEntity(String objectMap) {
        engine().getAsMap(objectMap);
    }

    public JS find(String by) {
        return find(NAME_TO_LOCATOR.apply(by));
    }

    public JS find(By by) {
        return initJSFunc.apply(by, null)
                .setParent(this);
    }
    
    public JS children() {
        return find("*");
    }
    
    public JS ancestor() {
        return find("/..");
    }
    
    public List<String> values(GetTextTypes getTextType) {
        return engine().getAttributeList(getTextType.value);
    }

    public List<String> values() {
        return values(textType);
    }
    
    public int size() {
        return engine().getSize();
    }
    
    public List<JsonObject> getObjectList(String json) {
        return engine().getJsonList(json);
    }
    
    public <T> List<T> getEntityList() {
        return engine().getEntityList(objectMap);
    }
    
    public void setEntity() {
        engine().getAsMap(objectMap);
    }

    public <T> List<T> getEntityList(Class<T> cl) {
        return getEntityList(GET_OBJECT_MAP.apply(cl), cl);
    }
    
    public JS fill(Object obj) {
        return setEntity(obj);
    }
    
    public JS submit(Object obj, String locator) {
        setEntity(obj);
        find(locator).click();
        return this;
    }
    
    public JS submit(Object obj) {
        return submit(obj, SUBMIT_LOCATOR);
    }
    
    public JS loginAs(Object obj, String locator) {
        return submit(obj, locator);
    }
    
    public JS loginAs(Object obj) {
        return submit(obj);
    }
    
    public JS setEntity(Object obj) {
        Field[] allFields = obj.getClass().getDeclaredFields();
        List<String> mapList = new ArrayList<>();
        for (Field field : allFields) {
            Object fieldValue = getValueField(field, obj);
            if (fieldValue == null) {
                continue;
            }
            String value = SET_COMPLEX_VALUE.apply(field, fieldValue);
            if (value != null) {
                mapList.add(value);
            }
        }
        setEntity(print(mapList, ";\n") + ";\nreturn ''");
        return this;
    }
    
    public <T> List<T> getEntityList(String objectMap, Class<?> cl) {
        engine().setupEntity(cl);
        return engine().getEntityList(objectMap);
    }
    
    public JS setEntityList(String objectMap) {
        engine().setMap(objectMap);
        return this;
    }
    
    public JS findFirst(String by, Function<JS, String> condition) {
        return findFirst(NAME_TO_LOCATOR.apply(by), condition.apply(this));
    }
    
    public JS findFirst(By by, Function<JS, String> condition) {
        return findFirst(by, condition.apply(this));
    }
    
    public JS findFirst(String by, String condition) {
        return findFirst(NAME_TO_LOCATOR.apply(by), condition);
    }
    
    public JS get(int index) {
        JS js = listToOne("element = elements[" + index + "];\n");
        js.setName(format("%s[%s]",getName(), index));
        return js;
    }
    
    public JS get(String by, int index) {
        return get(NAME_TO_LOCATOR.apply(by), index);
    }
    
    public JS get(By by, int index) {
        String script = "element = elements.filter(e => "+
                MessageFormat.format(dataType(by).get, "e", selector(by, engine().jsDriver().builder()))+
                ")[" + index + "];\n";
        return listToOne(script)
            .setName(format("%s[%s]",getName(), index)).core();
    }
    
    public JS get(Function<JS, String> filter) {
        return findFirst(filter);
    }
    
    public JS get(String value) {
        JS js = get(textEquals(value));
        js.setName(format("%s[%s]",getName(), value));
        return js;
    }
    
    public JS findFirst(Function<JS, String> condition) {
        return findFirst(condition.apply(this));
    }
    
    public JS findFirst(String condition) {
        return listToOne("element = elements.find(e => e && " + handleCondition(condition, "e") + ");\n");
    }

    protected String handleCondition(String condition, String elementName) {
        return condition.contains("#element#")
            ? condition.replace("#element#", elementName)
            : elementName + "." + condition;
    }
    
    public JS findFirst(By by, String condition) {
        String script = "element = elements.find(e => { const fel = " +
            MessageFormat.format(dataType(by).get, "e", selector(by, engine().jsDriver().builder())) + "; " +
            "return fel && " + handleCondition(condition, "fel") + "; });\n";
        return listToOne(script);
    }
    
    public long indexOf(Function<JS, String> condition) {
        return engine().jsDriver().indexOf(condition.apply(this));
    }

    protected JS listToOne(String script) {
        JS result = initJSFunc.apply(null, null);
        result.engine().jsDriver().setScriptInElementContext(engine().jsDriver(), script);
        engine().jsDriver().builder().cleanup();
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
        return isClickable(dimension.getWidth() / 2, dimension.getHeight() / 2 - 1);
    }
    
    public JS uploadFile(String filePath) {
        we().click();
        String pathToPaste = new File(filePath).getAbsolutePath();
        pasteText(pathToPaste);
        return this;
    }
    
    public JS press(Keys key) {
        Keyboard.press(key);
        return this;
    }
    
    public JS keyboardCommands(String... commands) {
        Keyboard.commands(commands);
        return this;
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
        return engine().color();
    }
    
    public String bgColor() {
        return engine().bgColor();
    }
    
    public String pseudo(String name, String value) {
        return engine().pseudo(name, value);
    }
    
    public JS focus() {
        doAction("dispatchEvent(new Event('focus', { 'bubbles': true }));");
        return this;
    }
    
    public JS blur() {
        doAction("dispatchEvent(new Event('blur', { 'bubbles': true }));");
        return this;
    }
    
    public boolean focused() {
        return getElement("element === document.activeElement").equalsIgnoreCase("true");
    }
    
    public List<By> locators() {
        return engine().jsDriver().locators();
    }

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
    
    public JS visualValidation() {
        visualValidation("");
        return this;
    }
    
    public JS visualValidation(String tag) {
        VISUAL_VALIDATION.accept(tag, this);
        return this;
    }
    
    public JS visualCompareWith(JS element) {
        COMPARE_IMAGES.apply(imagesData().imageFile, element.imagesData().imageFile);
        return this;
    }

    public Direction getDirectionTo(WebElement element) {
        Rectangle elementCoordinates = getRect();
        Rectangle destinationCoordinates = element.getRect();
        Direction direction = new Direction(getCenter(elementCoordinates), getCenter(destinationCoordinates));
        if (isInterface(element.getClass(), HasCore.class)) {
            JS core = ((HasCore)element).core();
            if (relations == null) {
                relations = new MapArray<>(core.getFullName(), direction);
            } else {
                relations.update(core.getFullName(), direction);
            }
        }
        return direction;
    }

    public boolean relativePosition(JS element, Direction expected) {
        return COMPARE_POSITIONS.apply(getDirectionTo(element), expected);
    }

    public OfElement isOn(Function<Direction, Boolean> expected) {
        return new OfElement(expected, this);
    }
    
    public boolean relativePosition(JS element, Function<Direction, Boolean> expected) {
        return expected.apply(getDirectionTo(element));
    }

    public MapArray<String, Direction> relations;

    public JS clearRelations() {
        relations = null;
        return this;
    }
    
    public MapArray<String, Direction> getRelativePositions(JS... elements) {
        relations = new MapArray<>();
        for (JS element : elements) {
            relations.update(element.getName(), getDirectionTo(element));
        }
        storeRelations(this, relations);
        return relations;
    }

    protected boolean similar(Pair<String, Direction> relation, Direction expectedRelation) {
        return VECTOR_SIMILARITY.apply(relation.value, expectedRelation);
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
        MapArray<String, Direction> newRelations = getRelations(storedRelations, failures);
        if (isNotEmpty(newRelations)) {
            storeRelations(this, newRelations);
        }
        return failures;
    }

    protected MapArray<String, Direction> getRelations(MapArray<String, Direction> storedRelations, List<String> failures) {
        MapArray<String, Direction> newRelations = new MapArray<>();
        for (Pair<String, Direction> relation : relations) {
            if (storedRelations.has(relation.key)) {
                checkRelations(storedRelations.get(relation.key), relation, failures);
            } else {
                newRelations.add(relation);
            }
        }
        return newRelations;
    }

    protected void checkRelations(Direction expectedRelation,  Pair<String, Direction> relation, List<String> failures) {
        if (similar(relation, expectedRelation)) {
            return;
        }
        failures.add(format("Elements '%s' and '%s' are misplaced: angle: %s => %s; length: %s => %s",
            getFullName(), relation.key, relation.value.angle(), expectedRelation.angle(),
            relation.value.length(), expectedRelation.length()));
    }
    
    public Point getCenter() {
        return getCenter(getRect());
    }

    protected Point getCenter(Rectangle rect) {
        int x = rect.x + rect.width / 2;
        int y = rect.y + rect.height / 2;
        return new Point(x, y);
    }
    
    public JSEngine engine() {
        return engine;
    }

    public String textType() {
        return textType.value;
    }
}
