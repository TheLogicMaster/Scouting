package com.logicmaster63.scouting;

public class LayoutObject {
    public enum INPUT_METHOD {
        CHECK_BOX, TEXT_FIELD
    }

    public INPUT_METHOD inputmethod;
    public String name;

    public LayoutObject(INPUT_METHOD inputmethod, String name) {
        this.inputmethod = inputmethod;
        this.name = name;
    }

    @Override
    public String toString() {
        return "(" + inputmethod + ": " + name + ")";
    }
}
