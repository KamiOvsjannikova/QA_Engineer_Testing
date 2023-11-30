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

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HugeForm {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //ChromeDriver driver = new ChromeDriver();//// importirovali chrome driver cherez alt+enter
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // kazdie 5 sek, dlja vsex elementov
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/huge_form.html");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successfulRegistration(){
        //vse polja dlja vvoda najdem //input//kolekcija web elemenot
        List<WebElement> inputFields =
                driver.findElements(By.tagName("input"));
        //enter data to all input fields
        for (WebElement input : inputFields) {
            input.sendKeys("Hallo");
        }
        WebElement submitButton =
                driver.findElement(By.tagName("button"));
        submitButton.click();

        //Congrats, you've passed the task!
        //zdatj vremja
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); // novoe ozidanija v tech 20 sek maximal kol-vo vremeni
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()) ;// zdatj do tex por pokaAlert ne stanet videlennim
        System.out.println(alert.getText());

        //check that alert has text "Congrats, you've passed the task!"
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

}
