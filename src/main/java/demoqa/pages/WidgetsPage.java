package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public WidgetsPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        shouldHaveText(oldSelectMenu, color, 5000);
        return this;
    }


    //* MultiSelectMenu
    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    public WidgetsPage multiSelect(String[] colors) {
        for (String color : colors) {
            if (color != null) {
                inputSelect.sendKeys(color);
                inputSelect.sendKeys(Keys.ENTER);
            }
            inputSelect.sendKeys(Keys.ESCAPE);
        }
        return this;
    }

    @FindBy(className = "css-12jo7m5")
    List<WebElement> selectedColorsElements;

    public boolean areColorsSelected(String[] colors) {

        List<String> selectedText = new ArrayList<>();
        for (WebElement element : selectedColorsElements) {
            selectedText.add(element.getText());
        }
        for (String color : colors) {
            if (!selectedText.contains(color)) {
                return false;
            }
        }
        return true;
    }


    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage standardMultiSelectByIndex(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            select.selectByIndex(index);
        }
        List<WebElement> options = select.getOptions();
        String selectedText = options.get(index).getText();
        System.out.println(selectedText);
        return this;
    }

    public WidgetsPage verifyByIndex(int index) {
        Select select = new Select(cars);
        List<WebElement> options = select.getOptions();
        List<WebElement> selectOptions = select.getAllSelectedOptions();
        String selectedText = options.get(index).getText();
        boolean textFound = false;
        for (WebElement element : selectOptions) {
            if (element.getText().equals(selectedText)) {
                textFound = true;
                break;
            }
        }
        System.out.println(selectedText);
        Assert.assertTrue(textFound);
        return this;
    }

    public WidgetsPage standardMultiSelectByCars(String[] car) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            for (String element : car) {
                select.selectByVisibleText(element);
            }
        }
        return this;
    }

    public WidgetsPage verifyMultiSelectByCars(String[] expected) {
        Select select = new Select(cars);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedText = new ArrayList<>();
        for (WebElement option : selectedOptions) {
            selectedText.add(option.getText());
        }
        List<String> expectedText = Arrays.asList(expected);
        assert new HashSet<>(selectedText).containsAll(expectedText);
        return this;
    }


//    @FindBy(id = "cars")
//    WebElement carsSelect;
//
//    public WidgetsPage multiCarSelect(String[] cars) {
//        Select select = new Select(carsSelect);
//        if (select.isMultiple()) {
//            for (String car : cars) {
//                select.selectByVisibleText(car);
//            }
//        } else {
//            throw new UnsupportedOperationException("This select does not support multiple selection");
//        }
//
//        return this;
//    }
//
//    public WidgetsPage verifyCarsSelected(String[] cars) {
//        assertTrue(areCarsSelected(cars));
//        return this;
//    }
//    private boolean areCarsSelected(String[] cars) {
//        List<String> selectedCars = new ArrayList<>();
//        for (String car : cars) {
//            if (!selectedCars.contains(car)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
