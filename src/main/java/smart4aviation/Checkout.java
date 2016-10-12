package smart4aviation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import smart4aviation.utilities.TestUser;

public class Checkout {
    private static final By CONFIRM_ORDER_NEXT_STEP_BUTTON = By.className("confirm-order-next-step-button");
    private static final String BILLING_NEW_ADDRESS_COUNTRY_ID = "BillingNewAddress_CountryId";
    private static final String BILLING_NEW_ADDRESS_STATE_PROVINCE_ID = "BillingNewAddress_StateProvinceId";
    private static final String BILLING_NEW_ADDRESS_CITY = "BillingNewAddress_City";
    private static final String BILLING_NEW_ADDRESS_ADDRESS_1 = "BillingNewAddress_Address1";
    private static final String BILLING_NEW_ADDRESS_ZIP_POSTAL_CODE = "BillingNewAddress_ZipPostalCode";
    private static final String BILLING_NEW_ADDRESS_PHONE_NUMBER = "BillingNewAddress_PhoneNumber";
    private static final String NEW_ADDRESS_NEXT_STEP_BUTTON = "new-address-next-step-button";
    private static final String SHIPPING_METHOD_NEXT_STEP_BUTTON = "shipping-method-next-step-button";
    private static final String SHIPPING_METHOD_NEXT_STEP_BUTTON1 = "shipping-method-next-step-button";
    private static final String PAYMENT_METHOD_NEXT_STEP_BUTTON = "payment-method-next-step-button";
    private static final String PAYMENT_METHOD_NEXT_STEP_BUTTON1 = "payment-method-next-step-button";
    private static final String PAYMENT_INFO_NEXT_STEP_BUTTON = "payment-info-next-step-button";
    private static final String PAYMENT_INFO_NEXT_STEP_BUTTON1 = "payment-info-next-step-button";
    private static final String THANK_YOU = "html/body/div[5]/div[3]/div/div/div/div[2]/div/div[1]/strong";
    private WebDriver webDriver;
    private WebDriverWait wait;

    public Checkout(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 4000);
    }

    public Checkout setBillingAddress(TestUser testUser) {
        new Select(webDriver.findElement(By.id(BILLING_NEW_ADDRESS_COUNTRY_ID)))
                .selectByVisibleText("United States");
        new Select(webDriver.findElement(By.id(BILLING_NEW_ADDRESS_STATE_PROVINCE_ID)))
                .selectByVisibleText("New York");
        webDriver.findElement(By.id(BILLING_NEW_ADDRESS_CITY))
                .sendKeys(testUser.getBillingAddress().getCity());
        webDriver.findElement(By.id(BILLING_NEW_ADDRESS_ADDRESS_1))
                .sendKeys(testUser.getBillingAddress().getAddress1());
        webDriver.findElement(By.id(BILLING_NEW_ADDRESS_ZIP_POSTAL_CODE))
                .sendKeys(testUser.getBillingAddress().getZip());
        webDriver.findElement(By.id(BILLING_NEW_ADDRESS_PHONE_NUMBER))
                .sendKeys(testUser.getBillingAddress().getPhoneNumber());
        webDriver.findElement(By.className(NEW_ADDRESS_NEXT_STEP_BUTTON)).click();
        return this;
    }

    public Checkout shippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className(SHIPPING_METHOD_NEXT_STEP_BUTTON)));
        webDriver.findElement(By.className(SHIPPING_METHOD_NEXT_STEP_BUTTON1)).click();
        return this;
    }

    public Checkout paymentMethodAndInformation() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className(PAYMENT_METHOD_NEXT_STEP_BUTTON)));
        webDriver.findElement(By.className(PAYMENT_METHOD_NEXT_STEP_BUTTON1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className(PAYMENT_INFO_NEXT_STEP_BUTTON)));
        webDriver.findElement(By.className(PAYMENT_INFO_NEXT_STEP_BUTTON1)).click();
        return this;
    }

    public Checkout paymentConfirmation() {
        wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_ORDER_NEXT_STEP_BUTTON));
        webDriver.findElement(CONFIRM_ORDER_NEXT_STEP_BUTTON).click();
        return this;
    }

    public String getFinalConfimationMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(THANK_YOU)));
        return webDriver.findElement(By.xpath(THANK_YOU)).getText();
    }
}
