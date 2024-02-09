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
            open(BASE_URL); 
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        @After
        public void tearDown(){
            closeWebDriver();//zakritj browser
        }
        HeaderPage headerPage = new HeaderPage();
        BooksPage booksPage = new BooksPage();
}
