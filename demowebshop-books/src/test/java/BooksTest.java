import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;

public class BooksTest extends BaseTest{
    @Test
    public void dropdownIsDisplayed(){
        headerPage.clickOnBooksButton();
        booksPage.clickOnDropdown();
    }
    @Test
    public void chooseFourBooks(){
        headerPage.clickOnBooksButton(); // knopka Books v header
        booksPage.clickOnDropdown(); // sam dropdow
        booksPage.clickOnChooseFourBooks(); //vibor 4 knig
        booksPage.getItem().filterBy(Condition.visible).shouldHave(size(4));// to chto oni vidimi vse 4
    }
// vibor 8 knig, on svalitsja, potomu chto 8 ne vidno
    @Test
    public void chooseEightBooks() {
        headerPage.clickOnBooksButton();
        booksPage.clickOnDropdown();
        booksPage.clickOnChooseEightBooks();
        booksPage.getItem().filterBy(Condition.visible).shouldHave(size(8));
    }
    // vibor 12 knig, on svalitsja, potomu chto 12 ne vidno
    @Test
    public void chooseTwelveBooks(){
        headerPage.clickOnBooksButton();
        booksPage.clickOnDropdown();
        booksPage.clickOnChooseTwelveBooks();
        booksPage.getItem().filterBy(Condition.visible).shouldHave(size(12));
    }
    @Test
    public void chooseTwentyBooks() {
        headerPage.clickOnBooksButton();
        booksPage.clickOnDropdown();
        booksPage.clickOnChooseTwentyBooks();
        booksPage.getItem().filterBy(Condition.visible).shouldHave(size(20));
    }
}
