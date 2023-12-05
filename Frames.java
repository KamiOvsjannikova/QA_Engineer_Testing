package lesson0512;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Frames {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        // chtobi ne pisatj v kazdom teste WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20))
        driver.get("https://demoqa.com/frames");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void frameTest() {
        //prekluchitsja na druguju html tam estj iframe
        driver.switchTo().frame("frame1"); // iframe #frame1
        WebElement header = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header.getText());

        //check that second header in small window has text "This is a sample page"
        //vernemsja na 1 str ranwe
        driver.switchTo().defaultContent(); //vozvrat na nacal stranicku
        driver.switchTo().frame("frame2"); // iframe #frame1
        WebElement header2 = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header2.getText());
    }
}
