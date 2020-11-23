package test;

import base.TestBase;
import helpers.GlobalMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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

    private SoftAssert softAssert = new SoftAssert();

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
        accountPage = loginPage.login(user, password);
        addressPage = accountPage.goToAddresses();

        }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyNoDeliveryAddress() throws Exception {
        softAssert.assertEquals(addressPage.getInfoDeliveryAddress(),
                testdata.getProperty("correctInfoAboutDeliveryAddress"));

        globalMethods.takeScreenshot("deliveryAddress");
    }

}
