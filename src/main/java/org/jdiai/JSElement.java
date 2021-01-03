package org.jdiai;

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc2;
import org.jdiai.interfaces.HasLocators;
import org.jdiai.jselement.JSSmart;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.jdiai.GetTextTypes.VALUE;
import static org.jdiai.ImageTypes.*;
import static org.openqa.selenium.OutputType.*;

public class JSElement implements WebElement {
    public final JSSmart js;
    private final WebDriver driver;
    private final List<By> locators;
    private final Safe<Actions> actions;
    private String name = "";

    public JSElement(WebDriver driver, By locator) {
        this(driver, locator, null);
    }
    public JSElement(WebDriver driver, By locator, HasLocators parent) {
        if (parent != null) {
            List<By> pLocators = parent.locators();
            this.locators = pLocators != null && pLocators.size() > 0
                ? pLocators : new ArrayList<>();
        } else {
            this.locators = new ArrayList<>();
        }
        this.locators.add(locator);
        this.js = new JSSmart(driver, locators);
        this.js.multiSearch();
        this.driver = driver;
        this.actions = new Safe<>(() -> new Actions(driver));
    }
    protected String jsResult(String action) {
        return js.getAttribute(action);
    }
    protected void doJSAction(String action) {
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
    public JSElement setName(String name) {
        this.name = name;
        return this;
    }

    public void click() {
        doJSAction("click()");
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

    public void submit() {
        doJSAction("submit()");
    }

    public void sendKeys(CharSequence... value) {
        // jsGet("val('" + value + "')");
        // jsGet("setAttribute('value', '"+value+"')");
        // jsResult("value='"+value+"'");
        String text = value.length == 1 ? value[0].toString() : "";
        js.jsDriver().builder().oneToOne("document", locators.get(0))
            .addJSCode("element.value='" + text + "';\n").trigger("change");
    }

    public void slide(String value) {
        //Actions a = new Actions(DRIVER.get());
        //a.dragAndDropBy(DRIVER.get().findElement(By.xpath("[aria-labelledby='range-slider'][data-index='0']")),20, 0)
        //        .build().perform();
        //js.jsDriver().builder().oneToOne("document", locators.get(0))
        //        .addJSCode("element.value='" + value + "';\n")
        //        .trigger("mousedown")
        //        .trigger("mousemove", "which: 1, pageX: 460");
        //.trigger("mousedown")
        //        .trigger("mousemove", { which: 1, pageX: 460 })
    }
    public void clear() {
        doJSAction("clear()");
    }

    public String getTagName() {
        return jsResult("tagName");
    }

    public String getAttribute(String name) {
        return jsResult("getAttribute('" + name + "')");
    }

    public boolean isSelected() {
        return isNotBlank(getAttribute("selected"));
    }

    public boolean isEnabled() {
        return isNotBlank(getAttribute("enabled"));
    }
    public JSElement setGetTextType(GetTextTypes getTextType) { this.getTextType = getTextType; return this; }

    protected GetTextTypes getTextType;
    public String getText() {
        return getText(getTextType);
    }
    public String getText(GetTextTypes textType) {
        return textType == VALUE
            ? getAttribute("value")
            : jsResult(getTextType.value);
    }

    public List<WebElement> findElements(By by) {
        return we().findElements(by);
    }

    public WebElement findElement(By by) {
        return we().findElement(by);
    }

    public boolean isDisplayed() {
        return js.getValue("element !== null && " +
            "getComputedStyle(element).visibility === 'visible' && " +
            "getComputedStyle(element).display !== 'none'").equalsIgnoreCase("true");
    }

    public Point getLocation() {
        ClientRect rect = getClientRect();
        int x, y;
        if (rect.x >= rect.windowHeight || rect.y >= rect.windowWidth)
            return new Point(-1, -1);
        x = rect.bottom < rect.windowHeight
            ? rect.x + (rect.bottom - rect.top)/2
            : rect.x + (rect.windowHeight - rect.top)/2;
        y = rect.right < rect.windowWidth
            ? rect.y + (rect.right - rect.left)/2
            : rect.y + (rect.windowWidth - rect.left)/2;
        return x < 0 || y < 0 ? new Point(-1, -1) : new Point(x, y);
    }

    public Dimension getSize() {
        ClientRect rect = getClientRect();
        int width, height;
        if (rect.x >= rect.windowHeight || rect.y >= rect.windowWidth)
            return new Dimension(0, 0);
        width = getWidth(rect);
        height = getHeight(rect);
        return new Dimension(width, height);
    }
    private int getWidth(ClientRect rect) {
        return rect.right < rect.windowWidth ? rect.right - rect.left : rect.windowWidth - rect.left;
    }
    private int getHeight(ClientRect rect) {
        return rect.right < rect.windowWidth ? rect.right - rect.left : rect.windowWidth - rect.left;
    }
    public Rectangle getRect() {
        ClientRect rect = getClientRect();
        return rect.x >= rect.windowHeight || rect.y >= rect.windowWidth
            ? new Rectangle(-1, -1, -1, -1)
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
        StreamToImageVideo screen = makeScreenshot(PNG);
        if (outputType == BASE64) {
            return (X) screen.asBase64();
        }
        if (outputType == BYTES) {
            return (X) screen.asByteStream();
        }
        if (outputType == FILE) {
            return (X) screen.asFile(screenshotName());
        }
        throw new JSException("Failed to get screenshot - unknown type: " + outputType);
    }
    private String screenshotName() {
        String name = isNotBlank(this.name) ? this.name : "screen";
        return name + currentTimeMillis();
    }
    private String canvas2Image(ImageTypes imageType) {
        return "toDataURL('" + imageType.value + "')";
    }
    private String element2Image(ImageTypes imageType) {
        return "html2canvas(element).then((canvas) => canvas."+canvas2Image(imageType)+")";
    }
    public StreamToImageVideo makeScreenshot() {
        return makeScreenshot(JPG);
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
    public JSElement setObjectMapping(String objectMap, Class<?> cl) {
        this.objectMap = objectMap;
        this.js.setEntity(cl);
        return this;
    }
    public <T> T getAsObject() {
        return js.getEntity(objectMap);
    }
    public <T> T getAsObject(String objectMap, Class<?> cl) {
        js.setEntity(cl);
        return js.getEntity(objectMap);
    }
}
