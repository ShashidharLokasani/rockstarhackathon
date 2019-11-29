package io.shashi.rockstar.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * CompareExpensesScreen is the Page Object class for CompareExpenses page
 *
 * @author Shashi
 */
public class CompareExpensesScreen {

    //Webdriver instance
    private WebDriver webDriver;

    //Page object
    @FindBy(id = "addDataset")
    private WebElement showNextYearDataButton;

    /**
     * Constructor
     *
     * @param driver Webdriver instance
     */
    public CompareExpensesScreen(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to click on button show next year data
     */
    public void addNextYearDataToChart() {
        showNextYearDataButton.click();
    }

}
