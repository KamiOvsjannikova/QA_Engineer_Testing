package lesson0712;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hover {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        // chtobi ne pisatj v kazdom teste WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20))
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html#");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {

        driver.quit();
    }
    @Test
    public void hoverTest () throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//li[@class=\"dropdown\"]/a"));
        //navesti kursor Hover po element
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        // sleep(3000); libo WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); Esli bistro proxodit test
        //WAIT.UNTIL(ExpectedConditions....)
        //nazatj na dropdown na element Secondary menu
        WebElement secondaryMenu = driver.findElement(By.xpath("//li[@class=\"secondary-dropdown\"]/a"));
        actions.moveToElement(secondaryMenu).perform(); // perform nuzen chtobi vosproizvel dejstvija
        //sleep(5000);
        //Push the "Secondary Action" button
        WebElement secondaryAction = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu secondary\"]//li/a")); //[onclick="handleSecondaryAction()"]
        secondaryAction.click();
        sleep(5000);
        //Check that "Secondary Page" is displayed
        WebElement textSecondaryPage = driver.findElement(By.xpath("//div[@class=\"jumbotron secondary-clicked\"]/h1")); // to chto text viwel na stranichke
        assertEquals("Secondary Page" ,textSecondaryPage.getText());
        // proverka podzagolovka Check that "Secondary action in the menu was clicked successfully!" is displayed
        WebElement clickedSuccessfully = driver.findElement(By.xpath("//div[@class=\"jumbotron secondary-clicked\"]/p[1]"));
        assertEquals("Secondary action in the menu was clicked successfully!",clickedSuccessfully.getText());

    }
}
