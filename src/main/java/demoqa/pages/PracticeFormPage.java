package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    //firstName
    //lastName
    //email
    //number
    @FindBy(id = "firstName")
    WebElement fName;
    @FindBy(id = "lastName")
    WebElement lName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String firstName, String lastName, String email, String number) {
        type(fName, firstName);
        type(lName, lastName);
        type(userEmail, email);
        type(userNumber, number);
        return this;
    }


    //label[contains(text(),'Other')]
    //label[contains(text(),'Male')]
    //label[contains(text(),'Female')]

    public PracticeFormPage selectGender(String gender) {
        try {
            String xpathGender = "//label[contains(text(),'" + gender + "')]";
            WebElement genderLocator = driver.findElement(By.xpath(xpathGender));
            click(genderLocator);
        } catch (NoSuchElementException e) {
            System.out.println("Gender is not found: [" + gender + "]");
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Error selecting gender:[" + gender + "] ");
            throw new RuntimeException(e);
        }
        return this;
    }


    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthSelect;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearSelect;

    public PracticeFormPage selectDate(String day, String month, String year) {
        click(dateOfBirthInput);
        new Select(monthSelect).selectByVisibleText(month);
        new Select(yearSelect).selectByVisibleText(year);
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }


    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage enterSubject(String[] subjects) {
        for (String subject : subjects) {
            if (subject != null) {
                type(subjectsInput, subject);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }


    //label[.='Reading']
    public PracticeFormPage selectHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            if (hobby != null) {
                driver.findElement(By.xpath("//label[.='" + hobby + "']")).click();
            }
        }
        return this;
    }


    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadPicture(String image) {
        uploadPicture.sendKeys(image);
        return this;
    }


    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterCurrentAddress(String address) {
        type(currentAddress, address);
        return this;
    }


    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage enterState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;
    public PracticeFormPage enterCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }


    @FindBy(id = "submit")
    WebElement submitButton;
    public PracticeFormPage submitForm() {
        click(submitButton);
        return this;
    }


    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement registrationModal;
    public PracticeFormPage verifySuccessRegistration(String text) {
        shouldHaveText(registrationModal, text,5000);
        return this;
    }

    public PracticeFormPage selectDateAsString(String date) {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        //type(dateOfBirthInput, date);
        if (os.contains("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND + "a");
        }else {
            dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }
}
