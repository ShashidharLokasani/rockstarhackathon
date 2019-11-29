package io.shashi.rockstar.util;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * DriverUtil class to initialise the driver
 *
 * @author Shashi
 */
public class DriverUtil {

    public static ChromeDriver webDriver() {
        String chromedriverPath = System.getProperty("chromedriver", "");
        if (chromedriverPath.isEmpty()) {
            String extension = SystemUtils.OS_NAME.toLowerCase().contains("window") ? ".exe" : "";
            chromedriverPath = new File("./src/test/resources/driver/chromedriver" + extension).getAbsolutePath();
        }
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
