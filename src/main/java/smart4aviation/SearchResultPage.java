package smart4aviation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private static final String PRODUCT_BOX_ADD_TO_CART_BUTTON = "product-box-add-to-cart-button";
    private static final String GO_TO_CART = ".//*[@id='flyout-cart']/div/div[4]/input";
    private WebDriver webDriver;
    private WebDriverWait wait;

    public SearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 4000);
    }

    public SearchResultPage getItem(String item) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(item)));
        webDriver.findElement(By.linkText(item)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(PRODUCT_BOX_ADD_TO_CART_BUTTON)));
        webDriver.findElement(By.className(PRODUCT_BOX_ADD_TO_CART_BUTTON)).click();
        return this;
    }

    public ShoppingCart navigateToCart() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",
                webDriver.findElement(By.xpath(GO_TO_CART)));
        return new ShoppingCart(webDriver);
    }
}