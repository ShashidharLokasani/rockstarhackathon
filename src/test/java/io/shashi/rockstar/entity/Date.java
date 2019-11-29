package io.shashi.rockstar.entity;

/**
 * Date entity class of recent transactions table Date column
 *
 * @author Shashi
 */
public class Date {

    //Day
    private String day;
    //Time
    private String time;

    //Getters and Setters
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
