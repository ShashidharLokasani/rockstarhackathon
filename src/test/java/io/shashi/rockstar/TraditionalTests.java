package io.shashi.rockstar;

import io.shashi.rockstar.entity.Row;
import io.shashi.rockstar.entity.Table;
import io.shashi.rockstar.screens.LoginScreen;
import io.shashi.rockstar.screens.RecentTransactionsScreen;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static io.shashi.rockstar.util.DriverUtil.webDriver;
import static io.shashi.rockstar.util.Statik.ADS_URL;
import static io.shashi.rockstar.util.Statik.URL;

/**
 * TraditionalTests class is the selenium tests [Heavy weight tests]
 *
 * @author Shashi
 */
public class TraditionalTests {

    //Objects
    LoginScreen loginScreen;
    RecentTransactionsScreen recentTransactionsScreen;
    ChromeDriver driver;

    /**
     * Executes before all tests run
     */
    @BeforeClass
    public void beforeClass() {
        //Webdriver initialization
        driver = webDriver();
        //Page Objects initialization
        loginScreen = new LoginScreen(driver);
        recentTransactionsScreen = new RecentTransactionsScreen(driver);
    }

    /**
     * Login Page UI Elements Tests
     */
    @Test
    public void testLoginPageUIElements() {
        loginScreen.navigateTo(URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginScreen.isHeaderLogoPresent(), "Header logo not present");
        softAssert.assertTrue(loginScreen.isHeaderTextPresent(), "Header text not present");
        softAssert.assertTrue(loginScreen.isUsernameIconPresent(), "Username Icon not present");
        softAssert.assertTrue(loginScreen.isPasswordIconPresent(), "Password Icon not present");
        softAssert.assertTrue(loginScreen.isUsernameFieldPresent(), "Username Textfield not present");
        softAssert.assertTrue(loginScreen.isPasswordFieldPresent(), "Password Textfield not present");
        softAssert.assertTrue(loginScreen.isLoginButtonPresent(), "Login Button not present");
        softAssert.assertTrue(loginScreen.isRemembermeCheckPresent(), "Remember me check not present");
        softAssert.assertTrue(loginScreen.isTwitterImagePresent(), "Twitter Icon not present");
        softAssert.assertTrue(loginScreen.isFacebookImagePresent(), "Facebook Icon not present");
        softAssert.assertTrue(loginScreen.isLinkedInImagePresent(), "LinkedIn Icon not present");
        softAssert.assertTrue(loginScreen.isUsernameLabelPresent(), "Username label not present");
        softAssert.assertTrue(loginScreen.isPasswordLabelPresent(), "Password label not present");
        softAssert.assertEquals(loginScreen.fetchHeaderText(), "Login Form", "Header Text not matching");
        softAssert.assertEquals(loginScreen.fetchUsernameLabel(), "Username", "Username Label not matching");
        softAssert.assertEquals(loginScreen.fetchPasswordLabel(), "Password", "Password Label not matching");
        softAssert.assertEquals(loginScreen.fetchUsernamePlaceholder(), "Enter your username", "Username placeholder not matching");
        softAssert.assertEquals(loginScreen.fetchPasswordPlaceholder(), "Enter your password", "Password placeholder not matching");
        softAssert.assertEquals(loginScreen.fetchLoginButtonText(), "Log In", "Login button text not matching");
        softAssert.assertEquals(loginScreen.fetchRememberMeCheckText(), "Remember Me", "Remember Me Checkbox text not matching");
        softAssert.assertAll();
    }

