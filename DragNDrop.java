package lesson0712;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DragNDrop {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        // chtobi ne pisatj v kazdom teste WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20))
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {

        driver.quit();
    }
    @Test
    public void dragNDropTest () throws InterruptedException {
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        // peremestitj iz odnogo mesta v kvadratik
        Actions actions = new Actions(driver); // v kachestve argumenta driver
       // actions.dragAndDrop(draggable, droppable).perform(); // v kach argemento nuzno peredatj, chto tjanem i kuda tjanem
       // sleep(3000);
        //opisanie vsex wagov, navesti, kliknutj //moveTo element - peremestitj elemnt pozvoljaet
        actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().build().perform(); //release - otustitj miwku. Build eto kogda celaja cepochka
        //check that "Dropped!" text is displayed
        assertEquals("Dropped!" ,droppable.getText()); // eto imenno proverka texta Equals - eto proverka v simvol v simvol
    }
}

