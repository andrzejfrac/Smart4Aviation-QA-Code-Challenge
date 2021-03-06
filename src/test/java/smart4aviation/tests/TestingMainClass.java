package smart4aviation.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import smart4aviation.Checkout;
import smart4aviation.HomePage;
import smart4aviation.SearchResultPage;
import smart4aviation.ShoppingCart;
import smart4aviation.utilities.BillingAddress;
import smart4aviation.utilities.BrowserFactory;
import smart4aviation.utilities.TestFailListener;
import smart4aviation.utilities.TestUser;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestingMainClass {
    private static final String PRODUCT_TO_LOOK_FOR = "HTC One Mini Blue";
    private static final String CONFIRMATION_MESSAGE = "Your order has been successfully processed!";
    private WebDriver webDriver;
    private HomePage home;
    private Checkout checkout;
    private ShoppingCart shoppingCart;
    private String ADDRESS_URL;
    private BillingAddress billingAddress;
    private TestUser testUser;

    @BeforeSuite(groups = {"important"})
    @Parameters({"URLAddress"})
    public void setUp(String addressUrl) {
        ADDRESS_URL = addressUrl;
        String dimensions = System.getProperty("size");
        webDriver = BrowserFactory.getWebDriver(System.getProperty("driver"));
        webDriver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(
                new Dimension(Integer.parseInt(dimensions.split(":")[0]), Integer.parseInt(dimensions.split(":")[1])));
        billingAddress = new BillingAddress("United States", "New York", "New York", "Lee", "10765", "123456789");
        testUser = new TestUser(billingAddress);
        new TestFailListener().setDriver(webDriver);
    }

    @Test(groups = {"important"})
    public void registrationProcessTest() {
        home = new HomePage(webDriver)
                .openAddress(ADDRESS_URL)
                .goToRegistration()
                .register(testUser);
        assertEquals(home.getUserEmail(), testUser.getEmail(), "Verifying registration");
    }

    @Test(groups = {"important"}, dependsOnMethods = {"registrationProcessTest"})
    public void searchForProduct() {
        SearchResultPage searchResultPage = home.sendToSearchBox(PRODUCT_TO_LOOK_FOR);
        shoppingCart = searchResultPage.getItem(PRODUCT_TO_LOOK_FOR).navigateToCart();
        assertEquals(shoppingCart.getProductsInShoppingCart().toLowerCase(), PRODUCT_TO_LOOK_FOR.toLowerCase(),
                "Verifying cart content: ");
    }

    @Test(groups = {"important"}, dependsOnMethods = {"searchForProduct"})
    public void checkoutProcessTest() {
        checkout = shoppingCart.goToCheckout();
        checkout.setBillingAddress(testUser)
                .shippingMethod().paymentMethodAndInformation()
                .paymentConfirmation();
        assertEquals(checkout.getFinalConfimationMessage().toLowerCase(), CONFIRMATION_MESSAGE.toLowerCase(),
                "Final Confirmation message is displayed");
    }

    @AfterSuite(groups = {"important"})
    public void tearDown() {
        webDriver.quit();
    }
}