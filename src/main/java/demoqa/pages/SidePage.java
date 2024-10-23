package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {
    public SidePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement login;


    public LoginPage selectLogin() {
        click(login);
        //clickWithJS(login, 0, 400);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public WidgetsPage selectSelectMenu() {
        click(selectMenu);
        // clickWithJS(selectMenu, 0, 300);
        return new WidgetsPage(driver);
    }


    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BasePage selectBrowserWindows() {
        click(browserWindows);
        return this;
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        click(buttons);
        return new ButtonsPage(driver);
    }


    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public BasePage selectTexBox() {
        click(textBox);
        return this;
    }

    //Practice Form
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public BasePage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    //AutoComplete
    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;

    public AutoCompletePage selectAutoCompleteMenu() {
        click(autoComplete);
        return new AutoCompletePage(driver);
    }


    //Broken Links - Images
    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;

    public BrokenLinksImagesPage selectBrokenLinksImages() {
        click(brokenLinksImages);
        return new BrokenLinksImagesPage(driver);
    }
}
