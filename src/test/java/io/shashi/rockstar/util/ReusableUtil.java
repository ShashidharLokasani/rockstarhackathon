package io.shashi.rockstar.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * ReusableUtil class to for all webdriver reusable methods
 *
 * @author Shashi
 */
public class ReusableUtil {

    /**
     * Method to get Preceding Sibling WebElement
     *
     * @param element Reference WebElement
     * @return Preceding Sibling WebElement
     */
    public static WebElement prevSibiling(WebElement element) {
        return element.findElement(By.xpath("preceding-sibling::label"));
    }

    /**
     * Method to find Element Presence
     *
     * @param element Reference WebElement
     * @return true if element present, false if element not present
     */
    public static boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Method to get the status color for recent transactions table
     *
     * @param element WebElement
     * @return class attribute of WebElement
     */
    public static String statusColor(WebElement element) {
        return element.findElement(By.className("status-pill")).getAttribute("class");
    }

    /**
     * Method to get the date day of recent transactions table
     *
     * @param element WebElement
     * @return date day
     */
    public static String dateDay(WebElement element) {
        return element.findElements(By.tagName("span")).get(0).getText();
    }

    /**
     * Method to get the date time for recent transactions table
     *
     * @param element WebElement
     * @return date time
     */
    public static String dateTime(WebElement element) {
        return element.findElements(By.tagName("span")).get(1).getText();
    }

    /**
     * Method to get the description image path for recent transactions table
     *
     * @param element WebElement
     * @return src of image
     */
    public static String descriptionImage(WebElement element) {
        return element.findElement(By.tagName("img")).getAttribute("src");
    }

    /**
     * Method to get the description name for recent transactions table
     *
     * @param element WebElement
     * @return description name
     */
    public static String descriptionName(WebElement element) {
        return element.findElement(By.tagName("span")).getText();
    }
}
