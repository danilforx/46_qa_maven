package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getForms().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();
    }


    @Test
    public void practiceFormTest() {
        new PracticeFormPage(app.driver)
                .enterPersonalData("Danylo","Yeremenko","danerem0@gmail.com","1234567890")
                .selectGender("Male")
                //.selectDate("3","April","2000")
                .selectDateAsString("03 Apr 2000")
                .enterSubject(new String[]{"Maths","English"})
                .selectHobbies(new String[]{"Sports","Music"})
                .uploadPicture("C:/Users/Admin/Desktop/pict.JPG")
                .enterCurrentAddress("Portishead, Bristol, UK")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form")
            ;
    }


    //"Danylo","Yeremenko","danerem0@gmail.com","1234567890"
    @Test
    @Parameters({"firstName","lastName","email","number"})
    public void practiceFormParametersTest(String firstName, String lastName, String email, String number) {
        new PracticeFormPage(app.driver)
                .enterPersonalData(firstName,lastName,email,number)
                .selectGender("Male")
                //.selectDate("3","April","2000")
                .selectDateAsString("03 Apr 2000")
                .enterSubject(new String[]{"Maths","English"})
                .selectHobbies(new String[]{"Sports","Music"})
                .uploadPicture("C:/Users/Admin/Desktop/pict.JPG")
                .enterCurrentAddress("Portishead, Bristol, UK")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
