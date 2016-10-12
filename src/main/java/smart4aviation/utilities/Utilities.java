package smart4aviation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utilities {

    public static void takeScreenShot(WebDriver webDriver) throws IOException {
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "target" +
                File.separator + "surefire-reports" + File.separator + "Smart4Aviation" + File.separator + "testScreenShot.jpg"));
        System.out.println("SCREEN SHOT  ENDS ");
    }
}
