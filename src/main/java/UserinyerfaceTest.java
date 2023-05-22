import configuration.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import static Utils.DomainUtils.generateRandomEmailDomain;
import static Utils.SettingsReader.*;
import static Utils.StringUtils.*;

public class UserinyerfaceTest extends BaseTest {


    @Test(testName = "Opening MainPage and Registering")
    public static void openingAndRegisteringTest()
    {
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main Form is not opened");
        mainPage.clickHereBtn();
        Assert.assertTrue(registrationPage.state().isDisplayed(), "Registration Form is not opened");
        registrationPage.fillPasword(generatePassword());
        registrationPage.fillEmailFirtsHalf(getString());
        registrationPage.fillEmailSecondsHalf(generateRandomEmailDomain());
        registrationPage.clickTearDown();
        registrationPage.chooseEmail();
        registrationPage.checkTermsAndConditions();
        registrationPage.clickNextBtn();
        Assert.assertTrue(profilePage.state().isDisplayed(),"profile-avatar Form is not opened");
        profilePage.uploadPicture(readJson("picture_FilePath"));
        profilePage.checkUnselectAll();
        profilePage.selectRandomCheckboxes(readJsonInt("checkboxQuantity"));
        profilePage.clickNextBtn();
        Assert.assertTrue(detailsPage.state().isDisplayed(),"personal-details Form is not opened");

    }

    @Test(testName = "opening main page and hiding help form")
    public static void mainPageHelpFormTest()
    {
        mainPage.clickHereBtn();
        Assert.assertTrue(registrationPage.state().isDisplayed(), "Registration Form is not opened");
        registrationPage.clicksendToBottom();
        Assert.assertTrue(registrationPage.checkIfhelpFormDisappeared(), "help-form didn,t disappear");
    }

    @Test(testName = "opening main page and accepting coockies")
    public static void mainPageAcceptCoockiesTest()
    {
        mainPage.clickHereBtn();
        Assert.assertTrue(registrationPage.state().isDisplayed(), "Registration Form is not opened");
        registrationPage.acceptCoockies();
        Assert.assertTrue(registrationPage.checkIfcoockiesTextDissapeared(),"coockie form didn,t disappear");

    }
    @Test(testName = "opening main page and check if Timer is correct")
    public static void mainPageTimerTest()
    {
        mainPage.clickHereBtn();
        Assert.assertTrue(registrationPage.state().isDisplayed(), "Registration Form is not opened");
        Assert.assertEquals(registrationPage.checkTimer(),readJson("timer"));

    }


}
