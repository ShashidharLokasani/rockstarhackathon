package io.shashi.rockstar;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import io.shashi.rockstar.screens.CompareExpensesScreen;
import io.shashi.rockstar.screens.LoginScreen;
import io.shashi.rockstar.screens.RecentTransactionsScreen;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.shashi.rockstar.util.DriverUtil.webDriver;
import static io.shashi.rockstar.util.Statik.*;

/**
 * VisualAITests class is the Applitools eyes tests[Testers life saver]
 *
 * @author Shashi
 */
public class VisualAITests {

    //Objects
    ChromeDriver driver;
    LoginScreen loginScreen;
    RecentTransactionsScreen recentTransactionsScreen;
    CompareExpensesScreen compareExpensesScreen;
    BatchInfo batchInfo;
    Eyes eyes;

    /**
     * Executes before all tests run
     */
    @BeforeClass
    public void beforeClass() {
        eyes = new Eyes();
        eyes.setApiKey(APPLITOOLS_API_KEY);
        eyes.setForceFullPageScreenshot(true);
        batchInfo = new BatchInfo("Applitools Rockstar");
    }

    /**
     * Executes before each test run
     */
    @BeforeMethod
    public void beforeTest() {
        //Webdriver initialization
        driver = webDriver();
        //Page objects
        loginScreen = new LoginScreen(driver);
        recentTransactionsScreen = new RecentTransactionsScreen(driver);
        compareExpensesScreen = new CompareExpensesScreen(driver);
    }

    /**
     * Login Page UI Elements Tests
     */
    @Test
    public void testLoginPageUIElements() {
        loginScreen.navigateTo(URL);
        eyes.setBatch(batchInfo);
        eyes.open(driver, "Applitools Rockstar", "Login Page UI Elements Test");
        eyes.checkWindow("Test Login Page UI Elements");
    }

    /**
     * Login page validation with different data sets
     */
    @Test
    public void testDataDriven() {
        loginScreen.navigateTo(URL);
        eyes.setBatch(batchInfo);
        eyes.open(driver, "Applitools Rockstar", "Login Screen Data driven Test");
        loginScreen.handleLogin("", "");
        eyes.checkWindow("Test Blank Username and Password");
        loginScreen.handleLogin("Applitools", "");
        eyes.checkWindow("Test Blank Password");
        loginScreen.handleLogin("", "Rockstar");
        eyes.checkWindow("Test Blank Username");
        loginScreen.handleLogin("Applitools", "Rockstar");
        eyes.checkWindow("Test Success Login");
    }

    /**
     * Table sort test
     */
    @Test
    public void testTableSort() {
        loginScreen.navigateTo(URL);
        eyes.setBatch(batchInfo);
        eyes.open(driver, "Applitools Rockstar", "Recent Transactions Table Sort Test");
        loginScreen.handleLogin("Applitools", "Rockstar");
        eyes.checkWindow("Test Recent Transactions Table Before Sort");
        recentTransactionsScreen.sortAmountColumn();
        eyes.checkWindow("Test Recent Transactions Table After Sort");
    }

    /**
     * Canvas Chart Test
     */
    @Test
    public void testCanvasChart() {
        loginScreen.navigateTo(URL);
        eyes.setBatch(batchInfo);
        eyes.open(driver, "Applitools Rockstar", "Compare Expenses Chart Test");
        loginScreen.handleLogin("Applitools", "Rockstar");
        recentTransactionsScreen.compareExpenses();
        eyes.checkWindow("Test Expenses for past two year");
        compareExpensesScreen.addNextYearDataToChart();
        eyes.checkWindow("Test Expenses for past two year and current year");
    }

    /**
     * Dynamic ads test
     */
    @Test
    public void testDynamicContent() {
        loginScreen.navigateTo(ADS_URL);
        eyes.setBatch(batchInfo);
        eyes.open(driver, "Applitools Rockstar", "Dynamic Content Flash ads Test");
        loginScreen.handleLogin("Applitools", "Rockstar");
        eyes.checkWindow("Test Flash Sale ads");
    }

    /**
     * Executes after each test run
     */
    @AfterMethod
    public void afterTest() {
        eyes.closeAsync();
        driver.quit();
        eyes.abort();
        eyes.abortIfNotClosed();
    }
}
