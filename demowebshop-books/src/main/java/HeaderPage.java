import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage {
    private SelenideElement booksButton = $x("//a[contains(@href,'/books')]"); //$(byClassName("header-menu"));

    //click on  button
    public void clickOnBooksButton() {
        booksButton.click();
    }
}
