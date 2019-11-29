package io.shashi.rockstar.entity;

import java.util.List;

/**
 * Table entity class of recent transactions table
 *
 * @author Shashi
 */
public class Table {
    //List of table rows
    private List<Row> rows;

    //Getters and Setters
    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
