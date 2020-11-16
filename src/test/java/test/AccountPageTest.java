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

public class AccountPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    GlobalMethods globalMethods;


    /********* konstruktor ***********/
    public AccountPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        globalMethods = new GlobalMethods();


        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }





    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyNameAccountAfterLogin() throws Exception {
        Assert.assertEquals(accountPage.getNameAccount(), testdata.getProperty("correctNameAccount"),
                "Nie jesteś zalogowany na własciwe konto! Proszę o wylogowanie się");

        globalMethods.takeScreenshot("afterLogin");
    }



}
