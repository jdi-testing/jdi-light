package org.mytests.uiobjects.example.knection;

import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;

import java.lang.reflect.Field;

import static com.epam.jdi.light.common.Exceptions.*;

public class Workspace extends DataClass<Workspace> {
    public String category, name, projectCode, apiId, therapeuticArea, processes,
        parentWorkspace, lastUpdated, id;

    public Workspace copy(JAction1<Workspace> change) {
        Workspace ws = copy();
        change.execute(ws);
        return ws;
    }
    public Workspace copy() {
        Workspace ws = new Workspace();
        try {
        Field[] otherFields = ws.getClass().getDeclaredFields();
        for (Field f : getClass().getDeclaredFields()) {
            Field fOther = LinqUtils.first(otherFields, fo -> fo.getName().equals(f.getName()));
            fOther.set(ws, f.get(this));
        }
        } catch(Exception ex) { throw exception("Can't copy class"); }
        return ws;
    }
}
