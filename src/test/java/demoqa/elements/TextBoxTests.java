package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPage;
import demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class TextBoxTests extends TestBase {


    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectTexBox().hideAds();
    }


    @Test
    public void keyboardEventTest() throws AWTException {
        new TextBoxPage(app.driver)
                .enterPersonalData("Test001", "email123@gmail.com", "Berlin")
                .keyboardEvent()
                .verifyCopyPasteAddress();
    }

    //"Test001", "email123@gmail.com", "Berlin"
    @Test(dataProvider = "addNewUserFormFromCSVFile", dataProviderClass = DataProviders.class)
    public void keyboardEventDataProviderTest(String name, String mail, String address) throws AWTException {
        new TextBoxPage(app.driver)
                .enterPersonalData(name, mail, address)
                .keyboardEvent()
                .verifyCopyPasteAddress();
    }
}