    /**
     * Login page validation with different data sets
     */
    @Test
    public void testDataDriven() {
        loginScreen.navigateTo(URL);
        SoftAssert softAssert = new SoftAssert();
        loginScreen.handleLogin("", "");//Blank Username and Password
        softAssert.assertEquals(loginScreen.fetchError(), "Both Username and Password must be present");
        loginScreen.handleLogin("Applitools", "");//Blank Password
        softAssert.assertEquals(loginScreen.fetchError(), "Password must be present");
        loginScreen.handleLogin("", "Rockstar");//Blank Username
        softAssert.assertEquals(loginScreen.fetchError(), "Username must be present");
        loginScreen.handleLogin("Applitools", "Rockstar");//Valid Username and Password
        softAssert.assertTrue(recentTransactionsScreen.isPageLoaded());
        softAssert.assertAll();
    }

    /**
     * Table sort test
     *
     * @throws Exception
     */
    @Test
    public void testTableSort() throws Exception {
        loginScreen.navigateTo(URL);
        SoftAssert softAssert = new SoftAssert();
        loginScreen.handleLogin("Applitools", "Rockstar");
        //Recent transactions before sort
        Table actualData = recentTransactionsScreen.fetchTableData();
        recentTransactionsScreen.sortAmountColumn();
        //Recent transactions after sort
        Table sortedData = recentTransactionsScreen.fetchTableData();

        ArrayList<Double> amountColumnData = (ArrayList<Double>) sortedData.getRows().stream().map(Row::getAmount).collect(Collectors.toList());
        ArrayList amountColumnDataClone = (ArrayList) amountColumnData.clone();
        amountColumnDataClone.sort(Comparator.naturalOrder());
        //Amount data is sorted or not validation
        softAssert.assertEquals(amountColumnData, amountColumnDataClone, "Amount column is not sorted");

        //Validation to see data in correct after sorting
        for (Row afterSortRow : sortedData.getRows()) {
            Row beforeSortRow = actualData.getRows().stream().filter(data -> data.getDescription().getName().equals(afterSortRow.getDescription().getName())).findFirst().orElseThrow(Exception::new);
            softAssert.assertEquals(afterSortRow.getStatus().getText(), beforeSortRow.getStatus().getText(), "Status Text not matching");
            softAssert.assertEquals(afterSortRow.getStatus().getColor(), beforeSortRow.getStatus().getColor(), "Status Color not matching");
            softAssert.assertEquals(afterSortRow.getDate().getDay(), beforeSortRow.getDate().getDay(), "Date Day not matching");
            softAssert.assertEquals(afterSortRow.getDate().getTime(), beforeSortRow.getDate().getTime(), "Date Time not matching");
            softAssert.assertEquals(afterSortRow.getDescription().getName(), beforeSortRow.getDescription().getName(), "Description Name not matching");
            softAssert.assertEquals(afterSortRow.getDescription().getImage(), beforeSortRow.getDescription().getImage(), "Description Image not matching");
            softAssert.assertEquals(afterSortRow.getCategory().getText(), beforeSortRow.getCategory().getText(), "Category Name not matching");
            softAssert.assertEquals(afterSortRow.getCategory().getBackground(), beforeSortRow.getCategory().getBackground(), "Category Background Color not matching");
            softAssert.assertEquals(afterSortRow.getAmount(), beforeSortRow.getAmount(), "Amount not matching");
        }
        softAssert.assertAll();
    }


    /**
     * Canvas Chart Test
     */
    @Test
    public void testCanvasChart() {
        /**
         * With Selenium we cannot automate Canvas, as Canvas child elements
         * are visible to DOM
         */
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false, "Failing this canvas test as selenium can't automate");
        softAssert.assertAll();

    }

    /**
     * Dynamic ads test
     */
    @Test
    public void testDynamicContent() {
        loginScreen.navigateTo(ADS_URL);
        SoftAssert softAssert = new SoftAssert();
        loginScreen.handleLogin("Applitools", "Rockstar");
        softAssert.assertTrue(recentTransactionsScreen.isAdOnePresent(), "First ad is not present");
        softAssert.assertTrue(recentTransactionsScreen.isAdTwoPresent(), "Second ad is not present");
        softAssert.assertAll();
    }

    /**
     * Executes after all tests done
     */
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
