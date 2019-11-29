package io.shashi.rockstar.util;

/**
 * Statik class to store constants
 *
 * @author Shashi
 */
public class Statik {

    private static String version() {
        return System.getProperty("version", "2");
    }

    public final static String URL = version().equals("1") ? "https://demo.applitools.com/hackathon.html" : "https://demo.applitools.com/hackathonV2.html";
    public final static String ADS_URL = version().equals("1") ? "https://demo.applitools.com/hackathon.html?showAd=true" : "https://demo.applitools.com/hackathonV2.html?showAd=true";
    public final static String APPLITOOLS_API_KEY = "8ONInjSPxRjBDW76JFZUuOBDKct7oPJVInJIpdOfLpI110";
}
