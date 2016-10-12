package smart4aviation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
    private static final String TERMSOFSERVICE = "termsofservice";
    private static final String CHECKOUT = "checkout";
    private static final String PRODUCT_NAME = "product-name";
    private WebDriver webDriver;
    private WebDriverWait wait;

    public ShoppingCart(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 4000);
    }

    public Checkout goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(TERMSOFSERVICE)));
        webDriver.findElement(By.id(TERMSOFSERVICE)).click();
        webDriver.findElement(By.id(CHECKOUT)).click();
        return new Checkout(webDriver);
    }

    public String getProductsInShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className(PRODUCT_NAME)));
        return webDriver.findElement(By.className(PRODUCT_NAME)).getText();
    }
}
