package applitools.hackathon.test.data;


import applitools.hackathon.entities.User;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public Object[][] correctUsers() {
        return new Object[][] {
            { new User() },
            { new User().set(u-> {u.username = "Alex"; u.password = "Another password";}) }
        };
    }

    @DataProvider
    public Object[][] emptyUsers() {
        return new Object[][] {
            { new User().set(u-> {u.username = ""; u.password = "";}),
                "Both Username and Password must be present"},
            { new User().set(u-> u.username = ""), "Username must be present"},
            { new User().set(u-> u.password = ""), "Password must be present"},
        };
    }
}
