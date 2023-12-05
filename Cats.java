import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Cats {
    ChromeDriver driver; 

   
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();// inializacija driver//ChromeDriver driver = new ChromeDriver();//ChromeDriver  class vidim v biblioteke selenium
        driver.get("http://suninjuly.github.io/cats.html");
    }
    @Test
    public void headerTextTest() {//public void firstScript() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver = new ChromeDriver();// inializacija driver//ChromeDriver driver = new ChromeDriver();//ChromeDriver  class vidim v biblioteke selenium
        //driver.get("http://suninjuly.github.io/cats.html");
        //proverka chto zagolovok cat memes
        WebElement header = driver.findElement(By.cssSelector("[class='jumbotron-heading']"));//v skobkax locator ukazivaj
        //System.out.println(header.getText());
        //proverka imenno togo text
        assertEquals("Cat memes",header.getText());
        //slomali test assertEquals("Dogs memes",header.getText());
        //chtobi google windows zakrivalisj
        //driver.quit();
        ////slomali test assertEquals("Dogs memes",header.getText()); windows ne zakroetsja, poromu chto ne dowla do strochki  driver.quit();

    }
    @Test
    public void timeFirstCatCardTest(){
        WebElement timeFirstCatCard = driver.findElement(By.xpath("//div[@class='col-sm-4'][1]//div/small"));// chtobi najti element 9 min
        assertEquals("9 mins",timeFirstCatCard.getText());
    }
    //check that "I love you so much" in name of last card
    @Test
    public void nameOfLastCatCardTest(){
        WebElement nameOfLastCatCard = driver.findElement(By.xpath("//div[@class='col-sm-4'][6]//p']"));
        assertEquals("I love you so much",nameOfLastCatCard.getText());
    }
@Test
    public void catsAlbumTittleTest() {
        WebElement catsAlbumTittle = driver.findElement(By.tagName("strong")); 
        assertTrue(catsAlbumTittle.isDisplayed());
    }
//first cat card is displayed
@Test
public void firstCatCardIsDisplayedTest() {
    WebElement firstCard = driver.findElement(By.xpath("//*[@class='col-sm-4'][1]"));
    assertTrue(firstCard.isDisplayed());
}
//check that 6 cards
    @Test
    public void checkCardQuantityTest() {
        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        assertEquals (6, cards.size()); 
    }
    //check that 6 images are on the page
    @Test
    public void checkImagesQuantityTest() {
        List<WebElement> images = driver.findElements(By.tagName("img"));
       // assertEquals (6, images.size());
    }
    //check that all cards are displayed
    @Test
    public void checkAllCardsAreDisplayedTest() {
        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        for (int i = 0; i < cards.size(); i++) {
            assertTrue(cards.get(i).isDisplayed());
        }
    }
        /*
        for (WebElement cards: cards) {
           assertTrue(cards.isDisplayed());
           }
        */
        /*
        cards.forEach(card -> assertTrue(card.isDisplayed())); --
         */

        //check that all cards have np empty names - chto net pustoj stroki
     @Test
        public void allCardsNamesAreNotEmpty(){
            List<WebElement> names = driver.findElements(By.tagName("p"));
         for (WebElement name: names) {
             assertFalse(name.getText().isEmpty()); 
         }
        }

    @AfterEach 
    public void tearDown() {
        driver.quit();
    }
}


