package io.shashi.rockstar.entity;

/**
 * Description entity class of recent transactions table Description column
 *
 * @author Shashi
 */
public class Description {
    //Description name
    private String name;
    //Description image
    private String image;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

