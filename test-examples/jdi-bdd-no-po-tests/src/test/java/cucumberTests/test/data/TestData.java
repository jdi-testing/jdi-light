package cucumberTests.test.data;

public class TestData {
    public static User ROMAN = new User().set(u -> {
        u.name = "Roman";
        u.password = "Jdi1234";
    });
}
