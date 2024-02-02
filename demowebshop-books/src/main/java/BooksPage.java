import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {
    private SelenideElement dropdown = $(byId("products-pagesize")); // naxozdenie dropdown
    private SelenideElement chooseFourBooks = $(byValue("https://demowebshop.tricentis.com/books?pagesize=4")); // dlja 4 books
    private SelenideElement chooseEightBooks = $(byValue("https://demowebshop.tricentis.com/books?pagesize=8")); // value="https://demowebshop.tricentis.com/books?pagesize=8"
    private SelenideElement chooseTwelveBooks = $(byValue("https://demowebshop.tricentis.com/books?pagesize=12"));

    private SelenideElement chooseTwentyBooks = $(byValue("https://demowebshop.tricentis.com/books?pagesize=20"));
    private ElementsCollection item = $$(byClassName("product-item"));//naxozu kollekciju books .product-item

    public ElementsCollection getItem() {
        return item;
    }

    public void clickOnChooseTwentyBooks(){
        chooseTwentyBooks.click();
    }
    public void clickOnChooseTwelveBooks(){
        chooseTwelveBooks.click();
    }
    public void clickOnChooseEightBooks(){
        chooseEightBooks.click();
    }

    public void clickOnChooseFourBooks(){
        chooseFourBooks.click();
    }

    //click on  dropdown
    public void clickOnDropdown() {
        dropdown.click();
    }
}
