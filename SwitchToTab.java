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
import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static java.lang.Thread.sleep;

import java.time.Duration;
import java.util.ArrayList;

public class SwitchToTab {
        ChromeDriver driver;

        @BeforeEach
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // ne javnoe ozidanie - ozidaet vsex vipol testov 5 sek,
            // chtobi ne pisatj v kazdom teste WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20))
            driver.get("http://suninjuly.github.io/redirect_accept.html");
        }

        @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
        public void tearDown() {

            driver.quit();
        }
        public double funcCalc(double x) {
            return log(abs(12 * sin(x))); // za modul kot. otvechaet eto - abs
        }
        @Test
        public void switchToTabTest() throws InterruptedException {
            WebElement redirectButton = driver.findElement(By.className("btn-primary")); //.btn-primary
            redirectButton.click();
           //sleep(10000);
           //perekluchenie na druguju str.
            System.out.println(driver.getWindowHandles()); // vozvrawaet unik nomera otkritix okon
            System.out.println(driver.getWindowHandle()); // vozvrawaet unik nomer vkladke, kotoraja aktivnoe, gde naxoditsja driver
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // dlja peredachi nomera windows
            //perekluchenie na drugoje okno.
            driver.switchTo().window(tabs.get(1));// nomer vkladki nuzno ukazatj v skobkax

            // math calc and enter answer to the input field
            WebElement x = driver.findElement(By.id("input_value")); // schitali x - pri pomowi id
            System.out.println(x.getText());
            double xValue = parseDouble(x.getText()); //preobrazovatj  strocku getText() v double
            System.out.println(xValue);
            double result = funcCalc(xValue);// method get text zabiraet t   chislo v vide stroki // budet chislo
            WebElement answerInputField =
                    driver.findElement(By.id("answer"));
            //iz double prevratitj v stroku
            answerInputField.sendKeys(String.valueOf(result)); // bil double stal strockoj
            // push Submit button
            WebElement submitButton = driver.findElement(By.tagName("button"));
            submitButton.click();
            // assert that alert has tex "Congrats!..."
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


        }
    }

