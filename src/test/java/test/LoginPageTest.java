package test;
import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;


public class LoginPageTest extends TestBase {

    /******* deklaracja obiektów ********/
    GlobalMethods globalMethods;
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;

    /********* konstruktor ***********/
    public LoginPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        globalMethods = new GlobalMethods();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }




    /********* TESTY ***********/
    @Test(priority = 0)
    public void verifyPageTitle() throws Exception {
        Assert.assertTrue(globalMethods.getPageTitle().equals(testdata.getProperty("correctAccountPageTitle")));

        globalMethods.takeScreenshot("accountPage");
    }


}
