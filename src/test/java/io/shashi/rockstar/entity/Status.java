package io.shashi.rockstar.entity;

/**
 * Status entity class of recent transactions table Status column
 *
 * @author Shashi
 */
public class Status {
    //Status name
    private String text;
    //Status color
    private String color;

    //Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
