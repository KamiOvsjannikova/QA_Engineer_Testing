package lesson0712;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToolTips {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// chtobi ne pisatj v kazdom teste WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20))
        driver.get("https://demoqa.com/tool-tips");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {

        driver.quit();
    }
    @Test
    public void toolTipsTest() throws InterruptedException {
        //Hover over "Hover me to see" button
        WebElement hoverMeToSeeButton = driver.findElement(By.id("toolTipButton"));
        //navesti kursor Hover po element
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMeToSeeButton).perform();
        //sleep(5000);
        //Check that tooltip has text "You hovered over the Button"
        WebElement toolTip = driver.findElement(By.cssSelector("[class = 'tooltip-inner']")); // By.className("tooltip-inner"));
        assertEquals("You hovered over the Button",toolTip.getText());
    sleep(5000);
        //Hover over the input field
        WebElement hoverOverTheInputField = driver.findElement(By.id("toolTipTextField"));
        actions.moveToElement(hoverOverTheInputField).perform();
        //sleep(5000);
        //Check the text of ToolTip
        WebElement textToolTip = driver.findElement(By.cssSelector("[class = 'tooltip-inner']")); // By.className("tooltip-inner"));
        assertEquals("You hovered over the text field",textToolTip.getText());
    }
}
