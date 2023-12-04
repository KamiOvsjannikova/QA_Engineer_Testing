package Lessons3011;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginForm {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/login-form.html");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void successLoginValidDataTest() {
        WebElement userNameInputField = driver.findElement(By.id("username"));
        userNameInputField.sendKeys("tester@crossbrowsertesting.com");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("test123");

        WebElement loginButton = driver.findElement(By.tagName("button")); // //button
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // dozdatsja sled str.zamesto sleep
        WebElement uniqueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logged-in-message")));

        WebElement successLoginText = driver.findElement(By.id("logged-in-message")); // logged-in-message h2 валится тест
        assertEquals("Welcome tester@crossbrowsertesting.com\n" + "You are now logged in!", successLoginText.getText());
    }

    @Test
    public void registrationWithSpaceTest() {
        WebElement userNameInputField = driver.findElement(By.id("username"));
        userNameInputField.sendKeys("tester@crossbrowsertesting.com ");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("test123 ");

        WebElement loginButton = driver.findElement(By.tagName("button")); // //button
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // dozdatsja sled str.zamesto sleep
        WebElement uniqueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-binding")));

        WebElement registrationWithSpace = driver.findElement(By.className("ng-binding"));
        assertEquals("Username or password is incorrect",registrationWithSpace.getText());

    }

    @Test
    public void registrationWithoutUserNameTest() {
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("test123");

        WebElement loginButton = driver.findElement(By.tagName("button")); // //button
        loginButton.click();

        WebElement userNameInputField = driver.findElement(By.id("username"));
        //System.out.println(firstNameInputField.getAttribute("validationMessage")); //proverka vsplivauwego okna ZAPOLNITE ETO POLE.Eto iz okna Properties
        assertEquals("Please fill out this field.",userNameInputField.getAttribute("validationMessage"));

    }

    @Test
    public void registrationWithoutPasswordTest() {
        WebElement userNameInputField = driver.findElement(By.id("username"));
        userNameInputField.sendKeys("tester@crossbrowsertesting.com");

        WebElement loginButton = driver.findElement(By.tagName("button")); // //button
        loginButton.click();

        WebElement passwordInputField = driver.findElement(By.id("password"));
        //System.out.println(firstNameInputField.getAttribute("validationMessage")); //proverka vsplivauwego okna ZAPOLNITE ETO POLE.Eto iz okna Properties
        assertEquals("Please fill out this field.",passwordInputField.getAttribute("validationMessage"));
    }

    @Test
    public void invalidPasswordTest() {
        WebElement userNameInputField = driver.findElement(By.id("username"));
        userNameInputField.sendKeys("tester@crossbrowsertesting.com");

        WebElement invalidPasswordInputField = driver.findElement(By.id("password"));
        invalidPasswordInputField.sendKeys("test12");

        WebElement loginButton = driver.findElement(By.tagName("button")); // //button
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // dozdatsja sled str.zamesto sleep
        WebElement uniqueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-binding")));

        WebElement invalidPassword = driver.findElement(By.className("ng-binding"));
        assertEquals("Username or password is incorrect",invalidPassword.getText());
    }
}
