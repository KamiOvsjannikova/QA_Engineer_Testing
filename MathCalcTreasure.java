package Lessons3011;

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
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MathCalcTreasure {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/get_attribute.html");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {
        driver.quit();
    }

    public double funcCalc(double x) {
        return log(abs(12 * sin(x))); // za modul kot. otvechaet eto - abs
    }

    @Test
    public void validAnswer() {
        WebElement treasureImage = driver.findElement(By.id("treasure"));
        String xValueString = treasureImage.getAttribute("valuex");
        double xValue = parseDouble(xValueString);
        System.out.println(xValue);
        double result = funcCalc(xValue);// method get text zabiraet t   chislo v vide stroki // budet chislo
        WebElement answerInputField =
                driver.findElement(By.id("answer"));
        //iz double prevratitj v stroku
        answerInputField.sendKeys(String.valueOf(result)); // bil double stal strockoj
        // sleep(5000);



        ///check checkbox I'm the robot
        WebElement robotCheckBox = driver.findElement(By.id("robotCheckbox"));
        robotCheckBox.click();
        //choose Robots rule
        WebElement robotsRuleRadioButton = driver.findElement(By.id("robotsRule"));
        robotsRuleRadioButton.click();
        //push Submit button
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        //check that alert has text "Congrats, you've passed the task!"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }
}
