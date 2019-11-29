package io.shashi.rockstar.entity;

/**
 * Category entity class of recent transactions table Category column
 *
 * @author Shashi
 */
public class Category {
    //Category name
    private String text;
    //Category background color
    private String background;

    //Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
