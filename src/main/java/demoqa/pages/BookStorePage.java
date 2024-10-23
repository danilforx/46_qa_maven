package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookStorePage extends BasePage {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox") // Поиск по id
    WebElement searchBox; // Поле поиска

    public BookStorePage typeInSearchFieldInput(String text) {
        type(searchBox, text); // Ввод текста в поле поиска
        return this;
    }

    @FindBy(css = ".mr-2>a")
    WebElement searchResult;

    public BookStorePage verifyText(String expectedText) {
        String actualText = searchResult.getText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Ожидалось: [" + expectedText + "], но было получено: [" + actualText + "]");
        return this;
    }
}
