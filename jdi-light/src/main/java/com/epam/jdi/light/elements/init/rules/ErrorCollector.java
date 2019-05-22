package com.epam.jdi.light.elements.init.rules;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
    private List<Throwable> errors = new ArrayList();

    public ErrorCollector(){

    }

    public void addError(Throwable error){
        this.errors.add(error);
    }

    public List<Throwable> showResults(){
        return errors;
    }
}
