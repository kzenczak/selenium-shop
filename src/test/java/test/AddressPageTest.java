package test;

import base.TLdriver;
import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AddressPage;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class AddressPageTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    GlobalMethods globalMethods;

    /********* konstruktor ***********/
    public AddressPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        addressPage = new AddressPage();
        globalMethods = new GlobalMethods();


        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        addressPage = accountPage.goToAddresses();

        }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        TLdriver.getTLDriver().quit();
    }


    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyNoDeliveryAddress() throws Exception {
        Assert.assertEquals(addressPage.getInfoDeliveryAddress(),
                testdata.getProperty("correctInfoAboutDeliveryAddress"));

        globalMethods.takeScreenshot("deliveryAddress");
    }

}
