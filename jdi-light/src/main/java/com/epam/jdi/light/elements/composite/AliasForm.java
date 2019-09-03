package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.common.JDIAction;

import static com.epam.jdi.light.common.UIUtils.GET_BUTTON;

/**
 * Created by Roman Iovlev on 29.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface AliasForm<T> {
    void submit(T entity, String buttonName);
    Object getPageObject();

    @JDIAction("Login as {0}")
    default void login(T entity) {
        submit(entity, "login");
    }
    @JDIAction("Login")
    default void login() {
        GET_BUTTON.execute(getPageObject(), "login").click();
    }
    @JDIAction("Login as {0}")
    default void loginAs(T entity) {
        login(entity);
    }
    @JDIAction("Send {0} in '{name}'")
    default void send(T entity) {
        submit(entity, "send");
    }

    @JDIAction("Send '{name}'")
    default void send() {
        GET_BUTTON.execute(getPageObject(), "send").click();
    }
    @JDIAction("Add {0} in '{name}'")
    default void add(T entity) {
        submit(entity, "add");
    }

    @JDIAction("Add '{name}'")
    default void add() {
        GET_BUTTON.execute(getPageObject(), "add").click();
    }
    @JDIAction("Publish {0} for '{name}'")
    default void publish(T entity) {
        submit(entity, "publish");
    }

    @JDIAction("Publish '{name}'")
    default void publish() {
        GET_BUTTON.execute(getPageObject(), "publish").click();
    }
    @JDIAction("Save {0} in '{name}'")
    default void save(T entity) {
        submit(entity, "save");
    }

    @JDIAction("Save '{name}'")
    default void save() {
        GET_BUTTON.execute(getPageObject(), "save").click();
    }
    @JDIAction("Update {0} in '{name}'")
    default void update(T entity) {
        submit(entity, "update");
    }

    @JDIAction("Update '{name}'")
    default void update() {
        GET_BUTTON.execute(getPageObject(), "update").click();
    }
    @JDIAction("Fill {0} and cancel '{name}'")
    default void cancel(T entity) {
        submit(entity, "cancel");
    }
    @JDIAction("Cancel '{name}'")
    default void cancel() {
        GET_BUTTON.execute(getPageObject(), "cancel").click();
    }
    @JDIAction("Fill {0} and close '{name}'")
    default void close(T entity) {
        submit(entity, "close");
    }

    @JDIAction("Close '{name}'")
    default void close() {
        GET_BUTTON.execute(getPageObject(), "close").click();
    }
    @JDIAction("Fill '{name}' with {0} and go back")
    default void back(T entity) {
        submit(entity, "back");
    }

    @JDIAction("Back '{name}'")
    default void back() {
        GET_BUTTON.execute(getPageObject(), "back").click();
    }
    @JDIAction("Select {0} for '{name}'")
    default void select(T entity) {
        submit(entity, "select");
    }
    @JDIAction("Fill '{name}' with {0} and go to next")
    default void next(T entity) {
        submit(entity, "next");
    }
    @JDIAction("Next '{name}'")
    default void next() {
        GET_BUTTON.execute(getPageObject(), "next").click();
    }
    @JDIAction("Search for {0} in '{name}'")
    default void search(T entity) {
        submit(entity, "search");
    }
    @JDIAction("Search '{name}'")
    default void search() {
        GET_BUTTON.execute(getPageObject(), "search").click();
    }
}
