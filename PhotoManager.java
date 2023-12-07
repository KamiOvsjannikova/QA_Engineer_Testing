package lesson0712;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class PhotoManager {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// chtobi ne pisatj v kazdom teste WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20))
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
    }

    @AfterEach//metod ,kotorij pozvoljaet zakrivatj brauzer posle kazhdogo testa, dazhe ,esli test padaet
    public void tearDown() {

        driver.quit();
    }
    @Test
    public void moveAllPhotoTrashTest() throws InterruptedException {
        WebElement frame = driver.findElement(By.className("demo-frame")); // najti Frame nuzno 3 vida perekluchenija: stringName Id, porjad.nomer, web element
        driver.switchTo().frame(frame); // peredajem Frame, tem samim perekluchajemsja
        //tak kak mno kartinok delaem List=kollekcija elementov
        List<WebElement> photos = driver.findElements(By.className("ui-draggable-handle"));
        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));//(By.id("trash"));
        Actions actions = new Actions(driver);
        for (WebElement onePhoto: photos) {
            actions.dragAndDrop(onePhoto,trash).perform();// chto tjanem i kuda tjanem
        }
        sleep (5000);
    // vse 4 photo vostanovitj //Recycle all photos
        //List<WebElement> recycleButtons = driver.findElements(By.
       for(WebElement photo: photos) {
           WebElement recycleButton = driver.findElement(By.cssSelector("[title='Recycle this image']"));
           actions.moveToElement(photo).moveToElement(recycleButton).click().build().perform();
       }
    }
}
