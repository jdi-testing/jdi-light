package org.jdiai.tests.jsdriver;

import org.jdiai.Json;
import org.jdiai.entity.UserInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.ifSelect;
import static com.epam.jdi.tools.LinqUtils.map;
import static java.util.Arrays.asList;
import static org.jdiai.jswrap.JSWrapper.element;
import static org.jdiai.tests.jsdriver.states.States.atUsersPage;
import static org.testng.Assert.assertEquals;

public class JSMultiTests extends TestInit {

    @BeforeMethod
    public void before() {
        atUsersPage();
    }

    @Test
    public void usersMapTest() {
        List<Json> users = element("#user-table input").getMultiAttributes("type", "id", "checked");
        assertEquals(users.size(), 6);
        List<String> userIds = map(users, u -> u.get("id"));
        assertEquals(userIds.toString(), "[roman, ivan, vlad, helen, yoshi, gio]");
        List<String> vipUsers = ifSelect(users,
            u -> u.get("checked").equals("true"),
            u -> u.get("id"));
        assertEquals(vipUsers.toString(), "[roman, vlad]");
    }
    @Test
    public void usersEntityTest() {
        List<UserInfo> users = element(UserInfo.class, "#user-table input").getEntityList(asList("type", "id", "checked"));
        assertEquals(users.size(), 6);
        List<String> userIds = map(users, u -> u.id);
        assertEquals(userIds.toString(), "[roman, ivan, vlad, helen, yoshi, gio]");
        List<String> vipUsers = ifSelect(users,
            u -> u.checked.equals("true"),
            u -> u.id);
        assertEquals(vipUsers.toString(), "[roman, vlad]");
    }
}
