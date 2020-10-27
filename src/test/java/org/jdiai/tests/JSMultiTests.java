package org.jdiai.tests;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.map.MapArray;
import org.jdiai.TestInit;
import org.jdiai.entity.UserInfo;
import org.jdiai.jsdriver.JSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;
import static org.jdiai.jselement.JSTalk.$;
import static org.jdiai.jselement.JSTalk.entity;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JSMultiTests extends TestInit {

    @BeforeMethod
    public void before() {
        logout();
    }

    @Test
    public void usersMapTest() {
        List<MapArray<String, String>> users = $("#user-table input").getMultiAttributes("type", "id", "checked");
        assertEquals(users.size(), 6);
        List<String> userIds = map(users, u -> u.get("id"));
        List<String> vipUsers = ifSelect(users,
            u -> u.get("checked").equals("true"),
            u -> u.get("id"));
        assertEquals(userIds.toString(), "[roman, ivan, vlad, helen, yoshi, gio]");
        assertEquals(vipUsers.toString(), "[roman, vlad]");
    }
    @Test
    public void usersEntityTest() {
        List<UserInfo> users = entity(UserInfo.class, "#user-table input").getObjectList("type", "id", "checked");
        assertEquals(users.size(), 6);
        List<String> userIds = map(users, u -> u.id);
        List<String> vipUsers = ifSelect(users,
            u -> u.checked.equals("true"),
            u -> u.id);
        assertEquals(userIds.toString(), "[roman, ivan, vlad, helen, yoshi, gio]");
        assertEquals(vipUsers.toString(), "[roman, vlad]");
    }
}
