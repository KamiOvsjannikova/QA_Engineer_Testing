import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
        final String BASE_URL = "https://demowebshop.tricentis.com/";
        @Before
        public  void setUp() {
            open(BASE_URL); // argument - eto ssilka //open -eto dlja otkritija str
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());//sluwaet chto proisxodit i prik scrennshot
        }
        //zaverwatj browser dlja togo chto bi vse testi prowli ne zavisimo drug ot druga
        @After
        public void tearDown(){
            closeWebDriver();//zakritj browser
        }
        HeaderPage headerPage = new HeaderPage();
        BooksPage booksPage = new BooksPage();
}
