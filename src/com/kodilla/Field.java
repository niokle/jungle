package com.kodilla;

public class Field {
    private String type;
    private Boolean onTop;

    public Field(String type, Boolean onTop) {
        this.type = type;
        this.onTop = onTop;
    }

    public String getType() {
        return type;
    }

    public Boolean getColour() {
        return onTop;
    }
}
