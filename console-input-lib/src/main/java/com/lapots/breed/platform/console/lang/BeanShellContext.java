package com.lapots.breed.platform.console.lang;

import bsh.EvalError;
import bsh.Interpreter;

import java.util.Map;

public class BeanShellContext {
    private Interpreter interpreter = new Interpreter();
    private String expr;

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public void setParameter(String name, Object value) {
        safeSet(name, value);
    }

    public void setParameters(Map<String, Object> parameters) {
        parameters.forEach(this::safeSet);
    }

    public void run() {
        if (null != expr) {
            try {
                interpreter.eval(expr);
            } catch (EvalError evalError) {
                evalError.printStackTrace();
            }
        }
    }

    private void safeSet(String name, Object value) {
        try {
            interpreter.set(name, value);
        } catch (EvalError evalError) {
            evalError.printStackTrace();
        }
    }
}
