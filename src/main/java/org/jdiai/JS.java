package org.jdiai;

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.jdiai.interfaces.HasLocators;
import org.jdiai.interfaces.HasName;
import org.jdiai.interfaces.HasParent;
import org.jdiai.jswrap.JSSmart;
import org.jdiai.scripts.Whammy;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.copyList;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.jdiai.Direction.VECTOR_SIMILARITY;
import static org.jdiai.GetTextTypes.INNER_TEXT;
import static org.jdiai.ImageTypes.VIDEO_WEBM;
import static org.jdiai.RelationsManager.*;
import static org.jdiai.VisualSettings.*;
import static org.jdiai.WebDriverByUtils.NAME_TO_LOCATOR;
import static org.openqa.selenium.OutputType.*;

public class JS implements WebElement, HasLocators, HasName<JS>, HasParent {
    public static String JDI_STORAGE = "src/test/jdi";
    public final JSSmart js;
    private final WebDriver driver;
    private final List<By> locators;
    private final Safe<Actions> actions;
    private String name = "";
    private Object parent = null;

    public JS(WebDriver driver, List<By> locators) {
        this.locators = locators;
        this.driver = driver;
        this.js = new JSSmart(driver, locators);
        this.js.multiSearch();
        this.actions = new Safe<>(() -> new Actions(driver));
    }
    public JS(WebDriver driver, By... locators) {
        this(driver, newList(locators));
    }
    public JS(WebDriver driver, By locator, Object parent) {
        this(driver, locatorsFromParent(locator, parent)); this.parent = parent;
    }
    private static List<By> locatorsFromParent(By locator, Object parent) {
        List<By> locators;
        if (parent != null && isInterface(parent.getClass(), HasLocators.class)) {
            List<By> pLocators = ((HasLocators)parent).locators();
            locators = pLocators != null && pLocators.size() > 0
                    ? copyList(pLocators) : new ArrayList<>();
        } else {
            locators = new ArrayList<>();
        }
        locators.add(locator);
        return locators;
    }
    public String getJSResult(String action) {
        return js.getAttribute(action);
    }
    public void set(String action) {
        doAction(action);
    }
    public void doAction(String action) {
        js.getAttribute(action);
    }
    public WebElement we() {
        SearchContext ctx = driver;
        for (By locator : locators) {
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
    public String getName() { return name; }
    public JS setName(String name) {
        this.name = name;
        return this;
    }
    public String getFullName() {
        String name = "";
        if (parent() != null) {
            name += isInterface(parent().getClass(), HasName.class)
                ? ((HasName<?>)parent()).getName()
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
        js.jsDriver().builder().setTemplate(value);
        click();
    }
    public void select(String... names) {
        for (String name : names)
            select(name);
    }
    public <TEnum extends Enum<?>> void select(TEnum name) {
        select(getEnumValue(name));
    }
    public void check() {
        if (isDeselected())
            click();
    }
    public void uncheck() {
        if (isSelected())
            click();
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
        String text = value.length == 1 ? value[0].toString() : "";
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
    public String attr(String attrName) {
        return getAttribute(attrName);
    }
    public List<String> classes() {
        String cl = attr("class");
        return cl.length() > 0
                ? newList(cl.split(" "))
                : new ArrayList<>();
    }
    public boolean hasClass(String className) {
        return classes().contains(className);
    }
    public boolean hasAttribute(String attrName) {
        return isNotBlank(attr(attrName));
    }

    public Json getAllAttributes() {
        return js.getMap("return [...element.attributes].reduce((map,attr)=> { map[attr.name]=attr.value; return map; }, {})");
    }
    public String printHtml() {
        return MessageFormat.format("<{0} {1}>{2}</{0}>", getTagName().toLowerCase(),
            print(getAllAttributes(), el -> format("%s='%s'", el.key, el.value), " "),
            getJSResult("innerHTML"));
    }
    public void show() {
        if (isDisplayed() && !isVisible()) {
            doAction("scrollIntoView({behavior:'auto',block:'center',inline:'center'})");
        }
    }
    public void highlight(String color) {
        show();
        set("style.border='3px dashed "+color+"'");
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
    public Json allCssStyles(String... style) {
        return js.getAllStyles();
    }

    public boolean isSelected() {
        return isNotBlank(getAttribute("selected"));
    }
    public boolean isDeselected() {
        return !isSelected();
    }
    public boolean isEnabled() {
        return isNotBlank(getAttribute("enabled"));
    }
    public JS setGetTextType(GetTextTypes getTextType) { this.getTextType = getTextType; return this; }

    protected GetTextTypes getTextType = INNER_TEXT;
    public String getText() {
        return getText(getTextType);
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
        return js.getValue("let styles = getComputedStyle(element);\n" +
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
        String stream = js.getValue("if (element.toDataURL) { return element."+canvas2Image(imageType)+"; }\n"
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
        String value = js.getValue("let blobs = [];\n" +
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
    public int renderTimeout = 5000;
    public StreamToImageVideo stopRecordingAndSave(ImageTypes imageType) {
        js.jsExecute("window.jdiRecorder.stop();");
        String stream = "";
        Timer timer = new Timer(renderTimeout);
        while (stream.length() < 10 && !timer.timeoutPassed()) {
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
        Timer.sleep((sec+1) * 1000);
        return stopRecordingAndSave(imageType);
    }
    // TODO Experimental record video for any element
    public StreamToImageVideo recordVideo(int sec) {
        js.jsExecute("await import(`https://html2canvas.hertzen.com/dist/html2canvas.min.js`)");
        js.getValue(Whammy.script);
        Timer.sleep((sec+5) * 1000);
        js.jsExecute("jdi.recording = false; jdi.compile();");
        String stream = "";
        Timer timer = new Timer(renderTimeout);
        while (stream.length() < 10 && !timer.timeoutPassed()) {
            stream = js.jsExecute("return jdi.videoBase64");
        }
        return new StreamToImageVideo(stream, VIDEO_WEBM);
    }

    protected String objectMap;
    public JS setObjectMapping(String objectMap, Class<?> cl) {
        this.objectMap = objectMap;
        this.js.setEntity(cl);
        return this;
    }
    public <T> T getEntity() {
        return js.getEntity(objectMap);
    }
    public <T> T getEntity(String objectMap, Class<?> cl) {
        js.setEntity(cl);
        return js.getEntity(objectMap);
    }

    public JS find(String by) {
        return find(NAME_TO_LOCATOR.execute(by));
    }
    public JS find(By by) {
        return new JS(this.driver, by, this);
    }
    public JS firstChild() { return find("*"); }

    public JS findFirst(By by) {
        return new JS(driver, by, this);
    }
    // TODO
    // public WebList finds(@MarkupLocator String by) {
    //     return $$(by, this);
    // }
    // public WebList finds(@MarkupLocator By by) {
    //     return $$(by, this);
    // }
    // public WebList children() { return finds("*"); }

    public boolean isClickable() {
        Dimension dimension = getSize();
        if (dimension.getWidth() == 0) return false;
        return isClickable(dimension.getWidth()/2, dimension.getHeight()/2-1);
    }
    public boolean isClickable(int x, int y) {
        return js.getValue("rect = element.getBoundingClientRect();\n" +
            "cx = rect.left + "+x+";\n" +
            "cy = rect.top + "+y+";\n" +
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

    public List<By> locators() { return locators; }
    protected MapArray<String, String> images;
    protected File imageFile;

    public File getImageFile() {
        return getImageFile("");
    }
    public File getImageFile(String tag) {
        return images.has(tag) ? new File(images.get(tag)) : null;
    }
    public void visualValidation() {
        visualValidation("");
    }
    public void visualValidation(String tag) {
        VISUAL_VALIDATION.execute(tag, this);
    }
    public void visualCompareWith(JS element) {
        COMPARE_IMAGES.execute(imageFile, element.imageFile);
    }
    public Direction getDirectionTo(JS element) {
        ClientRect destinationCoordinates = element.getClientRect();
        ClientRect elementCoordinates = getClientRect();
        Direction direction = new Direction(getCenter(elementCoordinates) , getCenter(destinationCoordinates));
        if (relations == null) {
            new MapArray<>(element.getFullName(), direction);
        } else {
            relations.update(element.getName(), direction);
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
    public MapArray<String, Direction> getRelativePosition(JS... elements) {
        relations = new MapArray<>();
        for (JS element : elements) {
            relations.update(element.getName(), getDirectionTo(element));
        }
        storeRelations(this, relations);
        return relations;
    }
    public List<String> validateRelations() {
        MapArray<String, Direction> storedRelations = readRelations(this);
        if (storedRelations.size() == 0) {
            return newList("No relations found in: " + RELATIONS_STORAGE);
        }
        List<String> failures = new ArrayList<>();
        if (relations == null || relations.size() == 0) {
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
        if (newRelations.size() > 0) {
            storeRelations(this, newRelations);
        }
        return failures;
    }

    protected Point getCenter(ClientRect rect) {
        int x = rect.left + (rect.right - rect.left) / 2;
        int y = rect.top + (rect.bottom - rect.top) / 2;
        return new Point(x, y);
    }

}
