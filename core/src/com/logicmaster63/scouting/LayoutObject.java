package com.logicmaster63.scouting;

/**
 * Created by dmpri on 10/28/2017.
 */

public class LayoutObject {
    public enum inputMethod {
        CHECK_BOX, TEXT_FIELD
    }

    public inputMethod inputmethod;
    public String name;

    public LayoutObject(inputMethod inputmethod, String name) {
        this.inputmethod = inputmethod;
        this.name = name;
    }
}
