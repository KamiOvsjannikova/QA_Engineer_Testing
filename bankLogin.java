import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class bankLogin {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }
    @Test
    public void successCustomerLoginValidDataTest() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
//        sleep(5000);
        WebElement dropDown = driver.findElement(By.id("userSelect"));
        dropDown.click();

        // nuzno vibratj variant
        WebElement answerOption = driver.findElement(By.cssSelector("[value='4']"));
        //System.out.println("[value= 'Albus Dumbledore']");
//        sleep(5000);
        answerOption.click();
//        sleep(5000);
        WebElement submitButton=driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
//        sleep(5000);
        assertTrue(driver.getCurrentUrl().contains("account"));
        sleep(5000);

        WebElement dropDownAccount = driver.findElement(By.id("accountSelect")); //#accountSelect
        dropDownAccount.click();
//        sleep(5000);
        WebElement accountNumber = driver.findElement(By.cssSelector("[value='number:1011']"));
        accountNumber.click();
        WebElement transactionsButton = driver.findElement(By.cssSelector("[ng-click='transactions()']"));
        transactionsButton.click();
//        sleep(5000);
        assertTrue(driver.getCurrentUrl().contains("listTx"));
    }
}
