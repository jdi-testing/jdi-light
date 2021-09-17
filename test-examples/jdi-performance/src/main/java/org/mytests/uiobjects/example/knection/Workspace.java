package org.mytests.uiobjects.example.knection;

import com.jdiai.tools.DataClass;
import com.jdiai.tools.func.JAction1;

import java.lang.reflect.Field;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.jdiai.tools.LinqUtils.first;
import static com.jdiai.tools.ReflectionUtils.getValueField;

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
            Field fOther = first(otherFields, fo -> fo.getName().equals(f.getName()));
            fOther.set(ws, getValueField(f, this));
        }
        } catch(Exception ex) { throw exception("Can't copy class"); }
        return ws;
    }
}
