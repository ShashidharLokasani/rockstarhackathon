package io.shashi.rockstar.entity;

/**
 * Row entity class of recent transactions tables each row
 *
 * @author Shashi
 */
public class Row {

    //Status column
    private Status status;
    //Date column
    private Date date;
    //Description column
    private Description description;
    //Category Column
    private Category category;
    //Amount Column
    private double amount;

    //Getters and Setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
