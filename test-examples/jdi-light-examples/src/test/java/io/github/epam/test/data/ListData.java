package io.github.epam.test.data;

import io.github.com.custom.Result;

public class ListData {
    public static Result CORRECT = new Result().set(r -> {
        r.name = "JDI OWNER CONTACT";
        r.description = "Write an email directly to Framework owner and main architect Iovlev Roman";
        r.link = "Write email";
    });
    public static Result CORRECT_2 = new Result().set(r -> {
        r.name = "JDI VK GROUP";
        r.description = "Russian Community VK group";
        r.link = "Visit Group";
    });
    public static Result CORRECT_3 = new Result().set(r -> {
        r.name = "JDI SKYPE";
        r.description = "JDI Skype group with active JDI users";
        r.link = "Join Skype group";
    });
    public static Result CORRUPTED = new Result().set(r -> {
        r.name = "JDI Missed";
        r.description = "Write an email directly to Framework owner and main architect Iovlev Roman";
        r.link = "Write email";
    });
    public static Result CORRUPTED_2 = new Result().set(r -> {
        r.name = "JDI Changed";
        r.description = "JDI Skype group with active JDI users";
        r.link = "Join Skype group";
    });
}
