package smart4aviation;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

/**
 * Created by Andy on 9/17/2016.
 */
public class MainClass {

    public static void main(String[] s) throws InterruptedException {
        System.out.println("poczatek main");
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTestNG\\src\\main\\resources\\chromedriver.exe");
          String userId = UUID.randomUUID().toString();
        System.out.println("UUID" +userId);

 WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://demo.nopcommerce.com");
        webDriver.manage().window().setSize(new Dimension(600,80));
//        webDriver.get("http://demo.nopcommerce.com/cart");
//        rejestracja
//                webDriver.findElement(By.className("ico-goToRegistration")).click();
//        RegistrationPage registrationPage = new RegistrationPage(webDriver);
//        registrationPage.goToRegistration("aa","aa","aa@aa.aa","6characters");

//        logowanie
//        webDriver.findElement(By.className("ico-login")).click();
//        webDriver.findElement(By.className("email")).sendKeys("krzys@gmail.com");
//        webDriver.findElement(By.className("password")).sendKeys("krzys24");
//        webDriver.findElement(By.className("login-button")).click();
//        Thread.sleep(10000);

//        Szukanie w searchbox
//        webDriver.findElement(By.id("small-searchterms")).sendKeys("HTC One Mini Blue");
//        webDriver.findElement(By.className("button-1")).click();
//        new SearchResultPage(webDriver).getItem("HTC One Mini Blue");
//        Thread.sleep(1000);
//        webDriver.findElement(By.partialLinkText("HTC One Mini Blue")).click();
//        Thread.sleep(10000);
//        Thread.sleep(100);
//        webDriver.findElement(By.className("product-box-add-to-cart-button")).click();
       String welcomeToStore = webDriver.findElement(By.xpath("html/body/div[5]/div[3]/div/div/div/div/div[2]/div[1]/h2")).getText();
        System.out.println(welcomeToStore);
//        System.out.println("koniec main");

    }
}
