package lesson0512;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Alerts {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        // chtobi ne pisatj v kazdom teste WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20))
        driver.get("https://demoqa.com/alerts");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void firstAlert() {
        //CLICK the first button "Click me"
        WebElement clickMeButton = driver.findElement(By.id("alertButton")); // #alertButton
        clickMeButton.click();
        //Check that text of alert "You clicked a button" is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 sek zdjom
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // okowko swerxu vsplivaet
        assertTrue(alert.getText().contains("You clicked a button"));
    }

    @Test
    public void secondAlert() {
        //CLICK the first button "Click me"
        WebElement secondButton = driver.findElement(By.id("timerAlertButton")); // #timerAlertButton
        secondButton.click();
        //Check that text of alert "This alert appeared after 5 seconds"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 sek zdjom
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // okowko swerxu vsplivaet
        assertTrue(alert.getText().contains("This alert appeared after 5 seconds"));
    }

    @Test
    public void alertConfirm() {
        //CLICK the first button "Click me"
        WebElement thirdButton = driver.findElement(By.id("confirmButton")); // #confirmButton
        thirdButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// 10 sek zdjom
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        assertEquals("You selected Ok", confirmResult.getText());
    }
    @Test
    public void alertCancel() {
        WebElement thirdButton = driver.findElement(By.id("confirmButton")); // #confirmButton
        thirdButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// 10 sek zdjom
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        assertEquals("You selected Cancel", confirmResult.getText());
    }
    @Test
    public void alertInput(){
        String name = "Kamilla"; // dlja onogo raza smenitj
        WebElement fourthButton = driver.findElement(By.id("promtButton")); // #promtButton
        fourthButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// 10 sek zdjom
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(name); // alert.sendKeys("Kamilla")
        alert.accept();
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        assertEquals("You entered " + name, promptResult.getText());
    }
}
