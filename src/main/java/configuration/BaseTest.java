package configuration;
import Utils.SettingsReader;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import forms.DetailsPage;
import forms.MainPage;
import forms.ProfilePage;
import forms.RegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

import static Utils.SettingsReader.readJson;

public class BaseTest{
    Browser browser = AqualityServices.getBrowser();
    public static MainPage mainPage = new MainPage();
    public static RegistrationPage registrationPage = new RegistrationPage();
    public static ProfilePage profilePage = new ProfilePage();
    public static DetailsPage detailsPage = new DetailsPage();



    @BeforeMethod
    public void setup(){
        browser.maximize();
        browser.goTo(readJson("url"));
        browser.waitForPageToLoad();
    }
    @AfterTest
    public void closeDriver(){
        browser.quit();
    }
}
