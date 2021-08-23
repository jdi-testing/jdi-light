package com.jdiai.jsdriver;

import com.jdiai.jsbuilder.*;
import com.jdiai.jsproducer.JSListProducer;
import com.jdiai.jsproducer.JSProducer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.tools.LinqUtils.*;
import static com.jdiai.jsbuilder.ListSearch.CHAIN;
import static com.jdiai.jsbuilder.ListSearch.MULTI;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static com.jdiai.jsdriver.RuleType.Element;
import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class JSDriver {
    private final Supplier<WebDriver> driver;
    protected List<By> locators;
    protected List<JSRule> rules;
    protected IJSBuilder builder;
    public ListSearch strategy = CHAIN;
    public String context = "document";

    public JSDriver(Supplier<WebDriver> driver, IJSBuilder builder) {
        this(driver, null, builder);
    }

    public JSDriver(Supplier<WebDriver> driver, By... locators) {
        this(driver, newList(locators), defaultBuilder(driver));
    }

    public JSDriver(WebDriver driver, By... locators) {
        this(() -> driver, locators);
    }

    public JSDriver(Supplier<WebDriver> driver, List<By> locators) {
        this(driver, locators, defaultBuilder(driver));
    }

    public JSDriver(WebDriver driver, List<By> locators) {
        this(() -> driver, locators);
    }

    public JSDriver(Supplier<WebDriver> driver, List<By> locators, IBuilderActions actions) {
        this(driver, locators, new JSBuilder(driver, actions));
    }

    public JSDriver(WebDriver driver, List<By> locators, IBuilderActions actions) {
        this(() -> driver, locators, actions);
    }

    public JSDriver(WebDriver driver, List<By> locators, IJSBuilder builder) {
        this(() -> driver, locators, builder);
    }

    public JSDriver(Supplier<WebDriver> driver, List<By> locators, IJSBuilder builder) {
        if (driver == null) {
            throw new JDINovaException("JSDriver init failed: WebDriver == null");
        }
        this.driver = driver;
        this.rules = locators != null
            ? map(locators, JSRule::new)
            : new ArrayList<>();
        this.builder = builder;
    }

    public IJSBuilder buildOne() {
        return build(RuleType.Element);
    }

    public IJSBuilder buildList() {
        return build(RuleType.List);
    }

    protected IJSBuilder build(RuleType last) {
        if (isEmpty(rules)) {
            return builder();
        }
        IJSBuilder builder = builder();
        String ctx = "document";
        int funcNumber = 0;
        for(int i = 0; i < rules.size(); i++) {
            JSRule rule = rules.get(i);
            JSRule nextRule = i < rules.size() - 1 ? rules.get(i + 1) : null;
            if (rule.isLocator()) {
                BCF result = processLocator(builder, ctx, rule, nextRule, strategy, last, funcNumber);
                builder = result.builder;
                ctx = result.context;
                if (result.hasFunction) {
                    funcNumber++;
                }
            } else {
                builder.addJSCode(rule.script);
                ctx = "element";
            }
        }
        return builder;
    }

    protected BCF processLocator(IJSBuilder builder, String ctx, JSRule rule, JSRule nextRule, ListSearch strategy, RuleType last, int funcNum) {
        RuleType nextExpect = getNextExpect(nextRule, last, strategy);
        boolean isElement = ctx.equals("document") || ctx.equals("element");
        if (rule.filter != null) {
            String filterName = "filter" + (funcNum > 0 ? funcNum : "");
            builder.registerFunction(filterName, filterName + " = function (element) {\n  " + rule.filter + "\n}\n");
            if (nextExpect == Element) {
                return new BCF("element", isElement
                    ? builder.oneToOneFilter(ctx, rule.locator, filterName)
                    : builder.listToOneFilter(rule.locator, filterName),
                    true
                );
            }
            return new BCF("elements", isElement
                ? builder.oneToListFilter(ctx, rule.locator, filterName)
                : builder.listToListFilter(rule.locator, filterName),
                true
            );
        }
        if (nextExpect == Element) {
            return new BCF("element", isElement
                ? builder.oneToOne(ctx, rule.locator)
                : builder.listToOne(rule.locator),
                false
            );
        }
        return new BCF("elements", isElement
            ? builder.oneToList(ctx, rule.locator)
            : builder.listToList(rule.locator),
            false
        );
    }

    protected RuleType getNextExpect(JSRule nextRule, RuleType last, ListSearch strategy) {
        if (nextRule == null) {
            return last == RuleType.Element
                ? RuleType.Element
                : RuleType.List;
        }
        if (nextRule.isScript()) {
            if (nextRule.previous == RuleType.Element) {
                return RuleType.Element;
            }
            if (nextRule.previous == RuleType.List) {
                return RuleType.List;
            }
        }
        return strategy == CHAIN
            ? RuleType.Element
            : RuleType.List;
    }

    private static IJSBuilder defaultBuilder(Supplier<WebDriver> driver) {
        return new JSBuilder(driver, new BuilderActions());
    }

    static Pattern idMatcher = compile("^#(?<id>[a-zA-Z][a-zA-Z0-9]*([-_:][a-zA-Z0-9]+)*)$");
    static Pattern csMatcher = compile("^.(?<class>[a-z][a-z0-9]*([-_:][a-z0-9]+)*)$");

    public JSDriver addRule(By locator) {
        rules.add(new JSRule(locator));
        return this;
    }
    public JSDriver addRule(String script) {
        return addRule(script, null);
    }

    public JSDriver addRule(String script, RuleType previous) {
        rules.add(new JSRule(script, previous));
        return this;
    }

    public void replaceLastLocator(String value) {
        List<JSRule> result = new ArrayList<>();
        for(JSRule rule : rules) {
            if (rule.isLocator() && getByLocator(rule.locator).contains("%s")) {
                result.add(new JSRule(fillByTemplate(rule.locator, value)));
            } else {
                result.add(rule);
            }
        }
        rules = result;
    }

    public JSDriver setRules(List<JSRule> rules) {
        if (rules == null) {
            this.rules = new ArrayList<>();
            return this;
        }
        this.rules = processRules(rules);
        return this;
    }

    protected List<JSRule> processRules(List<JSRule> rules) {
        List<JSRule> result = new ArrayList<>();
        boolean hasScript = false;
        for (JSRule rule : rules) {
            if (rule.isLocator()) {
                By locator = locatorFromRule(rule.locator);
                if (!hasScript && getByType(locator).equals("id")) {
                    result = new ArrayList<>();
                }
                result.add(new JSRule(locator, rule.filter));
            } else {
                hasScript = true;
                result.add(new JSRule(rule.script));
            }
        }
        return result;
    }

    protected By locatorFromRule(By locator) {
        Matcher matcher = idMatcher.matcher(getByLocator(locator));
        if (matcher.matches()) {
            return By.id(matcher.group("id"));
        }
        matcher = csMatcher.matcher(getByLocator(locator));
        if (matcher.matches()) {
            return By.className(matcher.group("class"));
        }
        return locator;
    }

    public JSDriver setLocators(List<By> locators) {
        if (locators == null) {
            this.locators = null;
            return this;
        }
        List<By> result = new ArrayList<>();
        for (By locator : locators) {
            Matcher matcher = idMatcher.matcher(getByLocator(locator));
            if (matcher.matches()) {
                locator = By.id(matcher.group("id"));
            }
            matcher = csMatcher.matcher(getByLocator(locator));
            if (matcher.matches()) {
                locator = By.className(matcher.group("class"));
            }
            if (getByType(locator).equals("id")) {
                result = new ArrayList<>();
            }
            result.add(locator);
        }
        this.locators = result;
        return this;
    }

    public JSDriver updateBuilderActions(IBuilderActions actions) {
        this.builder().updateActions(actions);
        return this;
    }

    public JSDriver setBuilder(IJSBuilder builder) {
        this.builder = builder.copy();
        return this;
    }

    public JSDriver elementCtx() {
        context = "element";
        return this;
    }

    protected IJSBuilder getBuilder() {
        JSRule lastRule = lastRule();
        return lastRule != null && lastRule.previous == RuleType.List
            ? buildList() : buildOne();
    }

    public void doAction(String collector) {
        getBuilder().doAction(collector).executeQuery();
    }

    public JSProducer getOne(String collector) {
        return new JSProducer(getBuilder().getResult(collector).executeQuery());
    }

    public JSListProducer getList(String collector) {
        return new JSListProducer(buildList().getResultList(collector).executeAsList());
    }

    public JSProducer getFirst(String collector) {
        return new JSProducer(buildList().getResult(collector).executeQuery());
    }

    public int getSize() {
        try {
            return ((Long) buildList().getResult("return elements.length;").executeQuery()).intValue();
        } catch (Exception ignore) {
            return -1;
        }
    }

    public long indexOf(String condition) {
        try {
            return (Long) buildList().addJSCode("return elements.findIndex(e => e && e." + condition + ");\n").executeQuery();
        } catch (Exception ignore) {
            return -1;
        }
    }
    
    public JSDriver multiSearch() {
        strategy = MULTI;
        return this;
    }

    public WebDriver driver() {
        return this.driver.get();
    }

    public IJSBuilder builder() {
        if (builder == null) {
            builder = new JSBuilder(driver);
        }
        return builder;
    }

    public List<By> locators() {
        return ifSelect(rules, JSRule::isLocator, r -> r.locator);
    }

    public JSDriver setFilter(String filter) {
        if (isBlank(filter)) {
            lastRule().filter = null;
            return this;
        }
        lastRule().filter = getFilterBody(filter);
        return this;
    }

    protected JSRule lastRule() {
        return isNotEmpty(rules) ? rules.get(rules.size() - 1) : null;
    }

    protected String getFilterBody(String filter) {
        String prefix = builder().preResult(filter);
        String filterBody = filter;
        if (filterBody.endsWith(";")) {
            filterBody += "\n";
        } else if (!filterBody.endsWith("\n")) {
            filterBody += ";\n";
        }
        filterBody = filterBody.replace("\n", "\n  ").trim();
        return prefix + "  " + returnFunc(filterBody);
    }

    public boolean hasFilter() {
        return rules.get(rules.size() - 1).filter != null;
    }

    protected String returnFunc(String func) {
        return func.contains("return ") ? func : "return " + func;
    }

    public JSDriver copy() {
        JSDriver jsDriver = new JSDriver(this.driver);
        jsDriver.copy(this);

        return jsDriver;
    }

    public JSDriver copy(JSDriver otherDriver) {
        this.builder = otherDriver.builder.copy();
        this.strategy = otherDriver.strategy;
        this.context = otherDriver.context;
        this.rules = new ArrayList<>(otherDriver.rules);

        return this;
    }
}
