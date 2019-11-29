package io.shashi.rockstar.screens;

import io.shashi.rockstar.entity.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static io.shashi.rockstar.util.ReusableUtil.*;

/**
 * RecentTransactionsScreen is the Page Object class for RecentTransactions page
 *
 * @author Shashi
 */
public class RecentTransactionsScreen {

    //Page Objects
    @FindBy(id = "showExpensesChart")
    private WebElement showExpensesChart;

    @FindBy(id = "amount")
    private WebElement amountColumn;

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    @FindBy(id = "flashSale")
    private WebElement adOne;

    @FindBy(id = "flashSale2")
    private WebElement adTwo;

    /**
     * Constructor
     *
     * @param driver Webdriver instance
     */
    public RecentTransactionsScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check is show expenses link is displayed
     *
     * @return true if displayed else false
     */
    public boolean isPageLoaded() {
        return showExpensesChart.isDisplayed();
    }

    /**
     * Method to click on Compare Expenses Link
     */
    public void compareExpenses() {
        showExpensesChart.click();
    }

    /**
     * Method to click on Amount Column
     */
    public void sortAmountColumn() {
        amountColumn.click();
    }

    /**
     * Method to get Recent Transactions table data
     *
     * @return table data
     */
    public Table fetchTableData() {
        Table table = new Table();
        List<Row> data = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> rowData = row.findElements(By.tagName("td"));
            //Status column data
            Status status = new Status();
            status.setText(rowData.get(0).getText());
            status.setColor(statusColor(rowData.get(0)));

            //Date column data
            Date date = new Date();
            date.setDay(dateDay(rowData.get(1)));
            date.setTime(dateTime(rowData.get(1)));

            //Description Column Data
            Description description = new Description();
            description.setName(descriptionName(rowData.get(2)));
            description.setImage(descriptionImage(rowData.get(2)));

            //Category Column data
            Category category = new Category();
            category.setText(rowData.get(3).getText());
            category.setBackground(rowData.get(3).getAttribute("class"));

            //Amount column data
            String amount = rowData.get(4).getText();
            amount = amount.substring(0, amount.length() - 4); //Remove USD
            amount = amount.replaceAll("\\s+", "");// Remove White Spaces
            amount = amount.replaceAll(",", "");//Remove Commma [To convert to integer]

            Row rowEntity = new Row();
            rowEntity.setStatus(status);
            rowEntity.setDate(date);
            rowEntity.setDescription(description);
            rowEntity.setCategory(category);
            rowEntity.setAmount(Double.parseDouble(amount));

            data.add(rowEntity);
        }
        table.setRows(data);
        return table;
    }

    /**
     * Method to see Ad 1 is present
     *
     * @return true is present else false
     */
    public boolean isAdOnePresent() {
        return isAdPresent(adOne);
    }

    /**
     * Method to see Ad 2 is present
     *
     * @return true is present else false
     */
    public boolean isAdTwoPresent() {
        return isAdPresent(adTwo);
    }

    /**
     * Method to see element presence
     *
     * @param element WebElement
     * @return true if present else false
     */
    private boolean isAdPresent(WebElement element) {
        try {
            return isElementPresent(element.findElement(By.tagName("img")));
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
