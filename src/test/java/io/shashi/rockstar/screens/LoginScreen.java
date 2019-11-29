package io.shashi.rockstar.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.shashi.rockstar.util.ReusableUtil.isElementPresent;
import static io.shashi.rockstar.util.ReusableUtil.prevSibiling;

/**
 * LoginScreen is the Page Object class for Login page
 *
 * @author Shashi
 */
public class LoginScreen {

    //Webdriver instance
    private WebDriver webDriver;

    //Input Fields
    @FindBy(id = "username")
    private WebElement usernameTextInput;

    @FindBy(id = "password")
    private WebElement passwordTextInput;

    @FindBy(id = "log-in")
    private WebElement loginButton;

    @FindBy(className = "form-check-label")
    private WebElement remembermeCheckBox;

    //Images and Logos
    @FindBy(css = ".logo-w img")
    private WebElement logoImage;

    @FindBy(className = "os-icon-user-male-circle")
    private WebElement usernameImage;

    @FindBy(className = "os-icon-fingerprint")
    private WebElement passwordImage;

    @FindBy(xpath = "//img[@src='img/social-icons/twitter.png']")
    private WebElement twitterImage;

    @FindBy(xpath = "//img[@src='img/social-icons/facebook.png']")
    private WebElement faceBookImage;

    @FindBy(xpath = "//img[@src='img/social-icons/linkedin.png']")
    private WebElement linkedInImage;

    //Headers and Labels
    @FindBy(className = "auth-header")
    private WebElement headerLabel;

    @FindBy(xpath = " //div[starts-with(@id,'random_id')]")
    private WebElement errorLabel;

    /**
     * Constructor
     *
     * @param driver Webdriver instance
     */
    public LoginScreen(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }


    //############### METHODS TO GET ELEMENTS TEXT/PLACEHODLERS ###############

    /**
     * Method to fetch Header Text
     *
     * @return Header Text
     */
    public String fetchHeaderText() {
        return headerLabel.getText().trim();
    }

    /**
     * Method to fetch Username Form Label
     *
     * @return Username Form Label
     */
    public String fetchUsernameLabel() {
        return prevSibiling(usernameTextInput).getText().trim();
    }

    /**
     * Method to fetch Username Form Label
     *
     * @return Username Form Label
     */
    public String fetchPasswordLabel() {
        return prevSibiling(passwordTextInput).getText().trim();
    }

    /**
     * Method to fetch Username text field place holder
     *
     * @return Username text field place holder
     */
    public String fetchUsernamePlaceholder() {
        return usernameTextInput.getAttribute("placeholder").trim();
    }

    /**
     * Method to fetch Password text field place holder
     *
     * @return Password text field place holder
     */
    public String fetchPasswordPlaceholder() {
        return passwordTextInput.getAttribute("placeholder").trim();
    }

    /**
     * Method to fetch Login Button Text
     *
     * @return Login Button Text
     */
    public String fetchLoginButtonText() {
        return loginButton.getText().trim();
    }

    /**
     * Method to fetch Remember Me Checkbox Text
     *
     * @return Remember Me Checkbox Text
     */
    public String fetchRememberMeCheckText() {
        return remembermeCheckBox.getText().trim();
    }

    /**
     * Method to fetch Error Text
     *
     * @return Error Text
     */
    public String fetchError() {
        return errorLabel.getText().trim();
    }

    //############### METHODS TO GET ELEMENT PRESENCE ###############

    /**
     * Method to check presence of header logo
     *
     * @return true if present, false if not present
     */
    public boolean isHeaderLogoPresent() {
        return isElementPresent(logoImage);
    }

    /**
     * Method to check presence of header label
     *
     * @return true if present, false if not present
     */
    public boolean isHeaderTextPresent() {
        return isElementPresent(headerLabel);
    }

    /**
     * Method to check presence of Username Text field
     *
     * @return true if present, false if not present
     */
    public boolean isUsernameFieldPresent() {
        return isElementPresent(usernameTextInput);
    }

    /**
     * Method to check presence of Password Text field
     *
     * @return true if present, false if not present
     */
    public boolean isPasswordFieldPresent() {
        return isElementPresent(passwordTextInput);
    }

    /**
     * Method to check presence of Username Icon
     *
     * @return true if present, false if not present
     */
    public boolean isUsernameIconPresent() {
        return isElementPresent(usernameImage);
    }

    /**
     * Method to check presence of Password Icon
     *
     * @return true if present, false if not present
     */
    public boolean isPasswordIconPresent() {
        return isElementPresent(passwordImage);
    }

    /**
     * Method to check presence of Username Label
     *
     * @return true if present, false if not present
     */
    public boolean isUsernameLabelPresent() {
        return isElementPresent(prevSibiling(usernameTextInput));
    }

    /**
     * Method to check presence of Password Label
     *
     * @return true if present, false if not present
     */
    public boolean isPasswordLabelPresent() {
        return isElementPresent(prevSibiling(passwordTextInput));
    }

    /**
     * Method to check presence of Login Button
     *
     * @return true if present, false if not present
     */
    public boolean isLoginButtonPresent() {
        return isElementPresent(loginButton);
    }

    /**
     * Method to check presence of Remember Me checkbox
     *
     * @return true if present, false if not present
     */
    public boolean isRemembermeCheckPresent() {
        return isElementPresent(remembermeCheckBox);
    }

    /**
     * Method to check presence of Twitter Icon
     *
     * @return true if present, false if not present
     */
    public boolean isTwitterImagePresent() {
        return isElementPresent(twitterImage);
    }

    /**
     * Method to check presence of Facebook Icon
     *
     * @return true if present, false if not present
     */
    public boolean isFacebookImagePresent() {
        return isElementPresent(faceBookImage);
    }

    /**
     * Method to check presence of LinkedIn Icon
     *
     * @return true if present, false if not present
     */
    public boolean isLinkedInImagePresent() {
        return isElementPresent(linkedInImage);
    }

    //############### FORM ACTIONS ###############

    /**
     * Method for Login Action
     *
     * @param username Username
     * @param password Password
     */
    public void handleLogin(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    /**
     * Method to set username
     *
     * @param username Username
     */
    public void setUsername(String username) {
        usernameTextInput.clear();
        usernameTextInput.sendKeys(username);
    }

    /**
     * Method to set password
     *
     * @param password Password
     */
    public void setPassword(String password) {
        passwordTextInput.clear();
        passwordTextInput.sendKeys(password);
    }

    /**
     * Method to click on login button
     */
    public void clickLoginButton() {
        loginButton.click();
    }

    /**
     * Method to open the URL
     */
    public void navigateTo(String url) {
        webDriver.get(url);
    }
}
