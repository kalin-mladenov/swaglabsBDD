package positive;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SwaglabsStepdefs {

    private WebDriver driver;


    private final static By USERNAME_INPUT_FIELD =  By.id("user-name");
    private final static By PASSWORD_INPUT_FIELD =  By.id("password");
    private final static By LOGIN_BUTTON =  By.id("login-button");
    private final static By PRODUCTS_HEADER_TITLE =  By.className("title");
    private final static By BACKPACK_ADD_TO_CART = By.id("add-to-cart-sauce-labs-backpack");
    private final static By CART_ICON = By.className("shopping_cart_link");
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON =By.id("continue");
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By COMPLETE_ORDER_MSG = By.className("complete-header");
    private static final By BACKPACK_INVENTORY_NAME = By.xpath("//div[text()='Sauce Labs Backpack']");
    private static final By INFO_HEADER_TITLE = By.xpath("//span[text()='Checkout: Your Information']");
    private static final By OVERVIEW_HEADER_TITLE = By.xpath("//span[text()='Checkout: Overview']");


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After

    public void tearDown()
//            throws InterruptedException
    {

//        Thread.sleep(1000);
        driver.quit();
    }
    @Given("I'm on {string} page")
    public void iMOnPage(String loginUrl) {
        driver.get(loginUrl);
    }

    @When("I enter {string} as username and {string} as password")
    public void iEnterAsUsernameAndAsPassword(String username, String password) {
        driver.findElement(USERNAME_INPUT_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
    }


    @And("I click on LOGIN button")
    public void iClickOnLOGINButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }


    @Then("I see {string} page header")
    public void iSeePageHeather(String expectedTitle) {
        String actualTitle = driver.findElement(PRODUCTS_HEADER_TITLE).getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Products page header not found");
    }
    @And("I click on ADD TO CART button for Sause Labs Backpack")
    public void iClickOnADDTOCARTButtonForSauseLabsBackpack() {
        driver.findElement(BACKPACK_ADD_TO_CART).click();
    }

    @And("I click on cart icon")
    public void iClickOnCartIcon() {
        driver.findElement(CART_ICON).click();

    }
    @Then("I see {string} in Cart")
    public void iSeeInCart(String expectedBackpackName) {
        String actualBackpackName = driver.findElement(BACKPACK_INVENTORY_NAME).getText();
        Assert.assertEquals(actualBackpackName, expectedBackpackName, "Backpack name not found in Cart");
    }

    @And("I click on CHECKOUT button")
    public void iClickOnCHECKOUTButton() {
        driver.findElement(CHECKOUT_BUTTON).click();

    }
    @Then("The {string} page is loaded")
    public void thePageIsLoaded(String expectedTitle) {
        String actualHeaderTitle = driver.findElement(INFO_HEADER_TITLE).getText();
        Assert.assertEquals(expectedTitle, actualHeaderTitle, "CHECKOUT: YOUR INFORMATION page is not loaded");
    }
    @And("I enter {string} for First Name, {string} for Last Name and {string} for Zip Postal Code")
    public void iEnterForFirstNameForLastNameAndForZipPostalCode(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(postalCode);
    }

    @And("I click CONTINUE button")
    public void iClickCONTINUEButton() {
        driver.findElement(CONTINUE_BUTTON).click();

    }

    @And("I click FINISH button")
    public void iClickFINISHButton() {
        driver.findElement(FINISH_BUTTON).click();

    }

    @Then("I see {string}")
    public void iSee(String expectedMessage) {
        String actualMessage = driver.findElement(COMPLETE_ORDER_MSG).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Problem with completing the order");
    }


    @Then("I can see {string} header")
    public void iCanSeeHeader(String expectedTitle) {
        String actualTitle = driver.findElement(OVERVIEW_HEADER_TITLE).getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Expected text not loaded");
    }
}
