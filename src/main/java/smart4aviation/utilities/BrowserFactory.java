package smart4aviation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
    public static WebDriver getWebDriver(String browser) {
        if (browser.equalsIgnoreCase("ie")) {
            return new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }
        return new ChromeDriver();
    }
}
